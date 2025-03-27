package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

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

    public Servico() {
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
        if (profissional != null && !profissionaisDisponiveis.contains(profissional)) {
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

    public void cadastrarServico(String nome, String descricao, int duracao, double preco) {
        Servico novoServico = new Servico(nome, descricao, duracao, preco);
        servicosCadastrados.add(novoServico);
        JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso!");
    }

    public void editarServico(int id, String novoNome, String novaDescricao, int novaDuracao, double novoPreco) {
        
        if (id >= 0 && id-1 <= servicosCadastrados.size()){
            Servico servico = servicosCadastrados.get(id-1);

            servico.setNome(novoNome);
            servico.setDescricao(novaDescricao);
            servico.setDuracao(novaDuracao);
            servico.setValor(novoPreco);
        }
        
    }

    public void excluirServico(int numero) {
        try {
            if (numero > 0 && numero - 1 < servicosCadastrados.size()) {
                Servico servicoRemovido = servicosCadastrados.remove(numero - 1);
                JOptionPane.showMessageDialog(null, "Serviço '" + servicoRemovido.getNome() + "' excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "ID inválido! Escolha um ID existente.");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Não é permitido valores Nulos!!!");
        }
    }

    public String listarServicosString() {
        StringBuilder text = new StringBuilder("=== Serviços Disponíveis ===");
        for (Servico servico : servicosCadastrados) {
            text.append("\nID: ").append(servico.getId())
                .append("\nNome: ").append(servico.getNome())
                .append("\nDuração: ").append(servico.getDuracao()).append(" min")
                .append("\nPreço: R$ ").append(servico.getValor())
                .append("\n-----------------------------");
        }
        return text.toString();
    }

    public static List<Servico> listarServicos() {
        return new ArrayList<>(servicosCadastrados);
    }

    public static List<Servico> inicializarServicos() {
        List<Servico> servicos = new ArrayList<>();

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

        if (profissional1 != null) servico1.adicionarProfissional(profissional1);
        if (profissional2 != null) servico2.adicionarProfissional(profissional2);
        if (profissional3 != null) servico3.adicionarProfissional(profissional3);

        servicos.add(servico1);
        servicos.add(servico2);
        servicos.add(servico3);

        return servicos;
    }

    static {
        servicosCadastrados = inicializarServicos();
    }
}

