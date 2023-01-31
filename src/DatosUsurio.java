import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DatosUsurio {
    private JTextField ingresarID;
    private JTextField ingresarNombre;
    private JTextField ingresarCorreo;
    private JTextField ingresarCelular;
    private JButton guardarButton;
    private JPanel resgistro;
    private JButton cancelarButton;

    PreparedStatement ps;


    public DatosUsurio() {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con;
                try {
                    con = getConection();
                    ps= con.prepareStatement("INSERT INTO usuario (`Id`, `Nombre`, `Celular`, `Correo`) VALUES(?,?,?,?)");
                    ps.setString(1, ingresarID.getText());
                    ps.setString(2, ingresarNombre.getText());
                    ps.setString(3, ingresarCelular.getText());
                    ps.setString(4, ingresarCorreo.getText());

                    System.out.println(ps);//imprimo en consola para verificación

                    int res = ps.executeUpdate();

                    if (res > 0) {
                        JOptionPane.showMessageDialog(null, "Persona Guardada");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Guardar persona");
                    }
                    //limpiartxt();
                    //txtId.setText("");
                    //txtNombre.setText("");
                    //txtCelular.setText("");
                    //txtCorreo.setText("");
                    con.close();//importante!!!!
                }catch (HeadlessException | SQLException f){
                    System.err.println(f);
                }

            }
        });
    }

    public static void main(String[] arg) {
        JFrame frame1 = new JFrame("Registro");
        DatosUsurio f1 = new DatosUsurio();

        frame1.setContentPane(f1.resgistro);
        frame1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame1.pack();
        frame1.setSize(300, 300);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }

    /// conxion con sql
    public static Connection getConection() {
        Connection con = null;
        String base = "base2"; //Nombre de la base de datos
        String url = "jdbc:mysql://localhost:3306/" + base; //Direccion, puerto y nombre de la Base de Datos
        String user = "root"; //Usuario de Acceso a MySQL
        String password = "root1"; //Password del usuario

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
        return con;
    }
}

