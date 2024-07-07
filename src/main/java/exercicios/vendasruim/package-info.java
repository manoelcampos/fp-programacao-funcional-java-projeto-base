/**
 * Mostra uma forma ruim de declarar funções
 * como variáveis locais, como é o caso das variáveis
 * {@code descontoProgressivo} e {@code descontoFixo},
 * declaradas como do tipo {@link java.util.function.Function}.
 *
 * <p>Apesar de ser perfeitamente válido e útil declarar funções
 * como variáveis locais, se tais funções representam regras
 * de negócio importantes e que podem ser reutilizadas em outras
 * partes do código, declará-las como variáveis locais é a pior coisa que você pode fazer.
 * Isso impedirá seu reuso e ainda parecerá que é apenas uma lógica
 * simples, sem muita importância, por estar localmente dentro de um método qualquer.
 * Adicionalmente, coloar regras de negócio importantes em variáveis locais,
 * torna difícil para outros desenvolvedores localizarem tais implementações.</p>
 *
 * <p>Veja o pacote {@link exercicios.vendas} para uma implementação mais adequada.</p>
 *
 * @author Manoel Campos
 * @see exercicios.vendasruim.RealizaVendaRuim
 */
package exercicios.vendasruim;