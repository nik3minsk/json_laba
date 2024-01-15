package com.core;

import com.domain.Software;
import com.domain.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;


public class GsonExample2 {
    public static void main(String[] args) {

        Gson gson = new GsonBuilder()

                .setPrettyPrinting()
                .excludeFieldsWithModifiers(Modifier.TRANSIENT, Modifier.TRANSIENT)
                .create();

        try (Reader reader = new FileReader("student.json")) {

            // Convert JSON File to Java Object
            // Staff staff = gson.fromJson(reader, Staff.class);

        /*    Software software = gson.fromJson(reader, Software.class);
            System.out.println(software);*/


            Type collectionType = new TypeToken<List<Staff>>(){}.getType();
            List<Staff> lcs = (List<Staff>) new Gson()
                    .fromJson( reader , collectionType);

            // print staff
            System.out.println(lcs);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
