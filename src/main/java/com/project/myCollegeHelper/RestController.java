package com.project.myCollegeHelper;

import com.project.myCollegeHelper.entity.SubjectsEntity;
import com.project.myCollegeHelper.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("/subject/all")
    ArrayList<SubjectsEntity> allSubjects() {
        return studentService.getAllSubjects();
    }
}
