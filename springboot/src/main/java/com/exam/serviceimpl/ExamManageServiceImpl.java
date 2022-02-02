package com.exam.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.entity.ExamManage;
import com.exam.mapper.ExamManageMapper;
import com.exam.service.ExamManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.restart.ConditionalOnInitializedRestarter;
import org.springframework.stereotype.Service;

import java.time.chrono.IsoChronology;
import java.util.Date;
import java.util.List;

@Service
public class ExamManageServiceImpl extends ServiceImpl<ExamManageMapper,ExamManage> implements ExamManageService {


    @Override
    public List<ExamManage> findAll() {
        return null;
    }

    @Override
    public IPage<ExamManage> findAll(Page<ExamManage> page) {
        return null;
    }

    @Override
    public ExamManage findById(Integer examCode) {
        return null;
    }

    @Override
    public int delete(Integer examCode) {
        return 0;
    }

    @Override
    public int update(ExamManage exammanage) {
        return 0;
    }

    @Override
    public int add(ExamManage exammanage) {
        return 0;
    }

    @Override
    public ExamManage findOnlyPaperId() {
        return null;
    }

    @Override
    public IPage<ExamManage> getUnBeginExam(Page<ExamManage> page) {
        QueryWrapper<ExamManage> qw = new QueryWrapper<>();
        qw.lambda().lt(ExamManage::getExamDate,new Date());
       return  this.page(page,qw);

    }
}
