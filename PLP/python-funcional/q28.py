def pos_max_aux(lista, valor_max, index_atual, lista_index_max):
    if not lista:
        return lista_index_max

    if lista[0] > valor_max:
        return pos_max_aux(lista[1:], lista[0], index_atual + 1, [index_atual])

    if lista[0] == valor_max:
        return pos_max_aux(lista[1:], valor_max, index_atual + 1, lista_index_max + [index_atual])

    return pos_max_aux(lista[1:], valor_max, index_atual + 1, lista_index_max)


def pos_max(lista):

    if not lista:
        return []

    return pos_max_aux(lista[1:], lista[0], 1, [0])


print(pos_max([1, 2, 3, 1, 2, 3]))
