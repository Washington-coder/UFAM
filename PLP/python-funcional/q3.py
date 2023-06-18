def quadrados_inv(n):
    if n == 0:
        return []
    else:
        cauda = quadrados_inv(n-1)
        return [pow(n, 2)] + cauda
    
print(quadrados_inv(5))
