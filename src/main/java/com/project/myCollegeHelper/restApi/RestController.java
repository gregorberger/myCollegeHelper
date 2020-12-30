package com.project.myCollegeHelper.restApi;

import com.project.myCollegeHelper.entity.SubjectNotesEntity;
import com.project.myCollegeHelper.entity.SubjectsEntity;
import com.project.myCollegeHelper.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    StudentServiceImpl studentService;

    @RequestMapping(value = "/subject/all", method = RequestMethod.GET)
    ArrayList<SubjectsEntity> allSubjects(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getHeader("apiKey") == null || !request.getHeader("apiKey").equals("apiSecret")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed");
        }
        return studentService.getAllSubjects();
    }

    @RequestMapping(value = "/subject/getNotes/{studentId}/{subjectId}", method = RequestMethod.GET)
    ArrayList<SubjectNotesEntity> getNotes(@PathVariable String studentId, @PathVariable String subjectId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getHeader("apiKey") == null || !request.getHeader("apiKey").equals("apiSecret")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed");
        }
        return studentService.getNotes(studentId, subjectId);
    }

    @RequestMapping(value = "/subject/insertNote", method = RequestMethod.POST)
    public SubjectNotesEntity insertNote(@RequestBody SubjectNotesEntity note, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getHeader("apiKey") == null || !request.getHeader("apiKey").equals("apiSecret")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed");
        } else {
            studentService.insertSubjectNote(note);
        }
        return note;
    }
}
