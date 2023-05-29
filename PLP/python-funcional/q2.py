def quadrados(n):
    if n == 0:
        return []
    else:
        cauda = quadrados(n-1)
        return cauda + [pow(n, 2)]
    
print(quadrados(5))
