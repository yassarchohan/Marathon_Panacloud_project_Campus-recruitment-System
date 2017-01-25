package com.example.ubitian.campus_recruiment_system;

/**
 * Created by Ubitian on 1/25/2017.
 */

public class Getter_methods {

    private String Student_name;
    private String Student_password;
    private String key;
    private String Avg_gpa;
    private String Subject;

    private String company_username;
    private String company_password;
    private String company_name;

    public Getter_methods() {
    }

    public Getter_methods(String student_name, String student_password, String key) {
        Student_name = student_name;
        Student_password = student_password;
        this.key = key;
    }

    public Getter_methods(String student_name, String student_password, String avg_gpa, String subject) {
        Student_name = student_name;
        Student_password = student_password;
        Avg_gpa = avg_gpa;
        Subject = subject;
    }


    public String getKey() {
        return key;
    }

    public String getStudent_name() {
        return Student_name;
    }

    public String getStudent_password() {
        return Student_password;
    }

    public String getAvg_gpa() {
        return Avg_gpa;
    }







    public String getCompany_username() {
        return company_username;
    }

    public String getCompany_password() {
        return company_password;
    }

    public String getCompany_name() {
        return company_name;
    }
}
