import java.util.Arrays;

public class MyArray {
    int[] arr;
    public MyArray(){
        arr = new int[] {8, 4, 3, 6, 3, 1, 9, 0, 3};
    }

    /*
    An algorithm is a set of instructions for a problem
    that is guaranteed to always solve that problem regardless of inputs

    Humansort
    Iterate through the list of numbers, find the lowest one,
    cross it out,
    and add it to the end of my new list of numbers.
    Do this for as many times as we have values.
     */

    public int getMin(){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    public void humanSort(){
//        establish a new array to fill sorted values with
        int[] newArr = new int[arr.length];
//        we know we need to repeat the search process N times
        for(int i = 0; i < arr.length; i++){
//            we know we need to keep track of the min
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
//            we need to search through the array to be able to find the min
            for(int j = 0; j < arr.length; j++){
                if(arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
//            we need to 'cross out' the found item
            arr[minIndex] = Integer.MAX_VALUE;
            newArr[i] = min;
//            so far what's missing is the 'crossing out' function..
            System.out.println("old: "+Arrays.toString(arr));
            System.out.println("new " + Arrays.toString(newArr));
        }
        arr = newArr;
    }

    public void selectionSort(){
//        we know we need to N passes through the find min/swap section
        for(int i = 0; i < arr.length; i++){
//            find the mininmum value after index i and swap it with index i
//            find the minimum
            int minIndex = i;
//            j=i because after the first pass, we're not looking to fill the 0th spot any more
            for(int j = i; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
//                    if the value at index j is smaller than the value at the previous min index, set min index to j
                    minIndex = j;
                }
            }
//            let's swap arr at i with arr at min index
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            System.out.println(Arrays.toString(arr));
        }
    }

    public boolean linearSearch(int a){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == a){
                return true;
            }
        }
        return false;
    }

    public boolean binarySearch(int a){
        int minIndex = 0;
        int maxIndex = arr.length;
//        we exit if there's no way to generate a new midIndex because min and max are identical
        while(minIndex <= maxIndex){

            int midIndex = ( minIndex + maxIndex ) /2;
            System.out.println("searching for values between "+minIndex + " and " + maxIndex);
            System.out.println("current mid is " + arr[midIndex]);
            if(arr[midIndex] == a){
                return true;
            }
            else if(arr[midIndex] > a){
//                look to the left by changing maxIndex
                maxIndex = midIndex-1;
            }
            else if(arr[midIndex] < a){
//                look to the right by changing minIndex
                minIndex = midIndex+1;
            }
        }
        return false;
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < arr.length; i++){
            s = s + arr[i] +", ";
        }
        return s;
    }
}

/*

the way both of these algorithms scale wrt the size of the input (ie the size of the array)
is n^2
because you have a for loop that executes n times inside of another for loop that executes n times
the best sorting algorithms are not scaling to n^2, but rather n*log(n)

*/

/*

there are different ways to even find a value within some group of items
the hash set we just created can find if a values exists instantaneously!
this is because calling the hashcode method will not change in speed
with any regard to the amount of items current in the hashset
it scales to 1 (constant time)

let's say that we're still interested in storing things in a regular old array...
if we wanted to find if a value is contained in an array, we just iterated
through the whole thing and return true if it exists
it scales linearly to the size of the problem

remember BST?
this did not scale linearly - rather, like searching through a dictionary, it
cut the problem in half every time we made a comparison
this makes it scale to log(n)

 */