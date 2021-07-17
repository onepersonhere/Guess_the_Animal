package animals.BinaryTree;

import animals.Animal;

public class Node {
    Object obj; //Object might be Animal or Map<String,Boolean>
    boolean isLeaf = false; //If object is Animal, node == leaf;

    Node False;
    Node True;
    Node Parent;

    public Node(Object obj){
        this.obj = obj;
        if(obj instanceof Animal){
            isLeaf = true; //The node is an Animal
        }else{
            //node is a Map
        }
        False = null;
        True = null;
        Parent = null;
    }

    @Override
    public String toString(){
        return obj.toString();
    }
}
