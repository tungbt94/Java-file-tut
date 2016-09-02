/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import io.IO;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author tungb
 */
public class StudentController {
    private ArrayList<Student> studentList;
    private int studentCode;
    private static final String STUDENT_FILE = "StudentOS.txt";

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
        IO.WriteToFile(studentList, STUDENT_FILE);
    }
    
    public void removeLastStudent(){
        studentList.remove(studentList.size() - 1);
        IO.WriteToFile(studentList, STUDENT_FILE);
    }
    
    public void showListStudent(){
        studentList.clear();//clear before read
        studentList = IO.ReadFromFile(STUDENT_FILE);
        System.out.println("List student:");
        for(Student s : studentList)
            System.out.println(s.toString());
    }
}
