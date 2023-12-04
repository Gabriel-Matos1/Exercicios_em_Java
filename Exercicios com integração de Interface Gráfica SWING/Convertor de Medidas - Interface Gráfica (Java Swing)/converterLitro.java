import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class converterLitro extends JFrame {

    private JTextField litrosField;
    private JLabel resultadoLabel;
    private JButton botaoConverter;

    public converterLitro() {
        setTitle("Conversor de Litros para Galões");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        litrosField = new JTextField();

        JLabel rotuloLitros = new JLabel("Litros:");

        botaoConverter = new JButton("Converter");

        resultadoLabel = new JLabel();

        botaoConverter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                converterLitrosParaGalao();
            }
        });

        add(rotuloLitros);
        add(litrosField);
        add(botaoConverter);
        add(resultadoLabel);

        setVisible(true);
    }

    private void converterLitrosParaGalao() {
        try {
            double litros = Double.parseDouble(litrosField.getText());
            double galoes = litros / 3.785;

            // Formatar o resultado para uma casa decimal
            DecimalFormat df = new DecimalFormat("#.#");
            String resultadoFormatado = df.format(galoes);

            resultadoLabel.setText("Resultado: " + resultadoFormatado + " galões");
        } catch (NumberFormatException ex) {
            resultadoLabel.setText("Erro: Insira um valor válido para litros.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new converterLitro());
    }
}
