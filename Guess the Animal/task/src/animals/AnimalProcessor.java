package animals;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class AnimalProcessor {
    public static void askForAnimal(){
        Scanner scanner = new Scanner(System.in);
        char[] cArr = {'a','e','i','o','u'};
        System.out.println("Enter an animal:");
        String line = scanner.nextLine();
        String animal = "";
        //"Is it a/an <animal>?"

        if(line.split(" ").length > 1) {
            animal = line.split(" ")[1];
            if(line.split(" ")[0].contains("a")){
                //use a
                animal = line;
            }else if(line.split(" ")[0].contains("an")) {
                //use an
                animal = line;
            }else {
                //use cArr
                //get the animal
                animal = getAnimal(cArr, animal);
            }
        }else{
            animal = line;
            System.out.println("animal is " + animal);
            animal = getAnimal(cArr, animal);
        }
        System.out.println("Is it " + animal + "?");
    }

    @NotNull
    private static String getAnimal(char[] cArr, String animal) {
        boolean isVowel = false;
        for(int i = 0; i < cArr.length; i++) {
            //System.out.println(animal.indexOf(0) + " " + cArr[i]);
            if (animal.charAt(0) == cArr[i]){
                //use an
                animal = "an " + animal;
                isVowel = true;
                break;
            }//else use arr
        }
        if(!isVowel){
            animal = "a " + animal;
        }
        return animal;
    }
}
