package Telas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class Login {
    private JFrame tela;
    private JTextField txtUsuario;
    private JPasswordField jpfSenha;
    private JLabel lblTitulo, lblUsuario, lblSenha, lblLogo;
    private JButton btnEntrar, btnEsqueci;; 
 
    public Login(){
        tela = new JFrame("Conecta Saúde - Login");
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(700, 700);
        tela.setResizable(false);
        tela.setLayout(new GridBagLayout());
 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15,15, 15, 15);
        gbc.fill = GridBagConstraints.CENTER;
        gbc.anchor = GridBagConstraints.CENTER;
 
        int linha = 0;
 
        
        // TÍTULO
        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.gridwidth = 2;
        
        java.net.URL imgUrl = getClass().getResource("logo.png");
        
        if (imgUrl != null) {
            ImageIcon imagemOriginal = new ImageIcon(imgUrl);
            
            Image imagemEscalada = imagemOriginal.getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH);
            lblLogo = new JLabel(new ImageIcon(imagemEscalada));
        } else {
                   
            lblLogo = new JLabel("Conecta Saude"); 
            lblLogo.setForeground(Color.BLUE);
        }

        tela.add(lblLogo, gbc);
        linha++;
       
        // USUARIO
        gbc.gridwidth = 1;
        gbc.gridy = linha;
        gbc.gridx = 0;
        lblUsuario = new JLabel("Usuário:");
        tela.add(lblUsuario, gbc);
 
        gbc.gridx = 1;
        txtUsuario = new JTextField( 15);
        tela.add(txtUsuario, gbc);
        linha++;
 
        // SENHA
        gbc.gridx = 0;
        gbc.gridy = linha;
        lblSenha = new JLabel("Senha:");
        tela.add(lblSenha, gbc);
        gbc.gridx = 1;
        jpfSenha = new JPasswordField(15);
        tela.add(jpfSenha, gbc);
        linha++;
 
        // ENTRAR
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = linha;
        btnEntrar = new JButton("Entrar");
        btnEntrar.setBackground(new Color(49,153,151));
        btnEntrar.setForeground(Color.WHITE);
        tela.add(btnEntrar, gbc);
        linha++;
        
        btnEsqueci = new JButton("Esqueceu a senha?");
        btnEsqueci.setForeground(Color.BLUE);       
        btnEsqueci.setBorderPainted(false);         
        btnEsqueci.setContentAreaFilled(false);     
        btnEsqueci.setFocusPainted(false);         
        

        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.gridwidth = 2; 
        tela.add(btnEsqueci, gbc);

        btnEsqueci.addActionListener(e -> {
            JOptionPane.showMessageDialog(tela, 
                "Usuário: admin\nSenha: 123", 
                "Recuperação de Senha", 
                JOptionPane.INFORMATION_MESSAGE);
        });                
 
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String senha = new String(jpfSenha.getPassword());
 
                if(usuario.equals("admin") && senha.equals("123")) {
                    JOptionPane.showMessageDialog(tela, "Login realizado com sucesso!");
                    new TelaInicial();  
                    tela.dispose();    
                } else {
                    JOptionPane.showMessageDialog(tela, "Usuário ou senha incorretos!");
                }
            }
        });
        
        if (Posicao.localizacao != null) {
            tela.setLocation(Posicao.localizacao); 
        } else {
            tela.setLocationRelativeTo(null); 
        }
   
        tela.setVisible(true);
    }

}
