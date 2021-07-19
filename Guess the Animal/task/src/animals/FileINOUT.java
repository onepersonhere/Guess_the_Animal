package animals;

import animals.BinaryTree.BinaryTree;
import animals.BinaryTree.Node;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;

public class FileINOUT {
    static ObjectMapper objectMapper = new JsonMapper();
    static String ext = ".json";
    public static void export(String filename) {
        try {
            //System.out.println(BinaryTree.getRoot());
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(filename + ext), BinaryTree.getRoot());
            System.out.println("File Successfully exported!");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void importNode(String filename){
        try {
            BinaryTree.setRoot(
                    objectMapper.readValue(new File(filename + ext), Node.class));
            //TODO: animals.Fact.listOfFacts, animals.Game.listOfAnimals
            BinaryTree.searchNodeRecursive(BinaryTree.getRoot());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static boolean searchForFile(String filename){
        File f = new File(filename+ext);
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
