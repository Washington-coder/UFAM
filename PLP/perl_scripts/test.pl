use strict;
use warnings;
use Text::CSV;

my $arquivo_csv = "alunos_IFPB.csv";

# Cria um objeto Text::CSV
my $csv = Text::CSV->new({ binary => 1 }) or die "Não foi possível criar o objeto CSV: " . Text::CSV->error_diag();

# Abre o arquivo CSV
open(my $fh, "<", $arquivo_csv) or die "Não foi possível abrir o arquivo '$arquivo_csv': $!";

# Lê o cabeçalho do arquivo CSV
my $cabecalho = $csv->getline($fh);

# Imprime o cabeçalho
print join(", ", @$cabecalho) . "\n";

# Lê cada linha do arquivo CSV
while (my $linha = $csv->getline($fh)) {
    # Imprime os valores da linha atual
    print join(", ", @$linha) . "\n";
}

# Fecha o arquivo CSV
close($fh) or die "Erro ao fechar o arquivo '$arquivo_csv': $!";
