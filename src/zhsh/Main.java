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

        String tree1Str3= "a(b(c d) e(f g(i)))";
        String tree1Str4= "a(b(c d) e(f g(h)))";

        String tree1Str5= "d";
        String tree1Str6= "g(h)";

        Tree tree1= new Tree(tree1Str1);
        Tree tree2= new Tree(tree1Str1);

        int distance= Tree.ZhangShasha(tree1, tree2);
        System.out.println(distance);

    }
}
