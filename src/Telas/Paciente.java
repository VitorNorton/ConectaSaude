package Telas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paciente {

    private JTextField txtnome, txtidade, txtcpf, txtendereco, txttelefone, txtemail;
    private JLabel lbltitulo, lblnome, lblgenero, lblidade, lblendereco, lbltelefone, lblemail, lblcpf, lblconvenio;
    private JComboBox<String> cbgenero, cbConvenio;
    private JButton btnNovo, btnexcluir, btnsalvar, btnalterar,btnconsultar, btnInicio, btnPaciente, btnAgendar, btnSair, btnMedico, btnconvenio, btnExames;
   
    private JFrame tela;
    
    private void CarregarConvenios() {
        cbConvenio.removeAllItems();
        cbConvenio.addItem("Selecione o Convênio");
        cbConvenio.addItem("Particular"); 
        
        var linhas = GerenciadorArquivos.LerArquivo("convenios.txt");
        for (String linha : linhas) {
            String[] dados = linha.split(";");
            if (dados.length > 1) {
                cbConvenio.addItem(dados[1]); 
            }
        }
    }

    public void Habilitar() {
        txtnome.setEnabled(true);
        txtcpf.setEnabled(true);
        txtendereco.setEnabled(true);
        txttelefone.setEnabled(true);
        txtemail.setEnabled(true);
        txtidade.setEnabled(true);
        cbgenero.setEnabled(true);
        cbConvenio.setEnabled(true); 
        CarregarConvenios();
    }

    private boolean ValidarCamposInterno() {
        if (txtnome.getText().isEmpty() || 
            txtcpf.getText().isEmpty() || 
            txttelefone.getText().isEmpty() || 
            txtemail.getText().isEmpty() || 
            txtendereco.getText().isEmpty() || 
            cbgenero.getSelectedIndex() == 0 ||
            cbConvenio.getSelectedIndex() == 0) {

            JOptionPane.showMessageDialog(tela, "Preencha todos os campos!");
            return false;
        }
        return true;
    }

   
    public void LimparCampos() {
        txtnome.setText("");
        txtendereco.setText("");
        txtidade.setText("");
        txtcpf.setText("");
        txttelefone.setText("");
        txtemail.setText("");
        cbgenero.setSelectedIndex(0);
        if(cbConvenio.getItemCount() > 0) cbConvenio.setSelectedIndex(0);

    }

    public void inicio() {
        txtnome.setEnabled(false);
        cbgenero.setEnabled(false);
        cbConvenio.setEnabled(false);
        txtidade.setEnabled(false);
        txtcpf.setEnabled(false);
        txtendereco.setEnabled(false);
        txttelefone.setEnabled(false);
        txtemail.setEnabled(false);

        btnsalvar.setEnabled(false);
        btnexcluir.setEnabled(false);
        btnNovo.setEnabled(true);
        btnalterar.setEnabled(false);
        btnconsultar.setEnabled(true);

        LimparCampos();
    }

    // CONSTRUTOR 

    public Paciente() {
        tela = new JFrame("Cadastro de Pacientes");
        tela.setSize(850, 750);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setResizable(true);
        tela.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;

        int linha = 0;

        // TÍTULO
        gbc.gridwidth = 5;
        gbc.gridx = 0;
        lbltitulo = new JLabel("Cadastro de Pacientes");
        lbltitulo.setFont(new Font("Arial", Font.BOLD, 30));
        tela.add(lbltitulo, gbc);
        linha++;

        // NOME
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = linha;
        lblnome = new JLabel("Nome:");
        tela.add(lblnome, gbc);

        txtnome = new JTextField(25);
        gbc.gridx = 1;
        tela.add(txtnome, gbc);
        linha++;

        // CPF
        gbc.gridx = 0;
        gbc.gridy = linha;
        lblcpf = new JLabel("CPF:");
        tela.add(lblcpf, gbc);

        txtcpf = new JTextField(15);
        gbc.gridx = 1;
        tela.add(txtcpf, gbc);
        linha++;

        // IDADE
        gbc.gridx = 0;
        gbc.gridy = linha;
        lblidade = new JLabel("Idade:");
        tela.add(lblidade, gbc);

        txtidade = new JTextField(5);
        gbc.gridx = 1;
        tela.add(txtidade, gbc);
        linha++;

        // GÊNERO
        gbc.gridx = 0;
        gbc.gridy = linha;
        lblgenero = new JLabel("Gênero:");
        tela.add(lblgenero, gbc);

        cbgenero = new JComboBox<>(new String[]{"Selecione", "Masculino", "Feminino", "Outros"});
        gbc.gridx = 1;
        tela.add(cbgenero, gbc);
        linha++;
        
        // CONVENIO
        gbc.gridx = 0;
        gbc.gridy = linha;
        lblconvenio = new JLabel("Convênio:");
        tela.add(lblconvenio, gbc);

        cbConvenio = new JComboBox<>();
        gbc.gridx = 1;
        tela.add(cbConvenio, gbc);
        linha++;

        // TELEFONE
        gbc.gridx = 0;
        gbc.gridy = linha;
        lbltelefone = new JLabel("Telefone:");
        tela.add(lbltelefone, gbc);

        txttelefone = new JTextField(11);
        gbc.gridx = 1;
        tela.add(txttelefone, gbc);
        linha++;

        // EMAIL
        gbc.gridx = 0;
        gbc.gridy = linha;
        lblemail = new JLabel("E-mail:");
        tela.add(lblemail, gbc);

        txtemail = new JTextField(20);
        gbc.gridx = 1;
        tela.add(txtemail, gbc);
        linha++;

        // ENDEREÇO
        gbc.gridx = 0;
        gbc.gridy = linha;
        lblendereco = new JLabel("Endereço:");
        tela.add(lblendereco, gbc);

        txtendereco = new JTextField(20);
        gbc.gridx = 1;
        tela.add(txtendereco, gbc);
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

        // BARRA INFERIOR
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));

        btnInicio = new JButton("Tela Inicial");
        btnInicio.setBackground(new Color(49, 153, 151));
        btnInicio.setForeground(Color.WHITE);
        painelBotoes.add(btnInicio);

        btnMedico = new JButton("Médico");
        btnMedico.setBackground(new Color(49, 153, 151));
        btnMedico.setForeground(Color.WHITE);
        painelBotoes.add(btnMedico);

        btnPaciente = new JButton("Paciente");
        btnPaciente.setBackground(new Color(49, 153, 151));
        btnPaciente.setForeground(Color.WHITE);
        btnPaciente.setEnabled(false);
        painelBotoes.add(btnPaciente);

        btnAgendar = new JButton("Agendamento");
        btnAgendar.setBackground(new Color(49, 153, 151));
        btnAgendar.setForeground(Color.WHITE);
        painelBotoes.add(btnAgendar);

         btnconvenio = new JButton("Convênio");
        btnconvenio.setBackground(new Color(49, 153, 151));
        btnconvenio.setForeground(Color.WHITE);
        painelBotoes.add(btnconvenio);

        btnExames = new JButton("Exames");
        btnExames.setBackground(new Color(49, 153, 151));
        btnExames.setForeground(Color.WHITE);
        painelBotoes.add(btnExames);

        btnSair = new JButton("Sair");
        btnSair.setBackground(new Color(49, 153, 151));
        btnSair.setForeground(Color.WHITE);
        painelBotoes.add(btnSair);

        linha++;
        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.gridwidth = 5;
        tela.add(painelBotoes, gbc);

         // Estado inicial
        inicio();
       

        // AÇÕES 

        btnNovo.addActionListener(e -> {
            Habilitar();
            btnNovo.setEnabled(false);
            btnexcluir.setEnabled(false);
            btnsalvar.setEnabled(true);
            btnconsultar.setEnabled(true);
            btnalterar.setEnabled(false);
            LimparCampos();
        });

        btnsalvar.addActionListener(e -> {
            if (!ValidarCamposInterno()) {
                return;
            }

            // DUPLICIDADE CPF 
            String busca = GerenciadorArquivos.Buscar("pacientes.txt", txtcpf.getText(), 0);
            if (busca != null) {
                JOptionPane.showMessageDialog(tela, "Já existe um paciente com este CPF!");
                return;
            }

            String linhaDados = txtcpf.getText() + ";" +
                                txtnome.getText() + ";" +
                                txtidade.getText() + ";" +
                                cbgenero.getSelectedItem() + ";" +
                                txttelefone.getText() + ";" +
                                txtemail.getText() + ";" +
                                txtendereco.getText();
                                cbConvenio.getSelectedItem();                                           

            GerenciadorArquivos.Salvar("pacientes.txt", linhaDados);

            JOptionPane.showMessageDialog(tela, "Paciente salvo com sucesso!");
            inicio();
        });

        btnexcluir.addActionListener(e -> {
            String cpf = txtcpf.getText();
            String nome = txtnome.getText();
            
            if (cpf.isEmpty()) {
                JOptionPane.showMessageDialog(tela, "Consulte um paciente primeiro para excluir.");
                return;
            }
            
            int confirmacao = JOptionPane.showConfirmDialog(tela, 
                "Tem certeza que deseja excluir o paciente " + nome + " (CPF: " + cpf + ")?");
            
            if (confirmacao == JOptionPane.YES_OPTION) {
                boolean sucesso = GerenciadorArquivos.Excluir("pacientes.txt", cpf, 0);
                if (sucesso) {
                    JOptionPane.showMessageDialog(tela, "Paciente excluído com sucesso");
                    inicio();
                } else {
                    JOptionPane.showMessageDialog(tela, "Erro ao excluir.");
                }
            }
        });


        btnalterar.addActionListener(e -> {
            if (!ValidarCamposInterno()) {
                return;
            }
            
            GerenciadorArquivos.Excluir("pacientes.txt", txtcpf.getText(), 0);

            String linhaDados = txtcpf.getText() + ";" +
                                txtnome.getText() + ";" +
                                txtidade.getText() + ";" +
                                cbgenero.getSelectedItem() + ";" +
                                txttelefone.getText() + ";" +
                                txtemail.getText() + ";" +
                                txtendereco.getText() + ";" +
                                cbConvenio.getSelectedItem();

            GerenciadorArquivos.Salvar("pacientes.txt", linhaDados);
            
            JOptionPane.showMessageDialog(tela, "Registro alterado com sucesso!");
            inicio();
        });


          btnconsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] opcoes = { "CPF", "Nome", "Listar Todos" };
                int escolha = JOptionPane.showOptionDialog(tela, "Consultar:", "Busca",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                
                if (escolha == 2) { 
                    JDialog janela = new JDialog(tela, "Pacientes", true);
                    janela.setSize(1000, 400);
                    
                    String[] colunas = {"CPF", "Nome", "Idade", "Gênero", "Telefone", "Email", "Endereço", "Convênio"};
                    javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(colunas, 0);
                    var linhas = GerenciadorArquivos.LerArquivo("pacientes.txt");
                    for (String l : linhas) modelo.addRow(l.split(";"));
                    
                    JTable tabela = new JTable(modelo);
                    GerenciadorArquivos.AjustarLarguraColunas(tabela);
                    janela.add(new JScrollPane(tabela));
                    janela.setLocationRelativeTo(tela);
                    janela.setVisible(true);
                    return;
                }
                
                String termo = (escolha == 0) ? JOptionPane.showInputDialog("CPF:") : JOptionPane.showInputDialog("Nome:");
                int indice = (escolha == 0) ? 0 : 1;
                
                if (termo != null && !termo.isEmpty()) {
                    String linha = GerenciadorArquivos.Buscar("pacientes.txt", termo, indice);
                    if (linha != null) {
                        String[] dados = linha.split(";");
                        Habilitar();
                        txtcpf.setText(dados[0]);
                        txtcpf.setEnabled(false);
                        txtnome.setText(dados[1]);
                        txtidade.setText(dados[2]);
                        cbgenero.setSelectedItem(dados[3]);
                        txttelefone.setText(dados[4]);
                        txtemail.setText(dados[5]);
                        txtendereco.setText(dados[6]);
                        
                        if(dados.length > 7) cbConvenio.setSelectedItem(dados[7]);
                        
                        btnNovo.setEnabled(false);
                        btnsalvar.setEnabled(false);
                        btnalterar.setEnabled(true);
                        btnexcluir.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(tela, "Não encontrado!");
                    }
                }
            }
        });
        btnAgendar.addActionListener(e -> {
            tela.dispose();
            new Agendamento();
        });

        btnPaciente.addActionListener(e -> {
            tela.dispose();
            new Paciente();
        });

        btnMedico.addActionListener(e -> {
            tela.dispose();
            new Medico();
        });

        btnInicio.addActionListener(e -> {
            tela.dispose();
            new TelaInicial();
        });

        btnconvenio.addActionListener(e -> {
            tela.dispose();
            new Convenio();
        });

        btnExames.addActionListener(e ->{
            tela.dispose();
            new Exames();
        });

        btnSair.addActionListener(e -> {
            tela.dispose();
            new Login();
        });
        
        if (Posicao.localizacao != null) {
            tela.setLocation(Posicao.localizacao);
        } else {
            tela.setLocationRelativeTo(null); 
        }

        tela.setVisible(true);
    }
}
