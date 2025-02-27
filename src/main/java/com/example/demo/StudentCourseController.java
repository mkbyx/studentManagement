package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentCourseController {

    // Simuler une liste de cours et étudiants pour l'exemple
    private List<Student> students = List.of(
            new Student("John", 1, 20),
            new Student("Jane", 2, 22),
            new Student("AIYFU", 2, 12)
    );

    private List<Course> courses = List.of(
            new Course("Math", 101, 3),
            new Course("History", 102, 4)
    );

    // Endpoint pour afficher tous les étudiants
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return students;
    }

    // Endpoint pour obtenir un étudiant par ID
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        return students.stream().filter(s -> s.getStudentID() == id).findFirst().orElse(null);
    }

    // Endpoint pour inscrire un étudiant à un cours
    @PostMapping("/enroll")
    public String enrollStudent(@RequestBody Enrollment enrollment) {
        enrollment.register();
        return "Student enrolled successfully!";
    }

    // Endpoint pour afficher tous les cours
    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courses;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot!";
    }
}
