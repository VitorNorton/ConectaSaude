package Telas;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Medico {

    private JTextField txtNome, txtCRM, txtCPF, txtTelefone, txtEmail, txtEndereco, txtDataNascimento;
    private JList<String> listEspecialidades; 
    private JTextArea txtObservacoes;
    private JButton btnNovo, btnexcluir, btnsalvar, btnAgendar, btnPaciente, btnSair, btnMedico, btnInicio, btnconsultar, btnalterar, btnconvenio, btnExames;
    private JComboBox<String> cbGenero, cbTurno;
  
    private JFrame tela;
    
    private void CarregarEspecialidades() {
        DefaultListModel<String> model = new DefaultListModel<>();
        var linhas = GerenciadorArquivos.LerArquivo("lista_exames.txt");
        
        for (String linha : linhas) {
            String[] dados = linha.split(";");
            if (dados.length > 0) {
                model.addElement(dados[0]); 
            }
        }
        listEspecialidades.setModel(model);
    }

    void TelaInicio() {
        txtNome.setEnabled(false);
        txtCRM.setEnabled(false);
        listEspecialidades.setEnabled(false);
        txtCPF.setEnabled(false);
        txtTelefone.setEnabled(false);
        txtEmail.setEnabled(false);
        txtEndereco.setEnabled(false);
        txtDataNascimento.setEnabled(false);
        txtObservacoes.setEnabled(false);
        cbGenero.setEnabled(false);
        cbTurno.setEnabled(false);

        btnNovo.setEnabled(true);
        btnexcluir.setEnabled(false);
        btnsalvar.setEnabled(false);
        btnconsultar.setEnabled(true);
        btnalterar.setEnabled(false);
        Limpar();
    }

    void Limpar() {
        txtNome.setText("");
        txtCRM.setText("");
        listEspecialidades.clearSelection();
        txtCPF.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        txtEndereco.setText("");
        txtDataNascimento.setText("");
        txtObservacoes.setText("");
        cbGenero.setSelectedIndex(0);
        cbTurno.setSelectedIndex(0);
    }

    void Habilitar() {
        txtNome.setEnabled(true);
        txtCRM.setEnabled(true);
        listEspecialidades.setEnabled(true);
        txtCPF.setEnabled(true);
        txtTelefone.setEnabled(true);
        txtEmail.setEnabled(true);
        txtEndereco.setEnabled(true);
        txtDataNascimento.setEnabled(true);
        txtObservacoes.setEnabled(true);
        cbGenero.setEnabled(true);
        cbTurno.setEnabled(true);
        
        CarregarEspecialidades();
        
    }


    private boolean ValidarCampos() {

        if (txtNome.getText().equals("") ||
            txtCRM.getText().equals("") ||
            listEspecialidades.getSelectedValuesList().isEmpty() ||
            txtCPF.getText().equals("") ||
            txtTelefone.getText().equals("") ||
            txtEmail.getText().equals("") ||
            txtEndereco.getText().equals("") ||
            txtDataNascimento.getText().equals("") ||
            txtObservacoes.getText().equals("") ||
            cbGenero.getSelectedIndex() == 0 ||
            cbTurno.getSelectedIndex() == 0) {

            JOptionPane.showMessageDialog(tela, "TODOS os campos são obrigatórios.");
            return false;
        }

        return true;
    }


    // CONSTRUTOR 

    public Medico() {

        tela = new JFrame("Cadastro de Medicos");
        tela.setSize(850, 750);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setResizable(false);
        tela.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;

        int linha = 0;

        // TÍTULO
        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.gridwidth = 5;
        JLabel titulo = new JLabel("Cadastro de Médico");
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        tela.add(titulo, gbc);
        linha++;

        // Nome
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = linha;
        tela.add(new JLabel("Nome:"), gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 1;
        txtNome = new JTextField(15);
        tela.add(txtNome, gbc);
        linha++;

        // CRM
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = linha;
        tela.add(new JLabel("CRM:"), gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 1;
        txtCRM = new JTextField(10);
        tela.add(txtCRM, gbc);
        linha++;

        // ESCIPIALIDADE
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = linha;
  
        tela.add(new JLabel("Especialidade(s):"), gbc);
        
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        
        listEspecialidades = new JList<>();
        listEspecialidades.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollSpec = new JScrollPane(listEspecialidades);
        scrollSpec.setPreferredSize(new Dimension(200, 60)); 
        
        tela.add(scrollSpec, gbc);
        
        gbc.gridx = 3; 
        JLabel aviso = new JLabel("(Segure Ctrl para selecionar vários)");
        aviso.setFont(new Font("Arial", Font.ITALIC, 10));
        tela.add(aviso, gbc);
        linha++;

        // CPF
        gbc.gridx = 0;
        gbc.gridy = linha;
        tela.add(new JLabel("CPF:"), gbc);

        gbc.gridx = 1;
        txtCPF = new JTextField(10);
        tela.add(txtCPF, gbc);
        linha++;

        // TELEFONE
        gbc.gridx = 0;
        gbc.gridy = linha;
        tela.add(new JLabel("Telefone:"), gbc);

        gbc.gridx = 1;
        txtTelefone = new JTextField(10);
        tela.add(txtTelefone, gbc);
        linha++;

        // Email
        gbc.gridx = 0;
        gbc.gridy = linha;
        tela.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        txtEmail = new JTextField(20);
        tela.add(txtEmail, gbc);
        linha++;

        // Endereço
        gbc.gridx = 0;
        gbc.gridy = linha;
        tela.add(new JLabel("Endereço:"), gbc);

        gbc.gridx = 1;
        txtEndereco = new JTextField(15);
        tela.add(txtEndereco, gbc);
        linha++;

        // Nascimento
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = linha;
        tela.add(new JLabel("Data de Nascimento:"), gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 1;
        txtDataNascimento = new JTextField(10);
        tela.add(txtDataNascimento, gbc);
        linha++;

        // GENERO
        gbc.gridx = 0;
        gbc.gridy = linha;
        tela.add(new JLabel("Gênero:"), gbc);

        gbc.gridx = 1;
        cbGenero = new JComboBox<>(new String[]{"Selecione", "Masculino", "Feminino", "Outros"});
        tela.add(cbGenero, gbc);
        linha++;

        // Observações
        gbc.gridx = 0;
        gbc.gridy = linha;
        tela.add(new JLabel("Observações:"), gbc);

        gbc.gridx = 1;
        txtObservacoes = new JTextArea(4, 30);
        JScrollPane scroll = new JScrollPane(txtObservacoes);
        tela.add(scroll, gbc);
        linha++;

        // Turno
        gbc.gridx = 0;
        gbc.gridy = linha;
        tela.add(new JLabel("Turno:"), gbc);

        gbc.gridx = 1;
        cbTurno = new JComboBox<>(new String[]{"Selecione", "Manhã", "Tarde", "Noite"});
        tela.add(cbTurno, gbc);
        linha++;

        // BOTÕES
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
        btnMedico.setEnabled(false);

        btnPaciente = new JButton("Paciente");
        btnPaciente.setBackground(new Color(49, 153, 151));
        btnPaciente.setForeground(Color.WHITE);
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
        tela.add(painelBotoes, gbc);

        TelaInicio();


        btnNovo.addActionListener(e -> {
            Habilitar();
            btnNovo.setEnabled(false);
            btnexcluir.setEnabled(false); 
            btnsalvar.setEnabled(true);
            btnconsultar.setEnabled(true);
            btnalterar.setEnabled(false); 
            Limpar();
        });

        btnsalvar.addActionListener((ActionEvent e) -> {
            if (!ValidarCampos()) return;
            
            String busca = GerenciadorArquivos.Buscar("medicos.txt", txtCRM.getText(), 0);
            if (busca != null) {
                JOptionPane.showMessageDialog(tela, "Já existe um médico com este CRM cadastrado!");
                return;
            }
            
            var listaSelecionada = listEspecialidades.getSelectedValuesList();
            String especialidadesString = String.join(", ", listaSelecionada);
            
            String linhaDados = txtCRM.getText() + ";" +
                    txtNome.getText() + ";" +
                    especialidadesString + ";" + // Salva a lista convertida em texto
                    txtCPF.getText() + ";" +
                    txtTelefone.getText() + ";" +
                    txtEmail.getText() + ";" +
                    txtEndereco.getText() + ";" +
                    txtDataNascimento.getText() + ";" +
                    cbGenero.getSelectedItem() + ";" +
                    cbTurno.getSelectedItem() + ";" +
                    txtObservacoes.getText().replace("\n", " ");
            
            GerenciadorArquivos.Salvar("medicos.txt", linhaDados);
            JOptionPane.showMessageDialog(tela, "Médico salvo com sucesso!");
            Limpar();
            TelaInicio();
        });

        btnexcluir.addActionListener(e -> {
            String crm = txtCRM.getText();
            
            if (crm.isEmpty()) {
                JOptionPane.showMessageDialog(tela, "Faça uma consulta primeiro para selecionar o médico.");
                return;
            }

            int confirmacao = JOptionPane.showConfirmDialog(tela, "Tem certeza que deseja excluir o médico CRM " + crm + "?");

            if (confirmacao == JOptionPane.YES_OPTION) {
                
                boolean sucesso = GerenciadorArquivos.Excluir("medicos.txt", crm, 0);
                
                if (sucesso) {
                    JOptionPane.showMessageDialog(tela, "Médico excluído com sucesso.");
                    Limpar();
                    TelaInicio();
                } else {
                    JOptionPane.showMessageDialog(tela, "Erro: Médico não encontrado no arquivo.");
                }
            }
        });

        btnalterar.addActionListener((ActionEvent e) -> {
            if (!ValidarCampos()) {
                return;
            }
            
            GerenciadorArquivos.Excluir("medicos.txt", txtCRM.getText(), 0);
            
            var listaSelecionada = listEspecialidades.getSelectedValuesList();
            String especialidadesString = String.join(", ", listaSelecionada);
            
            String linhaDados = txtCRM.getText() + ";" +
                    txtNome.getText() + ";" +
                    especialidadesString + ";" +
                    txtCPF.getText() + ";" +
                    txtTelefone.getText() + ";" +
                    txtEmail.getText() + ";" +
                    txtEndereco.getText() + ";" +
                    txtDataNascimento.getText() + ";" +
                    cbGenero.getSelectedItem() + ";" +
                    cbTurno.getSelectedItem() + ";" +
                    txtObservacoes.getText().replace("\n", " ");
            
            GerenciadorArquivos.Salvar("medicos.txt", linhaDados);
            
            JOptionPane.showMessageDialog(tela, "Registro alterado com sucesso!");
            Limpar();
            TelaInicio();
        });

        btnconsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] opcoes = { "CRM", "Nome", "Listar Todos" };
                int escolha = JOptionPane.showOptionDialog(tela, "O que deseja fazer?", "Consultar Médico",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                
                if (escolha == JOptionPane.CLOSED_OPTION) return;
                
                if (escolha == 2) {
                    JDialog janelaTabela = new JDialog(tela, "Todos os Médicos", true);
                    janelaTabela.setSize(1500, 400);
                    janelaTabela.setLayout(new BorderLayout());
                    
                    String[] colunas = {
                        "CRM", "Nome", "Especialidade", "CPF", "Telefone",
                        "Email", "Endereço", "Nascimento", "Gênero", "Turno", "Obs"
                    };
                    
                    javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(colunas, 0);
                    java.util.List<String> linhasArq = GerenciadorArquivos.LerArquivo("medicos.txt");
                    for (String l : linhasArq) {
                        String[] dados = l.split(";");
                        modelo.addRow(dados);
                    }
                    
                    JTable tabela = new JTable(modelo);
                    GerenciadorArquivos.AjustarLarguraColunas(tabela);
                    janelaTabela.add(new JScrollPane(tabela), BorderLayout.CENTER);
                    janelaTabela.setLocationRelativeTo(tela);
                    janelaTabela.setVisible(true);
                    return;
                }
                
                String termo = (escolha == 0) ? JOptionPane.showInputDialog(tela, "Digite o CRM:") : JOptionPane.showInputDialog(tela, "Digite o Nome:");
                int indiceBusca = (escolha == 0) ? 0 : 1;
                
                if (termo != null && !termo.trim().isEmpty()) {
                    String linhaEncontrada = GerenciadorArquivos.Buscar("medicos.txt", termo, indiceBusca);
                    
                    if (linhaEncontrada != null) {
                        String[] dados = linhaEncontrada.split(";");
                        
                        Habilitar();
                        txtCRM.setText(dados[0]);
                        txtCRM.setEnabled(false);
                        txtNome.setText(dados[1]);
                        
                        String[] specs = dados[2].split(", ");
                        
                        java.util.List<Integer> indicesParaSelecionar = new ArrayList<>();
                        ListModel<String> model = listEspecialidades.getModel();
                        
                        for (String s : specs) {
                            for (int i = 0; i < model.getSize(); i++) {
                                if (model.getElementAt(i).equalsIgnoreCase(s)) {
                                    indicesParaSelecionar.add(i);
                                }
                            }
                        }
                        
                        int[] indicesArray = indicesParaSelecionar.stream().mapToInt(i -> i).toArray();
                        listEspecialidades.setSelectedIndices(indicesArray);
                        
                        txtCPF.setText(dados[3]);
                        txtTelefone.setText(dados[4]);
                        txtEmail.setText(dados[5]);
                        txtEndereco.setText(dados[6]);
                        txtDataNascimento.setText(dados[7]);
                        cbGenero.setSelectedItem(dados[8]);
                        cbTurno.setSelectedItem(dados[9]);
                        if (dados.length > 10) txtObservacoes.setText(dados[10]);
                        else txtObservacoes.setText("");
                        
                        btnNovo.setEnabled(false);
                        btnsalvar.setEnabled(false);
                        btnalterar.setEnabled(true);
                        btnexcluir.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(tela, "Médico não encontrado!");
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
