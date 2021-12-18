package DynamicArray;

public class DynamicArr implements DynamicAPI{

    private int len; // length of array
    private int[] arr; // array itself which will be copied and modified
    private int count; // the var [count] in the array

    public DynamicArr(){
        this.len = 1;
        this.arr = new int[1];
        this.count = 0;
    }

    @Override
    public void add(int data) {
        int[] temp = null;

        // first we check if we have space left
        if (len == count){
            // make new array
            temp = new int[len*2];
            if (len >= 0) System.arraycopy(arr, 0, temp, 0, len);
            // swap the arrays, the old with the new
            this.arr = temp;

            // increase the classes length
            this.len *= 2;
        }
        // we have more space left to place variables
        arr[this.count] = data;

        // increase the class counter
        this.count++;
    }

    @Override
    public void shrinkSize() {
        if (count > 0){
            // temporary array to store the original array
            int[] temp = new int[count];
            // copy the values of the original arrays into the temporary array
            System.arraycopy(arr, 0, temp, 0, count);
            // update the length
            this.len = count;
            // replace the original array with the temporary one
            this.arr = temp;
        }
    }

    @Override
    public void addAt(int index, int data) {
        int[] temp = null;

        // first we check if we have space left
        if (len == count){
            // make new array
            temp = new int[len*2];
            if (len >= 0) System.arraycopy(arr, 0, temp, 0, len);
            // swap the arrays, the old with the new
            this.arr = temp;

            // increase the classes length
            this.len *= 2;
        }
        // shift elements right
        if (count - index >= 0) System.arraycopy(arr, index, this.arr, index + 1, count - index);

        // place the given variable in the array at given index
        this.arr[index] = data;

        // update count
        this.count++;
    }

    @Override
    public void remove() {
        // base case if there is more than 0 variables
        if (this.count > 0){
            // put at the last index 0
            this.arr[count-1] = 0;
            // update the count
            count--;
        }
    }

    @Override
    public void removeAt(int index) {
        if (this.count > 0){
            // shift values from the left to the right
            if (count - 1 - index >= 0) System.arraycopy(this.arr, index + 1, this.arr, index, count - 1 - index);
            // last value is 0 (deleted)
            this.arr[count - 1] = 0;
            // update count
            this.count--;
        }
    }
}
