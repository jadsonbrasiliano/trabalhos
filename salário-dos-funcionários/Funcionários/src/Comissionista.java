public class Comissionista extends Funcionario{

    // Construtor
    public Comissionista(int matricula, String nome, String CPF,
                        String nascimento, double percentual, double totalVendas){

        super(matricula, nome, CPF, nascimento, percentual, totalVendas);
    }

    // Sobrescrita do método
    @Override
    public double salario(){ return getTotalVendas() * getPercentual(); }
}
