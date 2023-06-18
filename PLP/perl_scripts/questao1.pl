use strict;
use warnings;
use Text::CSV;

my $string_procurada1 = "Washington";
my $string_procurada2 = "Bianka";
my $arquivo_csv = "alunos_IFPB.csv";

# Cria um objeto Text::CSV
my $csv = Text::CSV->new({ binary => 1 }) or die "Não foi possível criar o objeto CSV: " . Text::CSV->error_diag();

# Abre o arquivo CSV
open(my $fh, "<", $arquivo_csv) or die "Não foi possível abrir o arquivo '$arquivo_csv': $!";

# Lê cada linha do arquivo CSV
while (my $linha = $csv->getline($fh)) {
    my $valor_coluna = $linha->[0];  # Obtém o valor da primeira coluna

    if (index($valor_coluna, $string_procurada1) != -1) {
        print join(", ", @$linha) . "\n";        
    }
    if (index($valor_coluna, $string_procurada2) != -1){
        print join(", ", @$linha) . "\n";
    }
}

# Fecha o arquivo CSV
close($fh) or die "Erro ao fechar o arquivo '$arquivo_csv': $!";
