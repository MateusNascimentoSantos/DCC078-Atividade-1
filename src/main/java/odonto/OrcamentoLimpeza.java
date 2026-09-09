package odonto;

public class OrcamentoLimpeza extends Orcamento {

    public Procedimento criarProcedimento() {
        return new Limpeza();
    }
}