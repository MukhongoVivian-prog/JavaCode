package service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static <T> void saveToFile(List<T> data, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data);
            System.out.println("Saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

public static <T> List<T> loadFromFile(String filename) {
    File file = new File(filename);
    if (!file.exists()) {
        System.out.println("File not found: " + filename + ", initializing new list.");
        return new ArrayList<>();  // Return an empty list if the file doesn't exist
    }

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
        return (List<T>) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Could not load file: " + filename);
        return new ArrayList<>();  // Return an empty list if something goes wrong
    }
}

}
