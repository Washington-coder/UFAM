def retira_negativos(lista):
    if not lista:
        return []
    
    if lista[0] >= 0:
        return [lista[0]] + retira_negativos(lista[1:])
    
    return retira_negativos(lista[1:])

print(retira_negativos([1,2,3,-4,5,-6]))