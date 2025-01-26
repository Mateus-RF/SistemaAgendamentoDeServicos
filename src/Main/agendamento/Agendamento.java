package Main.agendamento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Main.usuario.Profissional;
import Main.usuario.Usuario;
import Main.servico.Servico;

public class Agendamento {
    private static int contadorAgendamentos = 1;
    private int numeroAgendamento;
    private Usuario cliente;
    private Servico servico;
    private Profissional profissional;
    private Date dataHora;
    private String status;

    public static List<Agendamento> agendamentos = new ArrayList<>();

    public int getNumeroAgendamento(){
        return numeroAgendamento;
    }
    public Usuario getCliente(){
        return cliente;
    }
    public Servico getServico(){
        return servico;
    }
    public Profissional getProfissional(){
        return profissional;
    }
    public Date getDataHora(){
        return dataHora;
    }
    public String getStatus(){
        return status;
    }

    public Agendamento(Usuario cliente, Servico servico, Profissional profissional2, Date dataHora) {
            this.numeroAgendamento = contadorAgendamentos++;
            this.cliente = cliente;
            this.servico = servico;
            this.profissional = profissional2;
        this.dataHora = dataHora;
        this.status = "Agendado";
    }

    public static void agendarServico(Usuario nomeCliente, Servico idServico) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("=== Agendamento de Serviço ===");

        Usuario cliente = null;
        for (Usuario u : Usuario.usuarios) {
            if (u.getNome().equalsIgnoreCase(nomeCliente.getNome())) {
                cliente = u;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
    
        Servico servico = null;
        for (Servico s : Servico.getServicosCadastrados()) {
            if (s.getId() == idServico.getId()) {
                servico = s;
                break;
            }
        }
        if (servico == null) {
            System.out.println("Serviço não encontrado.");
            return;
        }
    
        System.out.println("Profissionais disponíveis para o serviço:");
        List<Profissional> profissionais = servico.getProfissionaisDisponiveis();
        for (int i = 0; i < profissionais.size(); i++) {
            System.out.println((i + 1) + ". " + profissionais.get(i).getNome());
        }
        System.out.print("Selecione o profissional pelo número: ");
        int profissionalIndex = scanner.nextInt() - 1;
    
        if (profissionalIndex < 0 || profissionalIndex >= profissionais.size()) {
            System.out.println("Profissional inválido.");
            return;
        }
        Profissional profissional = profissionais.get(profissionalIndex);

        List<String> horariosDisponiveis = profissional.getHorariosDisponiveis();
        if (horariosDisponiveis.isEmpty()) {
            System.out.println("O profissional não tem horários disponíveis.");
            return;
        }

        System.out.println("Horários disponíveis para " + profissional.getNome() + ":");
        for (int i = 0; i < horariosDisponiveis.size(); i++) {
            System.out.println((i + 1) + ". " + horariosDisponiveis.get(i));
        }

        System.out.print("Selecione o horário pelo número: ");
        int horarioIndex = scanner.nextInt() - 1;

        if (horarioIndex < 0 || horarioIndex >= horariosDisponiveis.size()) {
            System.out.println("Horário inválido.");
            return;
        }
        String horarioEscolhido = horariosDisponiveis.get(horarioIndex);

        System.out.print("Digite a data do agendamento (formato: yyyy-MM-dd): ");
        scanner.nextLine();
        String dataInput = scanner.nextLine();
        Date dataHora = null;
        try {
            dataHora = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dataInput + " " + horarioEscolhido);
        } catch (Exception e) {
            System.out.println("Formato de data ou horário inválido.");
            return;
        }
    
        Agendamento novoAgendamento = new Agendamento(cliente, servico, profissional, dataHora);
        agendamentos.add(novoAgendamento);
        System.out.println("Agendamento realizado com sucesso! Número do agendamento: " + novoAgendamento.numeroAgendamento);
        
    }

    public String cancelarAgendamento() {
        this.status = "Cancelado";
        return "Agendamento #" + numeroAgendamento + " foi cancelado com sucesso.";
    }

    public void alterarStatus(String statusNovo) {
        if (statusNovo != null && !statusNovo.isEmpty()) {
            this.status = statusNovo;
        }
    }

    public String visualizarStatus() {
        return "Status do Agendamento #" + numeroAgendamento + ": " + status;
    }

    public String agendamento() {
        return "Agendamento #" + numeroAgendamento + ":\n" +
               "Cliente: " + cliente.getNome() + "\n" +
               "Serviço: " + servico.getNome() + "\n" +
               "Profissional: " + profissional + "\n" +
               "Data e Hora: " + dataHora + "\n" +
               "Status: " + status;
    }

    public static void listarAgendamentos() {
        System.out.println("=== Agendamentos ===");
        if (agendamentos.isEmpty()) {
            System.out.println("Nenhum agendamento encontrado.");
            return;
        }
        for (Agendamento agendamento : agendamentos) {
            System.out.println("Agendamento #" + agendamento.numeroAgendamento + ":\n" +
               "Cliente: " + agendamento.cliente.getNome() + "\n" +
               "Serviço: " + agendamento.servico.getNome() + "\n" +
               "Profissional: " + agendamento.profissional.getNome() + "\n" +
               "Data e Hora: " + agendamento.dataHora + "\n" +
               "Status: " + agendamento.status);
        }
    }
}