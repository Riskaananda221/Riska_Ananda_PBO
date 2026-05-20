import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Simulasi Input untuk Mahasiswa
        System.out.println("--- Input Data Mahasiswa ---");
        System.out.print("Nama Mahasiswa: ");
        String sName = input.nextLine();
        System.out.print("Alamat Mahasiswa: ");
        String sAddress = input.nextLine();
        Student s1 = new Student(sName, sAddress);

        s1.addCourseGrade("Pemrograman Berorientasi Objek", 90);
        s1.addCourseGrade("Basis Data", 85);
        
        System.out.println(s1.toString());
        s1.printGrades();
        System.out.println("Rata-rata: " + s1.getAverageGrade());

        // --- BAGIAN DOSEN YANG SUDAH DIUBAH ---
        System.out.println("\n--- Input Data Dosen ---");
        System.out.print("Nama Dosen: ");
        String tName = input.nextLine();
        
        Teacher t1 = new Teacher(tName,""); 

        System.out.print("Tambah Mata Kuliah: ");
        String course = input.nextLine();
        if (t1.addCourse(course)) {
            System.out.println("Mata kuliah " + course + " berhasil ditambahkan.");
        } else {
            System.out.println("Mata kuliah sudah ada.");
        }

        System.out.println(t1.toString());
        
        input.close();
    }
}