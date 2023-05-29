def maximo(lista):
    if len(lista) == 1:
        return lista[0]
    
    if lista[0] > lista[1]:
        return maximo([lista[0]] + lista[2:])
    else:
        return maximo(lista[1:])

print(maximo([14,-1,5,19,0]))