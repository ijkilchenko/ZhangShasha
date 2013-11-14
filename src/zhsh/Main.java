/**
 * User: ijk
 * Date: 10/26/13
 */
package zhsh;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException{
        System.out.println("Hello World!");

        //Sample trees (in preorder).
        String tree1Str1= "f(d(a c(b))e)";
        String tree1Str2= "f(c(d(a b))e)";
        String tree1Str3= "f(c d a(b c))";

        Tree tree1= new Tree(tree1Str1);
        Tree tree2= new Tree(tree1Str2);

        int distance= ZhangShasha(tree1, tree2);

    }

    static int[][] TD;

    private static int ZhangShasha(Tree tree1, Tree tree2){
        tree1.index();
        tree1.l();
        tree1.keyroots();
        tree2.index();
        tree2.l();
        tree1.keyroots();

        ArrayList<Integer> l1= tree1.l;
        ArrayList<Integer> keyroots1= tree1.keyroots;
        ArrayList<Integer> l2= tree2.l;
        ArrayList<Integer> keyroots2= tree2.keyroots;

        TD = new int[keyroots1.size()][keyroots2.size()];

        return 1;
    }
}
