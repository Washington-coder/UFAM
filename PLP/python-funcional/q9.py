def conta(lista, x):
    if not lista:
        return 0
    elif lista[0] == x:
        return 1 + conta(lista[1:], x)
    else:
        return conta(lista[1:], x)

print(conta([1,2,3,2,1,2],1))