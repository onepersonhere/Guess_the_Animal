package animals;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String animal;
    private String name;
    private List<String> fact = new ArrayList<>();

    public Animal(String name) {
        this.name = name;

        String[] arr = name.split(" ");
        animal = "";
        for(int i = 1; i < arr.length; i++){
            animal += arr[i] + " ";
        }
        animal = animal.trim();
    }

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
        return name;
    }
}
