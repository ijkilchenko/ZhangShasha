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

        //TODO: Figure out what's wrong. I may be evaluating in the wrong order.
        int distance= ZhangShasha(tree1, tree2);
        System.out.println(distance);

    }

    static int[][] TD;

    private static int ZhangShasha(Tree tree1, Tree tree2){
        tree1.index();
        tree1.l();
        tree1.keyroots();
        tree2.index();
        tree2.l();
        tree2.keyroots();

        ArrayList<Integer> l1= tree1.l;
        ArrayList<Integer> keyroots1= tree1.keyroots;
        ArrayList<Integer> l2= tree2.l;
        ArrayList<Integer> keyroots2= tree2.keyroots;

        TD = new int[l1.size()+1][l2.size()+1];

        for (int i1= 1; i1 < keyroots1.size()+1; i1++){
            for (int j1= 1; j1 < keyroots2.size()+1; j1++){
                int i= keyroots1.get(i1-1);
                int j= keyroots2.get(j1-1);
                TD[i1][j1]= treedist(l1, l2, i, j);
            }
        }

        return TD[keyroots1.size()][keyroots2.size()];
    }

    private static int treedist(ArrayList<Integer> l1, ArrayList<Integer> l2, int i, int j){
        int[][] forestdist= new int[i+1][j+1];

        int Gamma= 1;

        //The following two for-loops seem to work properly.
        forestdist[0][0]= 0;
        for (int i1= l1.get(i-1); i1 <= i; i1++){
            forestdist[i1][0]= forestdist[i1-1][0] + Gamma;
        }
        for (int j1= l2.get(j-1); j1 <= j; j1++){
            forestdist[0][j1]= forestdist[0][j1-1] + Gamma;
        }
        for (int i1= l1.get(i-1); i1 <= i; i1++){
            for (int j1= l2.get(j-1); j1 <= j; j1++){
                if ((l1.get(i1-1) == l1.get(i-1)) && (l2.get(j1-1) == l2.get(j-1))){
                    forestdist[i1][j1]= Math.min(Math.min(forestdist[i1-1][j1] + Gamma, forestdist[i1][j1-1] + Gamma),
                            forestdist[i1-1][j1-1] + Gamma);
                    TD[i1][j1]= forestdist[i1][j1];
                }
                else{
                    forestdist[i1][j1]= Math.min(Math.min(forestdist[i1-1][j1] + Gamma, forestdist[i1][j1-1] + Gamma),
                            forestdist[i1-1][j1-1] + TD[i1][j1]);
                }
            }
        }

        return forestdist[i][j];
    }
}
