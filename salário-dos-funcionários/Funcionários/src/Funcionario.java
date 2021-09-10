public abstract class Funcionario {

    // Atributos
    private int matricula;
    private String nome;
    private String CPF;
    private String nascimento;
    private double percentual;
    private double totalVendas;

    // Construtor
    public Funcionario(int matricula, String nome, String CPF,
                       String nascimento, double percentual, double totalVendas){
        this.matricula = matricula;
        this.nome = nome;
        this.CPF = CPF;
        this.nascimento = nascimento;
        this.percentual = percentual;
        this.totalVendas = totalVendas;
    }

    // Getters e Setters
    public int getMatricula() { return matricula; }
    public void setMatricula(int matricula) { this.matricula = matricula; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCPF() { return CPF; }
    public void setCPF(String CPF) { this.CPF = CPF; }

    public String getNascimento() { return nascimento; }
    public void setNascimento(String nascimento) { this.nascimento = nascimento; }

    public double getPercentual() { return percentual; }
    public void setPercentual(double percentual) { this.percentual = percentual; }

    public double getTotalVendas() { return totalVendas; }
    public void setTotalVendas(double totalVendas) { this.totalVendas = totalVendas; }

    // O método salário irá ser abstrato.
    public abstract double salario();
}
