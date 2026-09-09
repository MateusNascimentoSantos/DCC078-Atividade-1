package odonto;

public class OrcamentoRestauracao extends Orcamento {

    public Procedimento criarProcedimento() {
        return new Restauracao();
    }
}