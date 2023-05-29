def contem_imparesQ(lista):
    if not lista:
        return True
    elif lista[0] % 2 == 0:
        return False
    else:
        return contem_imparesQ(lista[1:])

print(contem_imparesQ([3,5,7,9,11]))
print(contem_imparesQ([3,4,7,9,11]))