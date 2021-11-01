/**
 * Given an array A of n natural numbers (A0....A(n-1)) and a number X>1. You have to suggest an order of 
 * the array A that the polynominal value A(0)+A(1)X + A(2)X^2 +....+ A(n-1)X^(n-1) will be the maximal.
 * 
 * 
 * solution: Greedy Approach
 * In order to find the solution we will sort the array from the maximum value to the lowest value (AKA 5 4 3 2 1)
 * There is an optimalistic solution which A(0) is the minimal value within array A.
 * Let assume that another optimalistic exist where index 0 does not hold the minimal value. So the minimal
 * value A(min) exist in another index in the array. let mark it with 'i'.
 * Now we will swap(A(0),A(min)) and we will get another polynominal value which is lower by (A(0) - A(min))
 * and bigger by (A(0) - A(min))*X^i. As we know X>1 Therefore, the value of the polynom increase. 
 * 
 * proof for the optimal subarray:
 * Let assume falsely that the whole arrangment of the array is optimalistic but the arrangment of sub array
 * A(1)....A(n-1) isn't optimal for the polynom A(1)X + A(2)X^2 +....+ A(n-1)X^(n-1). 
 * On the other hand exist optimalistic arrangment for the subarray A(1) ... A(n-1) so we can get higher value for the correct 
 * polynom.
 * Let's add A(0) to the optimalistic solution of subarray and we will get HIGHER VALUE for the whole polynom.
 * That's a contradiction to the assumption that the original solution was optimalistic to the whole polynom.
 * 
 * TC: O(nlog(n)) - just the sorting
 */