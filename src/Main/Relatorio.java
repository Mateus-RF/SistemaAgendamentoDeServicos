package Main;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Relatorio {
    private static Relatorio instanciaUnica;
    private ArrayList<Agendamento> agendamentosArmazenados = new ArrayList<>();
    private static int id = 1;
    
    private Relatorio() {
        this.agendamentosArmazenados = new ArrayList<>();
    }
    
    public static Relatorio getInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new Relatorio();
        }
        return instanciaUnica;
    }
    
    public List<Agendamento> getAgendamentos() {
        return agendamentosArmazenados;
    }
    
    public void adicionarAgendamento(Agendamento agendamento) {
        if (agendamento != null) {
            agendamentosArmazenados.add(agendamento);
            System.out.println("Agendamento #" + agendamento.getNumeroAgendamento() + " armazenado no relatório.");
        }
    }

    
    public void alterarStatus(int numAgendamento, String novoStatus) {
        for (Agendamento agendamento : agendamentosArmazenados) {
            if (agendamento.getNumeroAgendamento() == numAgendamento) {
                agendamento.setStatus(novoStatus);
                break;
            }
        }
    }

    
    public String gerarRelatorio(Usuario usuario) {
        StringBuilder relatorio = new StringBuilder();
        if (agendamentosArmazenados.isEmpty()) {
            return "Nenhum agendamento encontrado no relatório.";
        }

        relatorio.append("=== Relatório de Agendamentos ===\n");
        relatorio.append("Relatório ID: ").append(id).append("\n");
        relatorio.append("Número total de agendamentos arquivados: ").append(agendamentosArmazenados.size()).append("\n\n");

        // Percorre os agendamentos e cria a string do relatório
        for (Agendamento agendamento : agendamentosArmazenados) {
            if (agendamento.getCliente().equals(usuario)) {  // Verifica se o agendamento pertence ao usuário
                relatorio.append("Agendamento #").append(agendamento.getNumeroAgendamento()).append(":\n")
                         .append("Cliente: ").append(agendamento.getCliente().getNome()).append("\n")
                         .append("Serviço: ").append(agendamento.getServico().getNome()).append("\n")
                         .append("Profissional: ").append(agendamento.getProfissional().getNome()).append("\n")
                         .append("Data e Hora: ").append(agendamento.getDataHora()).append("\n")
                         .append("Status: ").append(agendamento.getStatus()).append("\n")
                         .append("------------------------------\n");
            }
        }

        id++;
        return relatorio.toString();
    }

    public String visualizarRelatorio(Usuario usuario) {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("=== Relatório de Agendamentos de ").append(usuario.getNome()).append(" ===\n");
    
        List<Agendamento> agendamentosUsuario = new ArrayList<>();
    
        
        for (Agendamento agendamento : this.agendamentosArmazenados) {
            if (agendamento.getCliente().equals(usuario)) {
                agendamentosUsuario.add(agendamento);
            }
        }
    
        
        if (usuario instanceof Profissional) {
            Profissional profissional = (Profissional) usuario;
            for (Agendamento agendamento : this.agendamentosArmazenados) {
                if (agendamento.getProfissional().equals(profissional)) {
                    agendamentosUsuario.add(agendamento);
                }
            }
        }
    
        if (agendamentosUsuario.isEmpty()) {
            return "Nenhum agendamento encontrado no relatório.";
        }
    
        for (Agendamento agendamento : agendamentosUsuario) {
            relatorio.append("Agendamento #").append(agendamento.getNumeroAgendamento()).append("\n")
                     .append("Serviço: ").append(agendamento.getServico().getNome()).append("\n")
                     .append("Data e Hora: ").append(agendamento.getDataHora()).append("\n")
                     .append("Status: ").append(agendamento.getStatus()).append("\n")
                     .append("------------------------------\n");
        }
    
        return relatorio.toString();
    }
    

}

