package exercicios.aula09;

import lombok.Getter;

import java.util.Collection;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Intercepta os acessos aos elementos de uma coleção (como {@link List})
 * e conta quantas iterações foram realizadas sobre
 * os elementos da coleção (quantas vezes os elementos foram acessados).
 *
 * @param <T>
 */
class Interceptor<T> extends Spliterators.AbstractSpliterator<T> {
    private final Spliterator<T> spliterator;

    /**
     * Total de iterações realizadas sobre os elementos da coleção.
     */
    private @Getter int iteracoes;

    public Interceptor(Spliterator<T> spliterator) {
        super(spliterator.estimateSize(), spliterator.characteristics());
        this.spliterator = spliterator;
    }

    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
        final boolean advance = spliterator.tryAdvance(action);
        if (advance)
            iteracoes++;
        else System.out.println("Total de Iterações: " + iteracoes);
        return advance;
    }

    /**
     * Cria um objeto {@link Stream} que intercepta os acessos aos elementos de uma {@link Collection}
     * (por exemplo uma {@link List}) e conta quantos acessos tais elementos tiveram.
     * @param collection coleção a partir da qual será criada uma Stream com a capacidade de interceptar e contar
     *                   os acessos aos elementos
     * @return a Stream para processar os elementos da coleção
     * @param <T> tipo dos elementos coleção
     */
    public static <T> Stream<T> stream(final Collection<T> collection){
        final var spliterator = new Interceptor<>(collection.spliterator());
        return StreamSupport.stream(spliterator, false);
    }
}
