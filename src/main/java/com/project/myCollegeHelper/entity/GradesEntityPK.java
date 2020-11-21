package com.project.myCollegeHelper.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GradesEntityPK implements Serializable {
    private int studentId;
    private int subjectId;

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
        GradesEntityPK that = (GradesEntityPK) o;
        return studentId == that.studentId &&
                subjectId == that.subjectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, subjectId);
    }
}
