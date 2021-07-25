package animals;

import animals.BinaryTree.BinaryTree;
import animals.BinaryTree.Node;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class FileINOUT {
    static ObjectMapper objectMapper = new JsonMapper();
    static String ext = ".json";
    static String lang = "";
    public static void export(String filename) {
        if(!Locale.getDefault().getLanguage().equalsIgnoreCase("en"))lang = "_" + Main.language;

        try {
            //System.out.println(BinaryTree.getRoot());
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(filename + lang + ext), BinaryTree.getRoot());
            System.out.println("Debug: File Successfully exported!");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void importNode(String filename){
        if(!Locale.getDefault().getLanguage().equalsIgnoreCase("en"))lang = "_" + Main.language;
        try {
            BinaryTree.setRoot(
                    objectMapper.readValue(new File(filename + lang + ext), Node.class));
            //TODO: animals.Fact.listOfFacts, animals.Game.listOfAnimals
            BinaryTree.searchNodeRecursive(BinaryTree.getRoot());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static boolean searchForFile(String filename){
        if(!Locale.getDefault().getLanguage().equalsIgnoreCase("en"))lang = "_" + Main.language;
        File f = new File(filename + lang + ext);
        if(f.exists() && !f.isDirectory()) {
            importNode(filename);
            return true;
        }
        return false;
    }

    public static void setObjectMapper(ObjectMapper objectMapper, String ext) {
        FileINOUT.objectMapper = objectMapper;
        FileINOUT.ext = ext;
    }
}
