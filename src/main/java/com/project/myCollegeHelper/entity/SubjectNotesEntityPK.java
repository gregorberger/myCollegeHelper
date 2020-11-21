package com.project.myCollegeHelper.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SubjectNotesEntityPK implements Serializable {
    private int id;
    private int studentId;
    private int subjectId;

    @Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "studentID")
    @Id
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Column(name = "subjectID")
    @Id
    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectNotesEntityPK that = (SubjectNotesEntityPK) o;
        return id == that.id &&
                studentId == that.studentId &&
                subjectId == that.subjectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, subjectId);
    }
}
