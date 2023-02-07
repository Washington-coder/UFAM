instrucoes = {
    'add': 0b1000, 'shr': 0b1001,
    'shl': 0b1010, 'not': 0b1011,
    'and': 0b1100, 'or': 0b1101,
    'xor': 0b1110, 'cmp': 0b1111,
    'ld': 0b0000, 'st': 0b0001,
    'data': 0b0010, 'jmpr': 0b0011,
    'jmp': 0b0100, 'jcaez': 0b0101,
    'clf': 0b0110
}

registradores = {
    'r0': 0, 'r1': 1, 'r2': 2, 'r3': 3,
}

# 1 - Caso seja data: um registrador e um valor
# 2 - Caso seja operacao: dois registradores
# 3 - Caso seja jump: um label

hex_code = ['00' for i in range(256)]
posicao_hex_code = 0


def separar_instrucao_de_parametro(linha):
    linha = linha.split()
    return linha


def qual_tipo_de_instrução(linhaAssembly):
    if (linhaAssembly[0] == 'data'):
        return 'data'
    elif linhaAssembly[0] == 'jmp' or linhaAssembly[0] == 'jmpr' or linhaAssembly[0] == 'jcaez':
        return 'jump'
    elif linhaAssembly[0].find(':') != -1:
        return "label"
    else:
        return 'aritmetico'

def data_registrador_em_hexa(registrador):
    INSTRUCAO_HEXA = '2'
    for i in registradores:
        if registrador == i:
            INSTRUCAO_HEXA = INSTRUCAO_HEXA + str(registradores[registrador])
            return INSTRUCAO_HEXA

def valor_data_hexa(valor):
    if (len(str(valor)) == 1):
        valor = "0" + str(valor)
    if (str(valor).find('x') != -1):
        valor = str(valor).split('x')
        valor = valor[1]
    return str(valor)

# main
with open("assembly.txt", "r") as arquivo:
    codigoAssembly = arquivo.readlines()

for linha in codigoAssembly:
    linhaAssembly = separar_instrucao_de_parametro(linha)
    tipoDeInstrucao = qual_tipo_de_instrução(linhaAssembly)

    if tipoDeInstrucao == 'data': 
        parametros = linhaAssembly[1].split(',')
        registrador = parametros[0]
        valor = parametros[1]
        dataRegistrador = data_registrador_em_hexa(registrador)
        hex_code[posicao_hex_code] = dataRegistrador
        posicao_hex_code+=1
        valorData = valor_data_hexa(valor)
        hex_code[posicao_hex_code] = valorData
        posicao_hex_code+=1
    
print(hex_code)