def comprimento(lista):
    if not lista:
        return 0
    return 1 + comprimento(lista[1:])

print(comprimento([2,3,5,2,2]))