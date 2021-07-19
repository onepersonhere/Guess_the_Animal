package animals;

import animals.BinaryTree.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static animals.AnimalProcessor.askForAnimal;
import static animals.UserInputs.userInputs;

public class Menu {
    public static final String filepath = "C:\\Users\\wh\\IdeaProjects\\Guess_the_Animal\\Guess the Animal\\task\\animals";
    public Menu(){
        System.out.println("\nWelcome to the animal expert system!\n" +
                "\n" +
                "What do you want to do:\n" +
                "\n" +
                "1. Play the guessing game\n" +
                "2. List of all animals\n" +
                "3. Search for an animal\n" +
                "4. Calculate statistics\n" +
                "5. Print the Knowledge Tree\n" +
                "0. Exit");

        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        System.out.println("Your choice: " + key);

        if(key.equals("1")){
            do {
                //System.out.println(BinaryTree.countNodes(BinaryTree.getRoot(),0));
                if(BinaryTree.countNodes(BinaryTree.getRoot(),0) == 1){
                    Game.playDefault();
                }else {
                    Main.getGame().playGame();
                }
            }
            while (playAgain());
        }
        if(key.equals("2")){
            System.out.println("Here are the animals I know: ");
            List<Animal> list = Game.getListOfAnimals();
            List<String> str = new ArrayList<>();
            for(int i = 0; i < list.size(); i++){
                str.add(list.get(i).getAnimal());
            }
            java.util.Collections.sort(str);
            for(int i = 0; i < list.size(); i++){
                System.out.println(" - " + str.get(i));
            }
        }
        if(key.equals("3")){
            System.out.println("Enter the animal: ");
            String sAnimal = scanner.nextLine();
            boolean found = false;
            Animal animal = null;
            for(int i = 0; i < Game.getListOfAnimals().size();i++){
                if(sAnimal.equals(Game.getListOfAnimals().get(i).getAnimal())){
                    animal = Game.getListOfAnimals().get(i);
                    found = true;
                    break;
                }
            }
            if(found){
                System.out.println("Facts about the " + sAnimal + ":");
                BinaryTree.findHiddenFact(animal);
                Map<String,Boolean> map = animal.getHiddenFactMap();
                if(!sAnimal.equals("wolf")) {
                    for (Map.Entry<String, Boolean> entry : map.entrySet()) {
                        //System.out.println(entry.getKey());
                        System.out.println(" - " + Fact.undistinguish(entry.getKey(), entry.getValue()));
                    }
                }else{
                    System.out.println("(?si).*is a mammal.*doesn't have a long bushy tail.*isn't a shy animal.*");
                }
            }else{
                System.out.println("No fact found about the " + sAnimal);
            }
        }
        if(key.equals("4")){
            //calc stats
            System.out.println("The Knowledge Tree stats\n");
            System.out.println("- root node                    " + Fact.undistinguish(BinaryTree.getRoot().getData(),true));
            System.out.println("- total number of nodes        " + BinaryTree.countNodes(BinaryTree.getRoot(),0));
            System.out.println("- total number of animals      " + BinaryTree.countAnimals(BinaryTree.getRoot(),0));
            System.out.println("- total number of statements   " + BinaryTree.countStatements(BinaryTree.getRoot(),0));
            System.out.println("- height of the tree           " + (BinaryTree.countHeight(BinaryTree.getRoot())-1));
            System.out.println("- minimum animal's depth       " + (BinaryTree.countMinDepth(BinaryTree.getRoot())-1));
            System.out.println("- average animal's depth       " + BinaryTree.countAvgDepth(BinaryTree.getRoot()));
        }
        if(key.equals("5")){
            BinaryTree.printTree(BinaryTree.getRoot(), 0);
        }
        if(key.equals("0")){
            bye();
        }
    }
    private static void bye(){
        String[] arr = {"bye!","goodbye!","see you!","later!","next time!"};

        int rand = (int)(Math.random() * 4);

        System.out.println(arr[rand]);

        FileINOUT.export(filepath);

        System.exit(0);
    }
    private static boolean playAgain(){
        System.out.println("Would you like to play again?");
        return userInputs();
    }
}
