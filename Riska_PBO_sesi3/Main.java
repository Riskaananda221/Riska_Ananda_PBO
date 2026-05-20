import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Menggunakan try-with-resources agar Scanner otomatis ditutup (tanpa warning)
        try (Scanner input = new Scanner(System.in)) {
            ArrayList<hitungNilai> listMhs = new ArrayList<>();
            
            System.out.print("Masukkan jumlah mahasiswa: ");
            int jumlah = input.nextInt();
            input.nextLine(); // Membersihkan buffer enter

            for (int i = 0; i < jumlah; i++) {
                System.out.println("\nInput data ke-" + (i + 1));
                System.out.print("NIM   : "); String nim = input.nextLine();
                System.out.print("Nama  : "); String nama = input.nextLine();
                System.out.print("Nilai : "); int nilai = input.nextInt();
                input.nextLine(); // Membersihkan buffer enter

                listMhs.add(new hitungNilai(nim, nama, nilai));
            }

            System.out.println("\n--- HASIL OUTPUT ---");
            
            int totalNilai = 0;
            int jmlLulus = 0, jmlTidakLulus = 0;
            int jmlA = 0, jmlB = 0, jmlC = 0, jmlD = 0, jmlE = 0;
            
            String namaLulus = "", namaTidakLulus = "";
            String namaA = "", namaB = "", namaC = "", namaD = "", namaE = "";
            String deretNilai = "";

            for (int i = 0; i < listMhs.size(); i++) {
                hitungNilai m = listMhs.get(i);
                m.cetakData(); // Memanggil method tampil data
                
                totalNilai += m.nilai;
                deretNilai += m.nilai + (i == listMhs.size() - 1 ? "" : "+");

                // Logika Kelulusan
                if (m.getStatus().equals("Lulus")) {
                    jmlLulus++;
                    namaLulus += m.getNama() + ", ";
                } else {
                    jmlTidakLulus++;
                    namaTidakLulus += m.getNama() + ", ";
                }

                // Menggunakan Switch Rule agar warning 'jmlE' & 'namaE' hilang
                switch (m.getGrade()) {
                    case "A" -> { jmlA++; namaA += m.getNama() + ", "; }
                    case "B" -> { jmlB++; namaB += m.getNama() + ", "; }
                    case "C" -> { jmlC++; namaC += m.getNama() + ", "; }
                    case "D" -> { jmlD++; namaD += m.getNama() + ", "; }
                    case "E" -> { jmlE++; namaE += m.getNama() + ", "; }
                    default -> System.out.println("Input nilai salah");
                }
            }

            // Bagian Rekapitulasi Akhir
            if (!listMhs.isEmpty()) {
                double rata = (double) totalNilai / listMhs.size();
                
                System.out.println("Jumlah Mahasiswa : " + listMhs.size());
                System.out.println("Jumlah Mahasiswa yg Lulus : " + jmlLulus + " yaitu " + bersihkanKoma(namaLulus));
                System.out.println("Jumlah Mahasiswa yg Tidak Lulus : " + jmlTidakLulus + " yaitu " + bersihkanKoma(namaTidakLulus));
                System.out.println("Jumlah Mahasiswa dengan Nilai A = " + jmlA + " yaitu " + bersihkanKoma(namaA));
                System.out.println("Jumlah Mahasiswa dengan Nilai B = " + jmlB + " yaitu " + bersihkanKoma(namaB));
                System.out.println("Jumlah Mahasiswa dengan Nilai C = " + jmlC + " yaitu " + bersihkanKoma(namaC));
                System.out.println("Jumlah Mahasiswa dengan Nilai D = " + jmlD + " yaitu " + bersihkanKoma(namaD));
                System.out.println("Jumlah Mahasiswa dengan Nilai E = " + jmlE + " yaitu " + bersihkanKoma(namaE));
                System.out.println("Rata-rata nilai mahasiswa adalah : " + deretNilai + " / " + listMhs.size() + " = " + rata);
            }
        }
    }

    // Fungsi pembantu untuk merapikan koma di akhir daftar nama
    private static String bersihkanKoma(String teks) {
        if (teks != null && teks.endsWith(", ")) {
            return teks.substring(0, teks.length() - 2);
        }
        return (teks == null || teks.isEmpty()) ? "-" : teks;
    }
}