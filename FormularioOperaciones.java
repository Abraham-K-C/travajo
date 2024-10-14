import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioOperaciones extends JFrame{
    private JComboBox comboBox1;
    private JButton button_operar;
    private JTextField text_n1;
    private JTextField text_n2;
    private JTextField text_resul;
    private JLabel Matematicas;
    private JPanel OPERACIONES;
    private JRadioButton primeroSegundoRadioButton;
    private JRadioButton segundoPrimeroRadioButton;
    private JCheckBox checkRedondear;

    public FormularioOperaciones() {
        setContentPane(OPERACIONES);
        setTitle("Formulario Operaciones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,250);
        setLocationRelativeTo(null);
        setVisible(true);


        comboBox1.addItem("SUMAR");
        comboBox1.addItem("RESTAR");
        comboBox1.addItem("MULTIPLICAR");
        comboBox1.addItem("DIVIDIR");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(primeroSegundoRadioButton);
        grupo.add(segundoPrimeroRadioButton);

        button_operar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double X, Y, R=0.0;
                String operacion;

                X = Double.parseDouble(text_n1.getText());
                Y = Double.parseDouble(text_n2.getText());

                operacion = comboBox1.getSelectedItem().toString();
                //JOptionPane.showMessageDialog(null, operacion);

                switch (operacion) {
                    case "SUMAR":
                        R=X+Y;
                        break;
                    case "RESTA":
                        if (primeroSegundoRadioButton.isSelected()) {
                            R=X-Y;
                        }else {
                            R=Y-X;
                        }
                        break;
                    case "MULTIPLICAR":
                        R=X*Y;
                        break;
                    case "DIVIDIR":
                        if (primeroSegundoRadioButton.isSelected()) {
                            R=X/Y;
                        }else {
                            R=Y/X;
                        }
                        break;
                }
                if (checkRedondear.isSelected()) {
                    String r=String.format("%.2f",R);
                    text_resul.setText(r);
                }else{
                    text_resul.setText(Double.toString(R));
                }
            }
        });
    }

    public static void main(String[] args) {
        new FormularioOperaciones();
    }
}
