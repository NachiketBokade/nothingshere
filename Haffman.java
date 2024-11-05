
import java.util.*;

class HaffmanNode {
    char c;
    int data;
    HaffmanNode left;
    HaffmanNode right;

    HaffmanNode(char c, int data) {
        this.c = c;
        this.data = data;
    }
}

class MyCostomComparator implements Comparator<HaffmanNode> {
    @Override
    public int compare(HaffmanNode a, HaffmanNode b) {

        return a.data - b.data;
    }
}

public class Haffman {

    static void PrintCode(HaffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + " : " + s);

            return;
        }
        PrintCode(root.left, s + "0");
        PrintCode(root.right, s + "1");

    }

    public static void main(String[] args) {
        int n = 6;
        char[] charValue = new char[] { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] intValue = new int[] { 5, 9, 12, 13, 16, 45 };
        PriorityQueue<HaffmanNode> pq = new PriorityQueue<HaffmanNode>(n, new MyCostomComparator());
        for (int i = 0; i < n; i++) {
            HaffmanNode node = new HaffmanNode(charValue[i], intValue[i]);
            pq.add(node);
        }
        HaffmanNode root = null;
        while (pq.size() > 1) {
            HaffmanNode l = pq.peek();
            pq.poll();
            HaffmanNode r = pq.peek();
            pq.poll();

            HaffmanNode f = new HaffmanNode('-', l.data + r.data);
            f.left = l;
            f.right = r;
            root = f;
            pq.add(f);

        }

        PrintCode(root, "");

    }

}
