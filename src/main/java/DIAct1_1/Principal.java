package DIAct1_1;
   
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Principal {
    
    // Array estatico 5 alumnos
    private static Alumno[] alumnos = new Alumno[5];
    private static int contador = 0;

    public static void main(String[] args) {
        // Crear ventana
        JFrame frame = new JFrame("Formulario de Alumnos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(8, 2, 5, 5));

        // Etiquetas y campos de texto
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();

        JLabel lblApellidos = new JLabel("Apellidos:");
        JTextField txtApellidos = new JTextField();

        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();

        JLabel lblEdad = new JLabel("Edad:");
        JTextField txtEdad = new JTextField();

        JLabel lblTelefono = new JLabel("Teléfono:");
        JTextField txtTelefono = new JTextField();

        // Etiqueta error
        JLabel lblError = new JLabel("Se ha alcanzado el límite de 5 alumnos");
        lblError.setForeground(Color.RED);
        lblError.setVisible(false);

        // Etiqueta alumno mas joven
        JLabel lblJoven = new JLabel("Alumno más joven: ");
        
        // Boton para añadir
        JButton btnAñadir = new JButton("Añadir");
        btnAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // validar edad
                int edad;
                try {
                    edad = Integer.parseInt(txtEdad.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Edad debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar limite alumnos
                if (contador >= 5) {
                    lblError.setVisible(true);
                    return;
                }

                // Nuevo alumno
                Alumno a = new Alumno(
                        txtNombre.getText(),
                        txtApellidos.getText(),
                        txtEmail.getText(),
                        edad,
                        txtTelefono.getText()
                );

                alumnos[contador] = a;
                contador++;

                lblError.setVisible(false);

                // Limpiar campos
                txtNombre.setText("");
                txtApellidos.setText("");
                txtEmail.setText("");
                txtEdad.setText("");
                txtTelefono.setText("");

                // Actualizacion en vivo alumno joven
                Alumno joven = alumnos[0];
                for (int i = 1; i < contador; i++) {
                    if (alumnos[i].getEdad() < joven.getEdad()) {
                        joven = alumnos[i];
                    }
                }
                lblJoven.setText("Alumno más joven: " + joven.getNombre() + " " + joven.getApellidos());
            }
        });

        // Añadir componentes a ventana
        frame.add(lblNombre);
        frame.add(txtNombre);
        frame.add(lblApellidos);
        frame.add(txtApellidos);
        frame.add(lblEmail);
        frame.add(txtEmail);
        frame.add(lblEdad);
        frame.add(txtEdad);
        frame.add(lblTelefono);
        frame.add(txtTelefono);
        frame.add(btnAñadir);
        frame.add(new JLabel()); 
        frame.add(lblError);
        frame.add(lblJoven);

        // Mostrar ventana
        frame.setVisible(true);
    }
    
}
