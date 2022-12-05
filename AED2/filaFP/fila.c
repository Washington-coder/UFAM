#include "stdio.h"
#include "stdlib.h"
#include "fila.h"
#include "agenda.h"

struct fila{
  int ocupacao;
  int primeiro;
  int ultimo;
  short e_infinita;
  int tamanho;
  void* *elems;
};

TFila* criar_fila(int tamanho){
  TFila* f = malloc(sizeof(TFila));

  f->tamanho = (tamanho>0?tamanho:4);
  f->e_infinita = (tamanho>0?0:1);


  f->elems = malloc(sizeof(void*)*f->tamanho);
  f->primeiro=0;
  f->ultimo=-1;
  f->ocupacao=0;

  return f;
}

void enfileirar(TFila *f, void* elem){

  f->ultimo = (f->ultimo+1 % f->tamanho);

  // falta tratar fila cheia // ocupacao máxima
  f->elems[f->ultimo] = elem;
  f->ocupacao++;

}


void* desenfileirar(TFila* f){

  if (f->ocupacao > 0){
    void* elem = f->elems[f->primeiro];
    f->primeiro = (f->primeiro+1 % f->tamanho);

    f->ocupacao--;
    if (f->ocupacao == 0){
      f->primeiro=0;
      f->ultimo=-1;
    }
    return elem;
  }
  return NULL;
}


int tamanho_fila(TFila* f){

  return f->ocupacao;

}

void imprimir_fila(TFila* f){
    int i = 0;

    while (i != f->ocupacao)
    {
        printf("%d\n", i);
        imprimir_evento(f->elems[i]);
        i++;
    }
    
}