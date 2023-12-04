package escola;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class mainpage {

    private static Aluno[] alunos;
    private static Professor[] professores;
    private static Disciplina[] disciplinas;
    private static JPanel cardPanel;
    private static CardLayout cardLayout;


    private static void initializeCardLayout() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);
    }

//telas

    private static JPanel criarTelaInicial() {
        JPanel telaInicial = new JPanel();
        JLabel label = new JLabel("Inicio");
        JButton button = new JButton("Iniciar");
        JLabel labelQTDEAlunos = new JLabel("Quantos alunos serão cadastrados?");
        JTextField QTDEAlunos = new JTextField(10);
        JLabel labelQTDEProfessor = new JLabel("Quantos professores serão cadastrados?");
        JTextField QTDEProfessor = new JTextField(10);
        JLabel labelQTDEDisciplinas = new JLabel("Quantas disciplinas serão cadastradas?");
        JTextField QTDEDisciplinas = new JTextField(10);

        QTDEAlunos.setColumns(10);
        QTDEProfessor.setColumns(10);
        QTDEDisciplinas.setColumns(10);

        telaInicial.add(label);
        telaInicial.add(new JLabel("\n")); // Adiciona espaçamento
        telaInicial.add(labelQTDEAlunos);
        telaInicial.add(new JLabel("\n"));
        telaInicial.add(QTDEAlunos);
        telaInicial.add(new JLabel("\n"));
        telaInicial.add(labelQTDEProfessor);
        telaInicial.add(new JLabel("\n"));
        telaInicial.add(QTDEProfessor);
        telaInicial.add(new JLabel("\n"));
        telaInicial.add(labelQTDEDisciplinas);
        telaInicial.add(new JLabel("\n"));
        telaInicial.add(QTDEDisciplinas);
        telaInicial.add(new JLabel("\n"));
        telaInicial.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int qtdeAlunos = Integer.parseInt(QTDEAlunos.getText());
                    int qtdeProfessores = Integer.parseInt(QTDEProfessor.getText());
                    int qtdeDisciplinas = Integer.parseInt(QTDEDisciplinas.getText());

                    alunos = new Aluno[qtdeAlunos];
                    professores = new Professor[qtdeProfessores];
                    disciplinas = new Disciplina[qtdeDisciplinas];

                    cardLayout.show(cardPanel, "PainelTelaBotoes");
    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite valores válidos para alunos, professores e disciplinas.");
                }
            }
        });

        return telaInicial;
    }

    private static JPanel criarTelaBotoes() {

        JPanel telaBotoes = new JPanel();
        JButton cadastrarAluno = new JButton("Cadastrar Aluno");
        JButton excluirAluno = new JButton("Excluir Aluno por Nome");
        JButton listarAluno = new JButton("Listar Alunos");
        JButton matricularAluno = new JButton("Matricular Aluno em Disciplina");
        JButton cancelarAluno = new JButton("Cancelar Matrícula de Aluno em Disciplina");

        JButton cadastrarProfessor = new JButton("Cadastrar Professor");
        JButton excluirProfessor = new JButton("Excluir Professor");
        JButton listarProfessor = new JButton("Listar Professor");


        JButton adicionarDisciplina = new JButton("Cadastrar DIsciplina");
        JButton excluirDisciplina = new JButton("Excluir DIsciplina");
        JButton listarDIsciplina = new JButton("Listar DIsciplina");


        telaBotoes.add(adicionarDisciplina);
        telaBotoes.add(excluirDisciplina);
        telaBotoes.add(listarDIsciplina);
        
        telaBotoes.add(cadastrarAluno);
        telaBotoes.add(excluirAluno);
        telaBotoes.add(listarAluno);
        telaBotoes.add(matricularAluno);
        telaBotoes.add(cancelarAluno);

        telaBotoes.add(cadastrarProfessor);
        telaBotoes.add(excluirProfessor);
        telaBotoes.add(listarProfessor);
        
        cadastrarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Quando o botão de cadastrar é pressionado, exibe o painel correspondente
                cardLayout.show(cardPanel, "PainelTelaCadastroAluno");
            }
        });
        excluirAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean existemAlunosCadastrados = false;
        
                // Verifica se há algum aluno não nulo no array
                for (Aluno aluno : alunos) {
                    if (aluno != null) {
                        existemAlunosCadastrados = true;
                        break; // Se encontrou um aluno não nulo, não precisa continuar verificando
                    }
                }
        
                if (existemAlunosCadastrados) {
                    // Se há alunos cadastrados, exibe o painel correspondente
                    cardLayout.show(cardPanel, "PainelTelaExcluirAluno");
                } else {
                    JOptionPane.showMessageDialog(null, "Não há alunos cadastrados. Cadastre algum!");
                }
            }
        });        
        matricularAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean existemAlunosCadastrados = false;
        
                for (Aluno aluno : alunos) {
                    if (aluno != null) {
                        existemAlunosCadastrados = true;
                        break;                     }
                }
        
                if (existemAlunosCadastrados) {
                    JPanel PainelTelaMatricularAlunoEmDisciplina = criarTelaMatricularAluno();
                    cardPanel.add(PainelTelaMatricularAlunoEmDisciplina, "PainelTelaMatricularAlunoEmDisciplina");
                    cardLayout.show(cardPanel, "PainelTelaMatricularAlunoEmDisciplina");

                } else {
                    JOptionPane.showMessageDialog(null, "Não há alunos cadastrados. Cadastre algum!");
                }
        
            }
        }); 
        cancelarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                      boolean existemAlunosCadastrados = false;
        
                for (Aluno aluno : alunos) {
                    if (aluno != null) {
                        existemAlunosCadastrados = true;
                        break;                     }
                }
    
                if (existemAlunosCadastrados) {
                cardLayout.show(cardPanel, "PainelTelaCancelarMatricula");
                } else {
                    JOptionPane.showMessageDialog(null, "Não há alunos cadastrados. Cadastre algum!");
                }        
            }
        });
        listarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                            boolean existemAlunosCadastrados = false;
        
                // Verifica se há algum aluno não nulo no array
                for (Aluno aluno : alunos) {
                    if (aluno != null) {
                        existemAlunosCadastrados = true;
                        break; // Se encontrou um aluno não nulo, não precisa continuar verificando
                    }
                }
        
                if (existemAlunosCadastrados) {
                    JPanel PainelTelaListarAlunos = criarPainelListarAlunos(Arrays.asList(alunos));
                    cardPanel.add(PainelTelaListarAlunos, "PainelTelaListarAlunos");

                    cardLayout.show(cardPanel, "PainelTelaListarAlunos");
                } else {
                    JOptionPane.showMessageDialog(null, "Não há alunos cadastrados. Cadastre algum!");
                }
                        }
        });
        
        cadastrarProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "PainelTelaCadastrarProfessor");
            }
        });
        excluirProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean existemProfessoresCadastrados = false;
        
                for (Professor professor : professores) {
                    if (professor != null) {
                        existemProfessoresCadastrados = true;
                        break; 
                    }
                }
        
                if (existemProfessoresCadastrados) {
                    
                cardLayout.show(cardPanel, "PainelTelaexcluirProfessorPorNome");
        
                } else {
                    JOptionPane.showMessageDialog(null, "Não há Professores cadastrados. Cadastre algum!");
                }
            }
        });
        listarProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                                boolean existemProfessoresCadastrados = false;
        
                for (Professor professor : professores) {
                    if (professor != null) {
                        existemProfessoresCadastrados = true;
                        break; 
                    }
                }
        
                if (existemProfessoresCadastrados) {
                        
                    JPanel painelListarProfessores = criarPainelListarProfessores(Arrays.asList(professores));
                    cardPanel.add(painelListarProfessores, "PainelListarProfessores");
                    cardLayout.show(cardPanel, "PainelListarProfessores");
                } else {
                    JOptionPane.showMessageDialog(null, "Não há Professores cadastrados. Cadastre algum!");
                }
     
            }
        });
        
        adicionarDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    JPanel painelCadastrarDisciplinas = criarTelaCadastrarDisciplina();
                    cardPanel.add(painelCadastrarDisciplinas, "painelCadastrarDisciplinas");
                    cardLayout.show(cardPanel, "painelCadastrarDisciplinas");
            }
        });
        excluirDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   boolean existemDisciplinasCadastradas = false;
                for (Professor professor : professores) {
                    if (professor != null) {
                        existemDisciplinasCadastradas = true;
                        break; 
                    }
                }
                if (existemDisciplinasCadastradas) {                
                    cardLayout.show(cardPanel, "PainelTelaExcluirDisciplina");
                } else {
                    JOptionPane.showMessageDialog(null, "Não há Disciplinas cadastradas. Cadastre alguma!");
                } 
            }
        });
        listarDIsciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                                  boolean existemDisciplinasCadastradas = false;
                for (Disciplina disciplina : disciplinas) {
                    if (disciplina != null) {
                        existemDisciplinasCadastradas = true;
                        break; 
                    }
                }
                if (existemDisciplinasCadastradas) {
                    JPanel painelListarDisciplinas = criarPainelListarDisciplinas(Arrays.asList(disciplinas));
                    cardPanel.add(painelListarDisciplinas, "painelListarDisciplinas");
                    cardLayout.show(cardPanel, "painelListarDisciplinas");
                } else {
                    JOptionPane.showMessageDialog(null, "Não há Disciplinas cadastradas. Cadastre alguma!");
                }
                 }
        });
        
        
        
        telaBotoes.setLayout(new FlowLayout());

        return telaBotoes;
    }
  
    //Alunos
    private static JPanel criarTelaCadastroAluno() {
        JPanel telaCadastroAluno = new JPanel();
        JLabel label = new JLabel("\nCadastrar Aluno\n");
        JButton button = new JButton("Cadastrar\n");
        JLabel labelNome = new JLabel("\nNome:\n");
        JTextField nome = new JTextField();
        JLabel labelMatricula = new JLabel("\nMatrícula:\n");
        JTextField matricula = new JTextField();
        JLabel labelCurso = new JLabel("\nCurso:\n");
        JTextField curso = new JTextField();
        JLabel labelPeriodo = new JLabel("\nPeríodo:\n");
        JTextField periodo = new JTextField();
        JLabel labelIdade = new JLabel("\nIdade:\n");
        JTextField idade = new JTextField();
        JLabel labelQuantidadeDisciplinasPermitidas = new JLabel("\nQuantidade de Disciplinas Permitidas:\n");
        JTextField quantidadeDisciplinasPermitidas = new JTextField();
        JButton voltar = new JButton("Voltar");

        nome.setColumns(10);
        matricula.setColumns(10);
        curso.setColumns(10);
        periodo.setColumns(10);
        idade.setColumns(10);
        quantidadeDisciplinasPermitidas.setColumns(10);

        // Adiciona os componentes ao painel
        telaCadastroAluno.add(label);
        telaCadastroAluno.add(labelNome);
        telaCadastroAluno.add(nome);
        telaCadastroAluno.add(labelMatricula);
        telaCadastroAluno.add(matricula);
        telaCadastroAluno.add(labelCurso);
        telaCadastroAluno.add(curso);
        telaCadastroAluno.add(labelPeriodo);
        telaCadastroAluno.add(periodo);
        telaCadastroAluno.add(labelIdade);
        telaCadastroAluno.add(idade);
        telaCadastroAluno.add(labelQuantidadeDisciplinasPermitidas);
        telaCadastroAluno.add(quantidadeDisciplinasPermitidas);
        telaCadastroAluno.add(voltar);
        telaCadastroAluno.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeAluno = nome.getText();
                String matriculaAluno = matricula.getText();
                String cursoAluno = curso.getText();
                int periodoAluno =  Integer.parseInt(periodo.getText());
                int idadeAluno =  Integer.parseInt(idade.getText());
                int disciplinasPermitidas = Integer.parseInt(quantidadeDisciplinasPermitidas.getText());

                Aluno aluno = new Aluno(nomeAluno, matriculaAluno, idadeAluno, cursoAluno, periodoAluno, disciplinasPermitidas);
                cadastrarAluno(aluno);
                cardLayout.show(cardPanel, "PainelTelaBotoes");

            }
        });

        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                cardLayout.show(cardPanel, "PainelTelaBotoes");
            }
        });

        telaCadastroAluno.setLayout(new FlowLayout());

        return telaCadastroAluno;
    }        
    
    private static JPanel criarTelaExcluirAluno() {
        JPanel telaExcluirAluno = new JPanel();
        JLabel label = new JLabel("Excluir Aluno");
        JButton button = new JButton("Excluir");
        JLabel labelNome = new JLabel("Nome:");
        JTextField nome = new JTextField();
        JButton voltar = new JButton("Voltar");

        nome.setColumns(10);
        
        // Adiciona os componentes ao painel
        telaExcluirAluno.add(label);
        telaExcluirAluno.add(labelNome);
        telaExcluirAluno.add(nome);
        telaExcluirAluno.add(voltar);
        telaExcluirAluno.add(button);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeAluno = nome.getText();

                for (int i = 0; i < alunos.length; i++) {
                    if (alunos[i] != null && alunos[i].getNome().equalsIgnoreCase(nomeAluno)) {
                        alunos[i] = null;
                        System.out.println("Aluno excluído com sucesso!");
                        cardLayout.show(cardPanel, "PainelTelaBotoes");
                       
                        return;
                    }
                }
            }
        });

        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                cardLayout.show(cardPanel, "PainelTelaBotoes");
            }
        });
    
        // Adiciona um layout (FlowLayout) para organizar os componentes
        telaExcluirAluno.setLayout(new FlowLayout());
 
        return telaExcluirAluno;
    }
  
    public static JPanel criarPainelListarAlunos(List<Aluno> listaAlunos) {
        JPanel painelListarAlunos = new JPanel();
        painelListarAlunos.setLayout(new BorderLayout());
       
        AlunoTableModel modelo = new AlunoTableModel(listaAlunos); // Correção aqui
        JTable tabelaAlunos = new JTable(modelo); // Correção aqui
        JScrollPane scrollPane = new JScrollPane(tabelaAlunos);
        painelListarAlunos.add(scrollPane, BorderLayout.CENTER);
    
        return painelListarAlunos;
    }

    private static JPanel criarTelaMatricularAluno() {
        JPanel telaMatricularAluno = new JPanel();
        JLabel label = new JLabel("Matricular aluno em disciplina");
        JButton button = new JButton("Matricular");
        JLabel labelNome = new JLabel("Nome:");
        JTextField nome = new JTextField();
        JLabel labelDisciplina = new JLabel("Disciplina:");
        JTextField disciplinaField = new JTextField();
        JLabel mensagem = new JLabel("Aluno não encontrado:");
        JButton voltar = new JButton("Voltar");


        nome.setColumns(10);
        disciplinaField.setColumns(10);

        telaMatricularAluno.add(label);
        telaMatricularAluno.add(labelNome);
        telaMatricularAluno.add(nome);
        telaMatricularAluno.add(labelDisciplina);
        telaMatricularAluno.add(disciplinaField);
        telaMatricularAluno.add(button);
        telaMatricularAluno.add(voltar);
        telaMatricularAluno.setLayout(new FlowLayout());

        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                cardLayout.show(cardPanel, "PainelTelaBotoes");
            }
        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeAluno = nome.getText();
                Aluno aluno = encontrarAlunoPorNome(nomeAluno);
        
                if (aluno != null) {
                    telaMatricularAluno.remove(mensagem); // Remover mensagem de aluno não encontrado, se existir
                    telaMatricularAluno.add(labelDisciplina);
        
                    
                  
                        // Obter a disciplina selecionada
                        String disciplinaSelecionada = disciplinaField.getText();
                        Disciplina disciplinaSelecionada1 = encontrarDisciplinaPorNome(disciplinaSelecionada);
                        // Realizar a matrícula
                        aluno.fazMatricula(disciplinaSelecionada1);
        
                        JOptionPane.showMessageDialog(null, "Aluno matriculado em " + disciplinaSelecionada + " com sucesso!");

        
                    cardLayout.show(cardPanel, "PainelTelaBotoes");
                } else {
                    telaMatricularAluno.remove(labelDisciplina); // Remover campo de disciplina, se existir
                    telaMatricularAluno.remove(disciplinaField);
                    telaMatricularAluno.add(mensagem);
                    telaMatricularAluno.revalidate();
                    telaMatricularAluno.repaint();
                }
            }
        });
        
        return telaMatricularAluno;
    }

    //Professores
    public static JPanel criarTelaCadastrarProfessor() {
        JPanel telaCadastrarProfessor = new JPanel();
        JLabel label = new JLabel("\nCadastrar Professor\n");
        JButton button = new JButton("Cadastrar\n");
        JLabel labelNome = new JLabel("\nNome:\n");
        JTextField nome = new JTextField();
        JLabel labelMatricula = new JLabel("\nMatrícula:\n");
        JTextField matricula = new JTextField();
        JLabel labelIdade = new JLabel("\nIdade:\n");
        JTextField idade = new JTextField();
        JLabel labelDisciplinasMinistradas = new JLabel("\nQuantidade de Disciplinas Ministradas:\n");
        JTextField quantidadeDisciplinasMinistradas = new JTextField();
        JButton voltar = new JButton("Voltar");
        
        nome.setColumns(10);
        matricula.setColumns(10);
        idade.setColumns(10);
        quantidadeDisciplinasMinistradas.setColumns(10);
    
        // Adiciona os componentes ao painel
        telaCadastrarProfessor.add(label);
        telaCadastrarProfessor.add(labelNome);
        telaCadastrarProfessor.add(nome);
        telaCadastrarProfessor.add(labelMatricula);
        telaCadastrarProfessor.add(matricula);
        telaCadastrarProfessor.add(labelIdade);
        telaCadastrarProfessor.add(idade);
        telaCadastrarProfessor.add(labelDisciplinasMinistradas);
        telaCadastrarProfessor.add(quantidadeDisciplinasMinistradas);
        telaCadastrarProfessor.add(voltar);
        telaCadastrarProfessor.add(button);
    
    
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeProfessor = nome.getText();
                String matriculaProfessor = matricula.getText();
                int idadeProfessor = Integer.parseInt(idade.getText());
                int disciplinasMinistradas = Integer.parseInt(quantidadeDisciplinasMinistradas.getText());
    
                Professor professor = new Professor(nomeProfessor, matriculaProfessor, idadeProfessor, disciplinasMinistradas);
                cadastrarProfessor(professor);
                cardLayout.show(cardPanel, "PainelTelaBotoes");
            }
        });
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                cardLayout.show(cardPanel, "PainelTelaBotoes");
            }
        });
    
        telaCadastrarProfessor.setLayout(new FlowLayout());
    
        return telaCadastrarProfessor;
    }
    
    public static JPanel CriarTelaexcluirProfessorPorNome() {
        JPanel telaExcluirProfessor = new JPanel();
        JLabel label = new JLabel("Excluir Professor");
        JButton button = new JButton("Excluir");
        JLabel labelNome = new JLabel("Nome:");
        JTextField nome = new JTextField();
        JButton voltar = new JButton("Voltar");
    
        nome.setColumns(10);
    
        telaExcluirProfessor.add(label);
        telaExcluirProfessor.add(labelNome);
        telaExcluirProfessor.add(nome);
        telaExcluirProfessor.add(voltar);
        telaExcluirProfessor.add(button);

        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "PainelTelaBotoes");
            }
        });
    
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeProfessor = nome.getText();
    
                for (int i = 0; i < professores.length; i++) {
                    if (professores[i] != null && professores[i].getNome().equalsIgnoreCase(nomeProfessor)) {
                        professores[i] = null;
                        JOptionPane.showMessageDialog(null, "Professor excluído com sucesso!");
                        cardLayout.show(cardPanel, "PainelTelaBotoes");
                        return;
                    }
                }
                
                JOptionPane.showMessageDialog(null, "Professor não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    
        return telaExcluirProfessor;  
    }
 
    public static JPanel criarPainelListarProfessores(List<Professor> listaProfessores) {
        JPanel painelListarProfessores = new JPanel();
        painelListarProfessores.setLayout(new BorderLayout());
       
        ProfessorTableModel modelo = new ProfessorTableModel(listaProfessores);
        JTable tabelaProfessores = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabelaProfessores);
        painelListarProfessores.add(scrollPane, BorderLayout.CENTER);
    
        return painelListarProfessores;
    }
    
    
    //Professores
    public static JPanel criarTelaCadastrarDisciplina() {
        JPanel telaCadastrarProfessor = new JPanel();
        JLabel label = new JLabel("\nCadastrar Disciplina\n");
        JButton button = new JButton("Cadastrar\n");
        JLabel labelNome = new JLabel("\nNome Disciplina:\n");
        JTextField nome = new JTextField();
        JLabel labelProfessor = new JLabel("\nProfessor:\n");
        JTextField professor = new JTextField();
        JButton voltar = new JButton("Voltar");
        
        nome.setColumns(10);
        professor.setColumns(10);
    
        // Adiciona os componentes ao painel
        telaCadastrarProfessor.add(label);
        telaCadastrarProfessor.add(labelNome);
        telaCadastrarProfessor.add(nome);
        telaCadastrarProfessor.add(labelProfessor);
        telaCadastrarProfessor.add(professor);
        telaCadastrarProfessor.add(voltar);
        telaCadastrarProfessor.add(button);
    
    
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeDisciplina = nome.getText();
                String Professor = professor.getText();
                cadastrarDisciplina(nomeDisciplina, Professor, disciplinas, professores);
                cardLayout.show(cardPanel, "PainelTelaBotoes");
            }
        });
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                cardLayout.show(cardPanel, "PainelTelaBotoes");
            }
        });
    
        telaCadastrarProfessor.setLayout(new FlowLayout());
    
        return telaCadastrarProfessor;
    }
    
    public static JPanel CriarTelaExcluirDisciplina() {
        JPanel telaExcluirProfessor = new JPanel();
        JLabel label = new JLabel("Excluir Professor");
        JButton button = new JButton("Excluir");
        JLabel labelNome = new JLabel("Nome:");
        JTextField nome = new JTextField();
        JButton voltar = new JButton("Voltar");
    
        nome.setColumns(10);
    
        telaExcluirProfessor.add(label);
        telaExcluirProfessor.add(labelNome);
        telaExcluirProfessor.add(nome);
        telaExcluirProfessor.add(voltar);
        telaExcluirProfessor.add(button);

        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "PainelTelaBotoes");
            }
        });
    
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeProfessor = nome.getText();
    
                for (int i = 0; i < professores.length; i++) {
                    if (professores[i] != null && professores[i].getNome().equalsIgnoreCase(nomeProfessor)) {
                        professores[i] = null;
                        JOptionPane.showMessageDialog(null, "Professor excluído com sucesso!");
                        cardLayout.show(cardPanel, "PainelTelaBotoes");
                        return;
                    }
                }
                
                JOptionPane.showMessageDialog(null, "Professor não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    
        return telaExcluirProfessor;  
    }
 
    public static JPanel criarPainelListarDisciplinas(List<Disciplina> listaDisciplina) {
        JPanel painelListarDisciplina = new JPanel();
        painelListarDisciplina.setLayout(new BorderLayout());
       
        DisciplinaTableModel modelo = new DisciplinaTableModel(listaDisciplina);  // Correção aqui
        JTable tabelaDisciplina = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabelaDisciplina);
        painelListarDisciplina.add(scrollPane, BorderLayout.CENTER);
    
        return painelListarDisciplina;
    }
    
    
//Metodos operacionais 

    private static Professor encontrarProfessorPorNome(String nome) {
        for (Professor professor : professores) {
            if (professor != null && professor.getNome().equalsIgnoreCase(nome)) {
                return professor;
            }
        }
        return null;
}
    private static Disciplina encontrarDisciplinaPorNome(String nome) {
        for (Disciplina diciplina : disciplinas) {
            if (diciplina != null && diciplina.getNome().equalsIgnoreCase(nome)) {
                return diciplina;
            }
        }
        return null;
}
    public static void cadastrarAluno(Aluno aluno) {
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] == null) {
                if (aluno != null) { // Verifique se o aluno não é null
                    alunos[i] = aluno;
                    JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Aluno é null.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }    
        JOptionPane.showMessageDialog(null, "Não há espaço para cadastrar mais alunos.", "Erro", JOptionPane.ERROR_MESSAGE);
    }

  
    private static Aluno encontrarAlunoPorNome(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno != null && aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }

    public static void cadastrarDisciplina(String nomeDisciplina, String nomeProfessor, Disciplina[] disciplinas, Professor[] professores) {
        for (int i = 0; i < disciplinas.length; i++) {
            if (disciplinas[i] == null) {
                if (nomeDisciplina != null && !nomeDisciplina.trim().isEmpty()) {
                    Professor professorSelecionado = encontrarProfessorPorNome(nomeProfessor);
    
                    if (professorSelecionado != null) {
                        disciplinas[i] = new Disciplina(nomeDisciplina, professorSelecionado);
                        disciplinas[i].setProfessorQueMinistra(professorSelecionado);
                        professorSelecionado.adicionarDisciplina(disciplinas[i]);
                        JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso!");
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "Professor não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Digite um nome para a disciplina.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Não há espaço para cadastrar mais disciplinas.", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void cadastrarProfessor(Professor professor) {
        for (int i = 0; i < professores.length; i++) {
            if (professores[i] == null) {
                if (professor != null) { // Verifique se o professor não é null
                    professores[i] = professor;
                    JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!");
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Professor é null.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Não há espaço para cadastrar mais professores.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void excluirProfessorPorNome(Scanner scanner) {
        System.out.print("Digite o nome do professor a ser excluído: ");
        String nome = scanner.next();
    
        for (int i = 0; i < professores.length; i++) {
            if (professores[i] != null && professores[i].getNome() != null && professores[i].getNome().equalsIgnoreCase(nome)) {
                professores[i] = null;
                JOptionPane.showMessageDialog(null, "Professor excluído com sucesso!");
                return;
            }
        }
    
        JOptionPane.showMessageDialog(null, "Professor não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
        
    private static void criarGUI() {
        JFrame frame = new JFrame("Sistema Acadêmico");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        initializeCardLayout();
        
        JPanel telaInicial = criarTelaInicial();
        cardPanel.add(telaInicial, "PainelTelaInicial");
        professores = new Professor[100];
        alunos = new Aluno[100];
        disciplinas = new Disciplina[100];
    
        JPanel telaBotoes = criarTelaBotoes();
        cardPanel.add(telaBotoes, "PainelTelaBotoes");
        
        
        JPanel telaCadastroAluno = criarTelaCadastroAluno();
        cardPanel.add(telaCadastroAluno, "PainelTelaCadastroAluno");

        JPanel painelTelaExcluirAluno = criarTelaExcluirAluno();
        cardPanel.add(painelTelaExcluirAluno, "PainelTelaExcluirAluno");

        JPanel TelaCadastrarProfessor = criarTelaCadastrarProfessor();
        cardPanel.add(TelaCadastrarProfessor, "PainelTelaCadastrarProfessor");

        JPanel TelaexcluirProfessorPorNome = CriarTelaexcluirProfessorPorNome();
        cardPanel.add(TelaexcluirProfessorPorNome, "PainelTelaexcluirProfessorPorNome");

        JPanel TelaExcluirDisciplina = CriarTelaExcluirDisciplina();
        cardPanel.add(TelaExcluirDisciplina, "PainelTelaExcluirDisciplina");


// Faça o mesmo para outras telas

        frame.add(cardPanel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            criarGUI();
        });
    }
    }


