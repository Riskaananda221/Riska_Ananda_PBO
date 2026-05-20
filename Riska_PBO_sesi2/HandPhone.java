public class HandPhone {
    String jenis_hp;
    int tahun_pembuatan;

    // Perbaikan: Urutan keyword harus 'public void' atau 'public String'
    // Menggunakan 'this' untuk membedakan variabel class dan parameter
    public void setDataHP(String jenis_hp, int tahun_pembuatan) {
        this.jenis_hp = jenis_hp;
        this.tahun_pembuatan = tahun_pembuatan;
    }

    public String getJenisHP() {
        return jenis_hp;
    }

    // Perbaikan: Method ini harus return int karena tahun_pembuatan adalah int
    public int getTahunPembuatan() {
        return tahun_pembuatan;
    }

    public static void main(String[] args) {
        HandPhone hp = new HandPhone();
        
        // Mengisi data
        hp.setDataHP("Samsung S24", 2024);
        
        // Perbaikan: Method getter harus dicetak agar hasilnya terlihat di console
        System.out.println("Jenis HP: " + hp.getJenisHP());
        System.out.println("Tahun Pembuatan: " + hp.getTahunPembuatan());
    }
}