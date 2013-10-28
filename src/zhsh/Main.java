/**
 * User: ijk
 * Date: 10/26/13
 */
package zhsh;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        String tree1Str= "f(d(a c(b))e)";
        String tree2Str= "f(c(d(a b))e)";

        Node myroot= new Node("F");
        myroot.addChild(new Node("A"));
        myroot.addChild(new Node("B"));

        Tree mytree= new Tree(myroot);

        System.out.println(mytree.printTree());


    }

    private int ZhangShasha(Tree tree1, Tree tree2){

        return 1;
    }
}
