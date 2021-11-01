/**
 * Problem:
 * We were given a part of raod that there are spreaded small amount of houses on it along the road and given an input number X.
 * We want to construct antenes to smartphones in specific points along the road, that each house being in a distance X km from one of
 * the antenes. 
 * 
 * Solution:
 * First we sort the array of houses by the distance of them from the start of the road.
 * S = {} -> list of distances (in km) from the start of the road of the suggested antenes.
 * 
 * for each i from house No 1 to house No n:
 *  if house i does not have any antene within its range (distance):
 *         S = S U {d[i] + X }
 * 
 * proof:
 * We have to prove that it's correct to place the first antene X km after the FIRST house.
 * 
 * Let assume that there's another optimalistic solution exist where the first antene is being placed in a 
 * different distance of X km from the first house.
 *  If the antene being found in MORE than X km of the first house - 
 *      The first house has no signal and no solution exist.
 *  Else if the antene being found in LESS than X km from the first house -
 *      We change the solution so the first antene will be placed in distance of X km.
 * 
 * The amount of antenes haven't changed and no house has no signal. Therefore, the solution is optimal.
 * 
 * 
 * Optimal substructure:
 * If S={S(1)...S(k)} optimalistic solution to the antenes from the first antene
 * then: S'={S(2)...S(k)} is optimalistic solution to the antenes from the first house in the spot S1 + distance X.
 * 
 * Suppose in the negative that a better solution than S' exist let's call it T.
 * let's add the antene S(1) and we will receive the optimalistic solution to the whole problem: T = T U {S(1)}
 * in contradiction that S is optimalistic.
 */