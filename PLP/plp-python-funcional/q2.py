# Escreva uma função recursiva que, dados dois parâmetros numéricos, x e y, retorne xy

potencia = lambda x, y: 1 if y == 0 else x * potencia(x, y-1)

resultado = potencia(3,2)

print(resultado)