package bytes.algorithm.trees;

import java.util.ArrayList;
import java.util.List;


/**
 * Use Queue to create tree from arrays in bottom up fashion
 *
 */
public class TournamentTrees {

    public void start() {
        int a[] = new int[]{3,6,100,9,10,12,7,-1};
        List<Node> l = new ArrayList<>(a.length/2);

        for(int i = 0; i <= a.length-2; i++) {
            Node n1 = new Node(a[i], null, null);
            Node n2 = new Node(a[i+1], null, null);

            Node min;
            if(n1.n < n2.n) {
                min = new Node(n1.n, n1, n2);
            } else {
                min = new Node(n2.n, n1, n2);
            }
            l.add(min);
        }

    }

}

class Node {
    int n;
    Node left;
    Node right;

    Node(int n, Node left, Node right) {
        this.n = n;
        this.left = left;
        this.right = right;
    }
}
