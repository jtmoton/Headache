package com.company;
import java.util.Scanner;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
	// write your code here
        Scanner keyboard = new Scanner(System.in);
        String userInput = "";

        Dog[] myDogs = DogFile.getAllDogs();
        while(!userInput.equals("0")) {
            userInput = getMenuChoice(keyboard);
            switch(userInput) {
                case "1":
                    Dog.addDog(myDogs);
                    break;
               case"2":
                    Dog.editDog(myDogs);
                    break;
                case "3":
                    Dog.deleteDog(myDogs, keyboard);
                    break;
               /* case"4":
                    rentDog();
                    break;
                case"5":
                    returnDog();
                    break;
                case"6":
                    massUpdate();
                    break;
                case"7":
                    viewIndCustReport();
                    break;
                case"8":
                    viewHistCustReport();
                case"9":
                    viewHistBreedReport();*/
                case"0":
                    System.out.println("You have exited the program.");
                    break;
                default:
                    System.out.println("Oops! Pick a valid number from the menu.");
                    break;

            }
        }
    }



    public static String getMenuChoice(Scanner keyboard) {
        System.out.println("To add a dog, press 1." + "\n" + "To edit a dog, press 2." + "\n" + "To delete a dog, press 3." + "\n" + "To return a dog" +
                " press 4." + "\n" + "To process a batch update, press 5." + "\n" + "To view individual customer rental report, press 6. " + "\n" + "To view historical customer report, press 7. " + "\n" +
                        "To view historical breed report, press 8." + "\n" + "To exit the program, press 0.");
        String userChoice = keyboard.nextLine();
        return userChoice;
    }
}
