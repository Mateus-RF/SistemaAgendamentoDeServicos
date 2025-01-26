package Main.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public static Profissional cadastrarProfissional(Usuario usuarioExistente) {
        if (usuarioExistente == null || !(usuarioExistente instanceof Usuario)) {
            System.out.println("Usuário inválido ou não encontrado.");
            return null;
        }

        Scanner scan = new Scanner(System.in);

        Profissional profissional = new Profissional();
        profissional.setCpf(usuarioExistente.getCpf());
        profissional.setNome(usuarioExistente.getNome());
        profissional.setTelefone(usuarioExistente.getTelefone());
        profissional.setEmail(usuarioExistente.getEmail());
        profissional.setSenha(usuarioExistente.getSenha());
        profissional.tipo = "Profissional";

        System.out.print("Digite suas especialidades: ");
        profissional.setEspecialidade(scan.nextLine());

        System.out.println("Adicione horários disponíveis (digite 'sair' para finalizar):");
        System.out.println("Padrao de Horario Aceito(09:00 - 10:00)");
        while (true) {
            System.out.print("Horário: ");
            String horario = scan.nextLine();
            if (horario.equalsIgnoreCase("sair")) {
                break;
            }
            profissional.adicionarHorario(horario);
        }

        Usuario.usuarios.remove(usuarioExistente);
        Usuario.usuarios.add(profissional);
        

        System.out.println("Usuário transformado em profissional com sucesso!");
        return profissional;
    }

    public void adicionarHorario(String horario) {
        horariosDisponiveis.add(horario);
    }

    public void removerHorario(String horario) {
        if (horariosDisponiveis.remove(horario)) {
            System.out.println("Horário " + horario + " removido com sucesso.");
        } else {
            System.out.println("Horário não encontrado.");
        }
    }

    public void listarHorarios() {
        if (horariosDisponiveis.isEmpty()) {
            System.out.println("Nenhum horário disponível no momento.");
        } else {
            System.out.println("Horários disponíveis:");
            for (String horario : horariosDisponiveis) {
                System.out.println(horario);
            }
        }
    }

    @Override
    public String visualizarPerfil() {
        StringBuilder perfil = new StringBuilder(super.visualizarPerfil());
        perfil.append("\nEspecialidades: ").append(especialidade != null ? especialidade : "Não especificada");

        if (horariosDisponiveis.isEmpty()) {
            perfil.append("\nHorários disponíveis: Nenhum horário cadastrado");
        } else {
            perfil.append("\nHorários disponíveis:");
            for (String horario : horariosDisponiveis) {
                perfil.append("\n- ").append(horario);
            }
        }
        return perfil.toString();
    }
    
}
