package odonto;

public class ProcedimentoCanal implements IProcedimento {

    private int quantidade;

    public String getNome() {
        return "Canal";
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if ((quantidade < 1) || (quantidade > 32)) {
            throw new IllegalArgumentException("Quantidade invalida");
        }
        this.quantidade = quantidade;
    }

    public double calcularValor() {
        return 700.0 * this.quantidade;
    }
}