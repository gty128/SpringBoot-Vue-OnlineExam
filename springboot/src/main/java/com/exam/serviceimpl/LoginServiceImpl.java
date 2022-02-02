package com.exam.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.exam.entity.Admin;
import com.exam.entity.Login;
import com.exam.entity.Student;
import com.exam.entity.Teacher;
import com.exam.service.AdminService;
import com.exam.service.LoginService;
import com.exam.service.StudentService;
import com.exam.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AdminService adminService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @Override
    public Object login(Login login) {
        QueryWrapper<Admin> qw1 = new QueryWrapper<>();
        Admin admin = adminService.getOne(qw1.lambda().
                eq(Admin::getAdminId, login.getUsername()).eq(Admin::getPwd, login.getPassword()));
        if(admin!=null){
            return admin;
        }
        QueryWrapper<Teacher> qw2 = new QueryWrapper<>();
        Teacher teacher = teacherService.getOne(qw2.lambda().
                eq(Teacher::getTeacherId, login.getUsername()).
                eq(Teacher::getPwd, login.getPassword()));
        if(teacher!=null){
            return teacher;
        }
        QueryWrapper<Student> qw3 = new QueryWrapper<>();
        Student student = studentService.getOne(qw3.lambda().
                eq(Student::getStudentId, login.getUsername()).
                eq(Student::getPwd, login.getPassword()));
        if(student!=null){
            return student;
        }

        return null;
    }
}
