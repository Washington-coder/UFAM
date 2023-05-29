def int_lista_listaQ(lista):
    if not lista:
        return True
    elif not isinstance(lista[0], list):
        return False
    elif not int_listaQ(lista[0]):
        return False
    else:
        return int_lista_listaQ(lista[1:])

def int_listaQ(lista):
    if not lista:
        return True
    elif not isinstance(lista[0], int):
        return False
    else:
        return int_listaQ(lista[1:])

print(int_lista_listaQ([[1,2,3],[4,5,6]]))
print(int_lista_listaQ([[1,2,3],["ola",3]]))
print(int_lista_listaQ([1,[1,2,3],[4,5,6]]))