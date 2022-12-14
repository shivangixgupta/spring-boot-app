package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Marks {

    @Id
    private long marksId;
    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name="semester_id")
    private Semester semester;

    private int totalMarks;
    private int studentMarks;
    private int grade;

    @JsonBackReference
    public Course getCourse() {
        return course;
    }

    @JsonBackReference
    public Semester getSemester() {
        return semester;
    }
}
