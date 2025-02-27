package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SMSController {

    private Map<Integer, Student> students = new HashMap<>();
    private Map<Integer, Course> courses = new HashMap<>();

    @PostMapping("/students")
    public String createStudent(@RequestBody Student student) {
        students.put(student.getStudentID(), student);
        return "Student created successfully!";
    }

    @PostMapping("/courses")
    public String createCourse(@RequestBody Course course) {
        courses.put(course.getCourseCode(), course);
        return "Course created successfully!";
    }

    @PostMapping("/enrollments")
    public String enrollStudent(@RequestParam int studentId, @RequestParam int courseCode) {
        Student student = students.get(studentId);
        Course course = courses.get(courseCode);
        if (student != null && course != null) {
            Enrollment enrollment = new Enrollment(student, course);
            enrollment.register();
            return "Student enrolled in course successfully!";
        }
        return "Invalid student or course!";
    }

    @GetMapping("/students")
    public Map<Integer,Student> getAllStudents() {
        return students;
    }

    @GetMapping("/students/{id}")
    public void getStudent(@PathVariable int id) {
        Student student = students.get(id);
        if (student != null) {
            student.displayInfo();
        }else{
            System.out.println("Student not found!");
        }
    }

    @GetMapping("/courses")
    public Map<Integer,Course> getAllCourses() {
        return courses;
    }

    @GetMapping("/courses/{id}")
    public void getCourse(@PathVariable int id) {
        Course course = courses.get(id);
        if (course != null) {
            course.displayCourseInfo();
            System.out.println("\nEnrolled Students: ");
            course.getEnrolledStudents();
        }else{
            System.out.println("Course not found!");
        }
    }

    @PostMapping("/students/{id}/addGrade")
    public String addGradeToStudent(@PathVariable int id, @RequestParam int grade) {
        Student student = students.get(id);
        if (student != null) {
            student.addGrade(grade);
            return "Grade added successfully! New average: " + student.getAverage();
        }
        return "Student not found!";
    }
}
