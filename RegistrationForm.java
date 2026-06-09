import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationForm extends JFrame {
    private JTextField txtNama, txtTglLahir, txtNoPend, txtNoTelp, txtAlamat, txtEmail;
    private JButton btnSubmit;

    public RegistrationForm() {
        setTitle("Form Daftar Ulang Mahasiswa Baru");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel Input
        JPanel panelInput = new JPanel(new GridLayout(6, 2, 10, 10));
        panelInput.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        txtNama = new JTextField();
        txtTglLahir = new JTextField();
        txtNoPend = new JTextField();
        txtNoTelp = new JTextField();
        txtAlamat = new JTextField();
        txtEmail = new JTextField();

        panelInput.add(new JLabel("Nama Lengkap:")); panelInput.add(txtNama);
        panelInput.add(new JLabel("Tanggal Lahir:")); panelInput.add(txtTglLahir);
        panelInput.add(new JLabel("No. Pendaftaran:")); panelInput.add(txtNoPend);
        panelInput.add(new JLabel("No. Telp:")); panelInput.add(txtNoTelp);
        panelInput.add(new JLabel("Alamat:")); panelInput.add(txtAlamat);
        panelInput.add(new JLabel("E-mail:")); panelInput.add(txtEmail);

        // Tombol Submit
        btnSubmit = new JButton("SUBMIT");
        btnSubmit.setBackground(new Color(70, 130, 180));
        btnSubmit.setForeground(Color.WHITE);
        
        btnSubmit.addActionListener(e -> prosesSubmit());

        add(new JLabel("REGISTRASI MAHASISWA BARU", SwingConstants.CENTER), BorderLayout.NORTH);
        add(panelInput, BorderLayout.CENTER);
        add(btnSubmit, BorderLayout.SOUTH);
    }

    private void prosesSubmit() {
        // Validasi kolom kosong
        if (txtNama.getText().isEmpty() || txtTglLahir.getText().isEmpty() || 
            txtNoPend.getText().isEmpty() || txtNoTelp.getText().isEmpty() || 
            txtAlamat.getText().isEmpty() || txtEmail.getText().isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Konfirmasi
        int choice = JOptionPane.showConfirmDialog(this, "Apakah anda yakin data yang Anda isi sudah benar?", 
                     "Konfirmasi Data", JOptionPane.OK_CANCEL_OPTION);

        if (choice == JOptionPane.OK_OPTION) {
            new ResultWindow(txtNama.getText(), txtTglLahir.getText(), txtNoPend.getText(), 
                             txtNoTelp.getText(), txtAlamat.getText(), txtEmail.getText());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrationForm().setVisible(true));
    }
}