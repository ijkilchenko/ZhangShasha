/**
 * User: ijk
 * Date: 10/26/13
 */
package zhsh;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{
        System.out.println("Hello World!");

        String tree1Str1= "f(d(a c(b))e)";
        String tree1Str2= "f(c(d(a b))e)";

        Node treeFromString= new Node();
        treeFromString= treeFromString.parseTree(tree1Str2);
        System.out.println(treeFromString.printTree());

    }

/*    private int ZhangShasha(Tree tree1, Tree tree2){

        return 1;
    }*/
}
