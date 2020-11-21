package com.project.myCollegeHelper.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subjects", schema = "Data", catalog = "")
public class SubjectsEntity {
    private int subid;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getSubid() {
        return subid;
    }

    public void setSubid(int subid) {
        this.subid = subid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectsEntity that = (SubjectsEntity) o;
        return subid == that.subid &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subid, name);
    }
}
