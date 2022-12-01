#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "livro.h"


struct livro{
  char titulo[60];
  int anoPubl;
};
//typedef struct livro TLivro;

TLivro* criar_livro(char* titulo, int anoPubl){
  TLivro *l = malloc(sizeof(TLivro));
  strcpy(l->titulo, titulo);
  l->anoPubl = anoPubl;

  return l;
}

void imprimir_livro(TLivro* l){

  printf("%s %d\n",l->titulo, l->anoPubl);

}
