# Escreva uma função que calcule as raízes reais (e complexas) de uma equação
# quadrática. Os parâmetros para a função são os três coeficientes da equação. Dica: use
# a função sqrt() do pacote cmath.

from cmath import sqrt

raizes = lambda a,b,c: ((-b - sqrt(b * b - 4 * a * c)) / 2 * a, (-b + sqrt(b * b - 4 * a
* c)) / 2 * a)

resultado = raizes(1,2,3)

print(resultado)