package animals.BinaryTree;

import animals.Animal;
import com.fasterxml.jackson.annotation.*;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "data")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Node {
    String data; //Object might be Animal or Map<String,Boolean>

    Node False;
    Node True;
    Node Parent;

    public Node(){}

    @JsonIgnore
    public Node(String qns){
        this.data = qns;

        False = null;
        True = null;
        Parent = null;
    }
    @JsonIgnore
    public Node(Animal animal){
        this.data = animal.toString();

        False = null;
        True = null;
        Parent = null;
    }
    @JsonIgnore
    @Override
    public String toString(){
        return data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getFalse() {
        return False;
    }

    public void setFalse(Node aFalse) {
        False = aFalse;
    }

    public Node getTrue() {
        return True;
    }

    public void setTrue(Node aTrue) {
        True = aTrue;
    }

    public Node getParent() {
        return Parent;
    }

    public void setParent(Node parent) {
        Parent = parent;
    }
}
