import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class Estudiantes implements Serializable {
    private static final long serialVersionUID=1l;     //dato especial
    private JTextField codigoT;
    private JTextField cedulaT;
    private JTextField nombreT;
    private JTextField apellidoT;
    private JButton cargarButton;
    private JButton atras;
    private JButton guardarButton;
    private JButton siguiente;
    private JComboBox signo;
    private JComboBox anio;
    private JComboBox mes;
    private JComboBox dia;
    private JRadioButton siRadioButton;
    private JRadioButton noRadioButton;
    private JCheckBox rojoCheckBox;
    private JCheckBox verdeCheckBox;
    private JCheckBox ningunoCheckBox;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JLabel respuestaL;
    private JPanel panel;
    private ArrayList codigo = new ArrayList();
    private ArrayList cedula = new ArrayList();
    private ArrayList nombre = new ArrayList();
    private ArrayList apellido = new ArrayList();
    private ArrayList signon = new ArrayList();
    private ArrayList f_nacimiento = new ArrayList();
    private ArrayList c_fav = new ArrayList();
    private ArrayList casado = new ArrayList();
    private boolean est = false;
    private int i = 0;

    public Estudiantes() {
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codigo.add(codigoT.getText());
                cedula.add(cedulaT.getText());
                nombre.add(nombreT.getText());
                apellido.add(apellidoT.getText());
                signon.add(signo.getComponent(0));
                f_nacimiento.add(anio.getComponent(0));
                f_nacimiento.add(mes.getComponent(0));
                f_nacimiento.add(dia.getComponent(0));
                c_fav.add(rojoCheckBox.getText());
                c_fav.add(verdeCheckBox.getText());
                c_fav.add(ningunoCheckBox.getText());
                casado.add(noRadioButton.getComponent(0));
                casado.add(siRadioButton.getComponent(1));
                codigoT.setText("");
                cedulaT.setText("");
                nombreT.setText("");
                apellidoT.setText("");
                signo.addItem("");
                f_nacimiento.add("");
                c_fav.add("");
                casado.add("");
                respuestaL.setText("Se a guardado el estudiante correctamente");
            }
        });
        cargarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                est = true;
                if (codigo.size() == 0) {
                    respuestaL.setText("No existen datos");
                } else {
                    codigoT.setText((String) codigo.get(0));
                    cedulaT.setText((String) cedula.get(0));
                    nombreT.setText((String) nombre.get(0));
                    apellidoT.setText((String) apellido.get(0));
                    signon.get(0);
                    f_nacimiento.get(0);
                    c_fav.get(0);
                    casado.add(0);
                }

            }
        });
        siguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int aux = codigo.size();
                if (est) {
                    if (i < aux - 1) {
                        respuestaL.setText("");
                        i = i + 1;
                        codigoT.setText((String) codigo.get(i));
                        cedulaT.setText((String) cedula.get(i));
                        nombreT.setText((String) nombre.get(i));
                        apellidoT.setText((String) apellido.get(i));
                        signon.get(0);
                        f_nacimiento.get(0);
                        c_fav.get(0);
                        casado.add(0);
                    } else {
                        respuestaL.setText("No existen mas elementos");
                    }
                } else {
                    respuestaL.setText("Cargue los datos primero");
                }
            }
        });
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (est) {
                    if (i > 0) {
                        i = i - 1;
                        respuestaL.setText("");
                        codigoT.setText((String) codigo.get(i));
                        cedulaT.setText((String) cedula.get(i));
                        nombreT.setText((String) nombre.get(i));
                        apellidoT.setText((String) apellido.get(i));
                        signon.get(0);
                        f_nacimiento.get(0);
                        c_fav.get(0);
                        casado.add(0);
                    } else {
                        respuestaL.setText("No existen mas elementos");
                    }
                } else {
                    respuestaL.setText("Cargue los datos primero");
                }
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Estudiantes");
        frame.setContentPane(new Estudiantes().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
