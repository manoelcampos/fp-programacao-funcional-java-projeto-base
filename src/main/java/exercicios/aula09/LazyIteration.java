package exercicios.aula09;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de exemplo que mostra como os elementos de uma coleção são
 * percorridos apenas uma vez, não importa quantas operações
 * como filter ou map são realizadas sobre o stream.
 */
public class LazyIteration {
    public static void main(String[] args){
        new LazyIteration();
    }

    public LazyIteration() {
        final var numeros = List.of(-4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
        //final var numeros = getRandomList(1000);

        final var stream = Interceptor.stream(numeros);
        int soma = stream
                .filter(n -> n >= 0)
                .map(n -> n * 2)
                .reduce((subtotal, n) -> subtotal + n)
                .orElse(0);

        System.out.printf("Java -> Soma: %d Tamanho da Lista: %d\n", soma, numeros.size());
    }

    private List<Integer> getRandomList(final int quant) {
        final var numeros = new ArrayList<Integer>(quant);
        for (int i = 0; i < quant; i++) {
            final int value = (int) (Math.random() * 1000.0);
            numeros.add(value);
        }

        System.out.println(numeros);

        return numeros;
    }
}