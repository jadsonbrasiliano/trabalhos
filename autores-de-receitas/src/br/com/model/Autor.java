package br.com.model;

public class Autor {

    private int id;
    private String nome;
    private String email;
    private String telefone;

    Autor(int id, String nome, String email, String telefone){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Autor(){
        this(-1, "", "", "");
    }

    public Autor(String nome, String email, String telefone){
        this(-1, nome, email, telefone);
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }

    void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}
