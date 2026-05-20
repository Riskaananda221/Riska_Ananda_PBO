public class MainBank {
    public static void main(String[] args) {
        System.out.println("=== TESTING METHOD OVERLOADING (Class Bank) ===");
        Bank bankUmum = new Bank();
        bankUmum.transferUang(500000, "12345678");
        bankUmum.transferUang(1000000, "87654321", "MANDIRI");
        bankUmum.transferUang(200000, "55667788", "BRI", "Bayar Hutang");
        bankUmum.sukuBunga();

        System.out.println("\n=== TESTING METHOD OVERRIDING (Bank BNI) ===");
        BankBNI bni = new BankBNI();
        bni.sukuBunga();
        bni.transferUang(1500000, "99900011", "BNI"); // Tanpa admin
        bni.transferUang(1500000, "99900011", "BCA"); // Pakai admin BNI

        System.out.println("\n=== TESTING METHOD OVERRIDING (Bank BCA) ===");
        BankBCA bca = new BankBCA();
        bca.sukuBunga();
        bca.transferUang(3000000, "11122233", "BCA"); // Tanpa admin
        bca.transferUang(3000000, "11122233", "BNI"); // Pakai admin BCA
    }
}