package Main.usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Profissional extends Usuario {
    private String especialidades;
    private ArrayList<String> horariosDisponiveis;

    // Construtor
    public Profissional() {
        this.tipo = "Profissional";
        this.horariosDisponiveis = new ArrayList<>();
    }

    // Setters e Getters
    public void setEspecialidades(String especialidades) {
        this.especialidades = especialidades;
    }

    public String getEspecialidades() {
        return especialidades;
    }

    public ArrayList<String> getHorariosDisponiveis() {
        return horariosDisponiveis;
    }

    public static Profissional cadastrarProfissional() {
        Scanner scan = new Scanner(System.in);

        System.out.println("=== Cadastro de Profissional ===");
        System.out.print("Digite seu email: ");
        String email = scan.next();
        System.out.print("Digite sua senha: ");
        String senha = scan.next();

        Usuario usuarioExistente = null;
        for (Usuario usuario : Usuario.usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                usuarioExistente = usuario;
                break;
            }
        }

        if (usuarioExistente == null) {
            System.out.println("Usuário não encontrado ou credenciais inválidas.");
            return null;
        }

        Profissional profissional = new Profissional();
        profissional.setCpf(usuarioExistente.getCpf());
        profissional.setNome(usuarioExistente.getNome());
        profissional.setTelefone(usuarioExistente.getTelefone());
        profissional.setEmail(usuarioExistente.getEmail());
        profissional.setSenha(usuarioExistente.getSenha());
        profissional.tipo = "Profissional";
        System.out.print("Digite suas especialidades: ");
        scan.nextLine();
        profissional.setEspecialidades(scan.nextLine());

        System.out.println("Adicione horários disponíveis (digite 'sair' para finalizar):");
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
        System.out.println("Horário " + horario + " adicionado com sucesso.");
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
        perfil.append("\nEspecialidades: ").append(especialidades != null ? especialidades : "Não especificada");

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
