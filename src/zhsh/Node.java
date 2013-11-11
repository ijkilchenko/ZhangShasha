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
    private String label;
    private int pIndex;
    private ArrayList<Node> children= new ArrayList<Node>();
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

    private String printTree(){
        ArrayList<String> treeString= new ArrayList<String>();
        treeString= printTree(this, treeString);
        return treeString.toArray().toString();
    }

    private ArrayList<String> printTree(Node currentRoot, ArrayList<String> currentString){
        //currentString.append(currentRoot.label + " ");
        for (int i= 0; i < currentRoot.children.size(); i++){
            currentString= printTree(currentRoot.children.get(i), currentString);
        }
        currentString.add(currentRoot.label); //Uncomment for postorder.
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

    public Object[] LRkeyroots(){
        for (int i= 0; i < l.size(); i++){
            int flag= 0;
            for (int j= i+1; j < l.size()-1; j++){
                if (l.get(j) == l.get(i)){
                    flag= 1;
                }
            }
            if (flag == 0){
                this.LRkeyroots.add(i);
            }
        }
        return LRkeyroots.toArray();
    }
}