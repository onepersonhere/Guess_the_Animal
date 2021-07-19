package animals.BinaryTree;

import animals.Animal;
import animals.Game;
import animals.Main;

import java.util.*;

import static animals.Fact.listOfFacts;

public class BinaryTree {
    //TODO: Create multi depth nodes
    //TODO: current stuck at depth = 2
    //the tree itself is built on nodes rather than anything else
    //create a new tree everytime a question is posed.
    static Node root;

    public BinaryTree(){}
    //create tree-
    public BinaryTree(Node currentNode){ //creates a Tree
        root = CreateBinaryTree.recursion(currentNode, 0);
    }
    public BinaryTree(String test){
        root = new Node("Is it a mammal?");
        Map<String,Boolean> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        map.put("Is it a mammal?",false);
        root.False = new Node(new Animal("shark","a shark",
                new ArrayList<>(Collections.singleton("Is it a mammal?")),map));
        root.True =
                new Node("Is it living in the forest?");
        root.True.True =
                new Node("Does it have a long bushy tail?");
        map.clear();
        map.put("Is it a mammal?",true);
        map.put("Is it living in the forest?",true);
        map.put("Does it have a long bushy tail?",true);
        list.add("Is it a mammal?");
        list.add("Is it living in the forest?");
        list.add("Does it have a long bushy tail?");
        root.True.True.True =
                new Node(new Animal("fox","a fox",list,map));
        root.True.True.False =
                new Node("Is it a shy animal?");
        map.put("Is it a shy animal?",true);
        list.add("Is it a shy animal?");
        root.True.True.False.True =
                new Node(new Animal("hare", "a hare", list, map));
        map.replace("Is it a shy animal?",false);
        root.True.True.False.False =
                new Node(new Animal("wolf", "a wolf", list, map));
        map.clear();
        list.clear();
        root.True.False = new Node("Can it climb trees?");
        map.put("Is it a mammal?",true);
        map.put("Is it living in the forest?",false);
        map.put("Can it climb trees?", true);
        list.add("Is it a mammal?");
        list.add("Is it living in the forest?");
        list.add("Can it climb trees?");
        root.True.False.True =
                new Node(new Animal("cat", "a cat", list, map));
        map.replace("Can it climb trees?",false);
        root.True.False.False =
                new Node(new Animal("dog", "a dog", list, map));
    }
    //1D tree
    public void addNode(Animal animal){
        root = new Node(animal);
    }
    public String getAnimalRoot() {
        return root.data;
    }
    public static Node getRoot() {
        return root;
    }
    public static void setRoot(Node root) {
        BinaryTree.root = root;
    }

    public static void searchNodeRecursive(Node current) {
        //TODO: Create NEW animals
        if (current.data != null) {
            //add to the animallist
            String[] arr = current.data.split(" ");
            if(arr[0].equals("a") || arr[0].equals("an")){
                //is an animal
                Animal animal = new Animal(current.data);
                getParentNode(animal, current);
                Game.addListOfAnimals(animal);
                System.out.println(animal.getAnimal()+": "+animal.factMap);
                System.out.println(animal.getAnimal()+": "+animal.getFact());
            }else{
                //is a fact
                listOfFacts.add(current.data);
                searchNodeRecursive(current.True);
                searchNodeRecursive(current.False);
            }
        }
    }
    private static void getParentNode(Animal animal, Node current){
        if(current.getParent() != null) {
            String qns = current.getParent().data;
            int m = 0;
            for (int i = 0; i < Game.getListOfAnimals().size(); i++) {
                System.out.println(Game.getListOfAnimals().get(i).factMap);
                if (Game.getListOfAnimals().get(i).factMap.containsKey(qns)) {
                    m++;
                }
            }
            if(m < 2) {
                animal.addFact(qns);

                boolean bool = false;
                if (current.getParent().True == current) {
                    bool = true;
                }
                animal.factMap.put(qns, bool);
            }
            getParentNode(animal,current.getParent());
        }
    }
}
