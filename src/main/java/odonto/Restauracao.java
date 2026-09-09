package odonto;

public class Restauracao implements Procedimento {

    public String getNome() {
        return "Restauracao";
    }

    public int getQuantidadeMaxima() {
        return 32;
    }

    public double calcularValor(int quantidade) {
        double total = 180.0 * quantidade;
        if (quantidade >= 4) {
            total = total * 0.9;
        }
        return total;
    }
}