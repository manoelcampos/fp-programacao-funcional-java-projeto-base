package exercicios;

import exercicios.base.Aula;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Aula04Test {
    private Aula04 instance = new Aula04(Aula.DEFAULT_SEED);
    private Curso cursoMatematica;

    @BeforeEach
    void setUp() {
        cursoMatematica = instance.getGenerator().COURSES[3];
    }

    @Test
    void maiorNotaTodosEstudantes() {
        final double esperado = 9.29;
        assertEquals(esperado, instance.maiorNotaTodosEstudantes(stream()), 0.01);
    }

    @Test
    void maiorNotaHomens() {
        final double esperado = 9.22;
        assertEquals(esperado, instance.maiorNotaHomens(stream()), 0.01);
    }

    @Test
    void maiorNotaCursoMatematicaAndMulher() {
        final double esperado = 7.83;
        assertEquals(esperado, instance.maiorNotaCursoAndSexo(stream(), cursoMatematica, 'F'), 0.01);
    }

    @Test
    void mediaNotaTodosEstudantesCursoMatematica() {
        final double esperado = 4.97;
        assertEquals(esperado, instance.mediaNotaTodosEstudantesCurso(stream(), cursoMatematica), 0.01);
    }

    @Test
    void totalHomensCursoMatematica() {
        final int esperado = 2;
        assertEquals(esperado, instance.totalEstudantesCursoAndSexo(stream(), cursoMatematica, 'M'), 0.01);
    }

    @Test
    void totalMulheresCursoMatematica() {
        final int esperado = 3;
        assertEquals(esperado, instance.totalEstudantesCursoAndSexo(stream(), cursoMatematica, 'F'), 0.01);
    }

    private Stream<Estudante> stream() {
        return instance.getEstudantes().stream();
    }
}