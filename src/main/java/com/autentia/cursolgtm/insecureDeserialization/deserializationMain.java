package com.autentia.cursolgtm.insecureDeserialization;

import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;

public class deserializationMain {

    private static Car car = new Car("1234ABC",
            "Opel Insignia",
            "Paco Perez Pinto",
            2013);

    public static void main(String[] args) {
        chooseOption();
    }

    private static void chooseOption() {
        System.out.println("What do you want to do?:");
        System.out.println("1) Save car data");
        System.out.println("2) Load car data");
        System.out.println("Enter your option:");
        String userInput = new Scanner(System.in).nextLine();
        int userOption = Integer.parseInt(userInput);
        switch (userOption) {
            case 1:
                carToJson(car);
                break;
            case 2:
                jsonToCar();
                break;
            default:
                System.err.println("You must enter a valid option!");
        }
    }

    private static void carToJson(Car car) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(car);
            System.out.println(json);
            BufferedWriter writer = new BufferedWriter(new FileWriter("myCar.txt"));
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void jsonToCar() {
        try {
            Gson gson = new Gson();
            BufferedReader reader = new BufferedReader(new FileReader("myCar.txt"));
            String json = reader.readLine();
            reader.close();
            Car loadedCar = gson.fromJson(json, Car.class);
            System.out.println("-------- ORIGINAL CAR DATA: ---------");
            System.out.println(car.toString());
            System.out.println("-------- LOADED CAR DATA: ---------");
            System.out.println(loadedCar.toString());
        } catch (FileNotFoundException e) {
            System.err.println("File not found. First, execute option 1 to create the file!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
