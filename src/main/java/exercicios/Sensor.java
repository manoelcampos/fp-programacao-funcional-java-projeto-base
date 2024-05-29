package exercicios;

/**
 * Um record que armazena dados de temperatura e umidade.
 * Tais dados podem ser lidos de um sensor de verdade,
 * mas aqui a classe é usada apenas para simular tal sensor.
 * Record é um tipo especial de classe introduzido no JDK 16
 * que permite criar objetos "imutáveis" (shallowly immutables).
 *
 * @param temperatura em graus celcius
 * @param umidade em percentual (entre 0 e 1)
 * @author Manoel Campos
 * @see <a href="https://docs.oracle.com/en/java/javase/16/language/records.html">Records</a>
 */
public record Sensor (double temperatura, double umidade) {
}
