package com.senla.bookshop.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextFileUtil {

    public static void writeDataToFile(String[] strArray, String filePath)throws IOException{
        Path path = Paths.get(filePath);
        if(!Files.exists(path)) {
            Files.createFile(path);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))) {
            for(String str : strArray) {
                writer.write(str+"\n");
            }
        }
    }

    public static String[] readDataFromFile(String filePath) throws IOException{

        List<String> strings = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                strings.add(line);
            }
            return strings.toArray(new String[0]);
        }
    }
}