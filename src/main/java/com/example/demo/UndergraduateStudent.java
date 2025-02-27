package com.example.demo;

public class UndergraduateStudent extends Student {

    public UndergraduateStudent(String name, int studentID, int age) {
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
            if (sum/getGrades().size()>=10){
                System.out.println("If "+getName()+" continues like this, he/her will pass with an average of: "+Math.round(average * 100.0) / 100.0 + ". Good job!");
            }else{
                System.out.println("If"+getName()+ " continues like this, he/her will fail with an average of "+Math.round(average * 100.0) / 100.0 + ". Pull yourself together!");
            }
        setaverage(Math.round(average * 100.0) / 100.0); 
        }
    }
}
