public class hitungNilai extends Mahasiswa {
    private String grade;
    private String status;

    public hitungNilai(String nim, String nama, int nilai) {
        super(nim, nama, nilai);
        prosesGrade();
    }

    private void prosesGrade() {
        if (nilai >= 80 && nilai <= 100) {
            grade = "A";
            status = "Lulus";
        } else if (nilai >= 70) {
            grade = "B";
            status = "Lulus";
        } else if (nilai >= 60) {
            grade = "C";
            status = "Lulus";
        } else if (nilai >= 50) {
            grade = "D";
            status = "Tidak Lulus";
        } else if (nilai >= 0 && nilai < 50) {
            grade = "E";
            status = "Tidak Lulus";
        } else {
            grade = "Salah";
            status = "Input nilai anda salah";
        }
    }

    public String getGrade() { return grade; }
    public String getStatus() { return status; }
    public String getNama() { return nama; }

    public void cetakData() {
        System.out.println("NIM   : " + nim);
        System.out.println("Nama  : " + nama);
        System.out.println("Nilai : " + nilai);
        System.out.println("Grade : " + grade);
        System.out.println("------------------------------------------");
    }
}   