package Main.agendamento;

import java.util.Date;
import Main.usuario.Usuario;
import Main.servico.Servico;

public class Agendamento {
    private int numeroAgendamento;
    private Usuario cliente;
    private Servico servico;
    private String profissional;
    private Date dataHora;
    private String status;

    // Construtor padrão
    public Agendamento(int numeroAgendamento, Usuario cliente, Servico servico, String profissional, Date dataHora, String status) {
        this.numeroAgendamento = numeroAgendamento;
        this.cliente = cliente;
        this.servico = servico;
        this.profissional = profissional;
        this.dataHora = dataHora;
        this.status = status;
    }

    // Método para agendar um serviço
    public boolean agendarServico(Usuario cliente, Servico servico, String profissional, Date dataHora) {
        if (cliente == null || servico == null || profissional == null || dataHora == null) {
            return false; // Falha ao agendar devido a dados inválidos
        }

        this.cliente = cliente;
        this.servico = servico;
        this.profissional = profissional;
        this.dataHora = dataHora;
        this.status = "Agendado";
        return true; // Sucesso no agendamento
    }

    // Método para cancelar o agendamento
    public String cancelarAgendamento() {
        this.status = "Cancelado";
        return "Agendamento #" + numeroAgendamento + " foi cancelado com sucesso.";
    }

    // Método para alterar o status do agendamento
    public void alterarStatus(String statusNovo) {
        if (statusNovo != null && !statusNovo.isEmpty()) {
            this.status = statusNovo;
        }
    }

    // Método para visualizar o status do agendamento
    public String visualizarStatus() {
        return "Status do Agendamento #" + numeroAgendamento + ": " + status;
    }

    // Implementação do método toString para exibir os detalhes do agendamento
    @Override
    public String toString() {
        return "Agendamento #" + numeroAgendamento + ":\n" +
               "Cliente: " + cliente.getNome() + "\n" +
               "Serviço: "  + "\n" +
               "Profissional: " + profissional + "\n" +
               "Data e Hora: " + dataHora + "\n" +
               "Status: " + status;
    }
}

