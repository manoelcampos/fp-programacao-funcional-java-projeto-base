package exercicios.vendas;

/**
 * @author Manoel Campos
 */
public class RealizarVenda {
    public static void main(String[] args) {
        var venda = new Venda(new DescontoProgressivo());
        venda.setValorTotal(200);
        System.out.println(venda);
    }
}
