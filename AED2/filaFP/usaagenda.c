#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "fila.h"
#include "agenda.h"
// #include "filaFP.h"
// #include "fila.h"
// #include "livro.h"

int main(int argc, char const *argv[]) {

  TFila* fila = criar_fila(3);

  int pararLoop = 0;
  char data[20];
  char hora[20];
  int tempoLimite;
  int prioridade;

  while(pararLoop == 0){
    printf("Digite a data: ");
    gets(data);
    printf("Digite a hora: ");
    gets(hora);
    printf("Digite o tempo limite: ");
    scanf("%d", &tempoLimite);
    printf("Digite a prioridade: ");
    scanf("%d", &prioridade);
    
    fflush(stdin);

    TEvento* evento = agendar_evento(data, hora, tempoLimite, prioridade);
    enfileirar(fila, evento);
    printf("\n\n");
    printf("Continuar inserindo eventos na fila ?\n");
    printf("0 - sim\n");
    printf("1 - nao\n");
    scanf("%d", &pararLoop);
    fflush(stdin);
    
    printf("\n\n");
  }

  printf("Eventos: \n\n");
  imprimir_fila(fila);

  return 0;
}
