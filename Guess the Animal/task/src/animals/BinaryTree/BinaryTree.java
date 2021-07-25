package animals.BinaryTree;

import animals.Animal;
import animals.Game;
import animals.Main;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
            if(current.True == null && current.False == null){
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
    public static void printTree(Node current, int depth){
        String spaces = "";
        for(int i = 0; i < depth; i++){
            spaces += "  ";
        }
        System.out.println(spaces + current);
        if(current.False != null){
            printTree(current.False, depth+1);
        }
        if(current.True != null){
            printTree(current.True, depth+1);
        }
    }

    public static int countNodes(Node current, int num){
        if(current != null){
            num++;
        }
        if(current.True != null){
            num = countNodes(current.True,num);
        }
        if(current.False != null){
            num = countNodes(current.False,num);
        }
        return num;
    }
    public static int countAnimals(Node current, int num){
        if(current != null) {
            for (int i = 0; i < Game.getListOfAnimals().size(); i++) {
                if (Game.getListOfAnimals().get(i).toString().equals(current.data)) {
                    num++;
                    break;
                }
            }
        }
        if(current.True != null){
            num = countAnimals(current.True,num);
        }
        if(current.False != null){
            num = countAnimals(current.False,num);
        }
        return num;
    }
    public static int countStatements(Node current, int num){
        if(current != null) {
            for (int i = 0; i < listOfFacts.size(); i++) {
                if (current.data.equals(listOfFacts.get(i))) {
                    num++;
                    break;
                }
            }
        }
        if(current.True != null){
            num = countStatements(current.True,num);
        }
        if(current.False != null){
            num = countStatements(current.False,num);
        }
        return num;
    }
    public static int countHeight(Node current){
        if (current == null)
            return 0;
        else {
            /* compute the depth of each subtree */
            int lDepth = countHeight(current.True);
            int rDepth = countHeight(current.False);

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }
    public static int countMinDepth(Node current){
        // Corner case. Should never be hit unless the code is
        // called on root = NULL
        if (current == null)
            return 0;

        // Base case : Leaf Node. This accounts for height = 1.
        if (current.True == null && current.False == null)
            return 1;

        // If left subtree is NULL, recur for right subtree
        if (current.True == null)
            return countMinDepth(current.False) + 1;

        // If right subtree is NULL, recur for left subtree
        if (current.False == null)
            return countMinDepth(current.True) + 1;

        return Math.min(countMinDepth(current.True),
                countMinDepth(current.False)) + 1;
    }
    private static double totalDepth(Node current, int num){
        //total depth of each animal
        if (current == null) {
            return 0;
        }
        return num +
                totalDepth(current.True, num + 1) +
                totalDepth(current.False, num + 1);
    }

    public static double countAvgDepth(Node current){
        BigDecimal bd = new BigDecimal((totalDepth(current, 0)-1) / Game.getListOfAnimals().size())
                .setScale(1, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static void findHiddenFact(Animal animal){
        Node animalNode = findNode(root, animal.toString());
        //System.out.println("Node: " + animalNode);
        addHiddenFact(animalNode, animal);
    }

    private static Node findNode(Node node, String animal){
        if(node != null){
            if(node.data.equals(animal)){
                return node;
            } else {
                Node foundNode = findNode(node.True, animal);
                if(foundNode == null) {
                    foundNode = findNode(node.False, animal);
                }
                return foundNode;
            }
        } else {
            return null;
        }
    }

    private static void addHiddenFact(Node current, Animal animal) {
        if(current.getParent() != null){
            String qns = current.getParent().data;
            boolean bool = false;
            if(current.getParent().True == current){
                bool = true;
            }
            for (int i = 0; i < listOfFacts.size(); i++) {
                //System.out.println(listOfFacts.get(i));
                if (listOfFacts.get(i).equals(qns)) {
                    animal.addHiddenFactMap(qns, bool);
                    break;
                }
            }
            if(current.getParent() != root) {
                addHiddenFact(current.getParent(), animal);
            }
        }
    }
}
