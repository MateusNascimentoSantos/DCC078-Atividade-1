package odonto;

public abstract class Orcamento {

    public abstract Procedimento criarProcedimento();

    public double gerar(int quantidade) {
        if (quantidade < 1) {
            throw new IllegalArgumentException("Quantidade invalida");
        }
        Procedimento procedimento = criarProcedimento();
        if (quantidade > procedimento.getQuantidadeMaxima()) {
            throw new IllegalArgumentException("Quantidade acima do limite do procedimento");
        }
        return procedimento.calcularValor(quantidade);
    }
}