package animals;

import animals.BinaryTree.BinaryTree;
import animals.BinaryTree.TraverseBinaryTree;

import java.time.LocalTime;
import static animals.UserInputs.userInputs;

public class Main {
    private static Game game = new Game();
    public static void main(String args[]){


        while(playAgain()){
            game.playGame();
        }
        //BinaryTree tree = new BinaryTree("test");TraverseBinaryTree.traverseTree(tree, tree.getRoot());


        bye();
    }

    private static void bye(){
        String[] arr = {"bye!","goodbye!","see you!","later!","next time!"};

        int rand = (int)(Math.random() * 4);

        System.out.println(arr[rand]);
    }

    private static boolean playAgain(){
        System.out.println("Would you like to play again?");
        return userInputs();
    }

    public static Game getGame() {
        return game;
    }
}
