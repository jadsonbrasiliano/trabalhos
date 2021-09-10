public class Main {

    private Funcionario[] funcionarios = {
            new Comissionista(1, "José", "111.222.333-44", "00/11/2222", 0.04, 45000),
            new Contratado(2, "Maria", "222.444.555-66", "01/01/1111", 0.02, 15000, 1200),
            new Comissionista(3, "Laura", "444.333.555-99", "13/04/1000", 0.05, 35000),
            new Contratado(4, "Pedro", "777.111.333-88", "02/05/1232", 0.03, 12000, 1100)
    };


    public void imprimir(Funcionario f){
        System.out.printf("""
                Nome: %s
                Matrícula: %s
                CPF: %s
                Nascimento: %s
                Salário: %s%n
                """, f.getNome(), f.getMatricula(), f.getCPF(), f.getNascimento(), f.salario());
    }

    public void run(){
        for(Funcionario funcionario : funcionarios){
            imprimir(funcionario);
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
