#include "stdio.h"
#include "stdlib.h"

int main(int argc, char** argv){

    int **vet, qtd_de_elementos;
    printf("Quantos elementos serão inseridos ?");
    scanf("%d",&qtd_de_elementos);

    vet = malloc(qtd_de_elementos * sizeof(int));

    for (int i = 0; i < qtd_de_elementos; i++)
    {
        printf("Digite o elemento[%d]: ", i);
        scanf("%d",&vet[i]);
    }

    for (int i = 0; i < qtd_de_elementos; i++)
    {
        for (int j = 0; j < qtd_de_elementos; j++)
        {
            if(vet[i] < vet[j]){
                int *aux;
                aux = vet[j];
                vet[j] = vet[i];
                vet[i] = aux;
            }
        }
    }

    for (int i = 0; i < qtd_de_elementos; i++)
    {
        printf("Elemento ordenado[%d]: %d\n", i, vet[i]);
    }

    return 0;
}