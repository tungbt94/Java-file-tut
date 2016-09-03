/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import io.IO;
import io.StudentIO;
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
    private static final String STUDENT_FILE_DS = "StudentDS.txt";
    private static final String STUDENT_FILE_B = "StudentB.txt";

    public StudentController() {
        studentList = new ArrayList<>();
        studentCode = 100;
    }

    public void add() {
        int numberStudentAdded = 3;
        for (int i = 0; i < numberStudentAdded; i++) {
            studentList.add(
                    new Student(studentCode++, "S " + studentCode, studentCode)
            );
        }
//        IO.WriteToFile(studentList, STUDENT_FILE);
//        StudentIO.writeToFileUseDataOutputStream(studentList, STUDENT_FILE_DS);
        StudentIO.writeToFileUseBufferWriter(studentList, STUDENT_FILE_B);
    }

    public void removeLastStudent() {
        studentList.remove(studentList.size() - 1);
//        IO.WriteToFile(studentList, STUDENT_FILE);
//        StudentIO.writeToFileUseDataOutputStream(studentList, STUDENT_FILE_DS);
        StudentIO.writeToFileUseBufferWriter(studentList, STUDENT_FILE_B);
    }

    public void showListStudent() {
        studentList.clear();//clear before read
//        studentList = IO.ReadFromFile(STUDENT_FILE);
//        studentList = StudentIO.readFromFileUseDataInputStream(STUDENT_FILE_DS);
        studentList = StudentIO.readFromFileUseBufferReader(STUDENT_FILE_B);
        System.out.println("List student:");
        for (Student s : studentList) {
            System.out.println(s.toString());
        }
    }
}
