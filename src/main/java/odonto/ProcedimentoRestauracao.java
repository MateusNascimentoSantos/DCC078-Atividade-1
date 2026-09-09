package odonto;

public class ProcedimentoRestauracao implements IProcedimento {

    private int quantidade;

    public String getNome() {
        return "Restauracao";
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
        double total = 180.0 * this.quantidade;
        if (this.quantidade >= 4) {
            total = total * 0.9;
        }
        return total;
    }
}