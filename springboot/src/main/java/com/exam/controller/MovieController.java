package com.exam.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.exam.common.AjaxResult;
import com.exam.entity.Movie;
import com.exam.service.MovieService;
import com.exam.util.NonStaticResourceHttpRequestHandler;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * @Auther gty
 * @Date 2022/2/6
 */
@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    private final NonStaticResourceHttpRequestHandler nonStaticResourceHttpRequestHandler;


    @GetMapping("/currentMovie")
    public void getCurrentMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getParameter("path");
        path = "/Users/gty/Downloads/kaiduan/"+path;
        Path filePath = Paths.get(path);
        if (Files.exists(filePath)) {
            String mimeType = Files.probeContentType(filePath);
            if (!StringUtils.isEmpty(mimeType)) {
                response.setContentType(mimeType);
            }
            request.setAttribute(NonStaticResourceHttpRequestHandler.ATTR_FILE, filePath);
            nonStaticResourceHttpRequestHandler.handleRequest(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        }
    }


    @GetMapping("/movieNum/{movieName}")
    public AjaxResult getMovieNum(@PathVariable String movieName){
        int num = 0;
        Movie movie = movieService.getOne(new QueryWrapper<Movie>().lambda().eq(Movie::getMovieName, movieName).isNull(Movie::getParentId));
        if(movie!=null){
            num = movieService.count(new QueryWrapper<Movie>().lambda().eq(Movie::getParentId,movie.getId()));
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("num",num);
        map.put("movieName",movie.getMovieNameDesc());

        return AjaxResult.success(map);
    }


}
