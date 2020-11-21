package com.project.myCollegeHelper.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "grades", schema = "Data", catalog = "")
@IdClass(GradesEntityPK.class)
public class GradesEntity {
    private int studentId;
    private int subjectId;
    private String grade;

    @Id
    @Column(name = "studentID")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Id
    @Column(name = "subjectID")
    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Basic
    @Column(name = "grade")
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradesEntity that = (GradesEntity) o;
        return studentId == that.studentId &&
                subjectId == that.subjectId &&
                Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, subjectId, grade);
    }
}
