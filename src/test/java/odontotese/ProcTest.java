package odonto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcTest {

    @Test
    void deveCriarProcedimentoLimpeza() {
        ProcedimentoFactory factory = new ProcedimentoFactory();
        IProcedimento procedimento = factory.criar("Limpeza");
        assertTrue(procedimento instanceof ProcedimentoLimpeza);
    }

    @Test
    void deveCriarProcedimentoRestauracao() {
        ProcedimentoFactory factory = new ProcedimentoFactory();
        IProcedimento procedimento = factory.criar("Restauracao");
        assertTrue(procedimento instanceof ProcedimentoRestauracao);
    }

    @Test
    void deveCriarProcedimentoCanal() {
        ProcedimentoFactory factory = new ProcedimentoFactory();
        IProcedimento procedimento = factory.criar("Canal");
        assertTrue(procedimento instanceof ProcedimentoCanal);
    }

    @Test
    void deveLancarExcecaoProcedimentoInexistente() {
        ProcedimentoFactory factory = new ProcedimentoFactory();
        try {
            factory.criar("Extracao");
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Procedimento invalido", e.getMessage());
        }
    }

    @Test
    void deveAtribuirQuantidadeLimpeza() {
        IProcedimento procedimento = new ProcedimentoFactory().criar("Limpeza");
        procedimento.setQuantidade(4);
        assertEquals(4, procedimento.getQuantidade());
    }

    @Test
    void deveLancarExcecaoQuantidadeLimpezaAbaixoLimite() {
        IProcedimento procedimento = new ProcedimentoFactory().criar("Limpeza");
        try {
            procedimento.setQuantidade(0);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Quantidade invalida", e.getMessage());
        }
    }

    @Test
    void deveLancarExcecaoQuantidadeLimpezaAcimaLimite() {
        IProcedimento procedimento = new ProcedimentoFactory().criar("Limpeza");
        try {
            procedimento.setQuantidade(5);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Quantidade invalida", e.getMessage());
        }
    }

    @Test
    void deveAtribuirQuantidadeRestauracao() {
        IProcedimento procedimento = new ProcedimentoFactory().criar("Restauracao");
        procedimento.setQuantidade(32);
        assertEquals(32, procedimento.getQuantidade());
    }

    @Test
    void deveLancarExcecaoQuantidadeRestauracaoAbaixoLimite() {
        IProcedimento procedimento = new ProcedimentoFactory().criar("Restauracao");
        try {
            procedimento.setQuantidade(0);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Quantidade invalida", e.getMessage());
        }
    }

    @Test
    void deveLancarExcecaoQuantidadeRestauracaoAcimaLimite() {
        IProcedimento procedimento = new ProcedimentoFactory().criar("Restauracao");
        try {
            procedimento.setQuantidade(33);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Quantidade invalida", e.getMessage());
        }
    }

    @Test
    void deveAtribuirQuantidadeCanal() {
        IProcedimento procedimento = new ProcedimentoFactory().criar("Canal");
        procedimento.setQuantidade(32);
        assertEquals(32, procedimento.getQuantidade());
    }

    @Test
    void deveLancarExcecaoQuantidadeCanalAbaixoLimite() {
        IProcedimento procedimento = new ProcedimentoFactory().criar("Canal");
        try {
            procedimento.setQuantidade(0);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Quantidade invalida", e.getMessage());
        }
    }

    @Test
    void deveLancarExcecaoQuantidadeCanalAcimaLimite() {
        IProcedimento procedimento = new ProcedimentoFactory().criar("Canal");
        try {
            procedimento.setQuantidade(33);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Quantidade invalida", e.getMessage());
        }
    }

    @Test
    void deveCalcularLimpezaLimiteInferior() {
        IProcedimento procedimento = new ProcedimentoFactory().criar("Limpeza");
        procedimento.setQuantidade(1);
        assertEquals(150.0, procedimento.calcularValor(), 0.01);
    }

    @Test
    void deveCalcularLimpezaLimiteSuperior() {
        IProcedimento procedimento = new ProcedimentoFactory().criar("Limpeza");
        procedimento.setQuantidade(4);
        assertEquals(600.0, procedimento.calcularValor(), 0.01);
    }

    @Test
    void deveCalcularRestauracaoLimiteInferior() {
        IProcedimento procedimento = new ProcedimentoFactory().criar("Restauracao");
        procedimento.setQuantidade(1);
        assertEquals(180.0, procedimento.calcularValor(), 0.01);
    }

    @Test
    void deveCalcularRestauracaoSemDesconto() {
        IProcedimento procedimento = new ProcedimentoFactory().criar("Restauracao");
        procedimento.setQuantidade(3);
        assertEquals(540.0, procedimento.calcularValor(), 0.01);
    }

    @Test
    void deveCalcularRestauracaoComDesconto() {
        IProcedimento procedimento = new ProcedimentoFactory().criar("Restauracao");
        procedimento.setQuantidade(4);
        assertEquals(648.0, procedimento.calcularValor(), 0.01);
    }

    @Test
    void deveCalcularRestauracaoLimiteSuperior() {
        IProcedimento procedimento = new ProcedimentoFactory().criar("Restauracao");
        procedimento.setQuantidade(32);
        assertEquals(5184.0, procedimento.calcularValor(), 0.01);
    }

    @Test
    void deveCalcularCanalLimiteInferior() {
        IProcedimento procedimento = new ProcedimentoFactory().criar("Canal");
        procedimento.setQuantidade(1);
        assertEquals(700.0, procedimento.calcularValor(), 0.01);
    }

    @Test
    void deveCalcularCanalLimiteSuperior() {
        IProcedimento procedimento = new ProcedimentoFactory().criar("Canal");
        procedimento.setQuantidade(32);
        assertEquals(22400.0, procedimento.calcularValor(), 0.01);
    }

    @Test
    void deveRetornarNomeDosProcedimentos() {
        ProcedimentoFactory factory = new ProcedimentoFactory();
        assertEquals("Limpeza", factory.criar("Limpeza").getNome());
        assertEquals("Restauracao", factory.criar("Restauracao").getNome());
        assertEquals("Canal", factory.criar("Canal").getNome());
    }
}