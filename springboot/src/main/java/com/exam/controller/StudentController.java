package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.common.AjaxResult;
import com.exam.entity.ApiResult;
import com.exam.entity.Student;
import com.exam.service.StudentService;
import com.exam.serviceimpl.StudentServiceImpl;
import com.exam.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students/{page}/{size}")
    public AjaxResult findAll(@PathVariable Integer page, @PathVariable Integer size) {
        IPage<Student> p = new Page<Student>(page,size);
        return AjaxResult.success(studentService.page(p));
    }

    @GetMapping("/student/{studentId}")
    public AjaxResult findById(@PathVariable("studentId") Integer studentId) {
      return AjaxResult.success(studentService.getById(studentId));
    }
//
    @DeleteMapping("/student/{studentId}")
    public AjaxResult deleteById(@PathVariable("studentId") Integer studentId) {
       return AjaxResult.success(studentService.removeById(studentId));
    }
//
//    @PutMapping("/studentPWD")
//    public ApiResult updatePwd(@RequestBody Student student) {
//        studentService.updatePwd(student);
//        return ApiResultHandler.buildApiResult(200,"密码更新成功",null);
//    }
    @PutMapping("/student")
    public AjaxResult update(@RequestBody Student student) {
        return AjaxResult.success( studentService.saveOrUpdate(student));
    }
//
    @PostMapping("/student")
    public AjaxResult add(@RequestBody Student student) {

        return AjaxResult.success(studentService.save(student));

    }
}
