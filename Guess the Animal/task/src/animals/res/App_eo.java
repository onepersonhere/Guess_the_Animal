package animals.res;

import java.util.ListResourceBundle;
import java.util.function.UnaryOperator;

public class App_eo extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"hello", "Saluton!"},
                {"bye", new String[]{
                    "Ĝis!",
                    "Ĝis revido!",
                    "Estis agrable vidi vin!"
                }},
                {"animal.name", (UnaryOperator<String>) name -> name},
                {"animal.question", "Ĉu ĝi estas {0}?"},
                {"response.positive", new String[]{
                        "y", "yes", "yeah", "yep", "sure", "right",
                        "affirmative", "correct", "indeed", "you bet", "exactly",
                        "you said it",
                        "jes", "ĝuste", "certe", "jesa",
                        "ĝusta", "fakte", "vi vetas",
                        "vi diris ĝin"
                }},
                {"response.negative", new String[]{
                        "n", "no", "no way", "nah", "nope", "negative",
                        "I don't think so", "yeah no",
                        "ne", "neniel", "negativa",
                        "Mi ne pensas", "jes ne"
                }},
                {"is", "estas"},
                {"can", "povas"},
                {"has", "havas"},
                {"isn't", "ne estas"},
                {"can't", "ne povas"},
                {"doesn't have", "ne havas"},
                {"Is it", "Ĉu ĝi estas "},
                {"Can it", "Ĉu ĝi povas "},
                {"Does it have", "Ĉu ĝi havas "},
                {"The", "La"}
        };
    }
}
