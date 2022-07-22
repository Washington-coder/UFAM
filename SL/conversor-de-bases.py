# ALUNO: WASHINGTON ANTONIO MORENO RIEGA
# MATRICULA: 22152254
# CURSO: CIENCIA DA COMPUTACAO

def converteBases(numero, baseOrigem, baseDestino):    
    # Vetor que guarda os resultados da função
    vetorResultado = []
    # Vetor para identificar as posições de valores literais e seus equivalentes inteiros
    DICIONARIO = [
    ["0", 0], ["1", 1], 
    ["2", 2], ["3", 3], 
    ["4", 4], ["5", 5], 
    ["6", 6], ["7", 7], 
    ["8", 8], ["9", 9],
    ["A", 10],["B", 11],
    ["C", 12],["D", 13],
    ["E", 14],["F", 15],    
]

    BASEDEZ = 10
    BASEHEXA = 16

    # Mudança de tipo das bases (STRING -> INTEIRO)
    baseOrigem = int(baseOrigem)
    baseDestino = int(baseDestino)

    # QUALQUER BASE -> DECIMAL
    # Caso as bases origem e destino forem iguais
    if baseOrigem == 10:
        vetorResultado.append(numero)
    else:
        # Caso a base origem seja Hexadecimal (HEXADECIMAL -> DECIMAL)
        if (baseOrigem == BASEHEXA):
            # Transforma um número em uma string e em seguida em um vetor com cada 
            # dígito ocupando uma posição do vetor
            listaNumero = list(str(numero))
            # Captura o tamanho da listaNumero e subtrai 1 para evitar erros de index fora do vetor
            lenLista = (len(listaNumero)-1)
            # Resultado da conversão recebe zero inicialmente
            resultadoConversao = 0
            # Percorrer a listaNumero
            for i in range(len(listaNumero)):
                # Percorrer dicionário
                for j in range(len(DICIONARIO)):
                    # Caso algum elemento da listaNumero for igual a algum valor do dicionário
                    if listaNumero[i].upper() == DICIONARIO[j][0]:
                        # Resultado da conversão recebe o valor numérico do elemento no dicionário multiplicado
                        # por dezesseis elevado a posição (Processo feito da esquerda para direita)
                        resultadoConversao += int(DICIONARIO[j][1]) * (pow(16, lenLista))
                        # Subtrai um de lenLista (tamanho da lista) a cada loop para executar o calculo corretamente
                        lenLista -= 1
            vetorResultado.append(resultadoConversao)
        # Caso a base de origem for maior que a base dez
        elif baseOrigem > BASEDEZ:
            resultadoConversao = ""
            # Divisões sucessivas até atingir o valor zero
            while numero != 0:
                # Caso a divisão seja exata
                if (numero % BASEDEZ) == 0:
                    # O resto é concatenado ao resultado
                    resultadoConversao = str(int(numero % BASEDEZ)) + resultadoConversao
                    # O número é dividido por dez para prosseguir com a divisão
                    numero = numero/BASEDEZ
                # Caso a divisão não seja exata (resto diferente de zero)
                else:
                    # O resto é concatenado ao resultado
                    resultadoConversao = str(int(numero % BASEDEZ)) + resultadoConversao
                    # O número é subtraído do seu resto e dividido por dez para continuar com as divisões
                    numero = (numero - (numero % BASEDEZ))/baseDestino
            # Concatena o resultado da conversão no vetor o resultado
            vetorResultado.append(resultadoConversao)
        # De uma base menor para base 10
        else:
            # Transforma um número em uma string e em seguida em um vetor com cada 
            # dígito ocupando uma posição do vetor
            listaNumero = list(str(numero))
            # Captura o tamanho da listaNumero e subtrai 1 para evitar erros de index fora do vetor
            lenLista = (len(listaNumero)-1)
            # Resultado da conversão recebe zero inicialmente            
            resultadoConversao = 0
            # Percorre o vetor listaNumero
            for i in range(len(listaNumero)): 
                # Resultado da conversão recebe cada elemento do vetor listaNumero 
                # multiplicado pela baseOrigem vezes a posição do número elevado a 
                # posição dele no vetor (Processo feito da esquerda para direita)
                resultadoConversao += int(listaNumero[i]) * (pow(baseOrigem, lenLista))
                # Subtrai um de lenLista (tamanho da lista) a cada loop para executar o calculo corretamente
                lenLista -= 1
            # Concatena o resultado da conversão no vetor o resultado
            vetorResultado.append(resultadoConversao)

    # BASE ORIGEM -> DESTINO
    # Caso a base destino seja Hexadecimal (DECIMAL -> HEXADECIMAL)
    if (baseDestino == BASEHEXA):
        # Valor inicial do resultado da conversão  
        resultadoConversao = ""
        # Variavel numero recebe o valor em base dez
        numero = int(vetorResultado[0])
        # Divisões sucessivas até atingir o valor zero
        while numero != 0:
            # Caso a divisão seja exata
            if (numero % 16) == 0: 
                # O resto é concatenado ao resultado
                resultadoConversao = str(numero % 16) + resultadoConversao
                # O número é dividido por dezesseis para prosseguir com a divisão
                numero = numero/16
            # Caso a divisão não seja exata
            else:
                # Percorre o DICIONARIO 
                for i in range(len(DICIONARIO)):
                    # Caso o resto do número por dezesseis seja igual a algum valor do dicionário
                    if (numero % 16) == DICIONARIO[i][1]:
                        # Concatena o valor equivalente no dicionário ao resultado
                        resultadoConversao = DICIONARIO[i][0] + resultadoConversao
                # O número é subtraído do seu resto e dividido por dezesseis para continuar com as divisões
                numero = (numero - (numero % 16))/16
        # Concatena o resultado da conversão no vetor o resultado
        vetorResultado.append(resultadoConversao)
    # De uma base maior para uma menor
    elif BASEDEZ > baseDestino:
        # Valor inicial do resultado da conversão
        resultadoConversao = ""
        # Variavel numero recebe o valor em base dez
        numero = int(vetorResultado[0])
        # Divisões sucessivas até atingir o valor zero
        while numero != 0:
            # Caso a divisão seja exata
            if (numero % baseDestino) == 0:
                # O resto é concatenado ao resultado
                resultadoConversao = str(int(numero % baseDestino)) + resultadoConversao
                # O número é dividido pela baseDestino para prosseguir com a divisão
                numero = numero/baseDestino
            # Caso a divisão não seja exata (resto diferente de zero)
            else:
                # O resto é concatenado ao resultado
                resultadoConversao = str(int(numero % baseDestino)) + resultadoConversao
                # O número é subtraído do seu resto e dividido por dez para continuar com as divisões
                numero = (numero - (numero % baseDestino))/baseDestino
        # Concatena o resultado da conversão no vetor o resultado
        vetorResultado.append(resultadoConversao)
    # De uma base menor para uma maior
    else:
        # Variavel numero recebe o valor em base dez
        numero = vetorResultado[0]
        # Transforma um número em uma string e em seguida em um vetor com cada 
        # dígito ocupando uma posição do vetor
        listaNumero = list(str(numero))
        # Captura o tamanho da listaNumero e subtrai 1 para evitar erros de index fora do vetor
        lenLista = (len(listaNumero)-1)
        # Valor inicial do resultado da conversão
        resultadoConversao = 0

        for i in range(len(listaNumero)):
            # Resultado da conversão recebe cada elemento do vetor listaNumero 
            # multiplicado pela baseOrigem vezes a posição do número elevado a 
            # posição dele no vetor (Processo feito da esquerda para direita)
            resultadoConversao += int(listaNumero[i]) * (pow(BASEDEZ, lenLista))
            # Subtrai um de lenLista (tamanho da lista) a cada loop para executar o calculo corretamente
            lenLista -= 1
        # Concatena o resultado da conversão no vetor o resultado
        vetorResultado.append(resultadoConversao)
    # Retorna o vetor resultado da função
    return vetorResultado

# Vetor resultado inicialmente vazia
resultado = []
print("\n--ENTRADAS--\n")
# Entrada do número a ser convertido
numero = input("Digite um número: ")
# Caso a entrada no número seja vazia 
if numero == "":
    # Imprime mensagem de erro
    print("\nNenhum número informado ! Execute o programa novamente.\n")
else:
    # Recebe as bases de origem e destino
    baseOrigem = input("Digite a base de origem: ")
    baseDestino = input("Digite a base de destino: ")

    # Caso a base origem ou base destino forem vazias, elas recebem 10 em string
    if baseOrigem == "":
        baseOrigem = "10"
    if baseDestino == "":
        baseDestino = "10"

    # Caso a base origem e a base destino sejam vazias, ambos recebem base dez por padrão
    if baseOrigem == "" and baseDestino == "":
        print("\n--SAIDAS--\n")
        print("Número em base 10:", numero)
        print("Número na base destino:", numero, "\n")

    else:
        # A variavel recebe o resultado da função como um vetor
        resultado = converteBases(numero, baseOrigem, baseDestino)

        # Caso base origem igual a base destino, imprime o resultado na base 10e 
        if baseOrigem == baseDestino:
            print("\n--SAIDAS--\n")
            print("Número na base 10:", resultado[0])
            print("Número na base destino (base " + baseDestino + "):", numero, "\n")            

        # Caso as bases sejam diferentes e não vazios
        else:
            print("\n--SAIDAS--\n")
            print("Número na base 10:", resultado[0])
            print("Número na base destino (base " + baseDestino + "):", resultado[1], "\n")