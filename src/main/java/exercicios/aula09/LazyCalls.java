package exercicios.aula09;

import java.util.Collection;
import java.util.List;

/**
 * Exemplo mostrando que, dependendo das operações que você fizer em uma cadeia de {@link java.util.stream.Stream},
 * tais operações serão ignoradas (não serão executadas) se não forem necessárias.
 * Este exemplo mostra que as operações map serão totalmente ignoradas e que a lista de números
 * não será percorrida nenhuma vez (pois o {@link Interceptor} não imprimirá nenhuma mensagem
 * indicando o total de iterações sobre a lista).
 * Isto porque, para obter o total de números na lista em um stream que não tem nenhum filter,
 * não precisa realizar maps nem percorrer a lista. A própria interface {@link Collection} já tem um método
 * {@link Collection#size()} que pode ser chamado diretamente pelo stream.
 * As implementações de {@link Collection} já guardam uma variável com o total de elementos,
 * dispensando qualquer iteração para descobrir este total.
 * Se se não há um filter (você for apenas contar o total de elementos),
 * você não precisa de um map pra isso. O Stream já entende isso e não executa as funções passadas para o map.
 *
 * <p>Obviamente, se você quer apenas o total de elementos da lista, deveria
 * simplesmente executar {@code int total = numeros.size()}, não precisa de Stream pra isso.
 * O exemplo é apenas para mostrar que, mesmo que você escreva um código que não faz sentido,
 * que levaria mais tempo pra executar, a Stream se encarregar de melhorar
 * o desempenho desse seu código porcaria 😂</p>
 *
 * @author Manoel Campos
 */
public class LazyCalls {
    public static void main(String[] args) {
        new LazyCalls();
    }

    public LazyCalls() {
        final var numeros = List.of(-4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
        final var stream = Interceptor.stream(numeros);

        final long totalNumeros =
            stream
                .map(n -> {
                    /* Não será impresso pois o map não precisa ser executado
                    quando a operação final é um count() e não temos outras
                    operações como filter, skip ou limit (por exemplo).
                    */
                    System.out.printf("map1: Math.abs(%d)\n", n);
                    return Math.abs(n);

                })
                .map(n -> {
                    /* Não será impresso pois o map não precisa ser executado
                    quando a operação final é um count() e não temos outras
                    operações como filter, skip ou limit (por exemplo).
                    */
                    System.out.printf("map2: %d * 100\n", n);
                    return n * 100;

                })
                .count();

        System.out.printf("Java -> Tamanho da Lista: %d Total de Números Obtidos: %d\n", numeros.size(), totalNumeros);
    }
}
