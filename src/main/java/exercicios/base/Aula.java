package exercicios.base;

import exercicios.Estudante;
import exercicios.StudentGenerator;

import java.util.List;


/**
 * Classe abstrata base para implementação de exercícios das aulas.
 * @author Manoel Campos
 */
public abstract class Aula {
    public static final long DEFAULT_SEED = 3463245213L;
    protected static final int TOTAL_ESTUDANTES = 30;
    public final StudentGenerator generator;
    public final List<Estudante> estudantes;

    public Aula() {
        generator = new StudentGenerator(DEFAULT_SEED);
        estudantes = generator.generate(TOTAL_ESTUDANTES);
    }
}
