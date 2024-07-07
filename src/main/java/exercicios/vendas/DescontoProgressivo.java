package exercicios.vendas;

/**
 * @author Manoel Campos
 */
public class DescontoProgressivo implements Desconto {
    @Override
    public double percentual(Venda venda) {
        return Math.min(venda.getValorTotal() / 2500, 0.2);
    }
}
