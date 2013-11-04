/**
 * User: ijk
 * Date: 10/26/13
 */
package zhsh;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;

public class Node {
    private String name;
    private ArrayList<Node> children = new ArrayList<Node>();

    public Node(){
    }

    public Node(String name){
        this.name= name;
    }

    public static Node parseTree(String s) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(s));
        tokenizer.nextToken(); //Move to first token.
        Node result = new Node(tokenizer); //Parse root node (and children).
        if (tokenizer.ttype != StreamTokenizer.TT_EOF) {
            throw new RuntimeException("Leftover token: "+ tokenizer.ttype);
        }
        return result;
    }

    public Node(StreamTokenizer tokenizer) throws IOException {
        if (tokenizer.ttype != StreamTokenizer.TT_WORD) {
            throw new RuntimeException("Identifier expected; got: " + tokenizer.ttype);
        }
        name = tokenizer.sval; //Read and
        tokenizer.nextToken(); //Consume the name.
        if (tokenizer.ttype == '(') { //Children?
            tokenizer.nextToken(); //Yes, consume '('.
            do {
                children.add(new Node(tokenizer)); //Add and parse a child.
            } while (tokenizer.ttype != ')'); //Until we reach ')'.
            tokenizer.nextToken(); //Consume ')'.
        }
    }

    public String printTree(){
        String treeString= "";
        treeString= printTree(this, treeString);
        return treeString;
    }

    private String printTree(Node currentRoot, String currentString){
        currentString += currentRoot.name + " ";
        for (int i= 0; i < currentRoot.children.size(); i++){
            currentString= printTree(currentRoot.children.get(i), currentString);
        }
        return currentString;
    }
}