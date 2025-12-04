package Telas;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

public class Sistema {
    private JButton btnInicio, btnAgenda, btnMedico, btnPaciente, btnSair, btnexames, btnconvenio;
    private JLabel lblTitulo, lblLogo;
    private JLabel lblNome1, lblNome2, lblNome3, lblNome4, lblNome5, lblNome6, lblNome7, lblNome8;

    private JFrame tela;

    public Sistema(){

        tela = new JFrame("Conecta Saúde - Sobre o Sistema");
        tela.setSize(850, 600); 
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setResizable(false);
        tela.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER; 
        
        int linha = 0;

        //TÍTULO
        gbc.gridwidth = 5;
        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.insets = new Insets(30, 10, 15, 10); 

        lblTitulo = new JLabel("Sobre o Sistema"); 
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 30));
        tela.add(lblTitulo, gbc);
        linha++;

        // BOTÕES
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 5));

        btnInicio = criarBotao("Tela Inicial");
        painelBotoes.add(btnInicio);

        btnMedico = criarBotao("Médico");
        painelBotoes.add(btnMedico);

        btnPaciente = criarBotao("Paciente");
        painelBotoes.add(btnPaciente);

        btnAgenda = criarBotao("Agendamento");
        painelBotoes.add(btnAgenda);

        btnconvenio = criarBotao("Convênio");
        painelBotoes.add(btnconvenio);

        btnexames = criarBotao("Exames");
        painelBotoes.add(btnexames);

        btnSair = criarBotao("Sair");
        painelBotoes.add(btnSair);

        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.gridwidth = 5;
        
        gbc.insets = new Insets(0, 10, 0, 10); 
        tela.add(painelBotoes, gbc);
        linha++; 

        JPanel painelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbcCentral = new GridBagConstraints();
        gbcCentral.gridx = 0;
        gbcCentral.gridy = 0;
        gbcCentral.insets = new Insets(0, 0, 10, 0); 

        URL caminhoImagem = getClass().getResource("logo.png");
        if (caminhoImagem != null) {
            ImageIcon iconeOriginal = new ImageIcon(caminhoImagem);
            Image imagem = iconeOriginal.getImage(); 
            Image novaImagem = imagem.getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH); 
            ImageIcon iconeRedimensionado = new ImageIcon(novaImagem);
            
            lblLogo = new JLabel(iconeRedimensionado);
            gbc.gridy = linha;
            gbc.insets = new Insets(0, 10, 20, 10);
            tela.add(lblLogo, gbc);
        } else {
            System.out.println("Erro");
        }
        linha++;

        // EQUIPE
        JPanel painelNomes = new JPanel(new GridLayout(0, 1, 5, 6)); 

        Font fonteNegrito = new Font("Arial", Font.BOLD, 14);
        Font fonteNormal = new Font("Arial", Font.PLAIN, 14);

        JLabel lblEquipe = new JLabel("Equipe:", JLabel.CENTER);
        lblEquipe.setFont(fonteNegrito);
        painelNomes.add(lblEquipe);

        painelNomes.add(criarLabelNome("Igor Raphael Silva Corrêa - 12014847746", fonteNormal));
        painelNomes.add(criarLabelNome("Vitor Hugo Frias Silva dos Santos - 1240207416", fonteNormal));
        painelNomes.add(criarLabelNome("Lucas Silva Oliveira - 1240205647", fonteNormal));
        painelNomes.add(criarLabelNome("Jonas Portilho Ribeiro - 1240204478", fonteNormal));
        painelNomes.add(criarLabelNome("Vitor Cesar Do Nascimento Silva - 1250113313", fonteNormal));

        painelNomes.add(new JLabel(" ")); 
        JLabel lblOrientador = new JLabel("Orientador: Lazaro Pereira de Oliveira", JLabel.CENTER); 
        lblOrientador.setFont(fonteNegrito);
        painelNomes.add(lblOrientador);

        painelNomes.add(criarLabelNome("Versão: 1.0", fonteNormal));
        painelNomes.add(criarLabelNome("2025.2", fonteNormal));

        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.gridwidth = 5;

        gbc.insets = new Insets(0, 10, 30, 10); 
        tela.add(painelNomes, gbc);
        linha++;

        configurarBotoes();

        if (Posicao.localizacao != null) {
            tela.setLocation(Posicao.localizacao);
        } else {
            tela.setLocationRelativeTo(null);
        }

        tela.setVisible(true);
    }

    private JButton criarBotao(String texto) {
        JButton btn = new JButton(texto);
        btn.setBackground(new Color(49,153,151));
        btn.setForeground(Color.WHITE);
        return btn;
    }

    private JLabel criarLabelNome(String texto, Font fonte) {
        JLabel lbl = new JLabel(texto, JLabel.CENTER);
        lbl.setFont(fonte);
        return lbl;
    }

    private void configurarBotoes() {
        btnAgenda.addActionListener(e ->{
            Posicao.localizacao = tela.getLocation(); 
            tela.dispose();
            new Agendamento();
        });
        btnPaciente.addActionListener(e ->{
            Posicao.localizacao = tela.getLocation(); 
            tela.dispose();
            new Paciente();
        });
        btnMedico.addActionListener(e -> {
            Posicao.localizacao = tela.getLocation(); 
            tela.dispose();
            new Medico();
        });
        btnInicio.addActionListener(e -> {
            Posicao.localizacao = tela.getLocation(); 
            tela.dispose();
            new TelaInicial();
        });
        btnconvenio.addActionListener(e -> {
            Posicao.localizacao = tela.getLocation(); 
            tela.dispose();
            new Convenio();
        });
        btnexames.addActionListener(e -> {
            Posicao.localizacao = tela.getLocation();
            tela.dispose();
            new Exames();
        });
        btnSair.addActionListener(e -> {
            tela.dispose();
            new Login();
        });
    }
}