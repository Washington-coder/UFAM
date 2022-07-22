# ALUNO1: WASHINGTON ANTONIO MORENO RIEGA; MATRICULA: 22152254;
# ALUNO2: MATHEUS SOUZA DE OLIVEIRA; MATRICULA: 22153438;
# CURSO: CIENCIA DA COMPUTAÇÃO

from random import randrange
import os

# Transforma de complemento de 2 para decimal
def binarioParaDecimal(numero):
    numero = list(numero)
    resultado = 0
    lenNumero = (len(numero)-1)

    for i in range(len(numero)):
        numero[i] = int(numero[i])

    if numero == [1,0,0,0]:
        resultado = -8
        return resultado

    elif (numero[0] == 0):
        # transformacao normal
        for i in range(len(numero)):
            numero[i] = int(numero[i])
            resultado += int(numero[i]) * pow(2, lenNumero)
            lenNumero -= 1

        return resultado

    elif (numero[0] == 1):
        # OK complemento de 1 
        for i in range(len(numero)):
            if numero[i] == 1:
                numero[i] = 0
            elif numero[i] == 0:
                numero[i] = 1

        # Adição por 1
        numero[len(numero)-1] += 1

        for i in range((len(numero)-1), -1, -1):
            if numero[i] == 2:
                numero[i] = 0
                if i != 0:
                    numero[i-1] = int(numero[i-1])
                    numero[i-1] += 1

            elif numero[i] == 3:
                numero[i] = 1
                if i != 0:
                    numero[i-1] = int(numero[i-1])
                    numero[i-1] += 1
        
        resultado = (binarioParaDecimal(numero) * -1)

        return resultado
            

# Sortear um número aletório
def sorteiaNumeroAleatorio():
    return randrange(-8, 7)

# Faz divisões sucessivas (decimal para binário)
def divisoesSecessivas (numero):
    resultado = ""

    while numero != 0:
        if numero % 2 == 0:
            resultado = str(int(numero % 2)) + resultado
            numero = numero/2
        else:
            resultado = str(int(numero % 2)) + resultado
            numero = (numero - (numero % 2))/2

    return resultado

# Transforma decimal para binario e complemento de 2
def decimalParaBinario (numero):
    resultado = ""

    if numero == 0:
        resultado = "0000"
        return resultado

    # Transformação de decimal para binário tradicional
    elif numero > 0:
        resultado = divisoesSecessivas(numero)

        if len(resultado) != 4:
            resultado = ((4 - len(resultado)) * "0") + resultado

    # Complemento de dois  
    elif numero < 0:
        numero = numero * -1
        resultado = divisoesSecessivas(numero)

        # Adicionando zero nas demais posiçoes que faltam elementos
        if len(resultado) != 4:
            resultado = ((4 - len(resultado)) * "0") + resultado
        
        # Complemento de 1
        resultado = list(resultado)
        for i in range(len(resultado)):
            if resultado[i] == "1":
                resultado[i] = "0"
            elif resultado[i] == "0":
                resultado[i] = "1"

        # Somando mais 1
        resultado[len(resultado)-1] = int(resultado[len(resultado)-1])
        resultado[len(resultado)-1] += 1
        for i in range((len(resultado)-1), -1, -1):
            resultado[i] = int(resultado[i])
            if resultado[i] == 2:
                resultado[i] = 0
                if i != 0:
                    resultado[i-1] = int(resultado[i-1])
                    resultado[i-1] += 1

            elif resultado[i] == 3:
                resultado[i] = 1
                if i != 0:
                    resultado[i-1] = int(resultado[i-1])
                    resultado[i-1] += 1

    return resultado


# Soma de dois binários
def somaBinarios(b1, resultado):

    # Tranformando caracteres para inteiros
    for i in range(len(resultado)):
        resultado[i] = int(resultado[i])
    for i in range(len(b1)):
        b1[i] = int(b1[i])

    # Soma dos binários (Comportamento circular)
    for i in range((len(resultado)-1), -1, -1):
        for j in range((len(b1)-1), -1, -1):
            if i == j:
                resultado[i] += b1[i]
                if resultado[i] == 2:
                    resultado[i] = 0
                    if i != 0:
                        resultado[i-1] += 1

                elif resultado[i] == 3:
                    resultado[i] = 1
                    if i != 0:
                        resultado[i-1] += 1

    return resultado

# Função principal do jogo roda da fortuna
def roda_da_fortuna(fortuna_infortunio, tentativas):
    continuaJogo = True
    tentativas = 3
    continuaJogoPergunta = "C"

    # Condição de loop do jogo (parada pelo usuário) ou (três tentativas)
    while ((continuaJogo == True) and (tentativas >= 0)):
        # Caso o usuário queira continuar
        if continuaJogoPergunta.upper() == "C":
            print("Você possue", tentativas, "tentativas")
            numeroAleatorio = sorteiaNumeroAleatorio()
            numeroAleatorio = decimalParaBinario(numeroAleatorio)
            fortuna_infortunio = decimalParaBinario(fortuna_infortunio)
            numeroAleatorio = list(numeroAleatorio)
            fortuna_infortunio = list(fortuna_infortunio)
            fortuna_infortunio = somaBinarios(fortuna_infortunio, numeroAleatorio)
            fortuna_infortunio = binarioParaDecimal(fortuna_infortunio)
            if fortuna_infortunio >= 0:
                print("\nFortuna! fortuna_infortunio")
            elif fortuna_infortunio < 0:
                print("\nInfortúnio! fortuna_infortunio")
            print("\nO número da rodada é", fortuna_infortunio)
            continuaJogoPergunta = input("\nDigite 'c' para continuar ou 'p' para parar: ")
            os.system('cls')
            tentativas -= 1

        # Caso o usuário queira parar
        elif continuaJogoPergunta.upper() == "P":
            print("\nVocê desistiu. Fim de jogo.")
            if fortuna_infortunio > 0:
                print("\nFortuna! fortuna_infortunio")
            elif fortuna_infortunio < 0:
                print("\nInfortúnio! fortuna_infortunio")
            print("\nO número da rodada era", fortuna_infortunio, "\n")
            
            continuaJogo = False
            return fortuna_infortunio
    
    return fortuna_infortunio

sua_sorte = sorteiaNumeroAleatorio()
fortuna_infortunio = sua_sorte

print("\n-----Roda da Fortuna ou Infortúnio-----\n")
print("1 - Você tem 3 tentativas para jogar")
print("2 - Um número aleatório inicial será gerado")
print("3 - A cada rodada seu número atual será somado a um número aleatório")
print("4 - Caso esse número seja positivo você ganha Fortuna")
print("5 - Caso esse número seja negativo você ganha Infortúnio")

print("\nSeu número inicial é:", fortuna_infortunio)

continuaJogo = input("\nDigite 'j' se quiser jogar ou 'd' para desistir: ")
os.system('cls')

# Condição para começar a jogar
if (continuaJogo.upper() == "J"):
    print("\nFortuna ou Infortúnio! O que será?\n")
    tentativas = 3
    fortuna_infortunio = roda_da_fortuna(fortuna_infortunio, tentativas)

# Condição para desistir do jogo
elif (continuaJogo.upper() == "D"):
    print("\nFim de jogo. Você desistiu.\n")