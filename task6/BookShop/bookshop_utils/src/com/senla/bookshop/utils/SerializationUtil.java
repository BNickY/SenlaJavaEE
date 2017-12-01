package com.senla.bookshop.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SerializationUtil {

    public static void saveData(List<Object> entities, String filePath) throws IOException {

        Path path = Paths.get(filePath);
        if(!Files.exists(path)) {
            Files.createFile(path);
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            out.writeObject(entities);
            out.flush();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Object> loadData(String filePath) throws ClassNotFoundException, IOException {
        List<Object> entities;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            entities = (ArrayList<Object>)in.readObject();
        }
        return entities;
    }
}
