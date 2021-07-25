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
    public static BinaryTree tree = new BinaryTree();
    private static List<Animal> listOfAnimals = new ArrayList<>();

    public Game(){ //build node
        if(FileINOUT.searchForFile(Menu.filepath)){
            //if file is found
            //tree.setRoot
        }else{
            defaultStart();
        }
    }
    private void defaultStart(){
        //Greetings
        System.out.println(getTime() + "\n");

        System.out.println(Main.appResource.getString("animal.wantLearn"));
        System.out.println(Main.appResource.getString("animal.askFavorite"));

        Animal animal = new Animal(askForAnimal());
        tree.addNode(animal);
        BinaryTree.setRoot(new Node(animal));
        listOfAnimals.add(animal);
    }
    public static void playDefault(){
        Animal animal = listOfAnimals.get(0);
        System.out.println(Main.appResource.getString("game.letsPlay"));
        System.out.println(Main.appResource.getString("game.think"));
        System.out.println(Main.appResource.getString("game.enter"));

        new Scanner(System.in).nextLine(); //consumes the \n

        BinaryTree.setRoot(new Node(animal));
        System.out.println(Main.appResource2.getString("animal.question")
                .replace("{0}", animal.toString()));

        if(!userInputs()){
            System.out.println(Main.appResource.getString("game.giveUp"));
            Animal animal2 = new Animal(askForAnimal());
            listOfAnimals.add(animal2);

            String fact = addFact(animal,animal2);
            BinaryTree.setRoot(new Node(fact));
            tree = new BinaryTree(BinaryTree.getRoot());
        }else{
            String[] winArr = Main.appResource.getString("game.win").split("\f");
            int rand = (int) (Math.random() * winArr.length);
            System.out.println(winArr[rand]);
            BinaryTree.setRoot(new Node(animal));
        }
    }
    //traverse node/build node
    public void playGame(){
        System.out.println(Main.appResource.getString("game.letsPlay"));
        System.out.println(Main.appResource.getString("game.think"));
        System.out.println(Main.appResource.getString("game.enter"));
        new Scanner(System.in).nextLine(); //consumes the \n

        //System.out.println(listOfAnimals);
        tree = TraverseBinaryTree.traverseTree(tree, BinaryTree.getRoot());
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
            return Main.appResource.getString("greeting.morning");
        }else if(hour > 12 && hour <= 18){
            return Main.appResource.getString("greeting.afternoon");
        }else{
            return Main.appResource.getString("greeting.night");
        }
    }
}
