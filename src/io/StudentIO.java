/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author tungb
 */
public class StudentIO {

    public static void writeToFileUseDataOutputStream(
            ArrayList<Student> arr, String url) {
        File file = new File(url);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            DataOutputStream dos = new DataOutputStream(fos);
            for (Student s : arr) {
                dos.writeInt(s.getCode());
                dos.writeUTF(s.getName());
                dos.writeDouble(s.getScore());
            }
            dos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Student> readFromFileUseDataInputStream(
            String url) {
        ArrayList<Student> studentList = new ArrayList<>();
        File file = new File(url);
        try {
            FileInputStream fis = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(fis);
            int temp = 0;
            String name = null;
            double score = 0;
            while (dis.available() > 0 && (temp = dis.readInt()) >= 100) {
                name = dis.readUTF();
                score = dis.readDouble();
                studentList.add(new Student(temp, name, score));
            }
            dis.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return studentList;
    }

    //-------------------Use Buffer---------------------------------------------
    public static void writeToFileUseBufferWriter(
            ArrayList<Student> arr, String url) {
        File file = new File(url);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (Student s : arr) {
                bw.write(s.toString()+"\n");
            }
            bw.close();
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Student> readFromFileUseBufferReader(
            String url) {
        ArrayList<Student> studentList = new ArrayList<>();
        File file = new File(url);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            String sInfo = null;
            int code = 0;
            String name = null;
            double score = 0;
            while((sInfo = br.readLine()) != null){
                String[] infoList = sInfo.split("\t");
                code = Integer.parseInt(infoList[0]);
                name = infoList[1];
                score = Double.parseDouble(infoList[2]);
                studentList.add(new Student(code, name, score));
            }
            br.close();
            fileReader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return studentList;
    }
}
