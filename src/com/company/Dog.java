package com.company;
import java.util.Scanner;
import java.io.*;

public class Dog {
    private int id = 0;
    private String name;
    private String breed;
    private String sex;
    private int age;
    private int weight;
    private String rentIndicator = "T";
    private static int count = 1;
    private static int maxID;
    private String deleteIndicator = "Available";

    public Dog(){

    }

    public Dog(int id) {
        this.id = id;
    }

    public Dog(int id, String name, String breed, String sex, int age, int weight, String rentIndicator, String deleteIndicator) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.sex = sex;
        this.weight = weight;
        this.age = age;
        this.rentIndicator = rentIndicator;
        this.deleteIndicator = deleteIndicator;
    }

    //Getters-
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getBreed() {
        return breed;
    }
    public String getSex() {
        return sex;
    }
    public int getWeight() {
        return weight;
    }
    public static int getCount() {
        return count;
    }
    public int getAge() {
        return age;
    }
    public String isRentIndicator() {
        return rentIndicator;
    }
    public void setReturned() {
        this.rentIndicator = "T";
    }

    public void setRented() {
        this.rentIndicator = "F";
    }
    public static int getMaxID() {
        return maxID;
    }
    public String getDeleteIndicator() {
        return deleteIndicator = "Deleted";
    }


    //Setters-
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public static void setCount(int count) {
        Dog.count = count;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setRentIndicator (String rentIndicator) {
        this.rentIndicator = rentIndicator;
    }
    public static void setMaxID(int maxID) {
        Dog.maxID = maxID;
    }
    public void setDeleteIndicator(String deleteIndicator) {
        this.deleteIndicator = deleteIndicator;
    }

    //add dog method
    public static void addDog(Dog[] myDogs) throws IOException {

        maxID++;
        String userInput = "";
        Scanner keyboard = new Scanner(System.in);

        Dog tempDog = new Dog();
        System.out.println("Please enter the dog's name.");
        userInput = keyboard.nextLine();
        tempDog.setName(userInput);

        System.out.println("Please enter the dog's breed.");
        userInput = keyboard.nextLine();
        tempDog.setBreed(userInput);

        System.out.println("Please enter the dog's sex.");
        userInput = keyboard.nextLine();
        tempDog.setSex((userInput));

        System.out.println("Please enter the dog's age.");
        userInput = keyboard.nextLine();
        tempDog.setAge(Integer.parseInt(userInput));

        System.out.println("Please enter the dog's weight.");
        userInput = keyboard.nextLine();
        tempDog.setWeight(Integer.parseInt(userInput));

        myDogs[Dog.getCount()] = tempDog;
        myDogs[Dog.getCount()].setId(Dog.getCount());
        myDogs[Dog.getCount()] = tempDog;
        count++;

       /* if (Dog.getMaxID() > myDogs[Dog.getCount()].getId()) {
            Dog.setMaxID(myDogs[Dog.getCount()].getId());
        }*/

        DogFile.saveAllDogs(myDogs);

    }

    //edit dog method
    public static void editDog(Dog[] myDogs) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        String userInput1 = "";
        String userChoice = "";
        String tempChange = "";


        System.out.println("Please enter the ID of the dog you want to edit.");
        userChoice = keyboard.nextLine();

        int indexFound = binaryDogSearch(myDogs, Integer.parseInt(userChoice));
        System.out.println("Here is the dog you chose: " + myDogs[indexFound]);

        System.out.println("What would you like to change about the dog?" + "\n" + "Press N for Name, Press B for Breed," +
                " Press S for Sex, Press A for Age, Press W for Weight, and R to change availability.");

        userInput1 = keyboard.nextLine();
        binaryDogSearch(myDogs, Integer.parseInt(userChoice));

        switch (userInput1) {
            case "N":
                System.out.println("What would you like to change the name to?");
                tempChange = keyboard.next();

                myDogs[indexFound].setName(tempChange);
                break;
            case "B":
                System.out.println("What would you like to change the breed to?");
                tempChange = keyboard.next();

                myDogs[indexFound].setBreed(tempChange);
                break;
            case "S":
                System.out.println("What would you like to change the sex to?");
                tempChange = keyboard.next();

                myDogs[indexFound].setSex(tempChange);
                break;
            case "A":
                System.out.println("What would you like to change the age to?");
                tempChange = keyboard.next();

                myDogs[indexFound].setAge(Integer.parseInt(tempChange));
                break;
            case "W":
                System.out.println("What would you like to change the weight to?");
                tempChange = keyboard.next();

                myDogs[indexFound].setWeight(Integer.parseInt(tempChange));
                break;
            case "R":
                System.out.println("What would you like to change the rent indicator to?");
               tempChange = keyboard.next();

                if (!tempChange.equals("T") && !tempChange.equals("F")) {
                    System.out.println("Oops! Please change the rent indicator from T to F or from F to T.");
                } else {
                    System.out.println("Rent indicator successfully changed!");
                    myDogs[indexFound].setRentIndicator(tempChange);
                }

                break;
            default:
                System.out.print("Oops! Choose a valid letter to change a part of your dog.");
                break;
        }
        DogFile.saveAllDogs(myDogs);
    }

    //binary searching the dogs by id
        public static int binaryDogSearch(Dog[] myDogs, int searchID) {
                int indexFound = -1;
                int startIndex = 0;
                int endIndex = count - 1;
                int midIndex = 0;

                boolean notFound = true;

                while (notFound && startIndex <= endIndex){

                    midIndex = (startIndex + endIndex) / 2;

                    if(searchID == (myDogs[midIndex].getId())){

                        notFound = false;
                        indexFound = midIndex;

                    }else if (searchID > (myDogs[midIndex].getId())){

                        startIndex = midIndex + 1;

                    }else {

                        endIndex = midIndex - 1;

                    }
                }

                return indexFound;
    }

    public static void deleteDog(Dog[] myDogs, Scanner keyboard) throws IOException{
        String delChoice = "";
        System.out.println("Which dog would you like to delete?");
        delChoice = keyboard.nextLine();
        String changeDelete = "Deleted";
        int indexFound = binaryDogSearch(myDogs, Integer.parseInt(delChoice));

        System.out.println("Here is the dog you want to delete: " + myDogs[indexFound]);
        myDogs[indexFound].getDeleteIndicator();
        myDogs[indexFound].setDeleteIndicator(changeDelete);

        DogFile.saveAllDogs(myDogs);


    }

    @Override
    public String toString(){
        return id + "#" + name + "#" + breed + "#" + sex + "#" + age + "#" + weight + "#" + rentIndicator + "#" + deleteIndicator;
    }
}