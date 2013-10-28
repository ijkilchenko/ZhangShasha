/**
 * User: ijk
 * Date: 10/26/13
 */
package zhsh;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tree {
    Node root;

    public Tree(){
    }

    public Tree(Node root){
        this.root= root;
    }

    public Tree(String preorder){
        //f(d(a c(b))e)
        root= buildTree(preorder);
    }

    private Node buildTree(String preorder){
        Node currentRoot;

        Pattern p= Pattern.compile("([^\\(\\s]+)");
        Matcher m= p.matcher(preorder);
        m.find();
        currentRoot= new Node(m.group(1)); //f

        if (preorder.length() == m.group(1).length()){
            return currentRoot;
        }
        //preorder= preorder.substring(m.group(1).length()); //(d(a c(b))e)

        return currentRoot;
    }

    public String printTree(){
        String treeString= "";
        treeString= printTree(this.root, treeString);
        return treeString;
    }

    private String printTree(Node currentRoot, String currentString){
        currentString += currentRoot.label + " ";
        for (int i= 0; i < currentRoot.children.size(); i++){
            currentString= printTree(currentRoot.children.get(i), currentString);
        }
        return currentString;
    }
}
