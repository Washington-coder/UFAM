def pertenceQ(lista, n):
    if not lista:
        return False
    elif lista[0] == n:
        return True
    else:
        return pertenceQ(lista[1:], n)

print(pertenceQ([1,2,3,4],5))
print(pertenceQ([1,2,3,4,5],5))