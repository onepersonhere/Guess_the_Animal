package animals;

import java.util.Scanner;

public class UserInputs {
    public static boolean userInputs() {
        Scanner scanner = new Scanner(System.in);

        String[] positiveRes = Main.appResource2.getStringArray("response.positive");

        String[] negativeRes = Main.appResource2.getStringArray("response.negative");

        String[] promptQns = Main.appResource.getString("ask.again").split("\f");

        String input = scanner.nextLine();

        input = input.toLowerCase().replaceFirst("[^a-zA-Z' ]", "").trim();
        //System.out.println(input);
        String answer = "";
        for (int i = 0; i < positiveRes.length; i++) {
            if (input.equalsIgnoreCase(positiveRes[i])) {
                return true;
            }
        }

        for (int i = 0; i < negativeRes.length; i++) {
            if (input.equalsIgnoreCase(negativeRes[i])) {
                return false;
            }
        }

        //ask again to clarify
        int prompt = (int) (Math.random() * promptQns.length);
        System.out.println(promptQns[prompt]);
        return userInputs();
    }
}
