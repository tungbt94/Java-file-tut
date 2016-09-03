/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tungb
 */
public class IO {

    //write all object of arr to file in url
    public static <T> void WriteToFile(ArrayList<T> arr, String url) {
        //init file to write
        File file = new File(url);
        try {
            //setup stream
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //write arr as Object
            oos.writeObject(arr);
            //close stream
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static <T> ArrayList<T> ReadFromFile(String url) {
        //set up arrayList and File
        ArrayList<T> arrayList = new ArrayList<>();
        File file = new File(url);
        try {
            //setup Stream
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            //read Object from file and cast to arrayList
            arrayList = (ArrayList<T>) ois.readObject();
            //close stream
            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return arrayList;
    }
}
