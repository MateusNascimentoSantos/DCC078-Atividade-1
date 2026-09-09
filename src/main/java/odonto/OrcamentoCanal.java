package odonto;

public class OrcamentoCanal extends Orcamento {

    public Procedimento criarProcedimento() {
        return new Canal();
    }
}