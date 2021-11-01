/**
 * Problem:
 * There is a sale in the Reuven's store; Whoever buys a pair of items recieve the cheaper pair of them for free.
 * After we choose 2n items in prices of P(1),...,P(n)....,P(2n) we want to arrange them as pairs so we can
 * recieve the sale. suggest an algorithm which grant pair of items that the overall cost we have to pay is minimalistic. 
 * 
 * 
 * solution:
 * Let X1.....X(n) be an array of items while X represent an item. 
 * We sort the items from the cheap to the expensive and then we chose a nearby pairs of items:
 * (X(1)&X(2)),(X(3)&X(4)), ..... , (X(n-1)&X(n)).
 * 
 * If we pair X(1) and X(2) different items, according to the solution the new pairing of fourth items
 * will COST MORE than the previous pairing of fourth items. It's a result of the way the items were sorted.
 * 
 * By given an optimalistic to N items, we will assume in contradiction that optimalistic solution exist for N-2
 * items (after we 'get rid of' one pair of items) and we will get a contradiction to the assumption.
 * 
 */