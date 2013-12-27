/**
 * User: ijk
 * Date: 10/26/13
 */
package zhsh;
import java.util.ArrayList;
public class Node {
    public String label; //Node label. //TODO: Use Java generics. See #1 in README.
    public int index; //Preorder index.
    public ArrayList<Node> children= new ArrayList<Node>(); //Note: trees need not be binary.
    public Node leftmost; //Used by the recursive O(n) leftmost() function in the Tree class.

    public Node(){

    }

    //TODO: Use Java generics. See #1 in README.
    public Node(String label){
        this.label= label;
    }
}