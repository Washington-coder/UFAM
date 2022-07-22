#include<stdio.h>
#define TAM 10

int buscaBinaria(int vet[TAM], int item){
  int inicio = 0, fim = TAM - 1;

  while(inicio <= fim){

    int meio = (inicio + fim)/2;

    if (vet[meio] == item){
      return 1;
    }

    if (vet[meio] < item){
      inicio = meio + 1;
    }
    
    else{
      fim = meio;
    }
  }
  return 0;
}

int main() {
  int vet[TAM], item;

  for (int i = 0; i < TAM; i++) {
    scanf("%d", &vet[i]);
  }

  printf("\nDigite a chave de pesquisa: ");
  scanf("%d", &item);
  if (buscaBinaria(vet, item)){
    printf("\nBusca binaria realizada com sucesso");
  }
  else{
    printf("\nBusca binaria falhou");
  }
}
