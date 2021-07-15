package animals;

import java.util.Scanner;

public class UserInputs {
    public static void userInputs() {
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

        input = input.toLowerCase().replaceFirst("[^a-zA-Z ]", "").trim();
        System.out.println(input);
        String answer = "";
        for (int i = 0; i < positiveRes.length; i++) {
            if (input.equals(positiveRes[i])) {
                answer = "You answered: Yes";
                break;
            }
        }

        for (int i = 0; i < negativeRes.length; i++) {
            if (input.equals(negativeRes[i])) {
                answer = "You answered: No";
                break;
            }
        }

        if (answer.equals("")) {
            //ask again to clarify
            int prompt = (int) (Math.random() * 4);
            System.out.println(promptQns[prompt]);
            userInputs();
        } else {
            System.out.println(answer);
        }
    }
}
