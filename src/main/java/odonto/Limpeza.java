package odonto;

public class Limpeza implements Procedimento {

    public String getNome() {
        return "Limpeza";
    }

    public int getQuantidadeMaxima() {
        return 4;
    }

    public double calcularValor(int quantidade) {
        return 150.0 * quantidade;
    }
}