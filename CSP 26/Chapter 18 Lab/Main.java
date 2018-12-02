public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        
        int[] data = new int[] {2, 10, 5, 18, 20};
        for (int i : data) {
            list.add(i);
        }
        
        System.out.printf("Smallest: %d%n", list.smallest());
        System.out.printf("Larges: %d%n", list.largest());
        
        System.out.println("Adding 30 to list");
        list.add(30);
        
        System.out.printf("Smallest: %d%n", list.smallest());
        System.out.printf("Larges: %d%n", list.largest());
    }
    
}
