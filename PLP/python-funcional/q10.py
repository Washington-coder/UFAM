def contem_parQ(lista):
    if not lista:
        return False
    elif lista[0] % 2 == 0:
        return True
    else:
        return contem_parQ(lista[1:])

print(contem_parQ([3,5,7,9,11]))
print(contem_parQ([3,4,7,9,11]))