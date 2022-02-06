package com.exam.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.entity.Movie;
import com.exam.mapper.MovieMapper;
import com.exam.service.MovieService;
import org.springframework.stereotype.Service;

/**
 * @Auther gty
 * @Date 2022/2/6
 */
@Service
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie> implements MovieService {
}
