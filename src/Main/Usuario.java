package Main;

import Main.Profissional;
import Main.Administrador;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Usuario {
    protected long cpf, telefone;
    protected String nome, email, senha;
    protected String tipo = "Cliente"; // Diz se o usuário é um cliente, administrador ou profissional.

    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    private List<Agendamento> agendamentos = new ArrayList<>();
    
    // Setters
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(long numero) {
        this.telefone = numero;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void addAgendamento(Agendamento agendamento) {
        agendamentos.add(agendamento);
    }

    // Getters
    public long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public long getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
    public String getTipo() {
        return tipo;
    }
    public List<Agendamento> getAgendamentos(){
        return agendamentos;
    }

    public boolean registrarUsuario(String nome, String cpf, String telefone, String email, String senha) {
        Usuario novoUsuario = new Usuario();
        
        novoUsuario.setNome(nome);
        if(nome == null || email == null || nome.isEmpty() || email.isEmpty()){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");
                return false;
        }
        if (cpf.length() != 11) {
            JOptionPane.showMessageDialog(null, "CPF inválido. Deve conter exatamente 11 dígitos numéricos.");
            return false;
        }
        try {
            novoUsuario.setCpf(Long.parseLong(cpf));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro ao converter CPF. Certifique-se de que contém apenas números.");
            return false;
        }

        if (telefone.length() != 11) {
            JOptionPane.showMessageDialog(null, "Telefone. Deve conter exatamente 11 dígitos numéricos.");
            return false;
        }
        try {
            novoUsuario.setTelefone(Long.parseLong(telefone));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro ao converter telefone. Certifique-se de que contém apenas números.");
            return false;
        }
        
        novoUsuario.setEmail(email);
        
        if (senha.length() < 8) {
            JOptionPane.showMessageDialog(null, "Senha Curta, tente uma maior");
            return false;
        }
        
        novoUsuario.setSenha(senha);
        

        usuarios.add(novoUsuario);
        JOptionPane.showMessageDialog(null, "Usuário registrado com sucesso!");
        return true;
    }

    public Usuario login(String email, String senha) {
        if (email == null || senha == null || email.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
            return null;
        }
    
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                if (usuario.getSenha().equals(senha)) {
                    return usuario;
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta.");
                    return null;
                }
            }
        }
        
        JOptionPane.showMessageDialog(null, "Email não cadastrado.");
        return null;
    }
    

    public boolean editarPerfil(String nome, String telefone, String email, String senha) {
        
        this.setNome(nome);
        
        if (telefone.length() != 11) {
            JOptionPane.showMessageDialog(null, "Telefone. Deve conter exatamente 11 dígitos numéricos.");
            return false;
        }
        try {
            this.setTelefone(Long.parseLong(telefone));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro ao converter telefone. Certifique-se de que contém apenas números.");
            return false;
        }
        
        this.setEmail(email);
        
        if (senha.length() < 8) {
            JOptionPane.showMessageDialog(null, "Senha Curta, tente uma maior");
            return false;
        }
        this.setSenha(senha);
        
        
        return true;
    }
    
    public String visualizarPerfil() {
        String text = "Nome: " + nome +
            "\nCPF: " + cpf +
            "\nTelefone: " + telefone +
            "\nEmail: " + email +
            "\nTipo: " + tipo;
        return text;
    }
    public String listarAgendamentos() {
        StringBuilder lista = new StringBuilder("Agendamentos de " + getNome() + ":\n");
        int id = 1;
        for (Agendamento a : agendamentos) {
            lista.append("\nAgendamento #").append(id)
                 .append("\nServiço: ").append(a.getServico().getNome())
                 .append("\nProfissional: ").append(a.getProfissional().getNome())
                 .append("\nData e Hora: ").append(a.getDataHora())
                 .append("\nStatus:").append(a.getStatus()).append("\n")
                 .append("\n------------------------------\n");
        }
        return lista.toString();
    }

    public void transferirAgendamentosParaProfissional(Profissional novoProfissional) {
        for (Agendamento agendamento : this.getAgendamentos()) {
            agendamento.setCliente(novoProfissional);
            novoProfissional.addAgendamento(agendamento);
        }
        this.getAgendamentos().clear();
    }

    static {
        Profissional profissional1 = new Profissional();
        profissional1.setCpf(11111111111L);
        profissional1.setNome("Neto");
        profissional1.setTelefone(11999999999L);
        profissional1.setEmail("edilsonAlves@exemplo.com");
        profissional1.setSenha("senha123");
        profissional1.setEspecialidade("Cabeleireiro");
        profissional1.adicionarHorario("09:00 - 10:00");

        Profissional profissional2 = new Profissional();
        profissional2.setCpf(22222222222L);
        profissional2.setNome("Maria Oliveira");
        profissional2.setTelefone(11988888888L);
        profissional2.setEmail("maria.oliveira@exemplo.com");
        profissional2.setSenha("senha456");
        profissional2.setEspecialidade("Manicure");
        profissional2.adicionarHorario("13:00 - 15:00");

        Profissional profissional3 = new Profissional();
        profissional3.setCpf(33333333333L);
        profissional3.setNome("Alice");
        profissional3.setTelefone(11977777777L);
        profissional3.setEmail("aliceMaria@exemplo.com");
        profissional3.setSenha("senha789");
        profissional3.setEspecialidade("Massoterapeuta");
        profissional3.adicionarHorario("10:00 - 10:50");

        Administrador administrador = new Administrador();
        administrador.setCpf(44444444444L);
        administrador.setNome("Mateus Administrador");
        administrador.setTelefone(11966666666L);
        administrador.setEmail("admin@admin");
        administrador.setSenha("admin123");
        
        Usuario usuario = new Usuario();
        usuario.setCpf(44444444444L);
        usuario.setNome("Mateus");
        usuario.setTelefone(11966666666L);
        usuario.setEmail("mat");
        usuario.setSenha("senha123");
        
        // Adicionar à lista de usuários
        usuarios.add(profissional1);
        usuarios.add(profissional2);
        usuarios.add(profissional3);
        usuarios.add(administrador);
        usuarios.add(usuario);
    }
}
