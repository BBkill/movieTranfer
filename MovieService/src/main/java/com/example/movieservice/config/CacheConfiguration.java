package com.example.movieservice.config;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfiguration {

    private static final int LINK_MOVIE_LIFE_TIME = 1;
//    private static final int MOVIE_NAME_LIFE_TIME = 1;

    @Bean("linkCache")
    public LoadingCache<String, String> createMovieLinkCacheBean() {
        return CacheBuilder.newBuilder()
                .expireAfterWrite(LINK_MOVIE_LIFE_TIME, TimeUnit.MINUTES)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        return key.toUpperCase();
                    }
                });
    }

//    @Bean("nameCache")
//    public LoadingCache<String, String> createMovieNameCacheBean() {
//        return CacheBuilder.newBuilder()
//                .expireAfterWrite(MOVIE_NAME_LIFE_TIME, TimeUnit.DAYS)
//                .build(new CacheLoader<String, String>() {
//                    @Override
//                    public String load(String key) throws Exception {
//                        return key.toUpperCase();
//                    }
//                });
//    }
}
