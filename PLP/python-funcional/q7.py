def triangulo(n):
    if n == 1:
        return [[1]]
    else:
        linhas_anteriores = triangulo(n - 1)
        nova_linha = list(range(1, n + 1))
        return linhas_anteriores + [nova_linha]
    
def imprimir_linhas(triangulo):
    if not triangulo:
        return
    print(str(triangulo[0]) + ', ', end='')
    imprimir_linhas(triangulo[1:])

n = 4
resultado = triangulo(n)
imprimir_linhas(resultado)
