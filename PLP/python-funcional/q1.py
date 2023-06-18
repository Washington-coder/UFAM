
def soma_nat(n):
    if (n > 0):
        return n + soma_nat(n-1)
    else:
        return 0

print(soma_nat(10))
