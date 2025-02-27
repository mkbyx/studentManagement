package com.example.demo;

public class GraduateStudent extends Student {
    
    public GraduateStudent(String name, int studentID, int age) {
        super(name, studentID, age);
    }

    @Override
    public void getAverageGrade() {
        int sum = 0;
        if (getGrades() == null || getGrades().isEmpty()){
            System.out.println(getName()+" doesn't have grades yet.");
        }else{
            for(Integer grade : getGrades()){
                sum += grade;
            }
        double average = (double) sum / getGrades().size();
        System.out.println(getName()+" is graduated with the following average: "+Math.round(average * 100.0) / 100.0);
        setaverage(Math.round(average * 100.0) / 100.0);
        }
    }
}
