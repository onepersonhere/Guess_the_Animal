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
        String str = Main.appResource.getString("statement.prompt");
        str = str.replace("{0}", animal1.toString());
        str = str.replace("{1}", animal2.toString());
        System.out.println(str);

        String fact = scanner.nextLine();

        String[] factArr = fact.split(" ");
        //get the "fact"
        fact = "";
        for(int i = 2; i < factArr.length; i++){
            fact += factArr[i] + " ";
        }
        fact = fact.trim();

        String qns = "";
        if(factArr.length > 1){
            if(
                    factArr[1].equalsIgnoreCase(Main.appResource2.getString("can"))||
                    factArr[1].equalsIgnoreCase(Main.appResource2.getString("has"))||
                    factArr[1].equalsIgnoreCase(Main.appResource2.getString("is"))
            ){
                System.out.println(
                        Main.appResource.getString("game.isCorrect")
                                .replace("{0}", animal2.toString()));
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
                String[] niceArr = Main.appResource.getString("animal.nice").split("\f");
                int rand = (int)(Math.random() * niceArr.length);

                System.out.println(niceArr[rand] + Main.appResource.getString("animal.learnedMuch"));
            }else if(factArr[0].equalsIgnoreCase("ĝi")){
                fact = "";
                for(int i = 1; i < factArr.length; i++){
                    fact += factArr[i] + " ";
                }
                fact = fact.trim();
                // fact = loĝas en la arbaro
                System.out.println(
                        Main.appResource.getString("game.isCorrect")
                                .replace("{0}", animal2.toString()));
                if(userInputs()){
                    animal2.addFact("ĝi " + fact); //can climb trees.
                    animal1.addFact("ĝi ne " + fact);
                    printAllFacts(animal1,animal2);

                    qns = distinguish(factArr, fact);
                    animal1.factMap.put(qns, false);
                    animal2.factMap.put(qns, true);
                }else{
                    animal1.addFact("ĝi " + fact);
                    animal2.addFact("ĝi ne " + fact);
                    printAllFacts(animal1,animal2);

                    qns = distinguish(factArr, fact);
                    animal1.factMap.put(qns, true);
                    animal2.factMap.put(qns, false);
                }

                listOfFacts.add(qns);
                String[] niceArr = Main.appResource.getString("animal.nice").split("\f");
                int rand = (int)(Math.random() * niceArr.length);

                System.out.println(niceArr[rand] + Main.appResource.getString("animal.learnedMuch"));
            }
            else{
                showExamples(animal1,animal2);
            }
        }else{
            showExamples(animal1,animal2);
        }
        return qns;
    }

    private static void showExamples(Animal animal1, Animal animal2){
        System.out.println(Main.appResource.getString("statement.error"));
        addFact(animal1,animal2);
    }

    private static String swapFormat(String[] factArr){
        if(factArr[1].equalsIgnoreCase(Main.appResource2.getString("can"))){
            return Main.appResource2.getString("can't");
        }
        else if(factArr[1].equalsIgnoreCase(Main.appResource2.getString("has"))){
            return Main.appResource2.getString("doesn't have");
        }
        return Main.appResource2.getString("isn't");
    }

    private static void printAllFacts(Animal animal1, Animal animal2){
        System.out.println(Main.appResource.getString("game.learned"));
        System.out.println("- "+Main.appResource2.getString("The") +
                " " + animal1.getAnimal() +
                " " + animal1.getFact().get(animal1.getFact().size()-1) + ".");
        System.out.println("- "+Main.appResource2.getString("The") +
                " " + animal2.getAnimal() +
                " " + animal2.getFact().get(animal2.getFact().size()-1) + ".");
    }

    private static String distinguish(String[] factArr, String fact){
        System.out.println(Main.appResource.getString("game.distinguish"));
        String str = "";
        if(factArr[1].equalsIgnoreCase(Main.appResource2.getString("can"))){
            str = Main.appResource2.getString("Can it") + fact + "?";
        }else if(factArr[1].equalsIgnoreCase(Main.appResource2.getString("has"))){
            str = Main.appResource2.getString("Does it have") + fact + "?";
        }else if(factArr[1].equalsIgnoreCase(Main.appResource2.getString("is"))){
            str = Main.appResource2.getString("Is it") + fact + "?";
        }else if(factArr[0].equalsIgnoreCase("ĝi")){
            str = "Ĉu ĝi " + fact + "?";
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
        }else if(qnsArr[0].equalsIgnoreCase("Ĉu") && bool){
            if(qnsArr[2].equalsIgnoreCase("estas")){
                str = "Ĝi estas " + fact + ".";
            }else if(qnsArr[2].equalsIgnoreCase("povas")){
                str = "Ĝi povas " + fact + ".";
            }else if(qnsArr[2].equalsIgnoreCase("havas")){
                str = "Ĝi havas " + fact + ".";
            }else{
                str = "Ĝi " + fact + ".";
            }
        }else if(qnsArr[0].equalsIgnoreCase("Ĉu") && !bool){
            if(qnsArr[2].equalsIgnoreCase("estas")){
                str = "Ĝi ne estas " + fact + ".";
            }else if(qnsArr[2].equalsIgnoreCase("povas")){
                str = "Ĝi ne povas " + fact + ".";
            }else if(qnsArr[2].equalsIgnoreCase("havas")){
                str = "Ĝi ne havas " + fact + ".";
            }else{
                str = "Ĝi ne " + fact + ".";
            }
        }
        return str;
    }
}
