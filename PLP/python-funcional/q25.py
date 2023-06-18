def apaga(w, k):
    if not w:
        return []
    
    if w[0] == k:
        return apaga(w[1:], k)
    
    return [w[0]] + apaga(w[1:], k)

print(apaga([1,2,1,3,1,4,1,5],1))
