def indices_pares(lista):
    if len(lista) <= 1:
        return lista
    else:
        return [lista[0]] + indices_pares(lista[2:])


print(indices_pares([4, 3, 7, 1, 2, 9]))
