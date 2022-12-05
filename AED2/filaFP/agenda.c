#include "stdio.h"
#include "stdlib.h"
#include "filaFP.h"
#include "agenda.h"
#include "string.h"

struct evento
{
    char data[20];
    char hora[20];
    int tempoLimite;
    int prioridade;
};

TEvento* agendar_evento(char* data, char* hora, int tempoLimite, int prioridade){
    
    TEvento *l = malloc(sizeof(TEvento));

    strcpy(l->data, data);
    strcpy(l->hora, hora);
    l->tempoLimite = tempoLimite;
    l->prioridade = prioridade;

    return l;
}

void imprimir_evento(TEvento *l){
    printf("\n\nData: %s\n", l->data);
    printf("hora: %s\n", l->hora);
    printf("tempo limite: %d\n", l->tempoLimite);
    printf("prioridade: %d\n", l->prioridade);
}