package Telas;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Convenio {

    private JTextField txtconvenio, txtcodigo,txttelefone, txtemail;
    private JComboBox<String> cbstatus, cbcategoria;
    JLabel lblconvenio, lblcodigo, lblcategoria, lblstatus, lbltelefone, lblemail, lbltitulo;
    private JButton btnNovo, btnsalvar, btnexcluir, btninicio, btnmedico, btnpaciente, btnagendar, btnsair, btnalterar, btnconsultar, btnconvenio, btnexames;
    
    private JFrame tela; 


     public void Habilitar() {
      txtconvenio.setEnabled(true);
      txtcodigo.setEnabled(true);
      cbcategoria.setEnabled(true);
      cbstatus.setEnabled(true);
      txttelefone.setEnabled(true);
      txtemail.setEnabled(true);
  }

  private boolean ValidarCamposInterno() {
   String convenio = txtconvenio.getText();
   String codigo = txtcodigo.getText();
   int categoria = cbcategoria.getSelectedIndex();
   int status = cbstatus.getSelectedIndex();
   String telefone = txttelefone.getText();
   String email = txtemail.getText();
  

   if (convenio.equals("") || codigo.equals("") || categoria == 0
           || telefone.equals("") || email.equals("") || status == 0) {
       
       JOptionPane.showMessageDialog(tela, "TODOS os campos são obrigatórios");
       return false;
   }

   return true;
}

public void LimparCampos() {
   txtconvenio.setText("");
   txtcodigo.setText("");
   cbcategoria.setSelectedIndex(0);
   cbstatus.setSelectedIndex(0);
   txttelefone.setText("");
   txtemail.setText("");
  
 }

 public void inicio() {
   txtconvenio.setEnabled(false);
   txtcodigo.setEnabled(false);
   cbcategoria.setEnabled(false);
   cbstatus.setEnabled(false);
   txttelefone.setEnabled(false);
   txtemail.setEnabled(false);
 
   btnsalvar.setEnabled(false);
   btnexcluir.setEnabled(false);
   btnNovo.setEnabled(true);
   btnconsultar.setEnabled(true);
   btnalterar.setEnabled(false);
 
   LimparCampos();
 }

     public Convenio(){
        tela = new JFrame("Cadastro de Convênios");
        tela.setSize(850,700);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setResizable(false);
        tela.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;

        int linha = 0;

        
        // TÍTULO
        gbc.gridwidth = 5;
        gbc.gridx = 0;
        lbltitulo = new JLabel("Cadastro de Convênio");
        lbltitulo.setFont(new Font("Arial", Font.BOLD, 30));
        tela.add(lbltitulo, gbc);
        linha++;

        // CONVÊNIO

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = linha;
        lblconvenio = new JLabel("Convênio:");
        tela.add(lblconvenio, gbc);

        txtconvenio = new JTextField(15);
        gbc.gridx = 1;
        tela.add(txtconvenio, gbc);
        linha++;

         // CÓDIGO

        gbc.gridx = 0;
        gbc.gridy = linha;
        lblcodigo = new JLabel("Código:");
        tela.add(lblcodigo, gbc);

        txtcodigo = new JTextField(6);
        gbc.gridx = 1;
        tela.add(txtcodigo, gbc);
        linha++;

        // CATEGORIA

        gbc.gridx = 0;
        gbc.gridy = linha;
        lblcategoria = new JLabel("Categoria:");
        tela.add(lblcategoria, gbc);

        cbcategoria = new JComboBox<>(new String[]{"Selecione", "Particular", "Empresarial", "Individual", "Familiar"});
        gbc.gridx = 1;
        tela.add(cbcategoria, gbc);
        linha++;

        // STATUS

         gbc.gridx = 0;
        gbc.gridy = linha;
        lblstatus = new JLabel("Status:");
        tela.add(lblstatus, gbc);

        cbstatus = new JComboBox<>(new String[]{"Selecione", "Ativo", "Inativo"});
        gbc.gridx = 1;
        tela.add(cbstatus, gbc);
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
        lblemail = new JLabel("Email:");
        tela.add(lblemail, gbc);

        txtemail = new JTextField(20);
        gbc.gridx = 1;
        tela.add(txtemail, gbc);
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

         // BARRA INFERIOR
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
        btnconvenio.setEnabled(false);

        btnexames = new JButton("Exames");
        btnexames.setBackground(new Color(49, 153, 151));
        btnexames.setForeground(Color.WHITE);
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
      
      String busca = GerenciadorArquivos.Buscar("convenios.txt", txtcodigo.getText(), 0);
      if (busca != null) {
          JOptionPane.showMessageDialog(tela, "Já existe um convênio com este Código!");
          return;
      }

      String linhaDados = txtcodigo.getText() + ";" +
                          txtconvenio.getText() + ";" +
                          cbcategoria.getSelectedItem() + ";" +
                          cbstatus.getSelectedItem() + ";" +
                          txttelefone.getText() + ";" +
                          txtemail.getText();

      GerenciadorArquivos.Salvar("convenios.txt", linhaDados);

      JOptionPane.showMessageDialog(tela, "Convênio salvo com sucesso");
      inicio();
  });

  btnexcluir.addActionListener(e ->{
    String codigo = txtcodigo.getText();
    String nome = txtconvenio.getText();
    
    if (codigo.isEmpty()) {
        JOptionPane.showMessageDialog(tela, "Consulte um convênio primeiro para excluir.");
        return;
    }

    int confirmacao = JOptionPane.showConfirmDialog(tela, 
        "Deseja excluir o convênio " + nome + " (Cód: " + codigo + ")?");

    if (confirmacao == JOptionPane.YES_OPTION) {
        boolean sucesso = GerenciadorArquivos.Excluir("convenios.txt", codigo, 0);
        
        if(sucesso) {
            JOptionPane.showMessageDialog(tela, "Excluído com sucesso");
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
    
    GerenciadorArquivos.Excluir("convenios.txt", txtcodigo.getText(), 0);

    String linhaDados = txtcodigo.getText() + ";" +
                          txtconvenio.getText() + ";" +
                          cbcategoria.getSelectedItem() + ";" +
                          cbstatus.getSelectedItem() + ";" +
                          txttelefone.getText() + ";" +
                          txtemail.getText();

    GerenciadorArquivos.Salvar("convenios.txt", linhaDados);
    
    JOptionPane.showMessageDialog(tela, "Registro alterado com sucesso!");
    inicio();
  });

  btnconsultar.addActionListener((ActionEvent e) -> {
      Object[] opcoes = { "Código", "Nome do Convênio", "Listar Todos" };
      int escolha = JOptionPane.showOptionDialog(tela, "Buscar por:", "Consultar",
              JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
      if (escolha == JOptionPane.CLOSED_OPTION) return;
      if (escolha == 2) {
          JDialog janelaTabela = new JDialog(tela, "Todos os Convênios", true);
          janelaTabela.setSize(800, 400);
          janelaTabela.setLayout(new BorderLayout());
          
          String[] colunas = {"Código", "Convênio", "Categoria", "Status", "Telefone", "Email"};
          
          javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(colunas, 0);
          
          java.util.List<String> linhasArq = GerenciadorArquivos.LerArquivo("convenios.txt");
          
          for (String l : linhasArq) {
              String[] dados = l.split(";");
              modelo.addRow(dados);
          }
          
          JTable tabela = new JTable(modelo);
          JScrollPane barraRolagem = new JScrollPane(tabela);
          GerenciadorArquivos.AjustarLarguraColunas(tabela);
          janelaTabela.add(barraRolagem, BorderLayout.CENTER);
          janelaTabela.setLocationRelativeTo(tela);
          janelaTabela.setVisible(true);
          
          return;
      }
      String termo = "";
      int indice = 0;
      if (escolha == 0) {
          termo = JOptionPane.showInputDialog("Digite o Código:");
          indice = 0;
      } else if (escolha == 1) {
          termo = JOptionPane.showInputDialog("Digite o Nome do Convênio:");
          indice = 1;
      }
            if (termo != null && !termo.trim().isEmpty()) {
                String linha1 = GerenciadorArquivos.Buscar("convenios.txt", termo, indice);
                if (linha1 != null) {
                    String[] dados = linha1.split(";");
                    Habilitar();
                    txtcodigo.setText(dados[0]);
                    txtcodigo.setEnabled(false);
                    txtconvenio.setText(dados[1]);
                    cbcategoria.setSelectedItem(dados[2]);
                    cbstatus.setSelectedItem(dados[3]);
                    txttelefone.setText(dados[4]);
                    txtemail.setText(dados[5]);
                    btnNovo.setEnabled(false);
                    btnsalvar.setEnabled(false);
                    btnalterar.setEnabled(true);
                    btnexcluir.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(tela, "Convênio não encontrado.");
                }
            }
        });

  btnagendar.addActionListener(e -> {
      tela.dispose();
      new Agendamento();
  });

  btnpaciente.addActionListener(e -> {
      tela.dispose();
      new Paciente();
  });

  btnmedico.addActionListener(e -> {
      tela.dispose();
      new Medico();
  });

  btninicio.addActionListener(e -> {
      tela.dispose();
      new TelaInicial();
  });

  btnconvenio.addActionListener(e -> {
      tela.dispose();
      new Convenio();
  });

  btnexames.addActionListener(e ->{
      tela.dispose();
      new Exames();
  });

  btnsair.addActionListener(e -> {
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