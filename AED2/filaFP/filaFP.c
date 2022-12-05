#include "stdio.h"
#include "stdlib.h"
#include "math.h"
#include "filaFP.h"

struct filaPrioridade{
  int ocupacao;
  short e_infinita;
  int tamanho;
  void* *elems;

  TCompararFP compararFP;
};

TFilaPrioridade* criar_FP(int tamanho, TCompararFP comparar){
  TFilaPrioridade* f = malloc(sizeof(TFilaPrioridade));

  f->tamanho = (tamanho>0?tamanho:4);
  f->e_infinita = (tamanho>0?0:1);

  f->elems = malloc(sizeof(void*)*f->tamanho);
  f->ocupacao=0;

  f->compararFP = comparar;
  return f;
}

void* compara();

static void trocar(void*  elems[], int i, int j){
  void* aux = elems[i];
  elems[i] = elems[j];
  elems[j] = aux;
}

void enfileirar_FP(TFilaPrioridade *f, void* elem){

  if ((f->e_infinita) && (f->ocupacao == f->tamanho)){
    f->tamanho *= 2;
    f->elems = realloc(f->elems, sizeof(void*)*f->tamanho);
  }

  f->elems[f->ocupacao] = elem;
  f->ocupacao++;
  // Validar a propriedade da ordem
  int i = f->ocupacao-1;
  int pai = floor((i-1)/2);
  while( (i!=0) && (f->compararFP(f->elems[pai], f->elems[i]) < 0)){
    trocar(f->elems,i,pai);
    i = pai;
    pai = floor((i-1)/2);
  }

}


void* desenfileirar_FP(TFilaPrioridade* f){

  if (f->ocupacao == 0){
    return NULL;
  }

  void* elem = f->elems[0];
  f->ocupacao--;
  trocar(f->elems, 0, f->ocupacao);
  // validar a propriedade da ordem
  int i=0, imaior = i;
  do{
    i = imaior;
    int iesq = 2*i+1;
    int idir = 2*i+2;

    if ((iesq < f->ocupacao)&&(f->compararFP(f->elems[i], f->elems[iesq]) < 0)){
      imaior = iesq;
    }
    if((idir < f->ocupacao)&&(f->compararFP(f->elems[imaior], f->elems[idir]))){
      imaior = idir;
    }
    trocar(f->elems, i, imaior);

  }while (i != imaior);
  

  return elem;
}


int tamanho_FP(TFilaPrioridade* f){

  return f->ocupacao;

}
