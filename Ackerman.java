/**
 * 
 *           /  m + 1             if n = 0
 *           |
 * A(n,m) =  {  A(n-1,1)          if m = 0
 *           |
 *           \  A(n-1,A(n,m-1))   both  m & n > 0   
 *              
 * 
 * 
 * 
 * Ackermann(m, n) 
    {next and goal are arrays indexed from 0 to m, initialized so that next[O] 
        through next[m] are 0, goal[O] through goal[m - l] are 1, and goal[m] is -1} 
    repeat
        value <-- next[O] + 1 
        transferring <-- true 
        current <-- O 
        while transferring do begin
        if next[current] = goal[current] then goal[current] <-- value
                                                else transferring <-- false
        next[current] <-- next[current]+l
        current <-- current + 1 
        end while
    until next[m] = n + 1 
    return value {the value of A(m, n)}
    end Ackermann 
 */
class Ackermann{
    public int ackermann(int n, int m){
        if ( n == 0 ) return m + 1;
        else if ( n > 0  && m == 0) return ackermann(n-1, 1);
        else if ( (m > 0) && (n > 0)){
            return ackermann(n-1, ackermann(n, m - 1));
        }else{
            return m + 1;
        } 

    }
}