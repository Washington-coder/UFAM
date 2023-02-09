instrucoes = {
    'add': 0b1000, 'shr': 0b1001,
    'shl': 0b1010, 'not': 0b1011,
    'and': 0b1100, 'or': 0b1101,
    'xor': 0b1110, 'cmp': 0b1111,
    'ld': 0b0000, 'st': 0b0001,
    'data': 0b0010, 'jmpr': 0b0011,
    'jmp': 40, 'jcaez': 0b0101,
    'jae': 56,'clf': 0b0110
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


# main
with open("assembly.txt", "r") as arquivo:
    codigoAssembly = arquivo.readlines()
    preenche_endereco_labels(codigoAssembly)
    print(labels)
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
        # elif (nomeDaInstrucao == 'data'):
        #     parametros = linhaAssembly[1]
        #     insere_tipo_Data()
        #     indexCodigoHexa += 2 
        # elif (tipoDeInstrucao == 'halt'):
            
            
        # elif (tipoDeInstrucao == 'st'):
            
        # elif (tipoDeInstrucao == 'add'):
            
        # elif (tipoDeInstrucao == 'shl'):
            
        # elif (tipoDeInstrucao == 'shr'):
            
        # elif (tipoDeInstrucao == 'not'):
            
        # elif (tipoDeInstrucao == 'and'):
            
        # elif (tipoDeInstrucao == 'or'):
            
        # elif (tipoDeInstrucao == 'xor'):
            
        # elif (tipoDeInstrucao == 'cmp'):
            

    # if tipoDeInstrucao == 'data': 
    #     parametros = linhaAssembly[1].split(',')
    #     registrador = parametros[0]
    #     valor = parametros[1]
    #     dataRegistrador = data_registrador_em_hexa(registrador)
    #     hex_code[posicao_hex_code] = dataRegistrador
    #     posicao_hex_code+=1
    #     valorData = valor_data_hexa(valor)
    #     hex_code[posicao_hex_code] = valorData
    #     posicao_hex_code+=1
    # elif tipoDeInstrucao == 'label':
        
print(codigoHexa)