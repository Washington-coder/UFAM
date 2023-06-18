# Escreva uma função que retorne o maior e o menor número de uma lista

from functools import reduce

maxmin = lambda l: (reduce(lambda x, y: x if x > y else y, l), reduce(lambda x, y: x if x < y else y, l))

resultado = maxmin([1,2,3,4,5])

print (resultado)