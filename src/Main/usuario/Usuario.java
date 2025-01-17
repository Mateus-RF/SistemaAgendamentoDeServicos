package Main.usuario;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.TreeUI;

public class Usuario {
    protected long cpf, telefone;
    protected String nome, email, senha;
    protected String tipo = "Cliente"; // Diz se o usuário é um cliente, administrador ou profissional.
    

    public static ArrayList<Usuario> usuarios = new ArrayList<>();

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

    // Método para registrar um novo usuário
    public static void registrarUsuario() {
        Usuario novoUsuario = new Usuario();
        Scanner scan = new Scanner(System.in);
        String cpf;
        while(true){
            System.out.println("Digite seu CPF: ");
            cpf = scan.next();
            if (cpf != null && cpf.length() == 11) {
                long ncpf = Long.parseLong(cpf);
                novoUsuario.setCpf(ncpf);
                break;
            } else {
                System.out.println("CPF inválido. Deve ter exatamente 11 dígitos.");
            }
        }

        String nome;
        while (true) {
            System.out.println("Digite seu nome: ");
            nome = scan.next();
            if (nome != null && !nome.trim().isEmpty()) {
                novoUsuario.setNome(nome);
                break;
            } else {
                System.out.println("O nome não pode ser nulo ou vazio.");
            }
        }

        String numero;
        while (true) {
            System.out.println("Digite um numero de contato: ");
            numero = scan.next();
            if (numero != null && numero.length() == 11) {
                long ntelefone = Long.parseLong(numero);
                novoUsuario.setTelefone(ntelefone);
                break;
            } else {
                System.out.println("A quantidade de dígitos deve ser EXATAMENTE: 11 (com DDD).");
            }
        }

        String email;
        while (true) {
            System.out.println("Digite um email de contato: ");
            email = scan.next();
            if (email != null && !email.trim().isEmpty()) {
                novoUsuario.setEmail(email);
                break;
            } else {
                System.out.println("O e-mail não pode ser vazio ou nulo.");
            }
        }

        String senha;
        while (true) {
            System.out.println("Digite uma senha(minimo 8 digitos): ");
            senha = scan.next();
            if (senha != null && senha.length() >= 8) {
                novoUsuario.setSenha(senha);
                break;
            } else {
                System.out.println("A senha deve ter pelo menos 8 dígitos.");
            }
        }

        // Adicionando o novo usuário à lista
        usuarios.add(novoUsuario);
        System.out.println("Usuário registrado com sucesso!");
    }

    // Outros métodos
    public boolean login(String email, String senha) {
        // Implementação do login
        return true;
    }

    public void editarPerfil(String nome, int numero, String email, String senha) {
        // Implementação de edição de perfil
    }

    public String visualizarPerfil() {
        return toString();
    }

    // Sobrescrevendo o método toString() para exibir informações do usuário
    @Override
    public String toString() {
        return "Usuario{" +
                "cpf=" + cpf +
                ", telefone=" + telefone +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
