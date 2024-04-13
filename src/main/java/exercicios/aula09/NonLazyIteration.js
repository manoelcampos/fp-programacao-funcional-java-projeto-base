
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
Array.prototype.originalFilter = Array.prototype.filter;
Array.prototype.originalReduce = Array.prototype.reduce;

Array.prototype.map = function (callback, thisArg) {
    return newProxyArray(this.originalMap(callback, thisArg));
}

Array.prototype.filter = function (callback, thisArg) {
    return newProxyArray(this.originalFilter(callback, thisArg));
}

Array.prototype.originalReduce = function (callback, initialValue) {
    return newProxyArray(this.originalReduce(callback, initialValue));
}

// --------------------------------------------------------------------------

/*
Percorre um determinado vetor, executando operações como filter e map,
e mostra ao final o total de vezes que os elementos do vetor foram acessados
(total de vezes que o vetor foi percorrido).
*/
const numeros = newProxyArray([-4, -3, -2, -1, 0, 1, 2, 3, 4, 5]);
const soma =
    numeros
        .filter(n => n >= 0)
        .map(n => n * 2)
        .reduce((subtotal, n) => subtotal + n);

console.log(`JS -> Soma: ${soma} Tamanho do vetor: ${numeros.length} Iterações: ${iteracoes}`);
