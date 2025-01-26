package Main.servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Main.usuario.Profissional;
import Main.usuario.Usuario;

public class Servico {
    private static int contador = 1;
    private static List<Servico> servicosCadastrados = new ArrayList<>();
    private List<Profissional> profissionaisDisponiveis;

    private int id, duracao;
    private String nome, descricao;
    private double valor;
    

    // Construtor
    public Servico(String nome, String descricao, int duracao, double valor) {
        this.id = contador++;
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.valor = valor;
        this.profissionaisDisponiveis = new ArrayList<>();
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getDuracao() {
        return duracao;
    }

    public double getValor() {
        return valor;
    }

    public List<Profissional> getProfissionaisDisponiveis() {
        return profissionaisDisponiveis;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String desc) {
        this.descricao = desc;
    }

    public void setDuracao(int tempo) {
        this.duracao = tempo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public void atribuirProfissional(Profissional profissional) {
        if (!profissionaisDisponiveis.contains(profissional)) {
            profissionaisDisponiveis.add(profissional);
        }
    }
    public void adicionarProfissional(Profissional profissional) {
        if (profissional != null) {
            profissionaisDisponiveis.add(profissional);
        } else {
            System.out.println("Profissional inválido.");
        }
    }
    
    public static Servico cadastrarServico() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cadastro de Serviço ===");

        System.out.print("Digite o nome do serviço: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a descrição do serviço: ");
        String descricao = scanner.nextLine();

        System.out.print("Digite a duração do serviço (em minutos): ");
        int duracao = scanner.nextInt();

        System.out.print("Digite o preço do serviço: ");
        double preco = scanner.nextDouble();

        Servico novoServico = new Servico(nome, descricao, duracao, preco);

        servicosCadastrados.add(novoServico);

        System.out.println("Serviço cadastrado com sucesso!");
        return novoServico;
    }

    public void editarServico() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Editar Serviço ===");
        System.out.print("Digite o novo nome do serviço: ");
        String novoNome = scanner.nextLine();

        System.out.print("Digite a nova descrição do serviço: ");
        String novaDescricao = scanner.nextLine();

        System.out.print("Digite a nova duração (em minutos): ");
        int novaDuracao = scanner.nextInt();

        System.out.print("Digite o novo preço: ");
        double novoPreco = scanner.nextDouble();

        this.nome = novoNome;
        this.descricao = novaDescricao;
        this.duracao = novaDuracao;
        this.valor = novoPreco;

        System.out.println("Serviço atualizado com sucesso!");
        scanner.close(); 
    }
    
    public static boolean excluirServico() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID do serviço que deseja excluir: ");
        int id = scanner.nextInt();

        for (Servico servico : servicosCadastrados) {
            if (servico.getId() == id) {
                servicosCadastrados.remove(servico);
                System.out.println("Serviço com ID " + id + " excluído com sucesso!");
                return true;
            }
        }
        System.out.println("Serviço com ID " + id + " não encontrado.");
        scanner.close();
        return false;
    }

    public static void listarServicos() {
        System.out.println("=== Serviços Disponíveis ===");
        for (Servico servico : servicosCadastrados) {
            System.out.println("ID: " + servico.getId() + 
                               "\nNome: " + servico.getNome() + 
                               "\nDescrição: " + servico.getDescricao() + 
                               "\nDuração: " + servico.getDuracao() + " min" +
                               "\nPreço: R$ " + servico.getValor());
        }
    }

    
    public static List<Servico> getServicosCadastrados() {
        return servicosCadastrados;
    }

    static {
        Profissional profissional1 = null;
        Profissional profissional2 = null;
        Profissional profissional3 = null;
    
        for (Usuario usuario : Usuario.usuarios) {
            if (usuario instanceof Profissional) {
                Profissional profissional = (Profissional) usuario;
                switch (profissional.getNome()) {
                    case "Neto":
                        profissional1 = profissional;
                        break;
                    case "Maria Oliveira":
                        profissional2 = profissional;
                        break;
                    case "Alice":
                        profissional3 = profissional;
                        break;
                }
            }
        }
    
        Servico servico1 = new Servico("Corte de cabelo", "Serviço profissional de cabeleireiro.", 60, 25);
        Servico servico2 = new Servico("Manicure", "Serviço completo de manicure.", 120, 100);
        Servico servico3 = new Servico("Massoterapia", "Serviço de relaxamento e massagem.", 45, 250);
    
        servico1.adicionarProfissional(profissional1);
        servico2.adicionarProfissional(profissional2);
        servico3.adicionarProfissional(profissional3);
    
        servicosCadastrados.add(servico1);
        servicosCadastrados.add(servico2);
        servicosCadastrados.add(servico3);
    }
}
