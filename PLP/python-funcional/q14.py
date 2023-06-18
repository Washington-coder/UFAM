def nat_listaQ(lista):
    if not lista:
        return True
    elif not isinstance(lista[0], int) or lista[0] < 0:
        return False
    else:
        return nat_listaQ(lista[1:])

print(nat_listaQ([1,2,3,-1]))
print(nat_listaQ([1,2,3,4]))