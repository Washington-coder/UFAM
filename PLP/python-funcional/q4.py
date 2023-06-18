def soma_divisores(num, divisor):
    if divisor == 1:
        return 1
    elif num % divisor == 0:
        return divisor + soma_divisores(num, divisor - 1)
    else:
        return soma_divisores(num, divisor - 1)

def num_perf(n):
    return soma_divisores(n, n - 1) == n

print(num_perf(6))
print(num_perf(5))
