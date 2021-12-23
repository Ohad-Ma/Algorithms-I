
/// <summary>Counts the number of islands on a matrix on O(N*M) Time Complexity</summary>
public class IslandsProblem{
    public int IslandCounter(char[][] board){
        var amount = 0; // number of islands
        for (int i = 0; i < board; i++){
            for (int j = 0; j < board[0].Length; j++){
                if (board[i][j] == '1'){
                    amount++;
                    UpdateBoard(i,j,board);
                }
            }
        }
        return amount;
    }

    /// <summary>Updates every cell if and only if indexes aren't negative,
    /// any index reach the grid's end or the current block is '0'
    /// </summary> 
    public void UpdateBoard(int i, int j,char[][] board){
        if(i< 0 || j<0 || i == board.Length || j == board[0].Length || board[i][j] == '0') return;
        board[i][j] = '0';
        UpdateBoard(i,j-1,board); // update left
        UpdateBoard(i,j+1,board); // update right
        UpdateBoard(i-1,j,board); // update top
        UpdateBoard(i+1,j,board); // update bottom
    }
}