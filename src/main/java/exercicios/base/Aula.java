package exercicios.base;

import exercicios.Estudante;
import exercicios.StudentGenerator;

import java.util.List;


/**
 * Classe abstrata base para implementação de exercícios das aulas.
 * @author Manoel Campos
 */
public abstract class Aula {
    public static final long DEFAULT_SEED = 346324523L;
    protected static final int TOTAL_ESTUDANTES = 30;
    private final StudentGenerator generator;
    private final List<Estudante> estudantes;
    /**
     * Instancia a classe usando uma semente (valor inicial para o gerador de números aleatórios) fixa.
     * Assim, a cada execução os estudantes gerados e os dados deles serão os mesmos.
     * @see StudentGenerator#StudentGenerator(long)
     */
    public Aula() {
        this(DEFAULT_SEED);
    }

    /**
     * Instancia a classe usando uma semente (valor inicial para o gerador de números aleatórios) específica.
     * Se o valor da seed for alterado entre uma execução e outra da aplicação, os estudantes gerados e os dados
     * devem mudar.
     *
     * @param seed define a semente (valor inciail) do gerador de números aleatórios.
     * @see StudentGenerator#StudentGenerator(long)
     */
    public Aula(final long seed) {
        generator = new StudentGenerator(seed);
        estudantes = generator.generate(TOTAL_ESTUDANTES);
    }

    public abstract void start();

    public StudentGenerator getGenerator() {
        return generator;
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }
}
