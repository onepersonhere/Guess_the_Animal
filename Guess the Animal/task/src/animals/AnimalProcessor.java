package animals;

import java.util.Scanner;

public class AnimalProcessor {
    public static String askForAnimal(){
        Scanner scanner = new Scanner(System.in);
        char[] cArr = {'a','e','i','o','u'};
        String line = scanner.nextLine();
        String animal = "";
        //"Is it a/an <animal>?"

        line = line.toLowerCase();
        if(line.length()>0) {
            if (line.split(" ").length > 1) {
                String[] arr = line.split(" ");
                for (int i = 1; i < arr.length; i++) {
                    animal += arr[i] + " ";
                }
                animal = animal.trim();

                if (line.split(" ")[0].equals("a")) {
                    //use a
                    animal = line;
                } else if (line.split(" ")[0].equals("an")) {
                    //use an
                    animal = line;
                } else if (line.split(" ")[0].equals("the")) {
                    //if the
                    animal = getAnimal(cArr, animal);
                } else {
                    //use cArr
                    //get the animal
                    animal = line;
                    animal = getAnimal(cArr, animal);
                }
            } else {
                animal = line.toLowerCase();
                animal = getAnimal(cArr, animal);
            }
        }else{
            return askForAnimal();
        }
        return animal;
    }

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
