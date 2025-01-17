package Main.agendamento;
import java.util.Date;
import Main.usuario.Usuario;
import Main.servico.Servico;
public class Agendamento {
    private int numeroAgendamento;
    private Usuario Cliente;
    private Servico servico;
    private String profissional;
    private Date dataHora;
    private String status;

    public boolean agendarServico(String Cliente, String servico, String profissional, Date dataHora){
        return true;
    }
    public String cancelarAgendamento(int numeroAgendamento){
        return toString();
    }
    public void alterarStatus(String statusNovo){

    }
    public String visualizarStatus(){
        return toString();
    }
}
