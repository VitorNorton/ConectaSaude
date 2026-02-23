# 🏥 Conecta Saúde - Sistema de Gerenciamento de Clínicas

Projeto acadêmico desenvolvido para a disciplina de Programação Orientada a Objetos (POO).

<div align="center">
<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white">
<img src="https://img.shields.io/badge/NetBeansIDE-1B6AC6.svg?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white">
</div>

## 💻 Sobre o Projeto

O **Conecta Saúde** é um sistema Desktop desenvolvido em Java (Swing) para gerenciar as operações diárias de uma clínica médica. 

O grande diferencial deste projeto é a sua **persistência de dados baseada em arquivos de texto (.txt)**, sem o uso de bancos de dados tradicionais (SQL). Desenvolvemos uma engine própria (`GerenciadorArquivos.java`) capaz de realizar operações de **CRUD** (Criar, Ler, Atualizar e Deletar) manipulando diretamente arquivos físicos.

## 📸 Screenshots

| Tela Inicial | Cadastro de Médicos |
|:---:|:---:|
| ![Tela Inicial](src/Telas/Telainicial.JPG) | ![Cadastro Médico](src/Telas/CadastrodeMedicos.JPG) |

## ✨ Funcionalidades Principais

-   **🔐 Login e Segurança:** Acesso restrito via usuário e senha.
-   **👨‍⚕️ Gestão de Médicos:** Cadastro completo com seleção múltipla de especialidades, validação de CRM único e dados pessoais.
-   **🤒 Gestão de Pacientes:** Cadastro com vínculo automático a convênios.
-   **📅 Agendamento Inteligente:** -   Preenchimento automático de CPF e Convênio ao selecionar o Paciente.
    -   Preenchimento automático do CRM ao selecionar o Médico.
    -   Seleção de procedimentos baseada no catálogo da clínica.
-   **📝 Catálogo de Exames:** Definição dos tipos de procedimentos oferecidos.
-   **🏥 Convênios:** Gerenciamento das operadoras de saúde parceiras.
-   **📊 Relatórios:** Visualização de todos os registros em tabelas dinâmicas (`JTable`) com ajuste automático de largura de colunas.

## 🛠️ Destaques Técnicos

O projeto foi construído focando em conceitos sólidos de POO e manipulação de arquivos:

1.  **Persistência Customizada:**
    -   Uso de `FileWriter` com modo `append=true` para inserção.
    -   Uso de `BufferedWriter` para performance de escrita.
    -   Lógica de "Excluir e Reescrever" para atualizações de registros.
2.  **Interface Gráfica Responsiva:**
    -   Uso extensivo do `GridBagLayout` para alinhamento preciso dos formulários.
3.  **Integração entre Módulos:**
    -   Os formulários conversam entre si lendo os arquivos `.txt` uns dos outros para popular `JComboBox` e preencher campos automaticamente.

## 📁 Estrutura de Arquivos

O sistema gera e gerencia os seguintes arquivos na raiz do projeto:
-   `medicos.txt`: Dados dos profissionais (CRM, Nome, Especialidades...).
-   `pacientes.txt`: Dados pessoais e convênio dos pacientes.
-   `agendamentos.txt`: Registro das consultas marcadas.
-   `convenios.txt`: Lista de operadoras de saúde.
-   `lista_exames.txt`: Catálogo de procedimentos disponíveis.
-   `exames.txt`: Histórico de exames realizados.

---
Feito com ☕ e Java.
