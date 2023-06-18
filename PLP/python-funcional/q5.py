def inverte_lista(lista):
    if len(lista) == 0 or len(lista) == 1:
        return lista
    else:
        ultimo_index = len(lista)-1 
        return [lista[ultimo_index]] + inverte_lista(lista[:ultimo_index])
    
print(inverte_lista([1,2,3]))
