public class Sort {
    public static void main(String[] args) {
        MyArray ma = new MyArray();
//        System.out.println(ma);
        ma.selectionSort();
//        System.out.println(ma);
        System.out.println(ma.binarySearch(2));
    }
}