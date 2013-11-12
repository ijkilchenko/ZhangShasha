/**
 * User: ijk
 * Date: 10/26/13
 */
package zhsh;
import java.util.ArrayList;
public class Node {
    public String label;
    public int index;
    public ArrayList<Node> children= new ArrayList<Node>();
    public Node leftmost;

    public Node(){

    }

    public Node(String label){
        this.label= label;
    }
}