package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.exam.entity.ExamManage;

import java.util.List;
import java.util.concurrent.Executors;

public interface ExamManageService extends IService<ExamManage> {

//    /**
//     * 不分页查询所有考试信息
//     */
//    List<ExamManage> findAll();
//    IPage<ExamManage> findAll(Page<ExamManage> page);
//
//    ExamManage findById(Integer examCode);
//
//    int delete(Integer examCode);
//
//    int update(ExamManage exammanage);
//
//    int add(ExamManage exammanage);
//
//    ExamManage findOnlyPaperId();
//
    IPage<ExamManage> getUnBeginExam(Page<ExamManage> page);

    void addExam(ExamManage examManage);
}
