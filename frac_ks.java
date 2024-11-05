
import java.util.Comparator;
import java.util.Arrays;

class Items {
    int weight, value;

    Items(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class customComparator implements Comparator<Items> {

    public int compare(Items a, Items b) {
        double ratio1 = (double) (a.value) / (double) (b.weight);
        double ratio2 = (double) (b.value) / (double) (b.weight);
        if (ratio1 > ratio2)
            return 1;
        else if (ratio1 < ratio2)
            return -1;
        else
            return 0;

    }
}

public class Solve {

    static double Ksnap(Items[] arr, int n, int capacity) {
        Arrays.sort(arr, new customComparator());
        int remainWeight = 0;
        double total = 0.0;
        for (Items item : arr) {
            if (remainWeight + item.weight <= capacity) {
                total = total + item.value;
                remainWeight += item.weight;
            } else {
                total = total + (double) (capacity-remainWeight) * ((double) (item.value) / (double) (item.weight));
                break;

            }
        }
        return total;
    }

    public static void main(String[] args) {
        int capacity = 50;
        int n = 3;
        Items arr[] = new Items[] { new Items(100, 20), new Items(60, 10), new Items(120, 30) };
        double finalCost = Ksnap(arr, n, capacity);
        System.out.println(finalCost);
        //

    }
}