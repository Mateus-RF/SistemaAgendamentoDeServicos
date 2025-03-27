package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Profissional extends Usuario {
    private String especialidade;
    private ArrayList<String> horariosDisponiveis;

    // Construtor
    public Profissional() {
        this.tipo = "Profissional";
        this.horariosDisponiveis = new ArrayList<>();
    }

    // Setters e Getters
    public void setEspecialidade(String especialidades) {
        this.especialidade = especialidades;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public ArrayList<String> getHorariosDisponiveis() {
        return horariosDisponiveis;
    }

    public static List<Profissional> getProfissionais() {
        List<Profissional> profissionais = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Profissional) {
                profissionais.add((Profissional) usuario);
            }
        }
        return profissionais;
    }

    
    public Profissional cadastrarProfissional(Usuario usuarioExistente) {
        if (usuarioExistente == null) {
            JOptionPane.showMessageDialog(null, "Usuário inválido ou não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        Profissional profissional = new Profissional();
        profissional.setCpf(usuarioExistente.getCpf());
        profissional.setNome(usuarioExistente.getNome());
        profissional.setTelefone(usuarioExistente.getTelefone()); 
        profissional.setEmail(usuarioExistente.getEmail());
        profissional.setSenha(usuarioExistente.getSenha());
        profissional.tipo = "Profissional";

        
        String especialidade = JOptionPane.showInputDialog(null, "Digite sua especialidade:", "Especialidade", JOptionPane.QUESTION_MESSAGE);
        if (especialidade == null || especialidade.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Especialidade não pode ser vazia!", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        profissional.setEspecialidade(especialidade);

        
        while (true) {
            String horario = JOptionPane.showInputDialog(null, "Digite um horário disponível (Formato: 09:00 - 10:00)\nOu digite 'sair' para finalizar:", "Horários Disponíveis", JOptionPane.QUESTION_MESSAGE);
            if (horario == null || horario.equalsIgnoreCase("sair")) {
                break;
            }
            profissional.adicionarHorario(horario);
        }

        
        Usuario.usuarios.remove(usuarioExistente);
        Usuario.usuarios.add(profissional);

        JOptionPane.showMessageDialog(null, "Usuário convertido para profissional com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        return profissional;
    }



    public boolean adicionarHorario(String horario) {
        if (horario.matches("\\d{2}:\\d{2} - \\d{2}:\\d{2}")) {
            horariosDisponiveis.add(horario);
        } else {
            JOptionPane.showMessageDialog(null, "Formato inválido! Use: HH:mm - HH:mm (Exemplo: 09:00 - 10:00)");
            return false;
        }
        return true;
    }
    

    public void removerHorario(int horario) {
        
        try {
            if(horario >= 0 && horario <= horariosDisponiveis.size()){
                horariosDisponiveis.remove(horario);
                JOptionPane.showMessageDialog(null, "Horario removido");
            }else{
                JOptionPane.showMessageDialog(null, "Horario não esta na lista!");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Digite um ID!");
        }
    }

    public String listarHorarios() {
        String text = "";
        if (horariosDisponiveis.isEmpty()) {
            text = "Nenhum horário disponível no momento.";
        } else {
            
            text += "Lista de Nomes:\n";
            for (String horario : horariosDisponiveis) {
                text += horario +"\n";
            }
        }
        return text;
    }
    

    @Override
    public String visualizarPerfil(){
        StringBuilder sb = new StringBuilder();
        for (String name : horariosDisponiveis) {
            sb.append(name).append("\n");
        }
        
        String text = "Nome: " + nome +
            "\nCPF: " + cpf +
            "\nTelefone: " + telefone +
            "\nEmail: " + email +
            "\nTipo: " + tipo +
            "\nEspecialidades:"+ especialidade +
            "\nHorarios\n" + sb.toString();
        
        return text;
    }
}
    

