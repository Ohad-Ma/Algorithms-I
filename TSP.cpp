/**
 * @file TSP.cpp
 * @author your name (maday.ohad@gmail.com)
 * @brief 
 * @version 0.1
 * @date 2021-12-25
 * 
 * @copyright Copyright (c) 2021
 * 
 * 
 * Problem: 
 * In a random field there are n flowers: f_1,...,f_n. Every position of flower f_i is
 * given by cooridnates (x_i,y_i). A bee found in the first flower - f_1 and it needs to visit EVERY flower
 * and at the end return to the first flower - f_1. We want to ahchieve it in the shortest path.
 * 
 *   > Let's assume she finds the shortest path by visiting all the possible paths. How many paths did the bee take?
 *   
 *   > Let's assume the bee use greedy algorithm which each step she visit the nearby flower that she
 *     haven't visit it yet. Show an example that the greedy algorithm isn't optimal.
 *   
 *   > Let's suggest a solution via Dynamic programming. Therefore, we define for each subset 
 *     A \subseteq (inclusion relation) in {2,...,n} and for each i NOT IN A the shortest path
 *     start with f_1 - T[A,i] which visits every flower {f_j,j IN A} and finish at f_i.
 * 
 *          & What is the size of T?
 *          & Write a recursive formula for T[A,i]?
 *          & On which order will you fill T?
 *          & How long does it take to calculate each cell?
 *          & In which cell from T are we interested in at the end?
 *          & What any information else do we need to store in every cell of T 
 *            in order to restore efficiently the shortest path?
 * 
 * Solution:
 * 
 * A) The bee visited (n-1)! paths. As the number of permutations on {2,...,n}
 * 
 * B)     Example: 
 *                 ( 0 )---( 3 )---( 5 )---( 11 )
 * 
 *                 greedy approach: (smaller distance first)
 *                                  3 -> 5  : distance 2
 *                                  5 -> 0  : distance 5
 *                                  0 -> 11 : distance 11
 *                                 11 -> 3  : distance 8
 *                                  total distance : 2+5+11+8 = 26
 *                  
 *                 optimal approach:
 *                                 3 -> 0  : distance 3 
 *                                 0 -> 5  : distance 5
 *                                 5 -> 11 : distance 6
 *                                11 -> 3  : distance 8
 *                                  total distance: 3+5+6+8 = 22
 *                  
 *                 Therefore we got a contradiction.
 * 
 * C) Dynamic programming solution:
 *  
 *     1) size of T: |T[A,i]| |A|*|i| = 2 ^ (n-1)*n.
 *     2) recursive formula of T[A,i]: min j in A (T[A-j,j] + d(j,i)).
 *     3) we fill T by the size of A from the smallest to the biggest.
 *     4) The time takes to calculate each cell is O(n).
 *     5) We are interested to get cell T[{2,...,n}, 1] from T.
 *     6) In order the restore efficiently the shortest path, every cell in T will store both the length of the path
 *        AND the path itself. 
 * 
 * 
 * An Example:
 *          
 * 
 * 
 *                              ( 1 )
 *                              / | \
 *                           10/20|  \15
 *                            / ( 4 ) \
 *                           / 25/  \30\  
 *                          /   /    \  \
 *                         ( 2 )--35--( 3 )
 * 
 *   i -> 
 * A
 * v   
 *               1 |  2 |  3  |  4  
 *              -------------------   
 *       {fi}    0   10   15    20     <- start at 1 and ends at 1 or 2 or 3 or 4
 *     {2,fi}   20    0   45    35     <- start at 2 including distance of 1 and 2 and ends at 1 or 2 or 3 or 4
 *     {3,fi}   30   50    0    45     <- start at 3 including distance of 1 and 3 and ends at 1 or 2 or 3 or 4
 *     {4,fi}   40   45   50     0     <- start at 4 including distance of 1 and 4 and ends at 1 or 2 or 3 or 4
 *   {2,3,fi}   60    0    0    75     <- start at 2,3 including distance of 1 and 2,3 and ends at 1 or 2 or 3 or 4
 *   {2,4,fi}   55    0   65     0     <- start at 2,4 including distance of 1 and 2,4 and ends at 1 or 2 or 3 or 4
 *   {3,4,fi}   65   70    0     0     <- start at 3,4 including distance of 1 and 3,4 and ends at 1 or 2 or 3 or 4
 * {2,3,4,fi}   80    0    0     0     <- start at 2,3,4 including distance of 1 and 2,3,4 and ends at 1 or 2 or 3 or 4
 * 
 * >>>>>> Why 0? Because there is no distance between the idx and itself
 * 
 * >>>>>> How do we calculate the path? 
 *          If A is different than empty group then: T[A,i] = min j in A (T[A/j,j] + d(j,i)) 
 * 
 * Time complexity: O(2^n * n^2)
 *                                                      
 */  

#include <iostream>

using namespace std;

int field[10][10], path[10], n ,cost = 0;
void minimal(int flower){
    int i, nflower;

    path[flower] = 1;

    cout << flower + 1 << endl;
    nflower = least(flower);

    if (nflower == -1) {
        nflower = 0;
        cout << flower + 1 << endl;
        cost += field[flower][nflower];

        return;
    }

    minimal(nflower);
}

int least(int c){
    int i, nc = -1, min = 999, kmin;

    for (i = 0; i < n; i++)
    {
        if ((field[c][i] != 0) && (path[i] == 0)){
            if(field[c][i] + field[i][c] < min) {
                min = field[i][0] + field[c][i];
                kmin = field[c][i];
                nc = i;
            }
        }
    }
    if (min != -1) cost += kmin;

    return nc;
    
}

        