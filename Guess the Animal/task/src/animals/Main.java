package animals;

import java.time.LocalTime;
import java.util.Locale;
import java.util.Scanner;

import static animals.AnimalProcessor.askForAnimal;

public class Main {
    public static void main(String args[]){
        //Greetings
        System.out.println(getTime());
        while(true) {
            askForAnimal();
            userInputs();
        }
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

    private static void userInputs(){
        Scanner scanner = new Scanner(System.in);

        String[] positiveRes = {"y", "yes", "yeah", "yep", "sure", "right",
                "affirmative", "correct", "indeed", "you bet", "exactly",
                "you said it"};

        String[] negativeRes = {"n", "no", "no way", "nah", "nope", "negative",
                "I don't think so", "yeah no"};

        String[] promptQns = {"I'm not sure I caught you: was it yes or no?",
                "Funny, I still don't understand, is it yes or no?",
                "Oh, it's too complicated for me: just tell me yes or no.",
                "Could you please simply say yes or no?",
                "Oh, no, don't try to confuse me: say yes or no."};

        String input = scanner.nextLine();

        input = input.toLowerCase();

        String answer = "";
        for(int i = 0; i < positiveRes.length; i++){
            if(input.equals(positiveRes[i])){
                answer = "You answered: Yes";
                break;
            }
        }
        for(int i = 0; i < negativeRes.length; i++){
            if(input.equals(negativeRes[i])){
                answer = "You answered: No";
                break;
            }
        }
        if(answer.equals("")){
            //ask again to clarify
            int prompt = (int)(Math.random() * 4);
            System.out.println(promptQns[prompt]);
            userInputs();
        }else{
            System.out.println(answer);
        }
    }

}
