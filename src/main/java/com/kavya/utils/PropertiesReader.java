package com.kavya.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    // to read the data.properties file and give the key for the value asked

    public static String readKey(String key){

        Properties p ;
        String file_path = System.getProperty("user.dir")+ "/src/main/resources/data.properties";
        try{
            FileInputStream fileInputStream = new FileInputStream(file_path);
            p= new Properties();
            p.load(fileInputStream);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        return p.getProperty(key);
    }

}
