package exercicios;

/**
 * Um record que armazena dados de temperatura e umidade.
 * Tais dados podem ser lidos de um sensor de verdade,
 * mas aqui a classe é usada apenas para simular tal sensor.
 * @param temperatura em graus celcius
 * @param umidade em percentual (entre 0 e 1)
 * @author Manoel Campos
 */
public record Sensor (double temperatura, double umidade) {
}
