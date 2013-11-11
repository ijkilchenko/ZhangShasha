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
    ArrayList<String> LR_keyroots= new ArrayList<String>();

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
        indexTree();
        StringBuffer treeString= new StringBuffer();
        treeString= printTree(this, treeString);
        return treeString.toString();
    }

    private static StringBuffer printTree(Node currentRoot, StringBuffer currentString){
        //currentString.append(currentRoot.label + " ");
        for (int i= 0; i < currentRoot.children.size(); i++){
            currentString= printTree(currentRoot.children.get(i), currentString);
        }
        currentString.append(currentRoot.pIndex + " "); //Uncomment for postorder.
        return currentString;
    }

    private void indexTree(){
        ArrayList<String> treeString= new ArrayList<String>();
        treeString= indexTree(this, treeString);
    }

    private ArrayList<String> indexTree(Node currentRoot, ArrayList<String> currentString){
        //currentString.append(currentRoot.label + " ");
        for (int i= 0; i < currentRoot.children.size(); i++){
            currentString= indexTree(currentRoot.children.get(i), currentString);
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

//    public Object[] LR_keyroots(){
//        this.LR_keyroots= LR_keyroots(this, LR_keyroots);
//        for (int i= 0; i < LR_keyroots.size(); i++){
//            int currentLeft= l.get(i);
//            for (int j= i; j < LR_keyroots.size(); j++){
//                if
//            }
//        }
//        return LR_keyroots.toArray();
//    }
//
//    private static ArrayList<String> LR_keyroots(Node currentRoot, ArrayList<String> LR_keyroots){
//
//    }
}