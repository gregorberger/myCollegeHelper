package com.project.myCollegeHelper.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subject_notes", schema = "Data", catalog = "")
@IdClass(SubjectNotesEntityPK.class)
public class SubjectNotesEntity {
    private int id;
    private int studentId;
    private int subjectId;
    private String title;
    private String notes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectNotesEntity that = (SubjectNotesEntity) o;
        return id == that.id &&
                studentId == that.studentId &&
                subjectId == that.subjectId &&
                Objects.equals(title, that.title) &&
                Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, subjectId, title, notes);
    }
}
