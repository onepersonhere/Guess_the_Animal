package animals;

import animals.BinaryTree.BinaryTree;
import animals.BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static animals.UserInputs.userInputs;

public class Fact {
    //returns question
    public static List<String> listOfFacts = new ArrayList<>();
    public static String addFact(Animal animal1, Animal animal2){
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

        String qns = "";
        if(factArr.length > 1){
            if(
                    factArr[1].equalsIgnoreCase("can")||
                    factArr[1].equalsIgnoreCase("has")||
                    factArr[1].equalsIgnoreCase("is")
            ){
                System.out.println("Is the statement correct for " + animal2 + "?");
                if(userInputs()){
                    animal2.addFact(factArr[1] + " " + fact); //can climb trees.
                    animal1.addFact(swapFormat(factArr) + " " + fact);

                    printAllFacts(animal1,animal2);
                    qns = distinguish(factArr, fact);
                    animal1.factMap.put(qns, false);
                    animal2.factMap.put(qns, true);
                }else{
                    animal1.addFact(factArr[1] + " " + fact); //can climb trees.

                    animal2.addFact(swapFormat(factArr) + " " + fact);

                    printAllFacts(animal1,animal2);
                    qns = distinguish(factArr, fact);
                    animal1.factMap.put(qns, true);
                    animal2.factMap.put(qns, false);
                }

                listOfFacts.add(qns);
                System.out.println("Nice! I've learned so much about animals!");
            }else{
                showExamples(animal1,animal2);
            }
        }else{
            showExamples(animal1,animal2);
        }
        return qns;
    }

    private static void showExamples(Animal animal1, Animal animal2){
        System.out.println("The examples of a statement:\n" +
                " - It can fly\n" +
                " - It has horn\n" +
                " - It is a mammal");
        addFact(animal1,animal2);
    }

    private static String swapFormat(String[] factArr){
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
                " " + animal1.getFact().get(animal1.getFact().size()-1) + ".");
        System.out.println("- The " + animal2.getAnimal() +
                " " + animal2.getFact().get(animal2.getFact().size()-1) + ".");
    }

    private static String distinguish(String[] factArr, String fact){
        System.out.println("I can distinguish these animals by asking the question:");
        String str = "";
        if(factArr[1].equalsIgnoreCase("can")){
            str = "Can it " + fact + "?";
        }else if(factArr[1].equalsIgnoreCase("has")){
            str = "Does it have " + fact + "?";
        }else if(factArr[1].equalsIgnoreCase("is")){
            str = "Is it " + fact + "?";
        }
        System.out.println("- "+str);
        return str;
    }

    public static String undistinguish(String qns, boolean bool){
        String str = qns;
        qns = qns.replaceAll("[^a-zA-Z ]", "");
        String[] qnsArr = qns.split(" ");
        String fact = "";
        for(int i = 2; i < qnsArr.length; i++){
            fact += qnsArr[i] + " ";
        }
        fact = fact.trim();
        if(qnsArr[0].equalsIgnoreCase("can") && bool){
            str = "It can " + fact + ".";
        }else if(qnsArr[0].equalsIgnoreCase("does") && bool){
            str = "It has " + fact + ".";
        }else if(qnsArr[0].equalsIgnoreCase("is") && bool){
            str = "It is " + fact + ".";
        }else if(qnsArr[0].equalsIgnoreCase("can") && !bool){
            str = "It can't " + fact + ".";
        }else if(qnsArr[0].equalsIgnoreCase("does") && !bool){
            str = "It doesn't have " + fact + ".";
        }else if(qnsArr[0].equalsIgnoreCase("is") && !bool){
            str = "It isn't " + fact + ".";
        }
        return str;
    }
}
