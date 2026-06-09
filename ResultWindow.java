import javax.swing.*;

public class ResultWindow extends JFrame {
    public ResultWindow(String nama, String tgl, String noPend, String telp, String alamat, String email) {
        setTitle("Data Mahasiswa Berhasil Disimpan");
        setSize(350, 300);
        setLocationRelativeTo(null);
        
        JTextArea areaHasil = new JTextArea();
        areaHasil.setEditable(false);
        areaHasil.setText("=== DATA MAHASISWA ===\n\n" +
                          "Nama        : " + nama + "\n" +
                          "Tgl Lahir   : " + tgl + "\n" +
                          "No. Pendaftaran : " + noPend + "\n" +
                          "No. Telp    : " + telp + "\n" +
                          "Alamat      : " + alamat + "\n" +
                          "E-mail      : " + email);
        
        add(new JScrollPane(areaHasil));
        setVisible(true);
    }
}