package exercicios;

import exercicios.base.Aula;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.stream.Stream;

import static java.util.Locale.filter;

/**
 * Esta é uma classe para você poder implementar as atividades propostas no README.
 * Você NÃO deve alterar a estrutura deste arquivo,
 * não pode alterar o nome da classe, dos métodos ou dos atributos,
 * não pode alterar valores dos atributos existentes,
 * nem pode alterar parâmetros e tipo de retorno dos métodos.
 *
 * <p>Você pode alterar o código interno dos métodos, criar métodos auxiliares que podem ser chamados
 * pelos existentes, mas não deve alterar a estrutura dos métodos disponíveis.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
@NoArgsConstructor
public class Aula04 extends Aula {

    /**
     * Veja o método {@link #start()}.
     */
    public static void main(String[] args) {
        new Aula04().start();
    }

    /**
     * Você pode chamar os métodos existentes e outros que você criar aqui,
     * incluir prints e fazer o que desejar neste método para verificar os valores retornados pelo seu método.
     * Para verificar se sua implementação está correta, clique com o botão direito no nome do projeto na aba esquerda
     * do IntelliJ e selecione a opção "Run 'All Tests'".
     */
    @Override
    public void start() {
        final var curso = getGenerator().COURSES[3];
        final char homem = 'M';
        final char mulher = 'F';

        System.out.printf("Maior nota de todos os Estudantes: %.2f%n", maiorNotaTodosEstudantes(getEstudantes().stream()));
        System.out.printf("Maior nota dos Estudantes homens: %.2f%n", maiorNotaHomens(getEstudantes().stream()));
        System.out.printf("Maior nota das mulheres do curso de %s: %.2f%n", curso.getNome(), maiorNotaCursoAndSexo(getEstudantes().stream(), curso, mulher));
        System.out.printf("Média de notas dos Estudantes do curso de %s: %.2f%n", curso.getNome(), mediaNotaTodosEstudantesCurso(getEstudantes().stream(), curso));
        System.out.printf("Total dos homens do curso de %s: %d%n", curso.getNome(), totalEstudantesCursoAndSexo(getEstudantes().stream(), curso, homem));
        System.out.printf("Total das mulheres do curso de %s: %d%n", curso.getNome(), totalEstudantesCursoAndSexo(getEstudantes().stream(), curso, mulher));
    }

    protected double maiorNotaCursoAndSexo(@NonNull final Stream<Estudante> stream, @NonNull final Curso curso, final char sexo) {
        // TODO: Você precisa implementar este método. Apague estas linhas e escreva o código correto.
        final double maiorNotaCursoAndSexo =
            getEstudantes().stream()
                .filter(estudante -> curso.equals(estudante.getCurso()) && estudante.getSexo() == sexo)
                .mapToDouble(Estudante::getNota)
                .max()
                .orElse(0.0);
        return maiorNotaCursoAndSexo;
    }

    protected long totalEstudantesCursoAndSexo(@NonNull final Stream<Estudante> stream, @NonNull final Curso curso, final char sexo) {
        // TODO: Você precisa implementar este método. Apague estas linhas e escreva o código correto.
        final long totalEstudantesCursoAndSexo =
                getEstudantes().stream()
                    .filter(estudante -> curso.equals(estudante.getCurso()) && estudante.getSexo() == sexo)
                    .count();
        return totalEstudantesCursoAndSexo;
    }

    protected double mediaNotaTodosEstudantesCurso(@NonNull final Stream<Estudante> stream, @NonNull final Curso curso){
        // TODO: Você precisa implementar este método. Apague estas linhas e escreva o código correto.
        final double mediaNotaTodosEStudantesCurso =
            getEstudantes().stream()
                    .filter(estudante -> curso.equals(estudante.getCurso()))
                    .mapToDouble(Estudante::getNota)
                    .average()
                    .orElse(0.0);
        return mediaNotaTodosEStudantesCurso;
    }

    protected double maiorNotaTodosEstudantes(@NonNull final Stream<Estudante> stream){
        // TODO: Você precisa implementar este método. Apague estas linhas e escreva o código correto.
        final double maiorNotaTodosEstudantes =
            getEstudantes().stream()
                .mapToDouble(Estudante::getNota)
                .max()
                .orElse(0.0);
        return maiorNotaTodosEstudantes;
    }


    protected double maiorNotaHomens(@NonNull final Stream<Estudante> stream){
        // TODO: Você precisa implementar este método. Apague estas linhas e escreva o código correto.
        final double maiorNotaHomens =
            getEstudantes().stream()
                .filter(estudante -> estudante.getSexo() == 'M')
                .mapToDouble(Estudante::getNota)
                .max()
                .orElse(0.0);
        return maiorNotaHomens;
    }

    Aula04(final long seed) { super(seed); }
}

