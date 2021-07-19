package animals.BinaryTree;

import animals.Animal;
import animals.Game;
import animals.Main;

import static animals.AnimalProcessor.askForAnimal;
import static animals.Fact.addFact;
import static animals.UserInputs.userInputs;

public class TraverseBinaryTree {
    //WORKING AS INTENDED
    private static boolean checkIfAnimal(String str){
        for(int i = 0; i < Game.getListOfAnimals().size(); i++){
            if(Game.getListOfAnimals().get(i).toString().equals(str)){
                return true;
            }
        }
        return false;
    }
    private static Animal findTheAnimal(String str){
        for(int i = 0; i < Game.getListOfAnimals().size(); i++){
            if(Game.getListOfAnimals().get(i).toString().equals(str)){
                return Game.getListOfAnimals().get(i);
            }
        }
        return null;
    }
    private static boolean askTheQns(Node currentNode){
        if(checkIfAnimal(currentNode.data)) {
            return checkIfCorrect(currentNode.data);
        }else{
            System.out.println(currentNode.data);
        }
        return false;
    }
    public static BinaryTree traverseTree(BinaryTree tree, Node currentNode){
        //ask the qns (normally at root node)
        boolean bool = false;
        if(checkIfAnimal(currentNode.data)) {
            bool = checkIfCorrect(currentNode.data);
        }
        //receive answer yes or no
        //nav down the tree
        if(!bool && !checkIfAnimal(currentNode.data)) {
            System.out.println(currentNode.data);
            if (userInputs()) { //here its eating an input
                //if yes
                //test if root.true.obj is Animal
                if (checkIfAnimal(currentNode.data)) {
                    tree = askIfItsTheAnimal(tree, currentNode.True);
                } else {
                    //ask that question
                    currentNode = currentNode.True;
                    tree = traverseTree(tree, currentNode);
                    //... recursive?
                }
            } else {
                if (checkIfAnimal(currentNode.data)) {
                    tree = askIfItsTheAnimal(tree, currentNode.False);
                } else {
                    //ask that question
                    currentNode = currentNode.False;
                    tree = traverseTree(tree, currentNode);
                    //... recursive?
                }
            }
        }else if(!bool && checkIfAnimal(currentNode.data)){
            return unknownAnimal(findTheAnimal(currentNode.data));
        }
        //if animal and is no, then ask a new qns to create a new tree.
        return tree;
    }

    private static BinaryTree askIfItsTheAnimal(BinaryTree tree, Node currentNode){
        //if true ask if its the Animal
        Animal animal = null;
        for(int i = 0; i < Game.getListOfAnimals().size(); i++){
            if(Game.getListOfAnimals().get(i).toString().equals(currentNode.data)){
                animal = Game.getListOfAnimals().get(i);
            }
        }
        if(!checkIfCorrect(currentNode.data)) {//if wrong
            if (checkIfAnimal(currentNode.data)) {
                //if both are animals -> unknown animal
                return unknownAnimal(animal);
            }else{
                //if not an animal
                if(currentNode == currentNode.Parent.False) {
                    currentNode = currentNode.True;
                }else{
                    currentNode = currentNode.False;
                }
                tree = traverseTree(tree, currentNode);
            }
        }
        return tree;
    }

    private static boolean checkIfCorrect(String animal) {
        System.out.println("Is it " + animal + "?");
        if(userInputs()){ //correct Animal
            //if the animal is true, AI won
            System.out.println("AI won!");
            return true;
        }
        return false;
    }

    private static BinaryTree unknownAnimal(Animal animal){
        //ask a new qns to create a new tree.
        System.out.println("I give up. What animal do you have in mind?");
        Animal animal2 = new Animal(askForAnimal());
        Game.addListOfAnimals(animal2);

        addFact(animal,animal2);

        CreateBinaryTree.qnsAcctFor.clear();
        return new BinaryTree(BinaryTree.getRoot());
    }
}
