package com.project.myCollegeHelper.restApi;

import com.project.myCollegeHelper.entity.SubjectNotesEntity;
import com.project.myCollegeHelper.entity.SubjectsEntity;
import com.project.myCollegeHelper.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    StudentServiceImpl studentService;

    @RequestMapping(value = "/subject/all", method = RequestMethod.GET)
    ArrayList<SubjectsEntity> allSubjects() {
        return studentService.getAllSubjects();
    }

    @RequestMapping(value = "/subject/getNotes/{studentId}/{subjectId}", method = RequestMethod.GET)
    ArrayList<SubjectNotesEntity> getNotes(@PathVariable String studentId, @PathVariable String subjectId) {
        return studentService.getNotes(studentId, subjectId);
    }
}
