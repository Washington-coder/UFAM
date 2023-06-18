def escolhe_pares(w):
    if not w:
        return []
    elif w[0] % 2 == 0:
        return [w[0]] + escolhe_pares(w[1:])
    else:
        return escolhe_pares(w[1:])

print(escolhe_pares([1,2,3,4,5,6,7,8]))