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
        Pattern p= Pattern.compile("([^\\(\\s]+)");
        Matcher m= p.matcher(preorder);
        m.find();
        root= new Node(m.group(1)); //f

        if (preorder.length() == m.group(1).length()){
            return;
        }

        preorder= preorder.substring(m.group(1).length()); //(d(a c(b))e)
        preorder= preorder.substring(1, preorder.length()-1); //d(a c(b))e
        root= buildTree(root, preorder);
    }

    private Node buildTree(Node currentRoot, String preorder){
        while (preorder.length() > 0){
            Pattern p= Pattern.compile("([^\\(\\s]+)");
            Matcher m= p.matcher(preorder);
            m.find();

            Node newNode= new Node(m.group(1));
            int i= newNode.label.length();
            if (!"".equals(preorder) && preorder.charAt(i) == '('){
                int firstP= i;
                int Pcount= 1;
                int j= i+1;
                while (Pcount != 0){
                    if (preorder.charAt(j) == '('){
                        Pcount++;
                    }
                    if (preorder.charAt(j) == ')'){
                        Pcount--;
                    }
                    j++;
                }
                newNode= buildTree(newNode, preorder.substring(firstP+1, j-1));
                preorder= preorder.substring(j+1);
            }
            i= newNode.label.length();
            if (!"".equals(preorder) && preorder.charAt(i) == ' '){
                return newNode;
            }

            currentRoot.addChild(newNode);
        }
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
