package exercicios;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * Uma lista de exemplos de algoritmos
 * "funcionais" mal escritos que
 * acabam usando recursos de programação funcional
 * de forma inapropriadada ou fazem uso de programação
 * estruturada no meio de código funcional, quando
 * há uma solução mais sucinta e fácil de entender.
 *
 * @author Manoel Campos
 */
public class CodigoFuncionalRuim {
    private final List<List<String>> listaCidadesPorLetraInicial = List.of(
            List.of("Aracajú", "Abreulândia"),
            List.of("Brejinho de Nazaré", "Bom Jesus do Tocantins"),
            List.of("Brasília", "Belém", "Belo Horizonte")
    );

    /**
     * Uma lista onde cada elemento é outra lista contendo
     * a distância entre os pontos de um polígono.
     * O total de elementos em cada lista interna indica o tipo de polígono,
     * como triângulo, qudrilátero, pentágono, etc.
     */
    private final List<List<Integer>> distanciasPoligonos = List.of(
            List.of(10, 10, 10),
            List.of(25, 25, 25),
            List.of(20, 10, 20, 10),
            List.of(30, 30, 30, 30, 30),
            List.of(10, 10, 15, 10, 15)
    );

    public CodigoFuncionalRuim() {
        codigoRuim1();
        correcao1();

        System.out.println();
        codigoRuim2();
        codigoRuim3();
        correcao2and3();

        System.out.println();
        codigoRuim4();
        correcao4();

        System.out.println();
        codigoRuim5();
        correcao5();

        System.out.println();
        codigoRuim6_1();
        codigoRuim6_2();
        correcao6();

        System.out.println();
        codigoRuim7();
        correcao7();

        System.out.println();
        codigoRuim8();
    }

    public static void main(String[] args) {
        new CodigoFuncionalRuim();
    }

    /**
     * Obtém um mapa com o total de cidades por letra inicial.
     *
     * <p>Cria estruturas de dados temporárias de forma procedural,
     * apenas como intermediárias para obter o resultado desejado.
     * Este é o cado da variável {@code cidadesMap},
     * sendo que estamos interessados apenas no resultado final:
     * a variável {@code totalCidadesMap}.</p>
     *
     * <p>Usar um loop para armazenar dados em uma estrutura intermediária
     * é totalmente válido quando escrever o código funcional é muito mais trabalhoso
     * ou confuso que o código procedural (ao ponto de precisar documentar
     * o código para explicar seu funcionamento).</p>
     *
     * <p>O código cria um mapa de cidades onde a chave é a letra inicial da cidade
     * e o valor é o total de cidades com aquela letra.
     * No entanto, ele também não lida com situações onde
     * existem listas de cidades duplicadas para a mesma letra,
     * obtendo resultado incorreto sem qualquer aviso.</p>
     *
     * <p><b>AVISO:</b> Este código também dará erro se uma lista interna
     * no {@link #listaCidadesPorLetraInicial}
     * estiver vazia (sem nenhuma cidade).</p>
     *
     * @see #correcao1()
     */
    private void codigoRuim1() {
        var cidadesMap = new HashMap<Character, List<String>>();
        for (List<String> listaCidades : listaCidadesPorLetraInicial) {
            cidadesMap.put(listaCidades.getFirst().charAt(0), listaCidades);
        }

        var totalCidadesMap =
            cidadesMap
                .entrySet()
                .stream()
                .collect(toMap(Map.Entry::getKey, p -> p.getValue().size()));
        System.out.println("Total de cidades por letra: " + totalCidadesMap);
    }

    /**
     * Fazer primeiro versão com 2 parâmetros no toMap de {@link Collectors},
     * que gera erro em tempo de execução se existirem diferentes
     * entradas na {@code List<List<String>>}
     * com cidades iniciando com a mesma letra.
     * Por fim, usar a versão com 3 parâmetros.
     */
    private void correcao1() {

    }

    /**
     * Obtém uma lista com o total de cidades em cada lista interna
     * de {@link #listaCidadesPorLetraInicial}.
     *
     * <p>O problema deste código é que ele usa um {@link IntStream} para percorrer
     * uma {@link Collection} ({@link List} neste caso),
     * quando poderia ter usado o método {@link List#stream()} diretamente.</p>
     *
     * @see #correcao2and3()
     */
    private void codigoRuim2() {
        var totalCidadesList =
            IntStream
                .range(0, listaCidadesPorLetraInicial.size())
                .mapToObj(i -> listaCidadesPorLetraInicial.get(i).size())
                .toList();

        System.out.println("Total de cidades em cada grupo: " + totalCidadesList);
    }

    /**
     * Usar um forEach para percorrer uma {@link Collection}
     * e criar uma nova estrutura de dados,
     * manualmente adicionando elementos nela,
     * quando poderia colectar os dados usando {@link Stream#collect(Collector)}.
     * A correção é o mesmo do método {@link #correcao2and3()}.
     *
     * @see #correcao2and3()
     */
    private void codigoRuim3() {
        var totalCidadesList = new ArrayList<Integer>();
        listaCidadesPorLetraInicial
                .forEach(cidades -> totalCidadesList.add(cidades.size()));

        System.out.println("Total de cidades em cada grupo: " + totalCidadesList);
    }

    /**
     * Usa {@link Stream#map(Function)} no lugar do
     * {@link IntStream} / {@link Stream#forEach(Consumer)}.
     *
     * @see #codigoRuim2()
     * @see #codigoRuim3()
     */
    private void correcao2and3() {

    }

    /**
     * Obtém o tipo de cada polígono a partir da quantidade de lados.
     *
     * <p>Um problema é não usar o novo Switch Expression
     * do JDK 14 para simplificar o código.</p>
     *
     * <p>Outro problema é não extrair uma lambda para um novo
     * método quando ela tem muitas linhas e
     * principalmente quando faz algo muito específico.</p>
     */
    private void codigoRuim4() {
        var nomePoligonos =
            distanciasPoligonos
              .stream()
              .map(distancias -> {
                 switch (distancias.size()) {
                   case 3: return "Triângulo";
                   case 4: return "Quadrilátero";
                   case 5: return "Pentágono";
                   case 6: return "Hexágono";
                   default: return "Polígono de %d lados".formatted(distancias.size());
                 }
              })
              .toList();

        System.out.println("Tipos de polígonos: " + nomePoligonos);
    }

    /**
     * Usar Switch Expression e extrair método.
     *
     * @see #codigoRuim4()
     */
    private void correcao4() {

    }

    /**
     * Obtem apenas os polígonos que tem mais de 3 lados.
     * <b>AVISO:</b> Este código não vai dar o resultado esperado.
     *
     * <p>O problema deste método é o uso de {@link Stream#of(Object[])}
     * a partir de uma {@link Collection} quando deveria ser usado
     * diretamente {@link Collection#stream()}.</p>
     */
    private void codigoRuim5() {
        var list =
              Stream.of(distanciasPoligonos)
                    .filter(distancias -> distancias.size() >= 4)
                    .toList();
        System.out.println("Polígonos com mais de 3 lados: " + list);
    }

    /**
     * Usar {@link Collection#stream()} ao invés de {@link Stream#of(Object[])}.
     *
     * @see #codigoRuim5()
     */
    private void correcao5() {

    }

    /**
     * Obtém o perímetro de um polígono, somando a distância entre seus pontos.
     *
     * <p>O problema é usar um for dentro de um flatMap para resumir uma conjunto de valores,
     * quando deveria usar um {@link Stream#reduce(BinaryOperator)}.</p>
     */
    private void codigoRuim6_1() {
        var perimetrosList =
                distanciasPoligonos.stream().flatMap(distancias -> {
                    var perimetro = 0;
                    for (Integer distancia : distancias) {
                        perimetro += distancia;
                    }
                    return Stream.of(perimetro);
                })
                                   .toList();

        System.out.println("Perímetros: " + perimetrosList);
    }

    /**
     * Obtém o perímetro de um polígono, somando a distância entre seus pontos.
     *
     * <p>O problema é usar um {@link Stream#mapToInt(ToIntFunction)}
     * dentro de um flatMap para resumir uma conjunto de valores, quando
     * também seria mais simples usar um {@link Stream#reduce(BinaryOperator)}.</p>
     */
    private void codigoRuim6_2() {
        var perimetrosList =
                distanciasPoligonos
                    .stream()
                    .flatMap(distancias -> {
                        var perimetro = distancias.stream().mapToInt(d -> d).sum();
                        return Stream.of(perimetro);
                    }).toList();

        System.out.println("Perímetros: " + perimetrosList);
    }

    /**
     * Usa {@link Stream#reduce(BinaryOperator)} dentro do
     * {@link Stream#flatMap(Function)}
     * para somar as distâncias de cada ponto de um polígono.
     *
     * @see #codigoRuim6_1()
     * @see #codigoRuim6_2()
     */
    private void correcao6() {

    }

    /**
     * Exibe a lista de estados com mais de 300 cidades.
     *
     * <p>O problema é criar um novo {@link Map} a partir de qualquer
     * {@link Collection} e esperar que obrigatoriamente
     * a ordem dos elementos seja a mesma.</p>
     */
    private void codigoRuim7() {
        // Um mapa onde a chave é um estado e o valor é o total de cidades dele
        final Map<String, Integer> cidadesPorEstado = Map.of(
                "BA", 417,
                "CE", 184,
                "DF", 1,
                "ES", 78,
                "GO", 246,
                "MG", 853,
                "PA", 144,
                "RS", 497,
                "SP", 645,
                "TO", 139
        );

        var map = cidadesPorEstado
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 300)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("Estados com mais de 300 cidades:");
        map.forEach(
          (estado, cidades) -> System.out.printf("%s: %d cidades%n", estado, cidades)
        );
    }

    /**
     * Cria um {@link TreeMap} para garantir a ordenação dos estados
     * e coleta os dados filtados em um novo {@link TreeMap}.
     */
    private void correcao7() {

    }

    /**
     * Obtém uma lista com todas as cidades de todos os estados.
     *
     * <p>O problema é usar o {@link Collectors#toList()}
     * para criar uma lista mutável quando
     * poderia simplesmente usar um {@link Stream#toList()}.</p>
     */
    private void codigoRuim8() {
        var lista = listaCidadesPorLetraInicial
                        .stream()
                        .flatMap(List::stream)
                        .collect(toList());

        System.out.println("Lista de todas as cidades: " + lista);
    }
}
