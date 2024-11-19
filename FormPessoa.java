import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPessoa extends JFrame {
    private JTextField nomeField;
    private JComboBox<String> sexoComboBox;
    private JTextField idadeField;
    private JLabel numeroLabel;
    private JButton okButton, mostrarButton;
    private Pessoa umaPessoa;

    public FormPessoa() {
        setTitle("Cadastro de Pessoa");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Centraliza a janela

        // Layout da interface
        setLayout(new GridLayout(5, 2));

        numeroLabel = new JLabel("Número: ");
        numeroLabel.setText("Número: " + (Pessoa.getKp() + 1));

        // Nome
        JLabel nomeLabel = new JLabel("Nome: ");
        nomeField = new JTextField();

        // Sexo
        JLabel sexoLabel = new JLabel("Sexo: ");
        sexoComboBox = new JComboBox<>(new String[] {"M", "F"});

        // Idade
        JLabel idadeLabel = new JLabel("Idade: ");
        idadeField = new JTextField();

        // Botões
        okButton = new JButton("OK");
        mostrarButton = new JButton("Mostrar");

        // Adiciona os componentes ao JFrame
        add(numeroLabel);
        add(new JLabel());  // Empty space
        add(nomeLabel);
        add(nomeField);
        add(sexoLabel);
        add(sexoComboBox);
        add(idadeLabel);
        add(idadeField);
        add(okButton);
        add(mostrarButton);

        // Ação do botão "OK"
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Valida campos obrigatórios
                String nome = nomeField.getText().trim();
                String idadeText = idadeField.getText().trim();
                String sexo = (String) sexoComboBox.getSelectedItem();

                if (nome.isEmpty() || idadeText.isEmpty() || sexo == null) {
                    JOptionPane.showMessageDialog(FormPessoa.this, "Todos os campos são obrigatórios.");
                    return;
                }

                try {
                    int idade = Integer.parseInt(idadeText);
                    char sexoChar = sexo.charAt(0);
                    umaPessoa = new Pessoa(nome, sexoChar, idade);
                    numeroLabel.setText("Número: " + (Pessoa.getKp())); // Atualiza o número
                    JOptionPane.showMessageDialog(FormPessoa.this, "Pessoa cadastrada com sucesso!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(FormPessoa.this, "Idade deve ser um número válido.");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(FormPessoa.this, ex.getMessage());
                }
            }
        });

        // Ação do botão "Mostrar"
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (umaPessoa != null) {
                    JOptionPane.showMessageDialog(FormPessoa.this,
                        "Nome: " + umaPessoa.getNome() + "\n" +
                        "Sexo: " + umaPessoa.getSexo() + "\n" +
                        "Idade: " + umaPessoa.getIdade() + "\n" +
                        "Número de pessoas cadastradas: " + Pessoa.getKp());
                } else {
                    JOptionPane.showMessageDialog(FormPessoa.this, "Nenhuma pessoa cadastrada.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormPessoa().setVisible(true);
            }
        });
    }
}
