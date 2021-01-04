package com.project.myCollegeHelper.restApi;

import com.project.myCollegeHelper.entity.*;
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

    @RequestMapping(value = "/subject/getGrade/{studentId}/{subjectId}", method = RequestMethod.GET)
    GradesEntity getGrade(@PathVariable String studentId, @PathVariable String subjectId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getHeader("apiKey") == null || !request.getHeader("apiKey").equals("apiSecret")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed");
        }
        return studentService.getGrade(studentId, subjectId);
    }

    @RequestMapping(value = "/subject/getGradeByStudentId/{studentId}/", method = RequestMethod.GET)
    ArrayList<GradesEntity> getGradeByStudentId(@PathVariable String studentId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getHeader("apiKey") == null || !request.getHeader("apiKey").equals("apiSecret")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed");
        }
        return studentService.getGradeByStudentId(studentId);
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

    @RequestMapping(value = "/subject/deleteNote", method = RequestMethod.POST)
    public String deleteNote(@RequestBody SubjectNoteId subjectNoteId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getHeader("apiKey") == null || !request.getHeader("apiKey").equals("apiSecret")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed");
        } else {
            studentService.deleteSubjectNote(String.valueOf(subjectNoteId.getId()));
        }
        return String.valueOf(subjectNoteId.getId());
    }

    @RequestMapping(value = "/student/getAllStudents", method = RequestMethod.GET)
    ArrayList<StudentsEntity> getGradeByStudentId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getHeader("apiKey") == null || !request.getHeader("apiKey").equals("apiSecret")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed");
        }
        return studentService.getAllStudents();
    }
}
