package Main;

import java.util.Date; // Import necessário para a classe Date
import Main.agendamento.Agendamento;
import Main.servico.Servico;
import Main.usuario.Usuario;

public class Main {
    public static void main(String[] args) {
    
        // Cadastrar alguns serviços
        Servico.cadastrarServico();
        Servico.cadastrarServico();
    
        // Listar serviços antes da exclusão
        Servico.listarServicos();
    
        // Excluir um serviço
        Servico.excluirServico();
    
        // Listar serviços após a exclusão
        Servico.listarServicos();
    }
    } 