package com.exam.controller;

import com.exam.common.AjaxResult;
import com.exam.entity.Admin;
import com.exam.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admins")
    public AjaxResult findAll(){
        return AjaxResult.success(adminService.list());
    }

    @GetMapping("/admin/{adminId}")
    public AjaxResult findById(@PathVariable("adminId") Integer adminId){
        return AjaxResult.success(adminService.getById(adminId));
    }

    @DeleteMapping("/admin/{adminId}")
    public AjaxResult deleteById(@PathVariable("adminId") Integer adminId){
        adminService.removeById(adminId);
        return AjaxResult.success();
    }

    @PutMapping("/admin/{adminId}")
    public AjaxResult update(@PathVariable("adminId") Integer adminId, Admin admin){
        return AjaxResult.success(adminService.saveOrUpdate(admin));
    }

    @PostMapping("/admin")
    public AjaxResult add(Admin admin){
        return AjaxResult.success(adminService.save(admin));
    }
}
