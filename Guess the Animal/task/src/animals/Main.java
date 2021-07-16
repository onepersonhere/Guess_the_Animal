package animals;

import java.time.LocalTime;

import static animals.AnimalProcessor.askForAnimal;
import static animals.Fact.addFact;

public class Main {
    public static void main(String args[]){
        //Greetings
        System.out.println(getTime());

        System.out.println("Enter the first animal:");
        Animal animal1 = new Animal(askForAnimal());
        System.out.println("Enter the second animal:");
        Animal animal2 = new Animal(askForAnimal());
        addFact(animal1,animal2);
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
