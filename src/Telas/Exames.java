package Telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.List;

public class Exames {

    private JTextField txtNomeProcedimento;
    private JComboBox<String> cbTipo; 
    private JButton btnNovo, btnsalvar, btnexcluir, btninicio, btnmedico, btnpaciente, btnagendar, btnsair, btnconsultar, btnalterar, btnexames, btnconvenio;
    private JLabel lblNome, lblTipo, lblTitulo;
    private JFrame tela;

    public void Habilitar() {
        txtNomeProcedimento.setEnabled(true);
        cbTipo.setEnabled(true);
    }

    public void LimparCampos() {
        txtNomeProcedimento.setText("");
        cbTipo.setSelectedIndex(0);
    }

    public void inicio() {
        txtNomeProcedimento.setEnabled(false);
        cbTipo.setEnabled(false);

        btnsalvar.setEnabled(false);
        btnexcluir.setEnabled(false);
        btnNovo.setEnabled(true);
        btnconsultar.setEnabled(true);
        btnalterar.setEnabled(false);
        LimparCampos();
    }

    private boolean ValidarCampos() {
        if (txtNomeProcedimento.getText().isEmpty() || cbTipo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(tela, "Preencha o nome e selecione o tipo!");
            return false;
        }
        return true;
    }

    public Exames() {
        tela = new JFrame("Cadastro de Procedimentos");
        tela.setSize(850, 600);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setResizable(false);
        tela.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;

        int linha = 0;

        gbc.gridwidth = 5;
        gbc.gridx = 0;
        gbc.gridy = linha;
        lblTitulo = new JLabel("Cadastro de Consultas e Exames");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 30));
        tela.add(lblTitulo, gbc);
        linha++;

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = linha;
        lblNome = new JLabel("Nome do Procedimento:");
        tela.add(lblNome, gbc);

        txtNomeProcedimento = new JTextField(25);
        gbc.gridx = 1;
        gbc.gridwidth = 2; 
        tela.add(txtNomeProcedimento, gbc);
        
        gbc.gridwidth = 1; 
        linha++;

        gbc.gridx = 0;
        gbc.gridy = linha;
        lblTipo = new JLabel("Tipo:");
        tela.add(lblTipo, gbc);

        cbTipo = new JComboBox<>(new String[]{"Selecione", "Consulta", "Exame", "Cirurgia"});
        gbc.gridx = 1;
        tela.add(cbTipo, gbc);
        linha++;

        JPanel painelAcoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));

        btnNovo = new JButton("Novo");
        btnNovo.setBackground(Color.BLACK);
        btnNovo.setForeground(Color.WHITE);
        painelAcoes.add(btnNovo);

        btnsalvar = new JButton("Salvar");
        btnsalvar.setBackground(Color.BLACK);
        btnsalvar.setForeground(Color.WHITE);
        painelAcoes.add(btnsalvar);

        btnexcluir = new JButton("Excluir");
        btnexcluir.setBackground(Color.BLACK);
        btnexcluir.setForeground(Color.WHITE);
        painelAcoes.add(btnexcluir);

        btnalterar = new JButton("Alterar");
        btnalterar.setBackground(Color.BLACK);
        btnalterar.setForeground(Color.WHITE);
        painelAcoes.add(btnalterar);

        btnconsultar = new JButton("Consultar");
        btnconsultar.setBackground(Color.BLACK);
        btnconsultar.setForeground(Color.WHITE);
        painelAcoes.add(btnconsultar);

        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.gridwidth = 5;
        tela.add(painelAcoes, gbc);
        linha++;

        inicio();

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        btninicio = new JButton("Tela Inicial");
        btninicio.setBackground(new Color(49, 153, 151));
        btninicio.setForeground(Color.WHITE);
        painelBotoes.add(btninicio);

        btnmedico = new JButton("Médico");
        btnmedico.setBackground(new Color(49, 153, 151));
        btnmedico.setForeground(Color.WHITE);
        painelBotoes.add(btnmedico);

        btnpaciente = new JButton("Paciente");
        btnpaciente.setBackground(new Color(49, 153, 151));
        btnpaciente.setForeground(Color.WHITE);
        painelBotoes.add(btnpaciente);

        btnagendar = new JButton("Agendamento");
        btnagendar.setBackground(new Color(49, 153, 151));
        btnagendar.setForeground(Color.WHITE);
        painelBotoes.add(btnagendar);

        btnconvenio = new JButton("Convênio");
        btnconvenio.setBackground(new Color(49, 153, 151));
        btnconvenio.setForeground(Color.WHITE);
        painelBotoes.add(btnconvenio);

        btnexames = new JButton("Exames"); 
        btnexames.setBackground(new Color(49, 153, 151));
        btnexames.setForeground(Color.BLACK);
        btnexames.setEnabled(false);
        painelBotoes.add(btnexames);

        btnsair = new JButton("Sair");
        btnsair.setBackground(new Color(49, 153, 151));
        btnsair.setForeground(Color.WHITE);
        painelBotoes.add(btnsair);

        linha++;
        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.gridwidth = 5;
        tela.add(painelBotoes, gbc);


        btnNovo.addActionListener(e -> {
            Habilitar();
            btnNovo.setEnabled(false);
            btnsalvar.setEnabled(true);
            btnconsultar.setEnabled(true);
            LimparCampos();
        });

        btnsalvar.addActionListener((ActionEvent e) -> {
            if (!ValidarCampos()) return;
            if (GerenciadorArquivos.Buscar("lista_exames.txt", txtNomeProcedimento.getText(), 0) != null) {
                JOptionPane.showMessageDialog(tela, "Procedimento já cadastrado!");
                return;
            }
            String linha1 = txtNomeProcedimento.getText() + ";" + cbTipo.getSelectedItem();
            GerenciadorArquivos.Salvar("lista_exames.txt", linha1);
            JOptionPane.showMessageDialog(tela, "Procedimento salvo!");
            inicio();
        });

        btnexcluir.addActionListener(e -> {
            String nome = txtNomeProcedimento.getText();
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(tela, "Consulte primeiro.");
                return;
            }
            if(JOptionPane.showConfirmDialog(tela, "Excluir " + nome + "?") == JOptionPane.YES_OPTION){
                GerenciadorArquivos.Excluir("lista_exames.txt", nome, 0);
                JOptionPane.showMessageDialog(tela, "Excluído!");
                inicio();
            }
        });

        btnalterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!ValidarCampos()) return;
                GerenciadorArquivos.Excluir("lista_exames.txt", txtNomeProcedimento.getText(), 0);
                String linha = txtNomeProcedimento.getText() + ";" + cbTipo.getSelectedItem();
                GerenciadorArquivos.Salvar("lista_exames.txt", linha);
                JOptionPane.showMessageDialog(tela, "Alterado!");
                inicio();
            }
        });

        btnconsultar.addActionListener(e -> {
            Object[] opcoes = { "Nome do Procedimento", "Listar Todos" };
            
            int escolha = JOptionPane.showOptionDialog(tela, "Buscar:", "Consultar",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

            if (escolha == 1) { 
                JDialog janela = new JDialog(tela, "Procedimentos", true);
                janela.setSize(500, 400);
                
                String[] colunas = {"Procedimento", "Tipo"};
                javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(colunas, 0);
                
                java.util.List<String> lista = GerenciadorArquivos.LerArquivo("lista_exames.txt");
                
                for (String l : lista) {
                    modelo.addRow(l.split(";"));
                }
                
                janela.add(new JScrollPane(new JTable(modelo)));
                janela.setLocationRelativeTo(tela);
                janela.setVisible(true);
                return;
                
            } else if (escolha == 0) {
                String termo = JOptionPane.showInputDialog("Nome:");
                
                if (termo != null && !termo.isEmpty()) {
                    String linhaEncontrada = GerenciadorArquivos.Buscar("lista_exames.txt", termo, 0);
                    
                    if (linhaEncontrada != null) {
                        String[] dados = linhaEncontrada.split(";");
                        Habilitar();
                        
                        txtNomeProcedimento.setText(dados[0]);
                        txtNomeProcedimento.setEnabled(false);
                        cbTipo.setSelectedItem(dados[1]);
                        
                        btnNovo.setEnabled(false);
                        btnsalvar.setEnabled(false);
                        btnalterar.setEnabled(true);
                        btnexcluir.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(tela, "Não encontrado.");
                    }
                }
            }
        });

        btnagendar.addActionListener(e -> { tela.dispose(); new Agendamento(); });
        btnpaciente.addActionListener(e -> { tela.dispose(); new Paciente(); });
        btnmedico.addActionListener(e -> { tela.dispose(); new Medico(); });
        btninicio.addActionListener(e -> { tela.dispose(); new TelaInicial(); });
        btnconvenio.addActionListener(e -> { tela.dispose(); new Convenio(); });
        btnexames.addActionListener(e -> { tela.dispose(); new Exames(); });
        btnsair.addActionListener(e -> { tela.dispose(); new Login(); });
        
        if (Posicao.localizacao != null) {
            tela.setLocation(Posicao.localizacao); 
        } else {
            tela.setLocationRelativeTo(null); 
        }

        tela.setVisible(true);
    }
}