    package com.example.demo;

public class Teacher extends Person {
        private final int teacherId;
        private String subject; 

        public Teacher(String name, int age, int teacherId) {
            super(name, age);
            this.teacherId = teacherId;
        }

        public int  getTeacherId(){
            return teacherId;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public void assignCourse(Course course) {
            this.subject = course.getCourseName();
        }

        @Override
        public void displayInfo() {
            System.out.println("Teacher Name: " + getName());
            System.out.println("Teacher Age: " + getAge());
            System.out.println("Teacher ID: " + teacherId);
            System.out.println("Subject: " + subject);
        }
    }
