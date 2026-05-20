// Subclass BankBNI
class BankBNI extends Bank {
    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga dari BNI adalah : 4%");
    }

    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        // Bonus Challenge: Biaya admin jika bank tujuan bukan BNI
        int biayaAdmin = bankTujuan.equalsIgnoreCase("BNI") ? 0 : 6500;
        System.out.println("[BNI Mobile] Transfer ke " + bankTujuan + " (" + rekeningTujuan + ") Rp" + jumlah + 
                           " | Biaya Admin: Rp" + biayaAdmin);
    }
}

// Subclass BankBCA
class BankBCA extends Bank {
    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga dari BCA adalah : 4.5%");
    }

    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        // Bonus Challenge: Biaya admin jika bank tujuan bukan BCA
        int biayaAdmin = bankTujuan.equalsIgnoreCase("BCA") ? 0 : 7500;
        System.out.println("[BCA Klik] Transfer ke " + bankTujuan + " (" + rekeningTujuan + ") Rp" + jumlah + 
                           " | Biaya Admin: Rp" + biayaAdmin);
    }
}