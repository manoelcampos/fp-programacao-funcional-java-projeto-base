package exercicios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Aula04Test {
    private Aula04 instance = new Aula04();
    private Curso cursoMatematica;

    @BeforeEach
    void setUp() {
        cursoMatematica = instance.generator.CURSOS[3];
    }

    @Test
    void maiorNotaTodosEstudantes() {
        final double esperado = 9.54;
        assertEquals(esperado, instance.maiorNotaTodosEstudantes(stream()), 0.01);
    }

    @Test
    void maiorNotaHomens() {
        final double esperado = 9.44;
        assertEquals(esperado, instance.maiorNotaHomens(stream()), 0.01);
    }

    @Test
    void maiorNotaCursoMatematicaAndMulher() {
        final double esperado = 9.05;
        assertEquals(esperado, instance.maiorNotaCursoAndSexo(stream(), cursoMatematica, 'F'), 0.01);
    }

    @Test
    void mediaNotaTodosEstudantesCursoMatematica() {
        final double esperado = 5.62;
        assertEquals(esperado, instance.mediaNotaTodosEstudantesCurso(stream(), cursoMatematica), 0.01);
    }

    @Test
    void totalHomensCursoMatematica() {
        final int esperado = 4;
        assertEquals(esperado, instance.totalEstudantesCursoAndSexo(stream(), cursoMatematica, 'M'), 0.01);
    }

    @Test
    void totalMulheresCursoMatematica() {
        final int esperado = 4;
        assertEquals(esperado, instance.totalEstudantesCursoAndSexo(stream(), cursoMatematica, 'F'), 0.01);
    }

    private Stream<Estudante> stream() {
        return instance.estudantes.stream();
    }
}