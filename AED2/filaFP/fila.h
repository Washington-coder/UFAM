typedef struct fila TFila;

TFila* criar_fila(int tamanho);
void enfileirar(TFila *f, void* elem);
void* desenfileirar(TFila* f);
int tamanho_fila(TFila* f);
void imprimir_fila(TFila* f);