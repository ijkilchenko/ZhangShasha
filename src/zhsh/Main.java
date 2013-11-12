/**
 * User: ijk
 * Date: 10/26/13
 */
package zhsh;
import java.io.IOException;
public class Main {

    public static void main(String[] args) throws IOException{
        System.out.println("Hello World!");

        //Sample trees (in preorder).
        String tree1Str1= "f(d(a c(b))e)";
        String tree1Str2= "f(c(d(a b))e)";
        String tree1Str3= "f(c d a(b c))";

        Tree tree1= new Tree(tree1Str1);

    }

    private int ZhangShasha(Node tree1, Node tree2){

        return 1;
    }
}
