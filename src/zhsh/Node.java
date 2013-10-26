package zhsh;
/**
 * User: ijk
 * Date: 10/26/13
 */
import java.util.ArrayList;
import java.util.List;

public class Node {
    String label;
    List<Node> children;

    public Node(){
    }

    public Node(String label){
        this.label= label;
        children= new ArrayList<Node>();
    }

    public void addChild(Node newNode){
        this.children.add(newNode);
    }
}
