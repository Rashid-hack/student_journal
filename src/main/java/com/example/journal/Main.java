package com.example.journal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StudentFileService service = new StudentFileService();
        List<Student> studentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1) Tələbə əlavə et");
            System.out.println("2) Siyahıya bax");
            System.out.println("3) Obyekt kimi saxla");
            System.out.println("4) Obyekt faylından yüklə");
            System.out.println("5) Backup al");
            System.out.println("6) Çıx");

            int choice = 0;
            while (choice == 0){
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                }catch (NumberFormatException e){
                    System.out.println("Reqem yaz!");
                }
            }

            switch (choice) {
                case 1:
                    int id = 0;
                    while (id == 0){
                        try {
                            System.out.print("Telebenin ID-sini daxil et: ");
                            id = Integer.parseInt(scanner.nextLine());
                        }catch (NumberFormatException e){
                            System.out.println("Reqem yaz!");
                        }
                    }

                    System.out.print("Telebenin adini daxil edin: ");
                    String name = scanner.nextLine();

                    int age = 0;
                    while (age == 0){
                        try {

                            System.out.print("Telebenin yasini daxil edin: ");
                            age = Integer.parseInt(scanner.nextLine());
                        }catch (NumberFormatException e){
                            System.out.println("Reqem yaz!");
                        }
                    }

                    System.out.print("Parol daxil edin: ");
                    String password = scanner.nextLine();

                    Student student = new Student(id, name, age, password);

                    service.addStudent(student);
                    studentList.add(student);
                    break;
                case 2:
                    service.readStudent();
                    break;
                case 3:
                    service.saveStudent(studentList);
                    break;
                case 4:
                    List<Student> loaded = service.loadStudents();
                    for (Student student1 : loaded){
                        System.out.println(student1);
                    }
                    break;
                case 5:
                    service.copyFileFromStudent();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Yanlış seçim");
            }


        }


    }
}