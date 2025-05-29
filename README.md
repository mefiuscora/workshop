# Workshop 1
## Objetivo

Vamos construir um jogo onde o objetivo é o usuário acertar uma sequência de números dentro de um dado um número de tentativas.

1- API Start Game

Recebe no input dois números: quantidade de números da sequência e quantidade de tentativas;

Essa api vai iniciar o jogo:

Gera uma sequência randômica de números contendo a quantidade do input;

A API devolve 200 com uma mensagem de “Jogo Iniciado”

2- API Palpite

recebe uma lista de números.

A lista deve conter exatamente o número de tentativas;

Caso um dos números seja a sequência, retorna 200 e uma mensagem de “parabéns você acertou” e o número gerado.

Caso nenhum dos números da lista bata com a sequência randômica, devolve 404 “você perdeu”;

A lista deve conter o número de tentativas, se não devolve 400 “input errado”.

Ao final da api de input, a sequência randômica deve ser apagada para que um novo jogo possa ser iniciado.

# Desafio

## Objetivo

1- a api de palpite passa a receber uma única tentativa;

Ela devolve o número de tentativas restantes, quantos números foram corretos e quantos estão na posição certa.

Ao acertar finaliza o jogo, se esgotar as tentativas finaliza o jogo