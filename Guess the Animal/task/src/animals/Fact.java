package animals;

import java.util.List;
import java.util.Scanner;
import static animals.UserInputs.userInputs;

public class Fact {
    public static void addFact(Animal animal1, Animal animal2){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Specify a fact that distinguishes "
                + animal1 + " from " + animal2 + ".");
        System.out.println("The sentence should be of the format:" +
                " 'It can/has/is ...'.");
        String fact = scanner.nextLine();

        String[] factArr = fact.split(" ");

        fact = "";
        for(int i = 2; i < factArr.length; i++){
            fact += factArr[i] + " ";
        }
        fact = fact.trim();

        if(factArr[1].equalsIgnoreCase("can")||
                factArr[1].equalsIgnoreCase("has")||
                factArr[1].equalsIgnoreCase("is")){
            System.out.println("Is it correct for " + animal2 + "?");
            if(userInputs()){
                animal2.addFact(factArr[1] + " " + fact); //can climb trees.
                animal1.addFact(checkFormat(factArr) + " " + fact);
            }else{
                animal1.addFact(factArr[1] + " " + fact); //can climb trees.
                animal2.addFact(checkFormat(factArr) + " " + fact);
            }
            printAllFacts(animal1,animal2);
            distinguish(factArr, fact);
        }else{
            showExamples(animal1,animal2);
        }
    }

    private static void showExamples(Animal animal1, Animal animal2){
        System.out.println("The examples of a statement:\n" +
                " - It can fly\n" +
                " - It has horn\n" +
                " - It is a mammal");
        addFact(animal1,animal2);
    }

    private static String checkFormat(String[] factArr){
        if(factArr[1].equalsIgnoreCase("can")){
            return "can't";
        }
        else if(factArr[1].equalsIgnoreCase("has")){
            return "doesn't have";
        }
        return "isn't";
    }

    private static void printAllFacts(Animal animal1, Animal animal2){
        System.out.println("I learned the following facts about animals:");
        System.out.println("- The " + animal1.getAnimal() +
                " " + animal1.getFact().get(0) + ".");
        System.out.println("- The " + animal2.getAnimal() +
                " " + animal2.getFact().get(0) + ".");
    }

    private static void distinguish(String[] factArr, String fact){
        System.out.println("I can distinguish these animals by asking the question:");

        if(factArr[1].equalsIgnoreCase("can")){
            System.out.println("- Can it " + fact + "?");
        }else if(factArr[1].equalsIgnoreCase("has")){
            System.out.println("- Does it have " + fact + "?");
        }else if(factArr[1].equalsIgnoreCase("is")){
            System.out.println("- Is it " + fact + "?");
        }
    }
}
