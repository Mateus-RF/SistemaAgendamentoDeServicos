package Main.agendamento;

import java.util.List;

public class Relatorio {
    private static int id;

    // Construtor
    public Relatorio() {
        this.id = 1000; // ID inicial do relatório
    }

    // Método para gerar o relatório com base nos agendamentos
    public static String gerarRelatorio(List<Agendamento> agendamentos) {
        if (agendamentos == null || agendamentos.isEmpty()) {
            return "Nenhum agendamento encontrado para gerar o relatório.";
        }

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("=== Relatório de Agendamentos ===\n");
        relatorio.append("Relatório ID: ").append(id).append("\n");
        relatorio.append("Número total de agendamentos: ").append(agendamentos.size()).append("\n\n");

        for (Agendamento agendamento : agendamentos) {
            relatorio.append("Agendamento #").append(agendamento.getNumeroAgendamento()).append(":\n")
                     .append("Cliente: ").append(agendamento.getCliente().getNome()).append("\n")
                     .append("Serviço: ").append(agendamento.getServico().getNome()).append("\n")
                     .append("Profissional: ").append(agendamento.getProfissional().getNome()).append("\n")
                     .append("Data e Hora: ").append(agendamento.getDataHora()).append("\n")
                     .append("Status: ").append("Concluido")
                     .append("------------------------------\n");
        }

        id++;
        return relatorio.toString();
    }

    // Método para visualizar um relatório específico (sobrescrevendo o toString)
    @Override
    public String toString() {
        return "Relatório ID: " + id + " (utilize o método gerarRelatorio para detalhes).";
    }
}
