/**
 * Problem:
 * We were given an N size array which contains values such that:
 *  - Every cell in the array contains a Cop or A Burglar
 *  - Every cop can capture only one burglar
 *  - Cop cannot capture burglar which is being found in a distance bigger than K cells from it.
 * 
 * We have to find the maximal amount of burglars that we can capture.
 * 
 * Solution:
 * 1) Find the lowest index where Cop is being found - p, and the lowest index where Burglar is found - t
 * 2) If (|p-t| <= k) : 
 *      Pair(p,t)
 *      increment p,t indexes to the next Cop and Burglar cells
 * 3) Else:
 *      Increment the min(p,t) idx to the next one.
 *      Do over 2 last steps.
 * 
 * 4) return the amount of pairs.
 * 
 * 
 * Time Complexity: O(N) 
 * 
 * Algorithm:
    1. Initialize the current lowest indices of policeman in pol and thief in thi variable as -1.
    2 Find the lowest index of policeman and thief.
    3 If lowest index of either policeman or thief remain -1 then return 0.
    4 If |pol – thi| <=k then make an allotment and find the next policeman and thief.
    5 Else increment the min(pol , thi) to the next policeman or thief found.
    6 Repeat the above two steps until we can find the next policeman and thief.
    7 Return the number of allotments made.
 */
 
 /**
  * GeeksForGeeks implementation below:
  */
class CopsAndBurglars {
 
    // Returns maximum number of thieves that can
    // be caught.
    static int policeThief(char arr[], int n, int k)
    {
 
        int pol = -1, thi = -1, res = 0;
 
        // store the first index of police in pol
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                pol = i;
                break;
            }
        }
 
        // store the first index of thief in thi
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'T') {
                thi = i;
                break;
            }
        }
 
        // return 0 if no police OR no thief found
        if (thi == -1 || pol == -1)
            return 0;
 
        // loop to increase res iff distance between
        // police and thief <= k
        while (pol < n && thi < n) {
 
            // thief can be caught
            if (Math.abs(pol - thi) <= k) {
 
                pol++;
 
                // to find the index of next police for next
                // iteration
                while (pol < n && arr[pol] != 'P') {
                    pol++;
                }
 
                // to find the index of next thief for next
                // iteration
                thi = thi + 1;
                while (thi < n && arr[thi] != 'T') {
                    thi++;
                    ;
                }
 
                // increment res, as the thief has been
                // caugh
                res++;
            }
 
            // thief cannot be caught as dist > k
            else if (thi < pol) {
 
                // as index of thief is behind police,
                // we need to find the next thief and check
                // if it can be caught by the current police
                //(it will be checked in the next iteration)
                // Hence, find the index of next thief
                thi++;
                while (thi < n && arr[thi] != 'T') {
                    thi++;
                }
            }
            else {
 
                // as the index of police is behind the
                // thief, it cannot catch the thief. Hence,
                // we need the index of next police and
                // check if it can catch the current thief
                //(it will be checked in the next iteration)
                pol++;
                while (pol < n && arr[pol] != 'P') {
                    pol++;
                }
            }
        }
 
        return res;
    }
 
    /*
    // Driver code starts
    public static void main(String[] args)
    {
 
        char arr1[] = { 'P', 'T', 'T', 'P', 'T' };
        int n = arr1.length;
        int k = 2;
        System.out.println("Maximum thieves caught: "
                           + policeThief(arr1, n, k));
 
        char arr2[] = { 'T', 'T', 'P', 'P', 'T', 'P' };
        n = arr2.length;
        k = 2;
        System.out.println("Maximum thieves caught: "
                           + policeThief(arr2, n, k));
 
        char arr3[] = { 'P', 'T', 'P', 'T', 'T', 'P' };
        n = arr3.length;
        k = 3;
        System.out.println("Maximum thieves caught: "
                           + policeThief(arr3, n, k));
    }
    */
}