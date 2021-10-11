/**
 * הוכחה באינדוקציה
 * We mark with 'n' the amount of floors in the tower and with h(n) the amount of steps it takes to move the whole
 * floor (or discs) from the start (A) to the end (C)
 * 
 * for n=1: h(n) = 1 (one floor straight to the end) therefore, one move
 * for n=2:
 *  a) We take the small disc from A to B (Marked as AB)
 *  b) We move the large disc from A to C (Maked as AC)
 *  c) We move the small disc from B to C (Maked as BC)
 * Therefore we have 3 moves : h(2) = 2h(1) + 1 = 3 (h(1) = 1, 2*1 + 1 = 3)
 * 
 * for n=3: 
 *  a) We move small disc from A to C 
 *  b) We move mid disc from A to B
 *  c) We move small disc from C to B
 *  d) We move big disc from A to C
 *  e) We move small disc from B to A
 *  f) We move mid disc from B to C 
 *  g) We move small disc from A to C
 * Therefore, we have 7 moves: h(3) = 2h(2) + 1 = 2*3 + 1 = 7
 * 
 * In general (for every n): 
 *  a) We move n-1 upper discs from A to B by C (h(n-1) moves)
 *  b) We move the big disc (lower) from A to B (one move)
 *  c) We move n-1 discs from B to C using A - h(n-1) moves
 * Therefore, h(n) = 2*h(n-1) + 1.   
 */

 public class HanoiTower {
      /**
       * Hanoi Tower algorithm pseudocode implemented recursive version
       * @param n - Amount of discs
       * @param a - Pillar A
       * @param b - Pillar B
       * @param c - Pillar C
       * @return - int which represents the number of moves for each n discs
       */
    public static int hannoi(int n, char a, char b, char c){
        // recursion stop condition - while base case reach n = 1 
        if ( n == 1 ){
            System.out.println("moving from " + a + " to "+ c);
            return 1;
        }
        // 'slice' into two parts
        int part1 = hannoi(n-1, a, b, c);
        System.out.println("moving from " + a + " to "+ c); // move from which pillar to which
        int part2 = hannoi(n-1, b, c, a);
        return 1+ part1 + part2;
    } 

    // main function to try the function
    /*
    public static void main(String[] args) {
        int n = 3;
        char a = 'A',b = 'B', c ='C';
        System.out.println(hannoi(n, a,b,c));
    }
    */
}