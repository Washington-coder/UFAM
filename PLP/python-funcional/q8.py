def prod_lista(lista):
    if not lista:
        return 1
    else:
        return lista[0] * prod_lista(lista[1:])

print(prod_lista([2, 4, 6]))
print(prod_lista([]))