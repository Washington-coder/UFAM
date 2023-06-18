# Escreva uma função que verifique se duas listas numéricas têm a mesma estrutura.
# Duas listas têm a mesma estrutura se cada um dos seus elementos tem a mesma
# estrutura, não importando os valores numéricos. Por exemplo, as listas [1, [2, [3]], 4] e
# [5, [6, [7]], 8] enquanto [1, 2, 3, [4]] e [[1], 2, [3, 4]] têm estruturas distintas. 

mesmaestrutura = lambda l1, l2: True if (l1 == [] and l2 == []) else False if (l1 == []
or l2 == []) else mesmaestrutura(l1[1:],l2[1:]) if ((type(l1[0]) is list and type(l2[0])
is list) or (type(l1[0]) is int and type(l2[0]) is int)) else False

resultado = mesmaestrutura([1, [2, [3]], 4], [5, [6, [7]], 8])

print(resultado)