package com.example.demo;

import com.sun.javafx.beans.IDProperty;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Test {
    //---- Table ID for Tests---
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long testID;
    //-----Fields----------
    @NotNull
    private String subject;
    @NotNull
    private String date;
    @NotNull
    private String score;
    //---- Data Relation to Student------
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    public Test(){}

    public long getTestID() {
        return testID;
    }

    public void setTestID(long testID) {
        this.testID = testID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
