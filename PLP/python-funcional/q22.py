def permutacao(w1, w2):
    if len(w1) != len(w2):
        return False
    
    if len(w1) == 0:
        return True
    
    if w1[0] in w2:
        w2.remove(w1[0])
        return permutacao(w1[1:], w2)
    else:
        return False

print(permutacao([1,2,3],[3,2,1]))
print(permutacao([1,1,2,3],[3,2,1]))