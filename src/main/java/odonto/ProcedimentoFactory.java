package odonto;

public class ProcedimentoFactory {

    public IProcedimento criar(String nome) {
        try {
            Class<?> classe = Class.forName("odonto.Procedimento" + nome);
            Object objeto = classe.getDeclaredConstructor().newInstance();
            return (IProcedimento) objeto;
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Procedimento invalido");
        }
    }
}