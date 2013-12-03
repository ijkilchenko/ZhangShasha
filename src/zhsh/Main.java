/**
 * User: ijk
 * Date: 10/26/13
 */
package zhsh;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException{
        System.out.println("Hello to ZhangShasha!");

        //Sample trees (in preorder).
        String tree1Str1= "f(d(a c(b)) e)";
        String tree1Str2= "f(c(d(a b)) e)";

        Tree tree1= new Tree(tree1Str1);
        Tree tree2= new Tree(tree1Str2);

        int distance= Tree.ZhangShasha(tree1, tree2);
        System.out.println(distance);

    }
}
