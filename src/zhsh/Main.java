/**
 * User: ijk
 * Date: 10/26/13
 */
package zhsh;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        String tree1Str= "f(d(a c(b))e)";

        Tree treeFromString= new Tree(tree1Str);
        System.out.println(treeFromString.printTree());

    }

    private int ZhangShasha(Tree tree1, Tree tree2){

        return 1;
    }
}
