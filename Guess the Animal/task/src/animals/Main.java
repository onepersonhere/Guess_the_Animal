package animals;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Locale;
import java.util.ResourceBundle;


public class Main {
    private static Game game;
    private static String type = "JSON";
    public static ResourceBundle appResource = ResourceBundle.getBundle("messages");
    public static ResourceBundle appResource2 = ResourceBundle.getBundle("animals.res.App");
    public static String language;
    public static void main(String[] args){
        language = Locale.getDefault().getLanguage();

        for(int i = 0; i < args.length; i++){
            if(args[i].equals("-type")){
                type = args[i+1];
            }
        }
        changeMapperType();

        game = new Game();
        while(true){
            new Menu();
        }
        //BinaryTree tree = new BinaryTree("test");TraverseBinaryTree.traverseTree(tree, tree.getRoot());
    }

    public static Game getGame() {
        return game;
    }

    private static void changeMapperType(){
        if(type.equalsIgnoreCase("YAML")){
            FileINOUT.setObjectMapper(new JsonMapper(), ".yaml");
        }else if(type.equalsIgnoreCase("XML")){
            FileINOUT.setObjectMapper(new XmlMapper(), ".xml");
        }else{
            FileINOUT.setObjectMapper(new JsonMapper(), ".json");
        }
    }

}
