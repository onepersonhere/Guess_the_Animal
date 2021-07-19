package animals;

import animals.BinaryTree.BinaryTree;
import animals.BinaryTree.Node;
import animals.BinaryTree.TraverseBinaryTree;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static animals.AnimalProcessor.askForAnimal;
import static animals.Fact.addFact;
import static animals.UserInputs.userInputs;

public class Game {
    public BinaryTree tree = new BinaryTree();
    private static List<Animal> listOfAnimals = new ArrayList<>();

    public Game(){ //build node
        if(FileINOUT.searchForFile(Menu.filepath)){
            //if file is found
            //tree.setRoot
            playGame();
        }else{
            defaultStart();
        }
    }
    private void defaultStart(){
        //Greetings
        System.out.println(getTime() + "\n");

        System.out.println("I want to learn about animals.");
        System.out.println("Which animal do you like most?");
        Animal animal = new Animal(askForAnimal());
        tree.addNode(animal);
        BinaryTree.setRoot(new Node(animal));
        listOfAnimals.add(animal);
    }
    public void playDefault(Animal animal){
        System.out.println(
                "Wonderful! I've learned so much about animals!" +
                        "Let's play a game!\n" +
                        "You think of an animal, and I guess it.\n" +
                        "Press enter when you're ready.");

        new Scanner(System.in).nextLine(); //consumes the \n

        BinaryTree.setRoot(new Node(animal));
        System.out.println("Is it " + animal + "?");

        if(!userInputs()){
            System.out.println("I give up. What animal do you have in mind?");
            Animal animal2 = new Animal(askForAnimal());
            listOfAnimals.add(animal2);

            String fact = addFact(animal,animal2);
            BinaryTree.setRoot(new Node(fact));
            tree = new BinaryTree(tree.getRoot());
        }else{
            System.out.println("AI Wins!");
            tree.setRoot(new Node(animal));
        }
    }
    //traverse node/build node
    public void playGame(){
        System.out.println(
                "Let's play a game!\n" +
                "You think of an animal, and I guess it.\n" +
                "Press enter when you're ready.");
        new Scanner(System.in).nextLine(); //consumes the \n

        System.out.println(listOfAnimals);
        tree = TraverseBinaryTree.traverseTree(tree, tree.getRoot());
    }

    public static void addListOfAnimals(Animal animal) {
        listOfAnimals.add(animal);
    }

    public static List<Animal> getListOfAnimals() {
        return listOfAnimals;
    }

    private static String getTime(){
        LocalTime time = LocalTime.now();
        int hour = time.getHour();
        if(hour >= 5 && hour <= 12){
            return "Good morning";
        }else if(hour > 12 && hour <= 18){
            return "Good afternoon";
        }else{
            return "Good evening";
        }
    }
}
