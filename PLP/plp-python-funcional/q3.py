# Escreva uma função que retorne o número de zeros em uma lista.

# Primeiro a funcao verifica quem na lista 'l' eh igual a zero.
# Apos isso, esse zero eh retornado em uma lista.
# Entao a funcao retorna o len de quantos zeros entraram na lista.
nzeros = lambda l: len([x for x in l if x == 0])

resultado = nzeros([1,2,3,0,0,0])

print(resultado)