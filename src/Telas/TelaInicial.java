package Telas;

import java.awt.*;
import java.awt.event.*;
import java.net.URL; 
import javax.swing.*;

public class TelaInicial {
    private JButton btnInicio, btnAgenda, btnMedico, btnPaciente, btnconvenio, btnexames, btnSair;
    private JLabel lblTitulo, lblSub, lblLogo; 
    private JFrame tela;

    public TelaInicial() {
        tela = new JFrame("Conecta Saúde");
        tela.setSize(850, 600); 
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setResizable(false);
        tela.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;

        int linha = 0;

        
        gbc.gridwidth = 5; 
        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.anchor = GridBagConstraints.CENTER; 

        // Carregar a imagem
        URL caminhoImagem = getClass().getResource("logo.png");
        
        if (caminhoImagem != null) {
            ImageIcon iconeOriginal = new ImageIcon(caminhoImagem);
            Image imagem = iconeOriginal.getImage(); 
            Image novaImagem = imagem.getScaledInstance(300, 150,  java.awt.Image.SCALE_SMOOTH); 
            ImageIcon iconeRedimensionado = new ImageIcon(novaImagem);
            
            lblLogo = new JLabel(iconeRedimensionado);
            tela.add(lblLogo, gbc);
        } else {
            System.out.println("Conecta Saude");
        }
        linha++;

        // TÍTULO
        gbc.gridy = linha;
        lblTitulo = new JLabel("Tela Inicial");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 30));

        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER); 
        tela.add(lblTitulo, gbc);
        linha++;

        // SUBTÍTULO
        gbc.gridy = linha;
        lblSub = new JLabel("Seja bem-vindo(a)!");
        lblSub.setFont(new Font("Arial", Font.PLAIN, 16));
        lblSub.setHorizontalAlignment(SwingConstants.CENTER);
        tela.add(lblSub, gbc);
        linha++;

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        btnMedico = new JButton("Médico");
        btnMedico.setBackground(new Color(49, 153, 151));
        btnMedico.setForeground(Color.WHITE);
        painelBotoes.add(btnMedico);

        btnPaciente = new JButton("Paciente");
        btnPaciente.setBackground(new Color(49, 153, 151));
        btnPaciente.setForeground(Color.WHITE);
        painelBotoes.add(btnPaciente);

        btnAgenda = new JButton("Agendamento");
        btnAgenda.setBackground(new Color(49, 153, 151));
        btnAgenda.setForeground(Color.WHITE);
        painelBotoes.add(btnAgenda);

        btnconvenio = new JButton("Convênio");
        btnconvenio.setBackground(new Color(49, 153, 151));
        btnconvenio.setForeground(Color.WHITE);
        painelBotoes.add(btnconvenio);

        btnexames = new JButton("Exames");
        btnexames.setBackground(new Color(49, 153, 151));
        btnexames.setForeground(Color.WHITE);
        painelBotoes.add(btnexames);

        btnSair = new JButton("Sair");
        btnSair.setBackground(new Color(49, 153, 151));
        btnSair.setForeground(Color.WHITE);
        painelBotoes.add(btnSair);

        gbc.gridy = linha;
        tela.add(painelBotoes, gbc);
        linha++;
        
        btnInicio = new JButton("Sobre o Sistema");
        btnInicio.setForeground(Color.BLUE);           
        btnInicio.setFont(new Font("Arial", Font.PLAIN, 12)); 
        btnInicio.setBorderPainted(false);             
        btnInicio.setContentAreaFilled(false);         
        btnInicio.setFocusPainted(false);               

        gbc.gridy = linha;
        gbc.insets = new Insets(20, 10, 10, 10); 
        tela.add(btnInicio, gbc);
        
        btnAgenda.addActionListener(e -> {
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
            new Sistema();
        });

        btnconvenio.addActionListener(e -> {
            tela.dispose();
            new Convenio();
        });

        btnSair.addActionListener(e -> {
            tela.dispose();
            new Login();
        });

        btnexames.addActionListener(e -> {
            tela.dispose();
            new Exames();
        });
        
        if (Posicao.localizacao != null) {
            tela.setLocation(Posicao.localizacao); 
        } else {
            tela.setLocationRelativeTo(null); 
        }

        tela.setVisible(true);
    }
}