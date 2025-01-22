package Main.servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Servico {
    private static int contador = 1;
    private static List<Servico> servicosCadastrados = new ArrayList<>();

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

    // Cadastro de Serviço
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
}
