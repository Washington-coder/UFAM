def prim_alg(n):
    if n < 10:
        return n
    
    return prim_alg(n // 10)

print(prim_alg(8935))