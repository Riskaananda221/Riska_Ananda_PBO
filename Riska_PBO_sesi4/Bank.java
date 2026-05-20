public class Bank {
    
    // 1) Transfer ke rekening lain (Internal)
    public void transferUang(int jumlah, String rekeningTujuan) {
        System.out.println("Transfer internal sebesar Rp" + jumlah + " ke rekening " + rekeningTujuan + " BERHASIL.");
    }

    // 2) Transfer ke bank lain (Antar Bank)
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        System.out.println("Transfer ke Bank " + bankTujuan + " (" + rekeningTujuan + ") sebesar Rp" + jumlah + " BERHASIL.");
    }

    // 3) Transfer dengan berita
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        System.out.println("Transfer ke Bank " + bankTujuan + " (" + rekeningTujuan + ") sebesar Rp" + jumlah + 
                           " dengan berita: '" + berita + "' BERHASIL.");
    }

    // 4) Suku Bunga Standar
    public void sukuBunga() {
        System.out.println("Suku Bunga standar adalah 3%");
    }
}