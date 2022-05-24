public class HashDriver {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("zebra");
        if(hs.contains("zebra")){
            System.out.println("contains string");
        }else{
            System.out.println("does not contain string");
        }
        if(hs.contains("cow")){
            System.out.println("contains string");
        }else{
            System.out.println("does not contain string");
        }
    }
}
