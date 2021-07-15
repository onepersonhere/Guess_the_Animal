package animals;

import java.time.LocalTime;

import static animals.AnimalProcessor.askForAnimal;
import static animals.UserInputs.userInputs;

public class Main {
    public static void main(String args[]){
        //Greetings
        System.out.println(getTime());
        //while(true) {
            askForAnimal();
            userInputs();
            //break;
        //}
        bye();
    }

    private static String getTime(){
        LocalTime time = LocalTime.now();
        int hour = time.getHour();
        if(hour >= 5 && hour <= 12){
            return "Good morning";
        }else if(hour > 12 && hour <= 18){
            return "Good afternoon";
        }else{
            return "Good evening";
        }
    }

    private static void bye(){
        String[] arr = {"bye!","goodbye!","see you!","later!","next time!"};

        int rand = (int)(Math.random() * 4);

        System.out.println(arr[rand]);
    }
}
