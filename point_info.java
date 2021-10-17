public interface point_info {
    /**
     * Comparasion function
     * @return
     */
    public int hashCode();

    /**
     * Comparasion between objects using the hashcode above
     * @param obj
     * @return
     */
    public boolean equals(Object obj);

    /**
     * Decide how to object "point" will be printed
     * @return 
     */
    public String toString();
    
}
