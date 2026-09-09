package odonto;

public interface IProcedimento {

    String getNome();

    int getQuantidade();

    void setQuantidade(int quantidade);

    double calcularValor();
}