def lposicoes_indexado(w, k, index):
    if not w:
        return []
    
    if w[0] == k:
        return [index] + lposicoes_indexado(w[1:], k, index + 1)
    
    return lposicoes_indexado(w[1:], k, index + 1)

def lposicoes(w, k):    
    return lposicoes_indexado(w, k, 0)

print(lposicoes([1,2,3,4,12,2,4,3,2],2))