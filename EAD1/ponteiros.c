#include <stdio.h>

int main(){
    int a = 1, b = 2, c = 3, d = 4;
    int *p;
    long *p1;
    char *p2;

    printf("%p\n", &p);
    printf("%p\n", &p1);
    printf("%p\n", &p2);

    // p recebe endereco de a
    p = &a;

    // conteudo da variavel apontada por p recebe 40
    *p = 40;

    printf("%d", a);
}