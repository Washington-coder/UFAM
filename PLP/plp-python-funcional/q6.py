# Escreva uma função que, dada uma lista l e um inteiro n, é retornada uma lista sem o
# n-ésimo elemento de l. Se n é maior que o tamanho de l, l não é modificada. Por
# exemplo, removaNesimo([1,2,3,4,5,6], 3)  [1,2,4,5,6], removaNesimo([1,2,3,4,5], 42)
#  [1,2,3,4,5], removaNesimo([2,[1,2],5,[1,[7,[8,2],9],1], 3)  [2,5,[1,[7,[8,2],9],1]

deln = lambda l, n: [v for idx,v in enumerate(l) if idx != n - 1]

resultado = deln([2,2,1,4,5], 4)

print (resultado)