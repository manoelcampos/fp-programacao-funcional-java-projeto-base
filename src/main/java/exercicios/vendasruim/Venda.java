package exercicios.vendasruim;

import java.util.function.Function;

/**
 * @author Manoel Campos
 */
public class Venda {
    private double valorTotal;

    /**
     * Percentual de desconto a ser aplicado sobre o valor total da venda,
     * numa escala de 0..1
     */
    private double percentualDesconto;

    private final Function<Venda, Double> descontoStrategy;

    public Venda() {
        this(venda -> 0.0);
    }

    public Venda(final Function<Venda, Double> descontoStrategy) {
        this.descontoStrategy = descontoStrategy;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
        this.percentualDesconto = descontoStrategy.apply(this);
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }
}
