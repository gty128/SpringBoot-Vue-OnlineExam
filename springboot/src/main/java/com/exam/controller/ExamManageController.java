package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.common.AjaxResult;
import com.exam.entity.ApiResult;
import com.exam.entity.ExamManage;
import com.exam.service.ExamManageService;
import com.exam.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ExamManageController {

    @Autowired
    private ExamManageService examManageService;

    @GetMapping("/exams")
    public AjaxResult findAll(){
        List<ExamManage> list = examManageService.list();
        return AjaxResult.success(list);
    }

    @GetMapping("/exams/{page}/{size}")
    public AjaxResult findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Page<ExamManage> examManagePage = new Page<>(page,size);
        IPage<ExamManage> page1 = examManageService.page(examManagePage);
        return AjaxResult.success(page1);
    }

    @GetMapping("/exam/{examCode}")
    public AjaxResult findById(@PathVariable("examCode") Integer examCode){
        ExamManage exam = examManageService.getById(examCode);
        return AjaxResult.success(exam);
    }

    @DeleteMapping("/exam/{examCode}")
    public AjaxResult deleteById(@PathVariable("examCode") Integer examCode){
        boolean b = examManageService.removeById(examCode);
        return AjaxResult.success(b);
    }

    @PutMapping("/exam")
    public AjaxResult update(@RequestBody ExamManage exammanage){
        boolean b = examManageService.saveOrUpdate(exammanage);
        return AjaxResult.success(b);
    }

    @PostMapping("/exam")
    public AjaxResult add(@RequestBody ExamManage exammanage){
        examManageService.addExam(exammanage);
        return AjaxResult.success();
    }



    @GetMapping("/exams/getUnbegin/{page}/{size}")
    public AjaxResult getUnbegin(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Page<ExamManage> p = new Page<>(page,size);
        IPage<ExamManage> all = examManageService.getUnBeginExam(p);
        return AjaxResult.success(all);
    }
}
