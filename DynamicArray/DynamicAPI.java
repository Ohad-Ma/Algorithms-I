package DynamicArray;

public interface DynamicAPI {

    /**
     * function add an element at the end of array
     * @param data
     */
    public void add(int data);


    /**
     * function shrink size of array
     * which block unnecessary remove them
     */
    public void shrinkSize();

    /**
     * function add an element at given index
     * @param index
     * @param data
     */
    public void addAt(int index, int data);

    /**
     * function remove last element or put
     * zero at last index
     */
    public void remove();


    /**
     * function shift all element of right
     * side from given index in left
     */
    public void removeAt(int index);


}
