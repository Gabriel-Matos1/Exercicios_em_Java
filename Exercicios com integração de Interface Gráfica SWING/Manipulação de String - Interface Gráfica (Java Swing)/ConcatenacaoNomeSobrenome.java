
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConcatenacaoNomeSobrenome extends JFrame {

    private JTextField nomeField;
    private JTextField sobrenomeField;
    private JLabel resultadoLabel;

    public ConcatenacaoNomeSobrenome() {
        // Configurações básicas da janela
        setTitle("Concatenação de Nome e Sobrenome");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        // Campos de entrada para nome e sobrenome
        nomeField = new JTextField();
        sobrenomeField = new JTextField();

        // Rótulos para nome e sobrenome
        JLabel nomeLabel = new JLabel("Nome:");
        JLabel sobrenomeLabel = new JLabel("Sobrenome:");

        // Adiciona KeyListeners para capturar eventos de teclado
        nomeField.addKeyListener(new CampoKeyListener());
        sobrenomeField.addKeyListener(new CampoKeyListener());

        // Rótulo para exibir o resultado
        resultadoLabel = new JLabel();

        // Adiciona componentes à janela
        add(nomeLabel);
        add(nomeField);
        add(sobrenomeLabel);
        add(sobrenomeField);
        add(resultadoLabel);

        // Torna a janela visível
        setVisible(true);
    }

    
    // KeyAdapter para capturar eventos de teclado
    private class CampoKeyListener extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            // Atualiza o rótulo com a concatenação do nome e sobrenome
            String nome = nomeField.getText();
            String sobrenome = sobrenomeField.getText();
            resultadoLabel.setText("Nome Completo: " + nome + " " + sobrenome);
        }
    }
           public static double Galao(double litros){
                double galao = 3.785/litros;
                return galao;
            }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConcatenacaoNomeSobrenome());
    }
}
