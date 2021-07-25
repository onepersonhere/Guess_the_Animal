package animals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Animal {
    private String animal;
    private String name;
    private List<String> fact = new ArrayList<>();
    public Map<String, Boolean> factMap = new HashMap<>();
    private Map<String, Boolean> hiddenFactMap = new HashMap<>();
    //for testing only
    public Animal(String animal, String name, List<String> fact, Map<String, Boolean> factMap){
        this.animal = animal;
        this.name = name;
        this.fact = fact;
        this.factMap = factMap;
    }

    public Animal(String name) {
        this.name = name;
        System.out.println(name);
        String[] arr = name.split(" ");
        if(arr.length > 1 &&
                (arr[0].equalsIgnoreCase("a") ||
                        arr[0].equalsIgnoreCase("an"))) {
            animal = "";
            for (int i = 1; i < arr.length; i++) {
                animal += arr[i] + " ";
            }
            animal = animal.trim();
        }else{
            animal = name;
        }
    }

    public Animal() {}

    public void addFact(String fact){
        this.fact.add(fact);
    }

    public String getAnimal() {
        return animal;
    }

    public String getName() {
        return name;
    }

    public List<String> getFact() {
        return fact;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFact(List<String> fact) {
        this.fact = fact;
    }

    @Override
    public String toString(){
        if(animal != null) {
            return name;
        }else{
            return "";
        }
    }

    public void addHiddenFactMap(String str, boolean bool) {
        this.hiddenFactMap.put(str, bool);
    }

    public Map<String, Boolean> getHiddenFactMap() {
        return hiddenFactMap;
    }
}
