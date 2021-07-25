package animals.res;

import java.util.ListResourceBundle;
import java.util.function.UnaryOperator;

public class App extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"hello", "Hello!"},
                {"bye", new String[]{
                    "Bye!",
                    "Bye, bye!",
                    "See you later!",
                    "See you soon!",
                    "Have a nice one!"
                }},
                {"animal.name", (UnaryOperator<String>) name -> {
                    if (name.matches("[aeiou].*")){
                        return "an " + name;
                    } else {
                        return "a " + name;
                    }
                }},
                {"animal.question", "Is it {0}?"},
                {"response.positive", new String[]{
                        "y", "yes", "yeah", "yep", "sure", "right",
                        "affirmative", "correct", "indeed", "you bet", "exactly",
                        "you said it"
                }},
                {"response.negative", new String[]{
                        "n", "no", "no way", "nah", "nope", "negative",
                        "I don't think so", "yeah no"
                }},
                {"is", "is"},
                {"can", "can"},
                {"has", "has"},
                {"isn't", "isn't"},
                {"can't", "can't"},
                {"doesn't have", "doesn't have"},
                {"Is it", "Is it "},
                {"Can it", "Can it "},
                {"Does it have", "Does it have "},
                {"The", "The"}
        };
    }
}
