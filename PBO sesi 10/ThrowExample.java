public class ThrowExample {
    static void demo () {
        NullPointerException t;
        t = new NullPointerException ("Coba Throw");
        throw t;
    }
    public static void main(String[] args) {
        System.out.println("Selesai");
        try {
            demo ();
        } catch (NullPointerException e) {
            System.out.println("Ada pesan error: "+e);
        }
    }
}