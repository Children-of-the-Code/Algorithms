public class HashSet <T> {
    T[] bucket;
    int bucketSize;
    public HashSet(){
        bucketSize = 1000;
        bucket = (T[]) new Object[bucketSize];
        /*
        'T' in this case is the same as using the Object class - because all objects
        are descended from Object, T can act as a stand-in for any object - a placeholder
         */
    }
    public void add(T item){
        /*how do we get our position?
        the way a hashset works -
        an object can be converted into a raw number based on its properties
        (this method that does actually comes with the Object class - it's inherited by all
        objects
        we can use this number to potentially find a completely random spot in an array
        where it may belong

        how?

        we can divide by the size of the array, but only use the remainder
        eg you want to insert items into boxes, but you want to follow some organization -
        you notice that the items have a unique serial number, and can use the last 2 digits
        of the serial to get a random box position -
        then, if you want to find an item, but know its serial, you can just take a look at those
        digits and find the item in its box

        8643 % 100 = 43
        8643 / 100 = 86
         */

        int position = item.hashCode() % bucketSize;
        bucket[position] = item;
//        caveat : there is a very small chance that multiple items
//        fall in the same position: let's ignore that for now
    }
    public boolean contains(T item){
        int position = item.hashCode() % bucketSize;
//        bucket position is NOT NULL, so it's NOT empty, contains is TRUE
        if(bucket[position]!=null){
            return true;
        }
//        bucket position is NULL, so it's empty, contains is FALSE
        return false;
    }

}
