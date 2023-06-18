def media_digitos(n):
    soma_digitos = soma_dos_digitos(n)
    qtd_digitos = contar_digitos(n)
    return soma_digitos / qtd_digitos

def soma_dos_digitos(n):
    if n < 10:
        return n
    
    return n % 10 + soma_dos_digitos(n // 10)

def contar_digitos(n):
    if n < 10:
        return 1
    
    return 1 + contar_digitos(n // 10)

print(media_digitos(14276))
