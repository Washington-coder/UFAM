def pos_pares_aux(lista, index_atual, resultado):
    if not lista:
        return resultado
    elif lista[0] % 2 == 0:
        resultado.append(index_atual)
    
    return pos_pares_aux(lista[1:], index_atual + 1, resultado)

def pos_pares(w):
    if not w:
        return []
    
    return [pos_pares_aux(w[0], 0, [])] + pos_pares(w[1:])

print(pos_pares([[1,2,3],[4,5,6],[7,8,9,10]]))