package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.common.AjaxResult;
import com.exam.entity.ApiResult;
import com.exam.entity.Teacher;
import com.exam.service.TeacherService;
import com.exam.serviceimpl.TeacherServiceImpl;
import com.exam.util.ApiResultHandler;
import com.exam.vo.AnswerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @GetMapping("/teachers/{page}/{size}")
    public AjaxResult findAll(@PathVariable Integer page, @PathVariable Integer size){
        Page<Teacher> teacherPage = new Page<>(page,size);

        return AjaxResult.success(teacherService.page(teacherPage));
    }

    @GetMapping("/teacher/{teacherId}")
    public AjaxResult findById(@PathVariable("teacherId") Integer teacherId){
        return AjaxResult.success(teacherService.getById(teacherId));
    }

    @DeleteMapping("/teacher/{teacherId}")
    public AjaxResult deleteById(@PathVariable("teacherId") Integer teacherId){
        return AjaxResult.success(teacherService.removeById(teacherId));
    }

    @PutMapping("/teacher")
    public AjaxResult update(@RequestBody Teacher teacher){
        return AjaxResult.success(teacherService.saveOrUpdate(teacher));
    }

    @PostMapping("/teacher")
    public AjaxResult add(@RequestBody Teacher teacher){
        return AjaxResult.success(teacherService.save(teacher));
    }
}
