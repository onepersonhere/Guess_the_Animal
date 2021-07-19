package animals.BinaryTree;

import animals.Animal;
import animals.Main;

import java.util.ArrayList;
import java.util.List;

import static animals.Fact.listOfFacts;

public class ReverseBinaryTree {
/*
    static List<String> qnsAcctFor = new ArrayList<>();

    public static Node recursion(String qns, Animal animal1, Animal animal2, Node currentNode){
        if(animal1.factMap.get(qns)){ //qns is true
            currentNode.True = createTreeNodes(animal1,currentNode.True);
            currentNode.False = createTreeNodes(animal2,currentNode.False);
        }else{ //qns is false
            currentNode.True = createTreeNodes(animal2,currentNode.True);
            currentNode.False = createTreeNodes(animal1,currentNode.False);
        }

        currentNode.True.Parent = currentNode;
        currentNode.False.Parent = currentNode; //is null
        return currentNode;
    }
    private static Node createTreeNodes(Animal animal, Node currentNode){
        boolean b = true;
        //At the start, both child nodes will be animals
        if(getSizeOfUnaccountedFacts(animal) > 1){
            //if one of the child node has more than one unaccounted fact
            System.out.println(animal + " has more than one fact");
            System.out.println(animal.getFact());
            System.out.println(animal.factMap);

            for(int i = 0; i < listOfFacts.size();i++){ //foreach fact in list of facts
                String qns = listOfFacts.get(i); //the key to the map

                boolean bool = true;//check if the qns is alr accounted for
                for(int j = 0; j < qnsAcctFor.size();j++){
                    if(qns.equals(qnsAcctFor.get(j))){
                        bool = false; //skip the qns that is accounted for
                    }
                }
                //if the qns == any from listOfFacts
                if(bool && animal.factMap.containsKey(qns)) {
                    qnsAcctFor.add(qns);
                    currentNode = new Node(qns);
                    b = false;
                    break;
                }
            }
        }
        if(b) {
            //size of animal == 1 or 0
            currentNode = new Node(animal);
        }
        System.out.println("Current Node: " + currentNode);
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
            for (int i = 0; i < Main.getGame().getListOfAnimals().size(); i++) {
                if (Main.getGame().getListOfAnimals().get(i).factMap.containsKey(qns)) {
                    animals[m] = Main.getGame().getListOfAnimals().get(i);
                    m++;
                }
            }
            Animal animal1 = animals[0];
            Animal animal2 = animals[1];
            currentNode = recursion(qns, animal1, animal2, currentNode);
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
    }*/
}
