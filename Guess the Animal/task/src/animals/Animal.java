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
    //for testing only
    public Animal(String animal, String name, List<String> fact, Map<String, Boolean> factMap){
        this.animal = animal;
        this.name = name;
        this.fact = fact;
        this.factMap = factMap;
    }

    public Animal(String name) {
        this.name = name;

        String[] arr = name.split(" ");
        animal = "";
        for(int i = 1; i < arr.length; i++){
            animal += arr[i] + " ";
        }
        animal = animal.trim();
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
}
