use strict;
use warnings;
use Text::CSV;
use utf8;

my $arquivo_csv = "alunos_IFPB.csv";

# Cria um objeto Text::CSV
my $csv = Text::CSV->new({ binary => 1 }) or die "Não foi possível criar o objeto CSV: " . Text::CSV->error_diag();

# Abre o arquivo CSV
open(my $fh, "<", $arquivo_csv) or die "Não foi possível abrir o arquivo '$arquivo_csv': $!";

my $string_procurada = "JOÃO PESSOA";

# Lê cada linha do arquivo CSV
while (my $linha = $csv->getline($fh)) {
    my $valor_coluna = $linha->[4];  

    if (index($valor_coluna, $string_procurada) != -1){
        print join(", ", @$linha) . "\n";
    }
}

# Fecha o arquivo CSV
close($fh) or die "Erro ao fechar o arquivo '$arquivo_csv': $!";
