package com.company;
import java.util.Scanner;
import java.io.*;

public class DogFile {
    public static Dog[] getAllDogs() throws IOException{
        Dog[] myDogs = new Dog[200];
        Scanner inFile = new Scanner(new File("dogs.txt"));

        while(inFile.hasNext()) {
            String temp = inFile.nextLine();
            String[] tempArray = temp.split("#");
            myDogs[Dog.getCount()] = new Dog(Integer.parseInt(tempArray[0]),
                    tempArray[1], tempArray[2], tempArray[3],
                    Integer.parseInt(tempArray[4]), Integer.parseInt(tempArray[5]), tempArray[6], tempArray[7]);

            /*if(tempArray[5].equals("Deleted")) {
                myDogs[Dog.getCount()] = new Dog(Integer.parseInt(tempArray[0]),
                        tempArray[1], tempArray[2], tempArray[3],
                        Integer.parseInt(tempArray[4]), Integer.parseInt(tempArray[5]), tempArray[6], tempArray[7]);
            }*/
            Dog.setCount(Dog.getCount() + 1);
        }

        inFile.close();
        return myDogs;
    }

    public static void saveAllDogs(Dog[] myDogs)throws IOException{
        PrintWriter outFile = new PrintWriter("dogs.txt");

        for(int i = 1; i < Dog.getCount(); i++) {
            outFile.println(myDogs[i].toString());
            System.out.println(myDogs[i].toString());
        }


        outFile.close();
    }

    public static void appendAllDogs(Dog[] myDogs)throws IOException{
        PrintWriter outFile = new PrintWriter(new FileWriter("dogs.txt", true));

        for(int i = 0; i < Dog.getCount(); i++) {
            outFile.println(myDogs[i].toString());
            System.out.println(myDogs[i].toString());
        }

        outFile.close();
    }

}
