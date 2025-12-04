package Telas;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

public class Agendamento {

    private JTextField txtcpf, txtcrm, txtsala, txtConvenio;
    private JComboBox<String> cbdata, cbhorario, cbPaciente, cbMedico, cbProcedimento;
    private JButton btnsalvar, btnexcluir, btntelainicial, btnagendamento,
            btnmedico, btnnovo, btnsair, btnconvenio, btnExames, btnalterar, btnconsultar, btnpaciente;
    private JLabel lbltitulo, lblpaciente, lblcpf, lblmedico, lblcrm, lblsala, lblhorario, lbldata, lblprocedimento;
    private JFrame tela;

    private void CarregarPacientes() {
        cbPaciente.removeAllItems();
        cbPaciente.addItem("Selecione o Paciente");
        List<String> linhas = GerenciadorArquivos.LerArquivo("pacientes.txt");
        for (String linha : linhas) {
            String[] dados = linha.split(";");
            if (dados.length > 1) cbPaciente.addItem(dados[1]);
        }
    }

    private void CarregarMedicos() {
        cbMedico.removeAllItems();
        cbMedico.addItem("Selecione o Médico");
        List<String> linhas = GerenciadorArquivos.LerArquivo("medicos.txt");
        for (String linha : linhas) {
            String[] dados = linha.split(";");
            if (dados.length > 1) cbMedico.addItem(dados[1]);
        }
    }

    private void CarregarProcedimentos() {
        cbProcedimento.removeAllItems();
        cbProcedimento.addItem("Selecione o Procedimento");
        List<String> linhas = GerenciadorArquivos.LerArquivo("lista_exames.txt");
        for (String linha : linhas) {
            String[] dados = linha.split(";");
            if (dados.length > 0) cbProcedimento.addItem(dados[0]); 
        }
    }

    public void Habilitar() {
        cbPaciente.setEnabled(true);
        txtcpf.setEnabled(false);
        cbMedico.setEnabled(true);
        txtcrm.setEnabled(false);
        cbProcedimento.setEnabled(true); 
        txtsala.setEnabled(true);
        cbdata.setEnabled(true);
        cbhorario.setEnabled(true);

        CarregarPacientes();
        CarregarMedicos();
        CarregarProcedimentos(); 
    }

    void TelaInicio() {
        cbPaciente.setEnabled(false);
        txtcpf.setEnabled(false);
        cbMedico.setEnabled(false);
        txtcrm.setEnabled(false);
        cbProcedimento.setEnabled(false);
        txtsala.setEnabled(false);
        cbdata.setEnabled(false);
        cbhorario.setEnabled(false);

        btnnovo.setEnabled(true);
        btnexcluir.setEnabled(false);
        btnsalvar.setEnabled(false);
        btnconsultar.setEnabled(true);
        btnalterar.setEnabled(false);
        LimparCampos();
    }

    public void LimparCampos() {
        if (cbPaciente.getItemCount() > 0) cbPaciente.setSelectedIndex(0);
        if (cbMedico.getItemCount() > 0) cbMedico.setSelectedIndex(0);
        if (cbProcedimento.getItemCount() > 0) cbProcedimento.setSelectedIndex(0);
        txtcpf.setText("");
        txtcrm.setText("");
        txtsala.setText("");
        txtConvenio.setText("");
        cbdata.setSelectedIndex(0);
        cbhorario.setSelectedIndex(0);
    }

    private boolean validarCampos() {
        if (cbPaciente.getSelectedIndex() == 0
                || cbMedico.getSelectedIndex() == 0
                || cbProcedimento.getSelectedIndex() == 0 
                || txtsala.getText().isEmpty()
                || cbdata.getSelectedIndex() == 0
                || cbhorario.getSelectedIndex() == 0) {

            JOptionPane.showMessageDialog(tela, "Preencha todos os campos!");
            return false;
        }
        return true;
    }

    public Agendamento() {
        tela = new JFrame("Agendamento");
        tela.setSize(850, 750); 
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setResizable(false);
        tela.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        int linha = 0;

        // TÍTULO
        gbc.gridwidth = 5;
        gbc.gridx = 0;
        gbc.gridy = linha;
        lbltitulo = new JLabel("Agendar Consulta/Exame", SwingConstants.CENTER);
        lbltitulo.setFont(new Font("Arial", Font.BOLD, 30));
        tela.add(lbltitulo, gbc);
        linha++;

        // PACIENTE
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = linha;
        lblpaciente = new JLabel("Nome do paciente:");
        tela.add(lblpaciente, gbc);

        cbPaciente = new JComboBox<>();
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        tela.add(cbPaciente, gbc);

        cbPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbPaciente.getSelectedIndex() > 0) {
                    String nomeSelecionado = cbPaciente.getSelectedItem().toString();
                    String linhaArq = GerenciadorArquivos.Buscar("pacientes.txt", nomeSelecionado, 1);
                    
                    if (linhaArq != null) {
                        String[] dados = linhaArq.split(";");
                        txtcpf.setText(dados[0]);
                        if(dados.length > 7) {
                            txtConvenio.setText(dados[7]);
                        } else {
                            txtConvenio.setText("Não informado");
                        }
                    }
                } else {
                    txtcpf.setText("");
                    txtConvenio.setText("");
                }
            }
        });
        
        gbc.gridwidth = 1;
        linha++;

        // CPF
        gbc.gridx = 0;
        gbc.gridy = linha;
        lblcpf = new JLabel("CPF do paciente:");
        tela.add(lblcpf, gbc);
        
        txtcpf = new JTextField(15);
        txtcpf.setEditable(false);
        gbc.gridx = 1;
        tela.add(txtcpf, gbc);
        linha++;
        
        // CONVÊNIO
        gbc.gridx = 0;
        gbc.gridy = linha;
        tela.add(new JLabel("Convênio:"), gbc);
        
        txtConvenio = new JTextField(15);
        txtConvenio.setEditable(false); 
        gbc.gridx = 1;
        tela.add(txtConvenio, gbc);
        linha++;

        // MÉDICO
        gbc.gridx = 0;
        gbc.gridy = linha;
        lblmedico = new JLabel("Médico:");
        tela.add(lblmedico, gbc);

        cbMedico = new JComboBox<>();
        gbc.gridx = 1;
        tela.add(cbMedico, gbc);

        cbMedico.addActionListener(e -> {
            if (cbMedico.getSelectedIndex() > 0) {
                String nomeSelecionado = cbMedico.getSelectedItem().toString();
                String linhaArq = GerenciadorArquivos.Buscar("medicos.txt", nomeSelecionado, 1);
                if (linhaArq != null) {
                    String[] dados = linhaArq.split(";");
                    txtcrm.setText(dados[0]);
                }
            } else {
                txtcrm.setText("");
            }
        });
        linha++;
        
        // CRM
        gbc.gridx = 0;
        gbc.gridy = linha;
        lblcrm = new JLabel("CRM:");
        tela.add(lblcrm, gbc);

        txtcrm = new JTextField(10);
        txtcrm.setEditable(false);
        gbc.gridx = 1;
        tela.add(txtcrm, gbc);
        linha++;

        gbc.gridx = 0;
        gbc.gridy = linha;
        lblprocedimento = new JLabel("Procedimento:");
        tela.add(lblprocedimento, gbc);

        cbProcedimento = new JComboBox<>();
        gbc.gridx = 1;
        gbc.gridwidth = 2; 
        tela.add(cbProcedimento, gbc);
        
        gbc.gridwidth = 1;
        linha++;

        // DATA
        gbc.gridx = 0;
        gbc.gridy = linha;
        lbldata = new JLabel("Data:");
        tela.add(lbldata, gbc);
        String[] data = {
            "Selecione a Data", "10/09/2025", "11/09/2025", "12/09/2025",
            "15/09/2025", "16/09/2025"
        };
        cbdata = new JComboBox<>(data);
        gbc.gridx = 1;
        tela.add(cbdata, gbc);
        linha++;

        // HORÁRIO
        gbc.gridx = 0;
        gbc.gridy = linha;
        lblhorario = new JLabel("Horário:");
        tela.add(lblhorario, gbc);

        String[] horarios = {
            "Selecione o Horário", "08:00", "08:30", "09:00", "09:30",
            "10:00", "10:30", "11:00", "11:30", "13:00", "13:30",
            "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00"
        };
        cbhorario = new JComboBox<>(horarios);
        gbc.gridx = 1;
        tela.add(cbhorario, gbc);
        linha++;

        // SALA
        gbc.gridx = 0;
        gbc.gridy = linha;
        lblsala = new JLabel("Sala:");
        tela.add(lblsala, gbc);

        txtsala = new JTextField(5);
        gbc.gridx = 1;
        tela.add(txtsala, gbc);
        linha++;
        
        JPanel painelAcoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));

        btnnovo = new JButton("Novo");
        btnnovo.setBackground(Color.BLACK);
        btnnovo.setForeground(Color.WHITE);
        painelAcoes.add(btnnovo);

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

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        btntelainicial = new JButton("Tela Inicial");
        btntelainicial.setBackground(new Color(49, 153, 151));
        btntelainicial.setForeground(Color.WHITE);
        painelBotoes.add(btntelainicial);

        btnmedico = new JButton("Médico");
        btnmedico.setBackground(new Color(49, 153, 151));
        btnmedico.setForeground(Color.WHITE);
        painelBotoes.add(btnmedico);

        btnpaciente = new JButton("Paciente");
        btnpaciente.setBackground(new Color(49, 153, 151));
        btnpaciente.setForeground(Color.WHITE);
        painelBotoes.add(btnpaciente);

        btnagendamento = new JButton("Agendamento");
        btnagendamento.setBackground(new Color(49, 153, 151));
        btnagendamento.setForeground(Color.WHITE);
        btnagendamento.setEnabled(false);
        painelBotoes.add(btnagendamento);

        btnconvenio = new JButton("Convênio");
        btnconvenio.setBackground(new Color(49, 153, 151));
        btnconvenio.setForeground(Color.WHITE);
        painelBotoes.add(btnconvenio);

        btnExames = new JButton("Exames");
        btnExames.setBackground(new Color(49, 153, 151));
        btnExames.setForeground(Color.WHITE);
        painelBotoes.add(btnExames);

        btnsair = new JButton("Sair");
        btnsair.setBackground(new Color(49, 153, 151));
        btnsair.setForeground(Color.WHITE);
        painelBotoes.add(btnsair);

        linha++;
        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.gridwidth = 5;
        tela.add(painelBotoes, gbc);

        TelaInicio();

        btnnovo.addActionListener(e -> {
            Habilitar();
            btnnovo.setEnabled(false);
            btnexcluir.setEnabled(false);
            btnsalvar.setEnabled(true);
            btnconsultar.setEnabled(true);
            btnalterar.setEnabled(false);
            LimparCampos();
        });

        btnsalvar.addActionListener(e -> {
            if (!validarCampos()) return;

            if (GerenciadorArquivos.Buscar("agendamentos.txt", txtcpf.getText(), 0) != null) {
                JOptionPane.showMessageDialog(tela, "Paciente já possui agendamento!");
                return;
            }

            String linhaDados = txtcpf.getText() + ";"
                    + cbPaciente.getSelectedItem() + ";"
                    + cbMedico.getSelectedItem() + ";"
                    + txtcrm.getText() + ";"
                    + txtsala.getText() + ";"
                    + cbdata.getSelectedItem() + ";"
                    + cbhorario.getSelectedItem() + ";"
                    + cbProcedimento.getSelectedItem() + ";"
                    + txtConvenio.getText(); 

            GerenciadorArquivos.Salvar("agendamentos.txt", linhaDados);
            JOptionPane.showMessageDialog(tela, "Agendamento salvo!");
            TelaInicio();
        });

        btnexcluir.addActionListener(e -> {
            String cpf = txtcpf.getText();
            String nome = (cbPaciente.getSelectedItem() != null) ? cbPaciente.getSelectedItem().toString() : "";

            if (cpf.isEmpty()) {
                JOptionPane.showMessageDialog(tela, "Consulte primeiro.");
                return;
            }
            if (JOptionPane.showConfirmDialog(tela, "Cancelar agendamento de " + nome + "?") == JOptionPane.YES_OPTION) {
                GerenciadorArquivos.Excluir("agendamentos.txt", cpf, 0);
                JOptionPane.showMessageDialog(tela, "Cancelado!");
                TelaInicio();
            }
        });

        btnalterar.addActionListener(e -> {
            if (!validarCampos()) return;
            GerenciadorArquivos.Excluir("agendamentos.txt", txtcpf.getText(), 0);
            
            String linhaDados = txtcpf.getText() + ";"
                    + cbPaciente.getSelectedItem() + ";"
                    + cbMedico.getSelectedItem() + ";"
                    + txtcrm.getText() + ";"
                    + txtsala.getText() + ";"
                    + cbdata.getSelectedItem() + ";"
                    + cbhorario.getSelectedItem() + ";"
                    + cbProcedimento.getSelectedItem() + ";"
                    + txtConvenio.getText(); 

            GerenciadorArquivos.Salvar("agendamentos.txt", linhaDados);
            JOptionPane.showMessageDialog(tela, "Alterado!");
            TelaInicio();
        });

        btnconsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] opcoes = {"CPF do Paciente", "Nome do Paciente", "Listar Todos"};
                int escolha = JOptionPane.showOptionDialog(tela, "Buscar por:", "Consultar",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                if (escolha == JOptionPane.CLOSED_OPTION) return;
                if (escolha == 2) {
                    JDialog janela = new JDialog(tela, "Agendamentos", true);
                    janela.setSize(1000, 400); 
                    
                    String[] colunas = {"CPF", "Paciente", "Médico", "CRM", "Sala", "Data", "Horário", "Procedimento", "Convênio"};
                    javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(colunas, 0);
                    
                    List<String> linhas = GerenciadorArquivos.LerArquivo("agendamentos.txt");
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
                    String linha1 = GerenciadorArquivos.Buscar("agendamentos.txt", termo, indice);
                    if (linha1 != null) {
                        String[] dados = linha1.split(";");
                        Habilitar();
                        txtcpf.setText(dados[0]);
                        cbPaciente.setSelectedItem(dados[1]);
                        cbMedico.setSelectedItem(dados[2]);
                        txtcrm.setText(dados[3]);
                        txtsala.setText(dados[4]);
                        cbdata.setSelectedItem(dados[5]);
                        cbhorario.setSelectedItem(dados[6]);
                        if(dados.length > 7) cbProcedimento.setSelectedItem(dados[7]);
                        btnnovo.setEnabled(false);
                        btnsalvar.setEnabled(false);
                        btnalterar.setEnabled(true);
                        btnexcluir.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(tela, "Não encontrado.");
                    }
                }
            }
        });

        // NAVEGAÇÃO
        btntelainicial.addActionListener(e -> { tela.dispose(); new TelaInicial(); });
        btnagendamento.addActionListener(e -> { tela.dispose(); new Agendamento(); });
        btnmedico.addActionListener(e -> { tela.dispose(); new Medico(); });
        btnpaciente.addActionListener(e -> { tela.dispose(); new Paciente(); });
        btnconvenio.addActionListener(e -> { tela.dispose(); new Convenio(); });
        btnExames.addActionListener(e -> { tela.dispose(); new Exames(); });
        btnsair.addActionListener(e -> { tela.dispose(); new Login(); });
        
        if (Posicao.localizacao != null) {
            tela.setLocation(Posicao.localizacao); 
        } else {
            tela.setLocationRelativeTo(null); 
        }
        
        tela.setVisible(true);
    }
}