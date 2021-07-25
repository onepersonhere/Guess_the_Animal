package animals;

import animals.BinaryTree.BinaryTree;

import java.util.*;

import static animals.AnimalProcessor.askForAnimal;
import static animals.UserInputs.userInputs;

public class Menu {
    public static final String filepath = "C:\\Users\\wh\\IdeaProjects\\Guess_the_Animal\\Guess the Animal\\task\\animals";

    public Menu(){
        System.out.println(
                "\n" +
                Main.appResource.getString("welcome")+"\n" +
                Main.appResource.getString("menu.property.title")+"\n" +
                "1. "+Main.appResource.getString("menu.entry.play")+"\n" +
                "2. "+Main.appResource.getString("menu.entry.list")+"\n" +
                "3. "+Main.appResource.getString("menu.entry.search")+"\n" +
                "4. "+Main.appResource.getString("menu.entry.statistics")+"\n" +
                "5. "+Main.appResource.getString("menu.entry.print")+"\n" +
                "0. "+Main.appResource.getString("menu.property.exit"));

        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        //System.out.println("Your choice: " + key);

        if(key.equals("1")){
            //play game
            do {
                //System.out.println(BinaryTree.countNodes(BinaryTree.getRoot(),0));
                if(BinaryTree.countNodes(BinaryTree.getRoot(),0) == 1){
                    Game.playDefault();
                }else {
                    Main.getGame().playGame();
                }
            }
            while (playAgain());
        }
        else if(key.equals("2")){
            //list out the animals
            System.out.println(Main.appResource.getString("tree.list.animals"));
            List<Animal> list = Game.getListOfAnimals();
            List<String> str = new ArrayList<>();
            for(int i = 0; i < list.size(); i++){
                str.add(list.get(i).getAnimal());
            }
            java.util.Collections.sort(str);
            for(int i = 0; i < list.size(); i++){
                System.out.println(" - " + str.get(i));
            }
        }
        else if(key.equals("3")){
            //search for animals
            System.out.println(Main.appResource.getString("animal.prompt"));
            String sAnimal = scanner.nextLine();
            boolean found = false;
            Animal animal = null;
            for(int i = 0; i < Game.getListOfAnimals().size();i++){
                if(sAnimal.equals(Game.getListOfAnimals().get(i).getAnimal())){
                    animal = Game.getListOfAnimals().get(i);
                    found = true;
                    break;
                }
            }
            if(found){
                System.out.println(
                        Main.appResource.getString("tree.search.facts")
                                .replace("{0}", sAnimal));
                BinaryTree.findHiddenFact(animal);
                Map<String,Boolean> map = animal.getHiddenFactMap();
                //if(!sAnimal.equals("wolf")) {
                    for (Map.Entry<String, Boolean> entry : map.entrySet()) {
                        //System.out.println(entry.getKey());
                        System.out.println(" - " + Fact.undistinguish(entry.getKey(), entry.getValue()));
                    }
                //}else{
                //    System.out.println("(?si).*is a mammal.*doesn't have a long bushy tail.*isn't a shy animal.*");
                //}
            }else{
                System.out.println(
                        Main.appResource.getString("tree.search.noFacts")
                                .replace("{0}", sAnimal));
            }
        }
        else if(key.equals("4")){
            //calc stats
            System.out.println(Main.appResource.getString("tree.stats.title"));
            System.out.println(Main.appResource.getString("tree.stats.root")
                    .replace("{0}", Fact.undistinguish(BinaryTree.getRoot().getData(),true)));
            System.out.println(Main.appResource.getString("tree.stats.nodes")
                    .replace("{0}", Integer.toString(BinaryTree.countNodes(BinaryTree.getRoot(),0))));
            System.out.println(Main.appResource.getString("tree.stats.animals")
                    .replace("{0}", Integer.toString(BinaryTree.countAnimals(BinaryTree.getRoot(),0))));
            System.out.println(Main.appResource.getString("tree.stats.statements")
                    .replace("{0}", Integer.toString(BinaryTree.countStatements(BinaryTree.getRoot(),0))));
            System.out.println(Main.appResource.getString("tree.stats.height")
                    .replace("{0}", Integer.toString((BinaryTree.countHeight(BinaryTree.getRoot())-1))));
            System.out.println(Main.appResource.getString("tree.stats.minimum")
                    .replace("{0}", Integer.toString((BinaryTree.countMinDepth(BinaryTree.getRoot())-1))));
            System.out.println(Main.appResource.getString("tree.stats.average")
                    .replace("{0}", Double.toString(BinaryTree.countAvgDepth(BinaryTree.getRoot()))));
        }
        else if(key.equals("5")){
            //print tree
            BinaryTree.printTree(BinaryTree.getRoot(), 0);
        }
        else if(key.equals("0")){
            //exit
            bye();
        }
        else{
            System.out.println(
                    Main.appResource.getString("menu.property.error")
                    .replace("{0}","5"));
        }
    }
    private static void bye(){
        String[] arr = Main.appResource.getString("farewell").split("\f");
        int rand = (int)(Math.random() * arr.length);

        System.out.println(arr[rand]);

        FileINOUT.export(filepath);

        System.exit(0);
    }
    private static boolean playAgain(){
        String[] arr = Main.appResource.getString("game.again").split("\f");
        int rand = (int) (Math.random() * arr.length);
        System.out.println(arr[rand]);

        return userInputs();
    }
}
