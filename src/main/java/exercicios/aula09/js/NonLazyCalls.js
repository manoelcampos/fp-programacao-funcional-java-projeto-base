import {getIteracoes, newArray} from './NewArray.js';

const numeros = newArray([-4, -3, -2, -1, 0, 1, 2, 3, 4, 5]);

/**
 * Veja a documentação do LazyCalss.java para mais detalhes.
 * Este código faz exatamente a mesma coisa que a versão em Java,
 * mas JavaScript não usa Lazy Evaluation em operações
 * como map, filter e reduce.
 *
 * O código abaixo poderia simplesmente ser substituído por const totalNumeros = numeros.length,
 * mas foi feito da forma como está para demonstrar como, mesmo que as operações map não façam sentido,
 * o vetor será percorrido e elas serão executadas inevitalmente em JavaScript.
 */
const totalNumeros =
    numeros
        .map(n => {
            console.log(`map1: Math.abs(${n})`)
            return Math.abs(n);
        })
        .map(n => {
            console.log(`map2: ${n} * 100`)
            return n * 100;

        })
        .length;

console.log(`JS -> Tamanho do vetor: ${numeros.length}`);
console.log(`Total de Números Obtidos na chamada acima: ${totalNumeros}`);
console.log(`Iterações no vetor: ${getIteracoes()}`);
