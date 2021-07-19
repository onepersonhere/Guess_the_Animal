package animals;

import java.util.Scanner;

import static animals.AnimalProcessor.askForAnimal;
import static animals.UserInputs.userInputs;

public class Menu {
    public static final String filepath = "C:\\Users\\wh\\IdeaProjects\\Guess_the_Animal\\Guess the Animal\\task\\animals";
    public Menu(){
        System.out.println("Welcome to the animal expert system!\n" +
                "\n" +
                "What do you want to do:\n" +
                "\n" +
                "1. Play the guessing game\n" +
                "2. List of all animals\n" +
                "3. Search for an animal\n" +
                "4. Calculate statistics\n" +
                "5. Print the Knowledge Tree\n" +
                "0. Exit");

        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        System.out.println("Your choice: " + key);

        if(key.equals("1")){
            do{
                Main.getGame().playGame();
            }
            while(playAgain());
        }
        if(key.equals("2")){
            System.out.println("Here are the animals I know: ");
            for(int i = 0; i < Game.getListOfAnimals().size(); i++){
                System.out.println(" - " + Game.getListOfAnimals().get(i).getAnimal());
            }
        }
        if(key.equals("3")){
            System.out.println("Enter the animal: ");
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
                System.out.println("Facts about the " + sAnimal + ":");
                for(int i = 0; i < animal.getFact().size(); i++){
                    System.out.println(" - " + animal.getFact().get(i));
                }
            }else{
                System.out.println("No fact found about the " + sAnimal);
            }
        }
        if(key.equals("4")){

        }
        if(key.equals("5")){

        }
        if(key.equals("0")){
            bye();
        }
    }
    private static void bye(){
        String[] arr = {"bye!","goodbye!","see you!","later!","next time!"};

        int rand = (int)(Math.random() * 4);

        System.out.println(arr[rand]);

        FileINOUT.export(filepath);

        System.exit(0);
    }
    private static boolean playAgain(){
        System.out.println("Would you like to play again?");
        return userInputs();
    }
}
