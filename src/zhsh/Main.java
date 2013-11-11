/**
 * User: ijk
 * Date: 10/26/13
 */
package zhsh;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{
        System.out.println("Hello World!");

        //Sample trees.
        String tree1Str1= "f(d(a c(b))e)";
        String tree1Str2= "f(c(d(a b))e)";
        String tree1Str3= "f(c d a(b c))";

        Node tree1= new Node();
        tree1= tree1.parseTree(tree1Str1);

        Node tree2= new Node();
        tree2= tree2.parseTree(tree1Str2);

        System.out.println(tree1.printTree());
        System.out.println(tree1.l());
        tree1.LRkeyroots();
        System.out.println(tree1.LRkeyroots.toArray().toString());
        System.out.println(tree2.printTree());
        System.out.println(tree2.l());
        tree2.LRkeyroots();
        System.out.println(tree2.LRkeyroots.toArray().toString());

    }

    private int ZhangShasha(Node tree1, Node tree2){

        return 1;
    }
}
