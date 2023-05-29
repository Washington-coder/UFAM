def intercala(w1, w2):
    if not w1:
        return w2
    if not w2:
        return w1
    
    return [w1[0], w2[0]] + intercala(w1[1:], w2[1:])

print(intercala([1,3,5],[2,4,6]))
print(intercala([1,3,5,7],[2]))