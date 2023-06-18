use strict;
use warnings;
use Text::CSV;

my $arquivo_csv = "alunos_IFPB.csv";

my %dicionario = ();

# Hash auxiliar para verificar unicidade
my %strings_unicas = ();

# Cria um objeto Text::CSV
my $csv = Text::CSV->new({ binary => 1 }) or die "Não foi possível criar o objeto CSV: " . Text::CSV->error_diag();

# Abre o arquivo CSV
open(my $fh, "<", $arquivo_csv) or die "Não foi possível abrir o arquivo '$arquivo_csv': $!";

# Lê cada linha do arquivo CSV
while (my $linha = $csv->getline($fh)) {
    my $valor_coluna = $linha->[5];

    # Verificar se a string ja existe no hash
    if (!$strings_unicas{$valor_coluna}){
        $dicionario{$valor_coluna} = 1; 
        $strings_unicas{$valor_coluna} = 1;
    }else{
        $dicionario{$valor_coluna} = $dicionario{$valor_coluna} + 1; 
    }

}

while (my ($chave, $valor) = each %dicionario){
    print "Chave: $chave, Valor: $valor\n";
}

# Fecha o arquivo CSV
close($fh) or die "Erro ao fechar o arquivo '$arquivo_csv': $!";
