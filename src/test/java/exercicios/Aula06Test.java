package exercicios;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Aula06Test {
    private final Aula06 instance = new Aula06();

    private List<Estudante> callGetList(final Function<Aula06, List<Estudante>> getListMethod) {
        final var msg = "A chamada do método para obter a lista não deveria lançar NullPointerException. Você precisa definir um predicado composto para o atributo mulheresAprovadas no lugar de null.";
        return assertDoesNotThrow(() -> getListMethod.apply(instance), msg);
    }

    private static void checkListIsUnmodifiable(final List<Estudante> list) {
        final var ex = UnsupportedOperationException.class;
        final var msg = "Uma %s deveria ter sido lançada ao tentar limpar a lista retornada pelo método, indicando que a lista é não-modificável";
        assertThrows(ex, list::clear, msg.formatted(ex.getSimpleName()));
    }

    @Test
    void getEstudantesMulheresAprovadasRetornaOsEstudantesEsperados() {
        final var listaObtida = callGetList(Aula06::getEstudantesMulheresAprovadas);
        final Integer[] idArrayObtido = listaObtida.stream().map(Estudante::getId).toArray(Integer[]::new);
        final Integer[] idArrayEsperado = {1, 5, 15, 7, 8, 9, 6, 21, 26, 29};

        assertThat(idArrayObtido, Matchers.arrayContainingInAnyOrder(idArrayEsperado));
        checkListIsUnmodifiable(listaObtida);
    }

    @Test
    void getEstudantesMulheresAprovadasNaoOrdenadasModificavel() {
        final var listaObtida = callGetList(Aula06::getEstudantesMulheresAprovadasNaoOrdenadasModificavel);
        final Integer[] idArrayObtido = listaObtida.stream().map(Estudante::getId).toArray(Integer[]::new);
        final Integer[] idArrayEsperado = {1, 5, 6, 7, 8, 9, 15, 21, 26, 29};

        assertThat(idArrayObtido, Matchers.arrayContainingInAnyOrder(idArrayEsperado));
        assertDoesNotThrow(listaObtida::clear, "A lista retornada deveria ser modificável");
    }

    @Test
    void getEstudantesMulheresAprovadasOrdenadasPorCursoAndNota(){
        final var listaObtida = callGetList(Aula06::getEstudantesMulheresAprovadasOrdenadasPorCursoAndNota);
        final Integer[] idArrayObtido = listaObtida.stream().map(Estudante::getId).toArray(Integer[]::new);
        final Integer[] idArrayEsperado = {5, 15, 29, 9, 7, 26, 8, 21, 6, 1};
        final var msg = "A lista retornada deveria estar ordenada por nome do curso e nota";
        assertThat(msg, idArrayObtido, Matchers.arrayContaining(idArrayEsperado));
        checkListIsUnmodifiable(listaObtida);
    }

    @Test
    void getEstudantesMulheresAprovadasOrdenadasPorCursoDecrescenteAndNotaCrescente(){
        final var listaObtida = callGetList(Aula06::getEstudantesMulheresAprovadasOrdenadasPorCursoDecrescenteAndNotaCrescente);
        final Integer[] idArrayObtido = listaObtida.stream().map(Estudante::getId).toArray(Integer[]::new);
        final Integer[] idArrayEsperado = {21, 6, 1, 8, 7, 26, 15, 29, 9, 5};
        final var msg = "A lista retornada deveria estar em ordem decrescente por nome do curso e crescente por nota";
        assertThat(msg, idArrayObtido, Matchers.arrayContaining(idArrayEsperado));
        checkListIsUnmodifiable(listaObtida);
    }

    @Test
    void getEstudantesMulheresAprovadasOrdenadasTotalmenteDecrescente(){
        final var listaObtida = callGetList(Aula06::getEstudantesMulheresAprovadasOrdenadasTotalmenteDecrescente);
        final Integer[] idArrayObtido = listaObtida.stream().map(Estudante::getId).toArray(Integer[]::new);
        final Integer[] idArrayEsperado = {1, 6, 21, 8, 26, 7, 9, 29, 15, 5};
        final var msg = "A lista retornada deveria estar em ordem decrescente tanto por curso quanto por nota";
        assertThat(msg, idArrayObtido, Matchers.arrayContaining(idArrayEsperado));
        checkListIsUnmodifiable(listaObtida);
    }

    @Test
    void getEstudantesMulheresAprovadasOrdenadasPorCursoCrescenteAndNotaDecrescente(){
        final var listaObtida = callGetList(Aula06::getEstudantesMulheresAprovadasOrdenadasPorCursoCrescenteAndNotaDecrescente);
        final Integer[] idArrayObtido = listaObtida.stream().map(Estudante::getId).toArray(Integer[]::new);
        final Integer[] idArrayEsperado = {5, 9, 29, 15, 26, 7, 8, 1, 6, 21};
        final var msg = "A lista retornada deveria estar em ordem crescente por nome do curso e descrescente pela nota";
        assertThat(msg, idArrayObtido, Matchers.arrayContaining(idArrayEsperado));
        checkListIsUnmodifiable(listaObtida);
    }
}