package com.project.myCollegeHelper.service;

import com.project.myCollegeHelper.entity.GradesEntity;
import com.project.myCollegeHelper.entity.StudentsEntity;
import com.project.myCollegeHelper.entity.SubjectNotesEntity;
import com.project.myCollegeHelper.entity.SubjectsEntity;

import java.util.ArrayList;

public interface StudentService {
    void insertStudent(StudentsEntity student);

    StudentsEntity getStudentByEmail(String email);

    ArrayList<StudentsEntity> getAllStudents();

    void insertSubjectNote(SubjectNotesEntity note);

    void deleteSubjectNote(String id);

    ArrayList<SubjectNotesEntity> getNotes(String studentId, String subjectId);

    SubjectNotesEntity getNote(String noteId);

    void insertSubject(SubjectsEntity subject);

    SubjectsEntity getSubject(String subjectName);

    ArrayList<SubjectsEntity> getAllSubjects();

    void insertGrade(GradesEntity grades);

    GradesEntity getGrade(String studentId, String subjectId);

    ArrayList<GradesEntity> getGradeByStudentId(String studentId);
}
