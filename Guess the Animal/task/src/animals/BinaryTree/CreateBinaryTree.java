package animals.BinaryTree;

import animals.Animal;
import animals.Fact;
import animals.Game;
import animals.Main;

import java.util.ArrayList;
import java.util.List;

import static animals.Fact.listOfFacts;

public class CreateBinaryTree {

    public static List<String> qnsAcctFor = new ArrayList<>();

    public static Node recursion(Node currentNode, int qnsIdx){
        //always start from the root
        Animal[] animals = new Animal[2];
        //find the animals from Map
        int m = 0;
        System.out.println(listOfFacts);
        String qns = listOfFacts.get(qnsIdx);
        System.out.println(qnsAcctFor);
        System.out.println(Game.getListOfAnimals() + "\n");
        for (int i = 0; i < Game.getListOfAnimals().size(); i++) {
            if (Game.getListOfAnimals().get(i).factMap.containsKey(qns)) {
                animals[m] = Game.getListOfAnimals().get(i);
                m++;
            }
        }
        Animal animal1 = animals[0];
        Animal animal2 = animals[1];
        //Node = root
        if(animal1.factMap.get(qns)){ //qns is true
            currentNode.True = createTreeNodes(animal1,currentNode.True);
            currentNode.False = createTreeNodes(animal2,currentNode.False);
        }else{ //qns is false
            currentNode.True = createTreeNodes(animal2,currentNode.True);
            currentNode.False = createTreeNodes(animal1,currentNode.False);
        }

        currentNode.True.Parent = currentNode;
        currentNode.False.Parent = currentNode;
        return currentNode;
    }

    private static Node createTreeNodes(Animal animal, Node currentNode){
        boolean b = true;
        //At the start, both child nodes will be animals
        System.out.println("For " + animal);
        System.out.println(animal.getFact());
        System.out.println(animal.factMap);
        System.out.println(qnsAcctFor);

        if(getSizeOfUnaccountedFacts(animal) > 1){
            //if one of the child node has more than one unaccounted qns
            //aka might have child node
            System.out.println(animal + " has more than one fact");
            for(int i = 0; i < listOfFacts.size();i++){ //foreach fact in list of facts
                String qns = listOfFacts.get(i); //the key to the map
                boolean bool = true;//check if the qns is alr accounted for
                for(int j = 0; j < qnsAcctFor.size();j++){
                    if(qns.equals(qnsAcctFor.get(j))){
                        bool = false; //skip the qns that is accounted for
                    }
                }
                if(Main.getGame().tree.getRoot().obj.toString().equals(qns)){
                    bool = false;
                }
                //if the qns == any from listOfFacts
                if(bool && animal.factMap.containsKey(qns)) {
                    qnsAcctFor.add(qns);
                    currentNode = new Node(qns);//
                    b = false;
                    break;
                }
            }
        }
        if(b) {
            //size of animal == 1 or 0
            currentNode = new Node(animal);
        }
        System.out.println("Current Node: " + currentNode +"\n");
        currentNode = ifItsAQns(currentNode);
        return currentNode;
    }
    private static Node ifItsAQns(Node currentNode){
        //currentNode.obj == qns
        //recursion here

        if (currentNode.obj instanceof Animal) {
        }
        else {
            String qns = (String) currentNode.obj;
            Animal[] animals = new Animal[2];
            //find the animals from Map
            int m = 0;
            //TODO: repeating the same qns over and over again
            for (int i = 0; i < Game.getListOfAnimals().size(); i++) {
                if (Game.getListOfAnimals().get(i).factMap.containsKey(qns)) {
                    animals[m] = Game.getListOfAnimals().get(i);
                    m++;
                }
            }
            Animal animal1 = animals[0];
            Animal animal2 = animals[1];
            currentNode = recursion(currentNode, listOfFacts.indexOf(qns));
        }

        return currentNode;
    }
    private static int getSizeOfUnaccountedFacts(Animal animal){
        int size = animal.factMap.size();
        for(int i = 0; i < qnsAcctFor.size(); i++){
            if(animal.factMap.containsKey(qnsAcctFor.get(i))){
                size--;
            }
        }
        return size;
    }
}
