package zhsh;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
/**
 * User: ijk
 * Date: 11/12/13
 */
public class Tree {
    Node root= new Node();
    ArrayList<Integer> l= new ArrayList<Integer>();
    ArrayList<Integer> keyroots= new ArrayList<Integer>();

    public Tree(){

    }

    public Tree(String s) throws IOException {
        StreamTokenizer tokenizer= new StreamTokenizer(new StringReader(s));
        tokenizer.nextToken(); //Move to first token.
        root= parseString(root, tokenizer); //Parse root node (and children).
        if (tokenizer.ttype != StreamTokenizer.TT_EOF){
            throw new RuntimeException("Leftover token: "+ tokenizer.ttype);
        }
    }

    private static Node parseString(Node node, StreamTokenizer tokenizer) throws IOException{
        if (tokenizer.ttype != StreamTokenizer.TT_WORD){
            throw new RuntimeException("Identifier expected; got: " + tokenizer.ttype);
        }
        node.label= tokenizer.sval; //Read and
        tokenizer.nextToken(); //Consume the label.
        if (tokenizer.ttype == '(') { //Children?
            tokenizer.nextToken(); //Yes, consume '('.
            do {
                node.children.add(parseString(new Node(), tokenizer)); //Add and parse a child.
            } while (tokenizer.ttype != ')'); //Until we reach ')'.
            tokenizer.nextToken(); //Consume ')'.
        }
        return node;
    }

    public void index(){
        index(root, 0);
    }

    private static int index(Node node, int index){
        for (int i= 0; i < node.children.size(); i++){
            index= index(node.children.get(i), index);
        }
        index++;
        node.index= index;
        return index;
    }

    public void l(){
        left();
        l= l(root, new ArrayList<Integer>());
    }

    private ArrayList<Integer> l(Node node, ArrayList<Integer> l){
        for (int i= 0; i < node.children.size(); i++){
            l= l(node.children.get(i), l);
        }
        l.add(node.leftmost.index);
        return l;
    }

    private void left(){
        left(root);
    }

    public static void left(Node node){
        if (node == null) return;
        for (int i= 0; i < node.children.size(); i++){
            left(node.children.get(i));
        }
        if (node.children.size() == 0){
            node.leftmost= node;
        }
        else {
            node.leftmost= node.children.get(0).leftmost;
        }
    }

    public void keyroots(){
        for (int i= 0; i < l.size(); i++){
            int flag= 0;
            for (int j= i+1; j < l.size(); j++){
                if (l.get(j) == l.get(i)){
                    flag= 1;
                }
            }
            if (flag == 0){
                this.keyroots.add(i + 1);
            }
        }
    }
}
