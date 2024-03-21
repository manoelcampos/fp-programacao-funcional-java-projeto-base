package exercicios;

import exercicios.base.Aula;
import lombok.NonNull;

import java.util.stream.Stream;

/**
 * Esta é uma classe para você poder implementar as atividades propostas no README.
 * Você <b>NÃO</b> deve alterar:
 * <ul>
 *     <li>a estrutura deste arquivo;</li>
 *     <li>o nome da classe, dos métodos ou dos atributos;</li>
 *     <li>parâmetros e tipo de retorno dos métodos.</li>
 * </ul>
 *
 * <p>Você pode alterar o código interno dos métodos, criar métodos auxiliares que podem ser chamados
 * pelos existentes, mas não deve alterar a estrutura dos métodos disponíveis.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
public class Aula04 extends Aula {

    /**
     * Você pode chamar os métodos existentes e outros que você criar aqui,
     * incluir prints e fazer o que desejar neste método para conferir os valores retornados pelo seu método.
     * Para verificar se sua implementação está correta, clique com o botão direito no nome do projeto na aba esquerda
     * do IntelliJ e selecione a opção "Run All Tests".
     */
    public Aula04() {
        final var curso = generator.COURSES[3];
        final char homem = 'M';
        final char mulher = 'F';

        System.out.printf("Maior nota de todos os Estudantes: %.2f%n", maiorNotaTodosEstudantes(estudantes.stream()));
        System.out.printf("Maior nota dos Estudantes homens: %.2f%n", maiorNotaHomens(estudantes.stream()));
        System.out.printf("Maior nota das mulheres do curso de %s: %.2f%n", curso.getNome(), maiorNotaCursoAndSexo(estudantes.stream(), curso, mulher));
        System.out.printf("Média de notas dos Estudantes do curso de %s: %.2f%n", curso.getNome(), mediaNotaTodosEstudantesCurso(estudantes.stream(), curso));
        System.out.printf("Total dos homens do curso de %s: %d%n", curso.getNome(), totalEstudantesCursoAndSexo(estudantes.stream(), curso, homem));
        System.out.printf("Total das mulheres do curso de %s: %d%n", curso.getNome(), totalEstudantesCursoAndSexo(estudantes.stream(), curso, mulher));
    }

    /**
     * Veja o método construtor {@link #Aula04()}.
     */
    public static void main(String[] args) {
        new Aula04();
    }

    protected double maiorNotaCursoAndSexo(@NonNull final Stream<Estudante> stream, @NonNull final Curso curso, final char sexo) {
        // TODO: Você precisa implementar este método. Apague estas linhas e escreva o código correto.
        return -1;
    }

    protected long totalEstudantesCursoAndSexo(@NonNull final Stream<Estudante> stream, @NonNull final Curso curso, final char sexo) {
        // TODO: Você precisa implementar este método. Apague estas linhas e escreva o código correto.
        return -1;
    }

    protected double mediaNotaTodosEstudantesCurso(@NonNull final Stream<Estudante> stream, @NonNull final Curso curso){
        // TODO: Você precisa implementar este método. Apague estas linhas e escreva o código correto.
        return -1;
    }

    protected double maiorNotaTodosEstudantes(@NonNull final Stream<Estudante> stream){
        // TODO: Você precisa implementar este método. Apague estas linhas e escreva o código correto.
        return -1;
    }


    protected double maiorNotaHomens(@NonNull final Stream<Estudante> stream){
        // TODO: Você precisa implementar este método. Apague estas linhas e escreva o código correto.
        return -1;
    }
}

