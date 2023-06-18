# Escreva uma função que remova o último elemento de uma lista.

dellast = lambda l: [v for idx, v in enumerate(l) if idx < len(l)-1]

resultado = dellast([1,2,3])

print(resultado)