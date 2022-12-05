typedef struct filaPrioridade TFilaPrioridade;
typedef int (*TCompararFP)(void*, void*);
TFilaPrioridade* criar_FP(int tamanho, TCompararFP compara);
static void trocar(void* elems[], int i, int j);
void enfileirar_FP(TFilaPrioridade *f, void* elem);
void* desenfileirar_FP(TFilaPrioridade* f);
int tamanho_FP(TFilaPrioridade* f);
