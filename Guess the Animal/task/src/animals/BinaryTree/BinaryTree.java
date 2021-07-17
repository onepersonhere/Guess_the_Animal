package animals.BinaryTree;

import animals.Animal;
import animals.Main;

import java.util.*;

public class BinaryTree {
    //TODO: Create multi depth nodes
    //TODO: current stuck at depth = 2
    //the tree itself is built on nodes rather than anything else
    //create a new tree everytime a question is posed.
    Node root;

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
    public Animal getAnimalRoot() {
        return (Animal) root.obj;
    }
    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }
}
