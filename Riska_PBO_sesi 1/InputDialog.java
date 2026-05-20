import javax.swing.JOptionPane;

public class InputDialog {
    public static void main(String[] args) {
        // Meminta input dari user
        String pelajaran = JOptionPane.showInputDialog("Anda sedang belajar apa?");
        
        // Menampilkan hasil input dalam pesan
        if (pelajaran != null) {
            JOptionPane.showMessageDialog(null, "Belajar " + pelajaran + " sangat mudah");
        }
    }
}