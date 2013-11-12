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
    public String label;

    private int pIndex;

    public ArrayList<Node> children= new ArrayList<Node>();

    private Node left;
    ArrayList<Integer> l= new ArrayList<Integer>();
    ArrayList<Integer> LRkeyroots= new ArrayList<Integer>();

    public Node(){

    }

    public Node(String label){
        this.label= label;
    }

    public static Node parseTree(String s) throws IOException{
        StreamTokenizer tokenizer= new StreamTokenizer(new StringReader(s));
        tokenizer.nextToken(); //Move to first token.
        Node result= new Node(tokenizer); //Parse root node (and children).
        if (tokenizer.ttype != StreamTokenizer.TT_EOF){
            throw new RuntimeException("Leftover token: "+ tokenizer.ttype);
        }
        return result;
    }

    private Node(StreamTokenizer tokenizer) throws IOException{
        if (tokenizer.ttype != StreamTokenizer.TT_WORD){
            throw new RuntimeException("Identifier expected; got: " + tokenizer.ttype);
        }
        label= tokenizer.sval; //Read and
        tokenizer.nextToken(); //Consume the label.
        if (tokenizer.ttype == '(') { //Children?
            tokenizer.nextToken(); //Yes, consume '('.
            do {
                children.add(new Node(tokenizer)); //Add and parse a child.
            } while (tokenizer.ttype != ')'); //Until we reach ')'.
            tokenizer.nextToken(); //Consume ')'.
        }
    }

    public String printTree(){
        ArrayList<String> treeString= new ArrayList<String>();
        treeString= printTree(this, treeString);
        return treeString.toArray().toString();
    }

    private ArrayList<String> printTree(Node currentRoot, ArrayList<String> currentString){
        for (int i= 0; i < currentRoot.children.size(); i++){
            currentString= printTree(currentRoot.children.get(i), currentString);
        }
        currentString.add(currentRoot.label);
        currentRoot.pIndex= currentString.size();
        return currentString;
    }

    public Object[] l(){
        this.l= l(this, l);
        return l.toArray();
    }

    private static ArrayList<Integer> l(Node currentRoot, ArrayList<Integer> l){
        for (int i= 0; i < currentRoot.children.size(); i++){
            l= l(currentRoot.children.get(i), l);
        }
        while(currentRoot.children.size() != 0){
            currentRoot= currentRoot.children.get(0);
        }
        l.add(currentRoot.pIndex);
        return l;
    }

    public static void left(Node currentNode){
        if (currentNode == null) return;

        for (int i= 0; i < currentNode.children.size(); i++){
            left(currentNode.children.get(i));
        }

        if (currentNode.children.size() == 0){
            currentNode.left= currentNode;
        }
        else {
            currentNode.left= currentNode.children.get(0).left;
        }

    }

    public Object[] LRkeyroots(){
        for (int i= 0; i < l.size(); i++){
            int flag= 0;
            for (int j= i+1; j < l.size(); j++){
                if (l.get(j) == l.get(i)){
                    flag= 1;
                }
            }
            if (flag == 0){
                this.LRkeyroots.add(i+1);
            }
        }
        return LRkeyroots.toArray();
    }
}