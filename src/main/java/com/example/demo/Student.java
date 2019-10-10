package com.example.demo;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Student {
    //----Table ID for student----
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentID;
    //----Fields----------------
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String major;
    //----Data Relation to Test-----
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Test> tests;

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Set<Test> getTest() {
        return tests;
    }

    public void setTest(Set<Test> test) {
        this.tests = tests;
    }

    public long getStudentId() {
        return studentID;
    }

    public void setStudentId(long studentId) {
        this.studentID = studentID;
    }
}
