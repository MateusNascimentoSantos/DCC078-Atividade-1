package odonto;

public class Canal implements Procedimento {

    public String getNome() {
        return "Canal";
    }

    public int getQuantidadeMaxima() {
        return 32;
    }

    public double calcularValor(int quantidade) {
        return 700.0 * quantidade;
    }
}