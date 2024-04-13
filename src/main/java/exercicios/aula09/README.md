# Lazy Evaluation: Avaliação Preguiçosa 

Lazy Evaluation é uma técnica de programação que consiste em adiar a avaliação de uma expressão (como chamada de um método) até que seu valor seja realmente necessário (se necessário). Assim, não executamos código que não precisa ser executado, economizando tempo e recursos computacionais. 

Passagem de funções / lambdas por parâmetro para outras funções é uma forma Lazy Evaluation. Em tipos como Optional de Java, temos o método orElseGet que recebe uma Supplier (um tipo de função) e só a executa tal função se nenhum valor for armazenado no Optional.

Por exemplo, considere o código abaixo:

```java
double maiorNota = estudantes.stream()                         
          .mapToDouble(Estudante::getNota)
          .filter(nota -> nota > 0)
          .map(nota -> nota*100)                   
          .max()
          .orElseGet(() -> 0);
```

A lambda (Supplier) passada para o `orElseGet` só será executada se o método `max` não encontrar nenhum estudante na lista.

No entanto, como a lista precisa ser percorrida, para verificar as notas maiores que zero e converter a nota para uma escala de 0 a 100, em Java, tais operações são feitas todas apenas no final, percorrendo a lista apenas uma vez. Este não é o caso em JavaScript, que para cada operação como filter e map, precisa percorrer a lista restante toda novamente. Como o filter pode devolver uma lista com menos elementos, essa sublista retornada precisa ser percorrida pelo map (depois que a lista original já foi percorrida totalmente pelo filter), para que o map possa converter as notas maiores que zero para escala [0..100].

Os programas nesta pasta mostram como a implementação de Streams em Java é mais eficiente por usar lazy evaluation e percorrer a lista uma única vez. Enquanto a implementação de métodos como filter, map e reduce em JavaScript percorrem a lista várias vezes.