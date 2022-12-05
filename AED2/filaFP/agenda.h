typedef struct evento TEvento;
TEvento* agendar_evento(char* data, char* hora, int tempoLimite, int prioridade);
void imprimir_evento(TEvento *l);