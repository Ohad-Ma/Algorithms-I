// The following implementation assumes that the activities
// are already sorted according to their finish time
import java.util.ArrayList;

class ActivitySelection
{
	// Prints a maximum set of activities that can be done by a single
	// person, one at a time.
	// n --> Total number of activities
	// s[] --> An array that contains start time of all activities
	// f[] --> An array that contains finish time of all activities
	public static ArrayList<Integer> maxActivities(int s[], int f[], int n)
	{
	int i, j;
    ArrayList<Integer> ans = new ArrayList<>();
	
	System.out.print("Following activities are selected : \n");
	
	// The first activity always gets selected
	i = 0; ans.add(i);
	
	// Consider rest of the activities
	for (j = 1; j < n; j++)
	{
		// If this activity has start time greater than or
		// equal to the finish time of previously selected
		// activity, then select it
		if (s[j] >= f[i])
		{
			ans.add(j);
			i = j;
		}
	}

    return ans;
	}
	
    /*
	// driver program to test above function
	public static void main(String[] args)
	{
	int s[] = {1, 3, 0, 5, 8, 5};
	int f[] = {2, 4, 6, 7, 9, 9};
	int n = s.length;
	
    System.out.println(maxActivities(s, f, n));
	
	}
    */
	
}
