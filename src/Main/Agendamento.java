package Main;

import Main.Relatorio;
import Main.Servico;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class Agendamento {
    private int contadorAgendamentos = 1;
    private int numeroAgendamento;
    private Usuario cliente;
    private Servico servico;
    private Profissional profissional;
    private Date dataHora;
    private String status;
    
    Servico serv = new Servico();
    Relatorio relatorio = Relatorio.getInstancia();
    
    
    public List<Agendamento> agendamentos = new ArrayList<>();

    public void removerAgendamento(Agendamento agendamento) {
        agendamentos.remove(agendamento);
    }
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
    public void setStatus(String status) {
        this.status = status;
    }
    public Agendamento(){}
    
    public Agendamento(Usuario cliente, Servico servico, Profissional profissional2, Date dataHora) {
            this.numeroAgendamento = contadorAgendamentos++;
            this.cliente = cliente;
            this.servico = servico;
            this.profissional = profissional2;
        this.dataHora = dataHora;
        this.status = "Agendado";
    }

    public void agendarServico(Usuario cliente, Servico servico, Profissional profissa, Date horarioEscolhido) {
        
        
        Agendamento novoAgendamento;
    
        if (cliente instanceof Profissional profissional) {
            novoAgendamento = new Agendamento(profissional, servico, profissa, horarioEscolhido);
            profissional.addAgendamento(novoAgendamento);
        } else {
            novoAgendamento = new Agendamento(cliente, servico, profissa, horarioEscolhido);
            cliente.addAgendamento(novoAgendamento);
        }
    
        Relatorio.getInstancia().adicionarAgendamento(novoAgendamento);
        profissa.addAgendamento(novoAgendamento);
        JOptionPane.showMessageDialog(null, "Agendamento realizado com sucesso!");
    }
    
    public void cancelarAgendamento(Usuario usuario, int numAgendamento) {
        if (usuario == null) {
            JOptionPane.showMessageDialog(null, "Erro: Usuário inválido.");
            return;
        }
    
        Agendamento agendamentoParaCancelar = null;
    
        for (Agendamento agendamento : usuario.getAgendamentos()) {
            if (agendamento.getNumeroAgendamento() == numAgendamento) {
                agendamentoParaCancelar = agendamento;
                break;
            }
        }
    
        if (agendamentoParaCancelar != null) {
            agendamentoParaCancelar.setStatus("Cancelado");
    
            relatorio.alterarStatus(numAgendamento, "Cancelado");
    
            usuario.getAgendamentos().remove(agendamentoParaCancelar);
    
            JOptionPane.showMessageDialog(null, "Agendamento #" + numAgendamento + " foi cancelado com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Erro: Agendamento não encontrado.");
        }
    }
    
    
    public String visualizarStatus() {
        return "Status do Agendamento #" + numeroAgendamento + ": " + status;
    }

    void setCliente(Profissional novoProfissional) {
        this.cliente = novoProfissional;
    }

    

    
}