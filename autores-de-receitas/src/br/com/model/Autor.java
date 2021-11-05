package br.com.model;

public class Autor {

    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String receita;

    Autor(int id, String nome, String email, String telefone, String receita){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.receita = receita;
    }

    public Autor(){
        this(-1, "", "", "", "");
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getReceita() {return receita;}

    void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setReceita(String receita) {this.receita = receita;}
}
