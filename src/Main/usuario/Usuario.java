package Main.usuario;

import java.util.ArrayList;
import java.util.Scanner;

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

    public static void registrarUsuario() {
        Usuario novoUsuario = new Usuario();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Digite seu CPF (11 dígitos): ");
            String cpf = scan.next();
            if (cpf.length() == 11) {
                novoUsuario.setCpf(Long.parseLong(cpf));
                break;
            } else {
                System.out.println("CPF inválido. Deve ter exatamente 11 dígitos.");
            }
        }

        System.out.print("Digite seu nome: ");
        scan.nextLine(); 
        novoUsuario.setNome(scan.nextLine());

        while (true) {
            System.out.print("Digite um número de contato (11 dígitos com DDD): ");
            String telefone = scan.next();
            if (telefone.length() == 11) {
                novoUsuario.setTelefone(Long.parseLong(telefone));
                break;
            } else {
                System.out.println("Número inválido. Deve ter 11 dígitos.");
            }
        }

        System.out.print("Digite seu email: ");
        novoUsuario.setEmail(scan.next());

        while (true) {
            System.out.print("Digite uma senha (mínimo 8 caracteres): ");
            String senha = scan.next();
            if (senha.length() >= 8) {
                novoUsuario.setSenha(senha);
                break;
            } else {
                System.out.println("Senha muito curta.");
            }
        }

        usuarios.add(novoUsuario);
        System.out.println("Usuário registrado com sucesso!");
    }

    // Método de login
    public static Usuario login(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                System.out.println("Login realizado com sucesso!");
                return usuario;
            }
        }
        System.out.println("Email ou senha inválidos.");
        return null;
    }

    // Método para editar o perfil
    public void editarPerfil() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Digite um número de contato (11 dígitos com DDD): ");
            String telefone = scan.next();
            if (telefone.length() == 11) {
                this.setTelefone(Long.parseLong(telefone));
                break;
            } else {
                System.out.println("Número inválido. Deve ter 11 dígitos.");
            }
        } 

        System.out.print("Digite o novo email da conta: ");
        scan.nextLine();
        this.setEmail(scan.nextLine());


        while (true) {
            System.out.print("Digite uma senha (mínimo 8 caracteres): ");
            String senha = scan.next();
            if (senha.length() >= 8) {
                this.setSenha(scan.nextLine());
                break;
            } else {
                System.out.println("Senha muito curta.");
            }
        }

        System.out.println("Perfil atualizado com sucesso!");
    }
    
    public String visualizarPerfil() {
        return "Nome: " + nome +
            "\nCPF: " + cpf +
            "\nTelefone: " + telefone +
            "\nEmail: " + email +
            "\nTipo: " + tipo;
}

}
