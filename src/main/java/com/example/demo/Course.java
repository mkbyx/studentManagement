package com.example.demo;

import java.util.List;
import java.util.ArrayList;

public class Course {
    private final String courseName;
    private final int courseCode;
    private final int creditHours;
    private List<Student> students;
    private Teacher teacher;

    public Course(String courseName, int courseCode, int creditHours) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public List<Student> getEnrolledStudents() {
        return students;
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
        teacher.assignCourse(this);
    }

    public void displayCourseInfo(){
        System.out.println("Course: " + courseName);
        System.out.println("Course Code: " + courseCode);
        System.out.println("Credit Hours: " + creditHours);
        System.out.println("Teacher: " + teacher.getName());
        System.out.println("Enrolled Students: ");
        for (Student student : students){
            student.displayInfo();
        }
    }
}
