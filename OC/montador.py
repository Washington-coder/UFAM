instrucoes = {
    'add':0b1000, 'shr':0b1001, 
    'shl':0b1010, 'not':0b1011, 
    'and':0b1100, 'or': 0b1101, 
    'xor':0b1110, 'cmp': 0b1111, 
    'ld': 0b0000, 'st': 0b0001, 
    'data': 0b0010, 'jmpr': 0b0011,
    'jmp': 0b0100,'jcaez': 0b0101,
    'clf': 0b0110
}

hex_code = ['00' for i in range(256)]

def separarInstrucoes(linha):
    linha = linha.split()
    return linha

def instrucaoEmHexa(instrucao):
    print(instrucoes.values())
    # for i in instrucoes:
    #      if instrucao == i:
    #         print(i)

def passarInstrucoesParaHexa(arrayDeInstrucoes):
    instrucoes_hexa = []
    for i in arrayDeInstrucoes:
        instrucao = instrucaoEmHexa(i)
        
## main
with open("assembly.txt", "r") as arquivo:
    codigo_assembly = arquivo.readlines()

for linha in codigo_assembly:
    arrayDeInstrucoes = separarInstrucoes(linha)
    passarInstrucoesParaHexa(arrayDeInstrucoes)
    