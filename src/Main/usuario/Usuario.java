package Main.usuario;

import java.util.ArrayList;

public class Usuario {
    protected long cpf, telefone;
    protected String nome, email, senha;
    protected String tipo = "Cliente";//Diz se o usuario é um cliente, administrador ou profissional.]

    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    
    public void setCpf(long cpf){
        this.cpf = cpf;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setTelefone(long numero){
       this.telefone = numero;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public long getCpf(){
        return cpf;
    }
    public String getNome(){
        return nome;
    }
    public long getTelefone(){
        return telefone;
    }
    public String getEmail(){
        return email;
    }
    public String getSenha(){
        return senha;
    }

    public void registrarUsuario(String cpf, String nome, String numero, String email, String senha) {
        if (cpf != null && cpf.length() == 11){
            long ncpf = Long.parseLong(cpf);
            setCpf(ncpf);
        }else {System.out.println("CPF inválido. Deve ter exatamente 11 dígitos.");}

        if (nome != null && !nome.trim().isEmpty()){
            setNome(nome);
        }else{System.out.println("O nome não pode ser nulo ou vazio.");}

        if (numero.length() == 11 && numero != null){
            long ntelefone = Long.parseLong(numero);
            setTelefone(ntelefone);
        }else{  System.out.println("A quantidade de digitos deve ser EXATAMENTE: 11(com DDD).");}

        if (email != null && !email.trim().isEmpty()){
           setEmail(email);
        }else{System.out.println("Não pode ser vazio ou nulo.");}

        if (senha != null && senha.length() >= 8){
            this.senha = senha;
        }else{System.out.println("A senha deve ter pelo menos 8 Digitos.");}

        usuarios.add(this);
    }
    
    public boolean login(String email, String senha){
        return true;
    }
    public void editarPerfil(String nome,int numero, String email, String senha){

    }
    public String visualizarPerfil(){
        return toString();
    }
}
