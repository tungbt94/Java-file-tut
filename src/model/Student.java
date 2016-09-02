/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tungb
 */
public class Student {
    private int code;
    private String name;
    private double score;

    public Student(int code, String name, double score) {
        this.code = code;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return code + "\t" + name +"\t" + score;
    }
}
