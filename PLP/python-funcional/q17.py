def int_matrizQ(m):
    if not m:
        return True
    
    if not int_listaQ(m[0]):
        return False

    if len(m) > 1 and len(m[0]) != len(m[1]):
        return False

    return int_matrizQ(m[1:])


def int_listaQ(lista):
    if not lista:
        return True
    elif not isinstance(lista[0], int):
        return False
    else:
        return int_listaQ(lista[1:])

print(int_matrizQ([[1,2],[4,5],[7,8]]))
print(int_matrizQ([[1,2],[4],[7,8]]))
print(int_matrizQ([[1,2],[4],7]))
