package com.example.journal;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StudentFileService {

    public void addStudent (Student student){
        Path folderPath = Path.of("data");
        try {
            Files.createDirectories(folderPath);

            Path filePath = folderPath.resolve("students.txt");

            try (FileWriter fw = new FileWriter(filePath.toFile(), true)){

                String studentLine = student.toString()+ "\n";

                fw.write(studentLine);


            }
        }catch (IOException e){
            System.out.println("Xeta bas verdi: " + e.getMessage());
        }
    }

    public void readStudent (){
        try(FileReader fr = new FileReader("data/students.txt")){
            int c;
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e){
            System.out.println("Xeta bas verdi: " + e.getMessage());
        }
    }

    public void saveStudent (List<Student> students){
        Path folderPath = Path.of("data");
        try {
            Files.createDirectories(folderPath);

            Path filePath = folderPath.resolve("students.dat");
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath.toFile()))) {
                oos.writeObject(students);
            }
        } catch (IOException e) {
            System.out.println("Xeta bas verdi: " + e.getMessage());
        }
    }

    public List<Student> loadStudents(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/students.dat"))){
           List<Student> students = (List<Student>) ois.readObject();
           return students;
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Xeta bas verdi: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public void copyFileFromStudent(){
        String sourceFile = "data/students.dat";
        String destinationFile = "data/backup.dat";

        try(FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(destinationFile)){

            byte [] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1){
                fos.write(buffer, 0, bytesRead);
            }
        }catch (IOException e){
            System.out.println("Xeta bas verdi: " + e.getMessage());
        }
    }

    public void createDirectory(){
        Path p = Path.of("data");

       try{
           Files.createDirectories(p);
       }catch (IOException e){
           System.out.println("Xeta bas verdi: " + e.getMessage());
       }
    }

    public void readFile() {
        Path p = Path.of("data", "students.txt");

        try{
            List<String> lines = Files.readAllLines(p);
            System.out.println(lines.size());
        }catch (NoSuchFileException e){
            System.out.println("Fayl tapilmadi: " + e.getMessage());
        }

        catch (IOException e){
            System.out.println("Xeta bas verdi: " + e.getMessage());
        }
    }

    public void deleteFile(){
        Path p = Path.of("data", "backup.dat");

        try{
            Files.deleteIfExists(p);
        }catch (IOException e){
            System.out.println("Xeta bas verdi: " + e.getMessage());
        }
    }
}
