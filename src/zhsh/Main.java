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

        String sen1= "S(NP(The sky) VP(is ADJP(blue)))";
        String sen2= "S(NP(The sky) VP(is ADJP(gray)))";

        Tree tree1= new Tree(sen1);
        Tree tree2= new Tree(sen2);

//        Tree tree1= new Tree(sen1);
//        Tree tree2= new Tree(sen2);

        int distance= Tree.ZhangShasha(tree1, tree2);
        System.out.println(distance);

    }
}
