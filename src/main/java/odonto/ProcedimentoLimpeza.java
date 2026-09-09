package odonto;

public class ProcedimentoLimpeza implements IProcedimento {

    private int quantidade;

    public String getNome() {
        return "Limpeza";
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if ((quantidade < 1) || (quantidade > 4)) {
            throw new IllegalArgumentException("Quantidade invalida");
        }
        this.quantidade = quantidade;
    }

    public double calcularValor() {
        return 150.0 * this.quantidade;
    }
}