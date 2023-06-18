def int_listaQ(lista):
    if not lista:
        return True
    elif not isinstance(lista[0], int):
        return False
    else:
        return int_listaQ(lista[1:])

print(int_listaQ([1,2,-3,4,9]))
print(int_listaQ([1.1,3,-3]))