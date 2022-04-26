package com.example.movieservice.service.iml;

import com.example.movieservice.dto.request.MovieUpdateReqDto;
import com.example.movieservice.dto.response.MovieUpdateResDto;
import com.example.movieservice.model.Info;
import com.example.movieservice.model.Movie;
import com.example.movieservice.repository.MovieRepo;
import com.example.movieservice.service.MovieUpdateService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

import java.util.*;
import java.util.stream.Collectors;

@Log4j2
@Service
public class MovieUpdateServiceIml implements MovieUpdateService {
    @Value("${config.path}")
    private static String path;
    @Value("${config.des}")
    private static String des;

    private final MovieRepo movieRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public MovieUpdateServiceIml(MovieRepo movieRepo, ModelMapper modelMapper) {
        this.movieRepo = movieRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public MovieUpdateResDto upLoadMovie(MultipartFile file, MovieUpdateReqDto reqDto)  {
        byte[] buffer = new byte[1024*1024];
        int byteRead = 0;
        int segment = 0;
        String finalPath = path + des;
        String base64;
        try {
            InputStream inputStream = file.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            if (!checkFolderExisted(finalPath)){
                createNewFolder(finalPath);
            }
            String movieLink = finalPath+"\\" + this.getFileName() + "." + this.getFileFormat(file);
            OutputStream outputStream = new FileOutputStream(movieLink, true);

            while (byteRead != -1) {
                byteRead = bufferedInputStream.read(buffer, 0, buffer.length);
                if (byteRead == -1) continue;
                byte[] finalByte;
                if (buffer.length > byteRead) {
                    finalByte = Arrays.copyOf(buffer, byteRead);
                } else {
                    finalByte = buffer;
                }
                base64 = toBase64(finalByte);
                downloadFile(base64, outputStream);
                segment++;
                log.info("copy right segment: " + segment);
            }
            inputStream.close();
            bufferedInputStream.close();
            outputStream.close();

            Date date = new Date();
            Info info = Info.builder()
                    .createdAt(date)
                    .createdBy(null) //TODO: convert access token and take user_id
                    .updatedAt(date)
                    .updatedBy(null)
                    .build();

            Movie movie = Movie.builder()
                    .name(file.getOriginalFilename())
                    .age(reqDto.getAge())
                    .director(reqDto.getDirector())
                    .country(reqDto.getCountry())
                    .description(reqDto.getDescription())
                    .length(reqDto.getLength())
                    .actors(Arrays.stream(reqDto.getActors()).collect(Collectors.toSet()))
                    .categories(Arrays.stream(reqDto.getCategories()).collect(Collectors.toSet()))
                    .movieLink(movieLink)
                    .posterLink(null)
                    .comments(null)
                    .reactions(null)
                    .view(0)
                    .info(info)
                    .build();
            movieRepo.save(movie);
        } catch (IOException e){
            log.info(e.getMessage());
        }
        return modelMapper.map(reqDto, MovieUpdateResDto.class);
    }

    private void downloadFile(String base64, OutputStream outputStream) {
        try {
            outputStream.write(Base64.getDecoder().decode(base64));
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    private String getFileName() {
        return UUID.randomUUID().toString();
    }

    private String getFileFormat(MultipartFile file) {
        return Objects.requireNonNull(file.getContentType()).split("/")[1];
    }

    private boolean checkFolderExisted(String path) {
        return new File(path).exists();
    }

    private void createNewFolder(String path) {
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    private String toBase64(byte[] byteArr) {
        return Base64.getEncoder().encodeToString(byteArr);
    }
}
