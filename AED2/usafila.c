#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "fila.h"
#include "livro.h"

int main(int argc, char const *argv[]) {

  TFila* para_ler = criar_fila(3);

  char titulo[60];
  int anoPubl;

  scanf("%s", titulo);
  while(strcmp(titulo,"FIM")!=0){
    scanf("%d\n",&anoPubl);

    TLivro* exemplar = criar_livro(titulo, anoPubl);
    enfileirar(para_ler, exemplar);

    scanf("%s", titulo);
  }
  TLivro* primeiro = desenfileirar(para_ler);
  imprimir_livro(primeiro);
  free(primeiro);

  printf("tamanho: %d\n", tamanho_fila(para_ler));

  return 0;
}
