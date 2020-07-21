package playground.chapter3_SharingObjects;

public class ImmutableArrayListTest {
    public static void main(String[] args) {
        ImmutableArrayList<String> ial = new ImmutableArrayList<>();
        ial = ial.add("Pankaj").add("Agarwal").add("Prisha");

        for(Object o : ial){
            System.out.println("o = " + o);
        }
    }
}
