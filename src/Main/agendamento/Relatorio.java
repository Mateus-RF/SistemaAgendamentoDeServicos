package Main.agendamento;
import java.util.Date;

public class Relatorio {
    private int id;
    private Date dataInicio, dataFim;
    private String tipoRecorrencia, dados;

    public String gerarRelatorio(){
        return toString();
    }
    public String visualizarRelatorio(){
        return toString();
    }
}
