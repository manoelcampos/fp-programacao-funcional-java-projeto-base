let iteracoes = 0;

export const getIteracoes = () => iteracoes;

/**
 * Cria um Proxy para interceptar os acessos aos elementos de um determinado vetor.
 * e contar quantas vezes tais elementos foram acessados.
 * @param array vetor para interceptar os acessos aos seus elementos
 * @returns {Array} vetor que intercepta os acessos aos seus elementos
 */
export const newArray = (array) => new Proxy(array, {
    get: function (target, prop) {
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
    return newArray(this.originalMap(callback, thisArg));
}

Array.prototype.filter = function (callback, thisArg) {
    return newArray(this.originalFilter(callback, thisArg));
}

Array.prototype.originalReduce = function (callback, initialValue) {
    return newArray(this.originalReduce(callback, initialValue));
}
