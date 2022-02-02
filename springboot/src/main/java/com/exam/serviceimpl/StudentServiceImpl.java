package com.exam.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exam.entity.Student;
import com.exam.mapper.StudentMapper;
import com.exam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService {
//    @Autowired
//    private StudentMapper studentMapper;
//
//
//    @Override
//    public IPage<Student> findAll(Page<Student> page) {
//        return studentMapper.findAll(page);
//    }
//
//    @Override
//    public Student findById(Integer studentId) {
//        return studentMapper.findById(studentId);
//    }
//
//    @Override
//    public int deleteById(Integer studentId) {
//        return studentMapper.deleteById(studentId);
//    }
//
//    @Override
//    public int update(Student student) {
//        return studentMapper.update(student);
//    }
//
//    @Override
//    public int updatePwd(Student student) {
//        return studentMapper.updatePwd(student);
//    }
//
//    @Override
//    public int add(Student student) {
//        return studentMapper.add(student);
//    }
}
