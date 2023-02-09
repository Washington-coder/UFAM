instrucoes = {
    'add': 8, 'shr': 9,
    'shl': 'a', 'not': 'b',
    'and': 'c', 'or': 'd',
    'xor': 'e', 'cmp': 'f',
    'ld': 0, 'st': 1,
    'data': 2, 'jmpr': 3,
    'jmp': '40', 'jcaez': 5,
    'jae': '56','clf': 6,
    'halt': '40'
}

registradores = {
    'r0': 0, 'r1': 1, 'r2': 2, 'r3': 3,
}

labels = {}

codigoHexa = ['00' for i in range(256)]
indexCodigoHexa = 0


def separar_instrucao_de_parametro(linha):
    linha = linha.split()
    return linha

def preenche_endereco_labels(codigoAssembly):
    addr = 0
    for linha in codigoAssembly:
        linhaAssembly = separar_instrucao_de_parametro(linha)
        tipoDeInstrucao = linhaAssembly[0]

        if (tipoDeInstrucao.find(':') != -1):
            label = linhaAssembly[0].split(':')
            labels.update({label[0]:hex(addr)})
        elif (tipoDeInstrucao == 'jmp'):
            addr += 2
        elif (tipoDeInstrucao == 'jae'):
            addr += 2
        elif (tipoDeInstrucao == 'halt'):
            addr += 2
        elif (tipoDeInstrucao == 'data'):
            addr += 2
        elif (tipoDeInstrucao == 'st'):
            addr += 1
        elif (tipoDeInstrucao == 'add'):
            addr += 1
        elif (tipoDeInstrucao == 'shl'):
            addr += 1
        elif (tipoDeInstrucao == 'shr'):
            addr += 1
        elif (tipoDeInstrucao == 'not'):
            addr += 1
        elif (tipoDeInstrucao == 'and'):
            addr += 1
        elif (tipoDeInstrucao == 'or'):
            addr += 1
        elif (tipoDeInstrucao == 'xor'):
            addr += 1
        elif (tipoDeInstrucao == 'cmp'):
            addr += 1

def busca_endereco(endereco):
    byte = ''
    if (endereco.find('x') != -1):
        endereco = endereco.split('x')
        byte = endereco[1]
    else:
        if endereco in labels:
            byte = labels[endereco]
            byte = byte.split('x')
            byte = byte[1]
            if len(str(byte)) == 1:
                byte = '0' + str(byte)
        else:
            exit('Não existe esse label: ' + str(endereco))
    return byte

def insere_tipo_J(endereco, nomeDaInstrucao, indexCodigoHexa, codigoHexa):
    byte1 = instrucoes[nomeDaInstrucao]
    byte2 = busca_endereco(endereco)
    codigoHexa[indexCodigoHexa] = byte1
    indexCodigoHexa += 1
    codigoHexa[indexCodigoHexa] = byte2
    indexCodigoHexa += 1

def split_hexa(hexa):
    hexa = hexa.split('x')
    hexa = hexa[1]
    return hexa

def split_parametros(parametros):
    parametros = parametros.split(',')
    return parametros

def insere_tipo_Data(parametros, nomeDaInstrucao, indexCodigoHexa, codigoHexa):
    byte1 = instrucoes[nomeDaInstrucao]
    registrador = str(parametros[0])
    valor = parametros[1]
    
    # Valida tanto o uso de registradores quanto o de enderecos
    if registrador in registradores:
        registrador = registradores[registrador]
    elif registrador.find('x') != -1:
        registrador = split_hexa(registrador)
    else:
        exit('Registrador não existe')
    
    # Valida uso de valores em hexa
    if valor.find('x') != -1:
        valor = split_hexa(valor)
    else:
        valor = split_hexa(hex(int(valor)))

    if len(str(valor)) == 1:
        valor = '0' + str(valor)

    byte1 = str(byte1) + str(registrador)
    byte2 = valor

    codigoHexa[indexCodigoHexa] = byte1
    indexCodigoHexa += 1
    codigoHexa[indexCodigoHexa] = byte2
    indexCodigoHexa += 1

def split_binary(binary):
    binary = binary.split('b')
    binary = binary[1]
    return binary

def passa_registradores_hexa(parametros):
    registrador1 = split_binary(bin(registradores[parametros[0]]))
    registrador2 = split_binary(bin(registradores[parametros[1]]))

    if len(registrador1) == 1:
        registrador1 = '0' + str(registrador1)
    if len(registrador2) == 1:
        registrador2 = '0' + str(registrador2)

    registradoresHexa = str(registrador1) + str(registrador2)
    return registradoresHexa

def insere_tipo_St(parametros, nomeDaInstrucao, indexCodigoHexa, codigoHexa):
    
    registradoresHexa = passa_registradores_hexa(parametros)
    registradoresHexa = split_hexa(hex(int(registradoresHexa,2)))

    byte = str(instrucoes[nomeDaInstrucao]) + str(registradoresHexa)
    codigoHexa[indexCodigoHexa] = byte
    
def insere_tipo_aritimetico_ou_logico(parametros, nomeDaInstrucao, indexCodigoHexa, codigoHexa):
    
    registradoresHexa = passa_registradores_hexa(parametros)
    registradoresHexa = split_hexa(hex(int(registradoresHexa,2)))

    byte = str(instrucoes[nomeDaInstrucao]) + str(registradoresHexa)
    codigoHexa[indexCodigoHexa] = byte
    

# main
with open("assembly.txt", "r") as arquivo:
    codigoAssembly = arquivo.readlines()
    preenche_endereco_labels(codigoAssembly)
    for linha in codigoAssembly:
        linhaAssembly = separar_instrucao_de_parametro(linha)
        nomeDaInstrucao = linhaAssembly[0]
        if (nomeDaInstrucao == 'jmp'):
            endereco = linhaAssembly[1]
            insere_tipo_J(endereco, nomeDaInstrucao, indexCodigoHexa, codigoHexa)
            indexCodigoHexa += 2    
        elif (nomeDaInstrucao == 'jae'):
            endereco = linhaAssembly[1]
            insere_tipo_J(endereco, nomeDaInstrucao, indexCodigoHexa, codigoHexa)
            indexCodigoHexa += 2    
        elif (nomeDaInstrucao == 'data'):
            parametros = split_parametros(linhaAssembly[1])
            insere_tipo_Data(parametros, nomeDaInstrucao, indexCodigoHexa, codigoHexa)
            indexCodigoHexa += 2 
        elif (nomeDaInstrucao == 'halt'):
            codigoHexa[indexCodigoHexa] = instrucoes[nomeDaInstrucao]
            indexCodigoHexa += 1
            codigoHexa[indexCodigoHexa] = '1b'
            indexCodigoHexa += 1    
        elif (nomeDaInstrucao == 'st'):
            parametros = split_parametros(linhaAssembly[1])
            insere_tipo_St(parametros, nomeDaInstrucao, indexCodigoHexa, codigoHexa)
            indexCodigoHexa += 1    
        elif (nomeDaInstrucao == 'add'):
            parametros = split_parametros(linhaAssembly[1])
            insere_tipo_aritimetico_ou_logico(parametros, nomeDaInstrucao, indexCodigoHexa, codigoHexa)
            indexCodigoHexa += 1
        elif (nomeDaInstrucao == 'not'):
            parametros = split_parametros(linhaAssembly[1])
            insere_tipo_aritimetico_ou_logico(parametros, nomeDaInstrucao, indexCodigoHexa, codigoHexa)
            indexCodigoHexa += 1
        elif (nomeDaInstrucao == 'shl'):
            parametros = split_parametros(linhaAssembly[1])
            insere_tipo_aritimetico_ou_logico(parametros, nomeDaInstrucao, indexCodigoHexa, codigoHexa)
            indexCodigoHexa += 1
        elif (nomeDaInstrucao == 'shr'):
            parametros = split_parametros(linhaAssembly[1])
            insere_tipo_aritimetico_ou_logico(parametros, nomeDaInstrucao, indexCodigoHexa, codigoHexa)
            indexCodigoHexa += 1
        elif (nomeDaInstrucao == 'and'):
            parametros = split_parametros(linhaAssembly[1])
            insere_tipo_aritimetico_ou_logico(parametros, nomeDaInstrucao, indexCodigoHexa, codigoHexa)
            indexCodigoHexa += 1
        elif (nomeDaInstrucao == 'or'):
            parametros = split_parametros(linhaAssembly[1])
            insere_tipo_aritimetico_ou_logico(parametros, nomeDaInstrucao, indexCodigoHexa, codigoHexa)
            indexCodigoHexa += 1
        elif (nomeDaInstrucao == 'xor'):
            parametros = split_parametros(linhaAssembly[1])
            insere_tipo_aritimetico_ou_logico(parametros, nomeDaInstrucao, indexCodigoHexa, codigoHexa)
            indexCodigoHexa += 1
        elif (nomeDaInstrucao == 'cmp'):
            parametros = split_parametros(linhaAssembly[1])
            insere_tipo_aritimetico_ou_logico(parametros, nomeDaInstrucao, indexCodigoHexa, codigoHexa)
            indexCodigoHexa += 1

print(codigoHexa)