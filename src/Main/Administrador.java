package Main;

import Main.Servico;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Administrador extends Usuario {

    // Construtor
    public Administrador() {
        this.tipo = "Administrador";
    }

    public void atribuirProfissionalAoServico() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Profissionais Disponíveis ===");
        List<Profissional> profissionais = Profissional.getProfissionais();
        for (int i = 0; i < profissionais.size(); i++) {
            System.out.println((i + 1) + ". " + profissionais.get(i).getNome());
        }

        System.out.print("Escolha um profissional pelo número: ");
        int escolhaProfissional = scanner.nextInt() - 1;
        if (escolhaProfissional < 0 || escolhaProfissional >= profissionais.size()) {
            System.out.println("Profissional inválido.");
            return;
        }
        Profissional profissionalEscolhido = profissionais.get(escolhaProfissional);

        System.out.println("=== Serviços Disponíveis ===");
        List<Servico> servicos = Servico.listarServicos();
        for (int i = 0; i < servicos.size(); i++) {
            System.out.println((i + 1) + ". " + servicos.get(i).getNome());
        }

        System.out.print("Escolha um serviço pelo número: ");
        int escolhaServico = scanner.nextInt() - 1;
        if (escolhaServico < 0 || escolhaServico >= servicos.size()) {
            System.out.println("Serviço inválido.");
            return;
        }
        Servico servicoEscolhido = servicos.get(escolhaServico);

        servicoEscolhido.atribuirProfissional(profissionalEscolhido);
        System.out.println("Profissional " + profissionalEscolhido.getNome() + " atribuído ao serviço " + servicoEscolhido.getNome());
    }
    
    @Override
    public String visualizarPerfil(){
            String text =  "Nome: " + nome +
                "\nCPF: " + cpf +
                "\nTelefone: " + telefone +
                "\nEmail: " + email +
                "\nTipo: " + tipo +
                "\nPermissões de controle Total!";
            
            return text;
        }
    
}