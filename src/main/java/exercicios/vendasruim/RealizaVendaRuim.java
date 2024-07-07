package exercicios.vendasruim;

import java.util.function.Function;

public class RealizaVendaRuim {
    public static void main(String[] args) {
        Function<Venda, Double> descontoProgressivo = v -> Math.min(v.getValorTotal()/2500, 0.2);
        Function<Venda, Double> descontoFixo = v -> 0.1;

        final Venda venda = new Venda(descontoProgressivo);
        venda.setValorTotal(100);
        System.out.printf("Percentual Desconto: %.2f%%\n", venda.getPercentualDesconto()*100);
    }
}
