package zhsh;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
/**
 * User: ijk
 * Date: 11/12/13
 */
public class Tree {
    Node root= new Node();

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

    private Node parseString(Node node, StreamTokenizer tokenizer) throws IOException{
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
}
