/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Student;

/**
 *
 * @author tungb
 */
public class StudentController {
    private ArrayList<Student> studentList;
    private int studentCode;

    public StudentController() {
        studentList = new ArrayList<>();
        studentCode = 100;
    }
    
    public void add(){
        int numberStudentAdded = 3;
        for(int i = 0; i < numberStudentAdded; i++)
            studentList.add(
                    new Student(studentCode++, "S "+studentCode, studentCode)
            );
    }
    
    public void removeLastStudent(){
        studentList.remove(studentList.size() - 1);
    }
    
    public void showListStudent(){
        System.out.println("List student:");
        for(Student s : studentList)
            System.out.println(s.toString());
    }
}
