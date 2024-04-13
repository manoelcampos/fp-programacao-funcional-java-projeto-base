
let iteracoes = 0;

/**
 * Cria um Proxy para interceptar os acessos aos elementos de um determinado vetor.
 * e contar quantas vezes tais elementos foram acessados.
 * @param array vetor para interceptar os acessos aos seus elementos
 * @returns {Array} vetor que intercepta os acessos aos seus elementos
 */
const newProxyArray = (array) => new Proxy(array, {
    get: function(target, prop) {
        /*
        Se a função get foi chamada passando-se um número, indica que
        está sendo solicitado o acesso a um elemento do vetor.
        Assim, ao chamar array[1], prop será 1, indicando isso.
        */
        if (!isNaN(prop)) {
            iteracoes++;
        }

        return target[prop];
    }
});

Array.prototype.originalMap = Array.prototype.map;

Array.prototype.map = function (callback, thisArg) {
    return newProxyArray(this.originalMap(callback, thisArg));
}

// --------------------------------------------------------------------------

const numeros = newProxyArray([-4, -3, -2, -1, 0, 1, 2, 3, 4, 5]);

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
            console.log(`map: Math.abs(${n})`)
            return Math.abs(n);
        })
        .map(n => {
            console.log(`map: ${n} * 100`)
            return n * 100;

        })
        .length;

console.log(`JS -> Tamanho do vetor: ${numeros.length} Total de Números Obtidos na chamada acima: ${totalNumeros} Iterações no vetor: ${iteracoes}`);
