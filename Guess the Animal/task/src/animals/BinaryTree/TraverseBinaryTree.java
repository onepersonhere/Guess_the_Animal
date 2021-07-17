package animals.BinaryTree;

import animals.Animal;
import animals.Game;
import animals.Main;

import static animals.AnimalProcessor.askForAnimal;
import static animals.Fact.addFact;
import static animals.UserInputs.userInputs;

public class TraverseBinaryTree {
    //WORKING AS INTENDED
    private static boolean askTheQns(Node currentNode){
        if(currentNode.obj instanceof Animal) {
            return checkIfCorrect((Animal) currentNode.obj);
        }else{
            System.out.println(currentNode.obj.toString());
        }
        return false;
    }
    public static BinaryTree traverseTree(BinaryTree tree, Node currentNode){
        //ask the fact (normally at root node)
        boolean bool = askTheQns(currentNode);
        //receive answer yes or no
        //nav down the tree
        //TODO: NOT CHECKED YET
        if(!bool) {
            if (userInputs()) {
                //if yes
                //test if root.true.obj is Animal
                if (currentNode.True.obj instanceof Animal) {
                    tree = askIfItsTheAnimal(tree, currentNode.True);
                } else {
                    //ask that question
                    currentNode = currentNode.True;
                    tree = traverseTree(tree, currentNode);
                    //... recursive?
                }
            } else {
                if (currentNode.False.obj instanceof Animal) {
                    tree = askIfItsTheAnimal(tree, currentNode.False);
                } else {
                    //ask that question
                    currentNode = currentNode.False;
                    tree = traverseTree(tree, currentNode);
                    //... recursive?
                }
            }
        }
        //if animal and is no, then ask a new qns to create a new tree.
        return tree;
    }

    private static BinaryTree askIfItsTheAnimal(BinaryTree tree, Node currentNode){
        //if true ask if its the Animal
        Animal animal = (Animal) currentNode.obj;
        if(!checkIfCorrect(animal)) {//if wrong
            if(currentNode.Parent.True.obj == currentNode.obj){
                currentNode = currentNode.Parent.False; //switch to the other node
            }else{
                currentNode = currentNode.Parent.True;
            }

            if (currentNode.obj instanceof Animal) {
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

    private static boolean checkIfCorrect(Animal animal) {
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
        Main.getGame().addListOfAnimals(animal2);

        String fact = addFact(animal,animal2);

        return new BinaryTree(fact, animal, animal2, Main.getGame().tree.getRoot()); //animal is cat and lynx
    }
}
