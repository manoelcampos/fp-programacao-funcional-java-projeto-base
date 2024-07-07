package exercicios.vendas;

/**
 * @author Manoel Campos
 */
public class DescontoFixo implements Desconto {
    @Override
    public double percentual(Venda venda) {
        return 0.1;
    }
}
