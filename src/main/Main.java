/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.StudentController;

/**
 *
 * @author tungb
 */
public class Main {

    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        studentController.add();
        studentController.showListStudent();
        studentController.removeLastStudent();
        studentController.showListStudent();
    }

}
