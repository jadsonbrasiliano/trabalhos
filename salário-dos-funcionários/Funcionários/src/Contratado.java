public class Contratado extends Funcionario{
    private double salarioFixo;

    // Construtor
    public Contratado(int matricula, String nome, String CPF, String nascimento,
                      double percentual, double totalVendas, double salarioFixo){

        super(matricula, nome, CPF, nascimento, percentual, totalVendas);
        this.salarioFixo = salarioFixo;
    }

    public double getSalarioFixo() { return salarioFixo; }
    public void setSalarioFixo(double salarioFixo){ this.salarioFixo = salarioFixo; }

    // Sobrescrita do método
    @Override
    public double salario(){ return (getTotalVendas() * getPercentual()) + salarioFixo; }
}
