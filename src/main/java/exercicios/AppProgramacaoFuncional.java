package exercicios;

import java.util.List;

/**
 * Aplicação de exemplo de princípios de programação funcional em Java,
 * Expressões Lambda e API de Streams do Java 8.
 * <p>
 * Para aprofundar nestes assuntos, veja os links abaixo:
 *
 * <ul>
 * <li><a href=
 * "https://www.oracle.com/technetwork/pt/articles/java/streams-api-java-8-3410098-ptb.html">Curso de Streams e Expressões Lambda do Java 8</a></li>
 * <li><a href= "http://bit.ly/2I2U5bU">Curso JDK 8 MOOC: Lambdas and Streams
 * Introduction</a></li>
 * </ul>
 *
 * @author Manoel Campos da Silva Filho
 */
public class AppProgramacaoFuncional {
    private static final int TOTAL_ESTUDANTES = 10;
    private final List<Estudante> estudantes = new StudentGenerator().generate(TOTAL_ESTUDANTES);

    public AppProgramacaoFuncional() {

    }

    public static void main(String[] args) {
        new AppProgramacaoFuncional();
    }
}

