package Main.agendamento;

public class Relatorio {
    private static int id;

    // Construtor
    public Relatorio() {
        this.id = 1000; // ID inicial do relatório
    }

    // Método para gerar o relatório com base nos agendamentos
    public static String gerarRelatorio() {
        if (Agendamento.agendamentos.isEmpty()) {
            return "Nenhum agendamento encontrado no relatório.";
        }

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("=== Relatório de Agendamentos ===\n");
        relatorio.append("Relatório ID: ").append(id).append("\n");
        relatorio.append("Número total de agendamentos arquivados: ").append(Agendamento.agendamentos.size()).append("\n\n");

        for (Agendamento agendamento : Agendamento.agendamentos) {
            relatorio.append("Agendamento #").append(agendamento.getNumeroAgendamento()).append(":\n")
                     .append("Cliente: ").append(agendamento.getCliente().getNome()).append("\n")
                     .append("Serviço: ").append(agendamento.getServico().getNome()).append("\n")
                     .append("Profissional: ").append(agendamento.getProfissional().getNome()).append("\n")
                     .append("Data e Hora: ").append(agendamento.getDataHora()).append("\n")
                     .append("Status: ").append(agendamento.getStatus()).append("\n")
                     .append("------------------------------\n");
        }

        id++;
        return relatorio.toString();
    }

    // Método para visualizar um relatório específico (sobrescrevendo o toString)
    public static void visualizarRelatorio() {
        String relatorio = gerarRelatorio();
        System.out.println(relatorio);

    }
}
