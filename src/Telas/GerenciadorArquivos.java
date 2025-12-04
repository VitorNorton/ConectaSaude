package Telas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;

public class GerenciadorArquivos {

    public static void Salvar(String nomeArquivo, String dados) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write(dados);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    public static List<String> LerArquivo(String nomeArquivo) {
        List<String> linhas = new ArrayList<>();
        File arquivo = new File(nomeArquivo);

        if (!arquivo.exists()) {
            return linhas;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
        return linhas;
    }

    public static String Buscar(String nomeArquivo, String termoBusca, int identificadorIndex) {
        List<String> linhas = LerArquivo(nomeArquivo);
        for (String linha : linhas) {
            String[] dados = linha.split(";");
            if (dados.length > identificadorIndex) {

                if (dados[identificadorIndex].toLowerCase().equals(termoBusca.toLowerCase())) {
                    return linha;
                }
            }
        }
        return null;
    }

    public static boolean Excluir(String nomeArquivo, String termoBusca, int identificadorIndex) {
        List<String> linhas = LerArquivo(nomeArquivo);
        List<String> novasLinhas = new ArrayList<>();
        boolean achou = false;

        for (String linha : linhas) {
            String[] dados = linha.split(";");
            if (dados.length > identificadorIndex) {

                if (dados[identificadorIndex].equalsIgnoreCase(termoBusca)) {
                    achou = true; 
                } else {
                    novasLinhas.add(linha); 
                }
            } else {
                novasLinhas.add(linha);
            }
        }

        if (achou) {
            ReescreverArquivo(nomeArquivo, novasLinhas);
        }
        return achou;
    }

    private static void ReescreverArquivo(String nomeArquivo, List<String> linhas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, false))) {
            for (String linha : linhas) {
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao reescrever arquivo: " + e.getMessage());
        }
    }

    public static void AjustarLarguraColunas(javax.swing.JTable tabela) {
        
        for (int coluna = 0; coluna < tabela.getColumnCount(); coluna++) {
         
            int largura = tabela.getColumnModel().getColumn(coluna).getHeaderValue().toString().length() * 10; 

            for (int linha = 0; linha < tabela.getRowCount(); linha++) {
                Object valor = tabela.getValueAt(linha, coluna);
                if (valor != null) {

                    int tamanhoTexto = valor.toString().length() * 10; 
                    if (tamanhoTexto > largura) {
                        largura = tamanhoTexto;
                    }
                }
            }
            tabela.getColumnModel().getColumn(coluna).setPreferredWidth(largura + 10); 
        }
    }

    static void AjustarLarguraColunas(JDialog janela) {
   
    }
}
    
  