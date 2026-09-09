package odonto;

public interface Procedimento {
    String getNome();
    int getQuantidadeMaxima();
    double calcularValor(int quantidade);
}

