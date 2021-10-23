import java.util.Arrays;
import java.util.Comparator;

/**
 * You have a knapsack which can only contain certain weight C of goods
 * With this weight capacity constraint, you want to maximize the values of the goods you can put in the knapsack.
 * Unlike the 0 1 KnapSack where you cannot break items, the fractional let you break items and put them inside the bag.
 * 
 * The approach for this solution is greedy
 * - Credits to geeksforgeeks for the solution - 
 * 
 * 
 */

public class FractionalKnapsackProblem {
    // function to get maximum value
    private static double getMaxValue(int[] weight, int[] value,int capacity)
    {
        // create a list of items instance of Item subclass
        Item[] items = new Item[weight.length];
  
        // put values of given thee in the list 
        for (int i = 0; i < weight.length; i++) {
            items[i] = new Item(weight[i], value[i], i);
        }
  
        // sorting items by value
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2)
            {
                return o2.cost.compareTo(o1.cost);
            }
        });
  
        double totalValue = 0d;
        // 'objectly' walk over the made list
        for (Item i : items) {
  
            // hold current weight and value
            int curWeight = (int)i.weight;
            int curVal = (int)i.value;
  
            // if there's still capacity left to hold more items
            if (capacity - curWeight >= 0) {
                // this weight can be picked while
                capacity = capacity - curWeight;
                totalValue += curVal;
            }
            else {
                // item cant be picked whole
                double fraction = ((double)capacity / (double)curWeight);
                totalValue += (curVal * fraction);
                capacity = (int)(capacity - (curWeight * fraction));
                break;
            }
        }
        return totalValue;
    }
  
    // item value class
    static class Item {
        Double cost;
        double weight, value;
        int index;
  
        // item value function
        public Item(int weight, int value, int ind)
        {
            this.weight = weight;
            this.value = value;
            this.index = ind;
            cost = new Double((double)value / (double)weight);
        }
    }
  
    /*
    // Driver code
    public static void main(String[] args)
    {
        int[] weight = { 10, 40, 20, 30 };
        int[] value = { 60, 40, 100, 120 };
        int capacity = 50;
  
        double maxValue = getMaxValue(weight, value, capacity);
  
        // Function call
        System.out.println("Maximum value we can obtain = "
                           + maxValue);
    }
    */
}
