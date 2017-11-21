package com.senla.bookshop.utils;

import com.danco.training.TextFileWorker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextFileUtil {
    private String filePath;
    private TextFileWorker textFileWorker;

    public TextFileUtil(String filePath) {
        this.filePath = filePath;
    }

    public void writeDataToFile(String[] strArray){
        Path path = Paths.get(filePath);
        if(!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
        textFileWorker = new TextFileWorker(filePath);
        textFileWorker.writeToFile(strArray);
    }

    public String[] readDataFromFile() {
        Path path = Paths.get(filePath);
        if(!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
        textFileWorker = new TextFileWorker(filePath);
        return textFileWorker.readFromFile();
    }
}
