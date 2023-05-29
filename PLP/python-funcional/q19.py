def div(m, n):
    if m < n:
        return 0
    
    return 1 + div(m - n, n)

print(div(7,2))