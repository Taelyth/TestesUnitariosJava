# language: pt
# noinspection NonAsciiCharacters
Funcionalidade: Comprar Curso PO

  Cenario: Pesquisar Curso com Clique e Incluir no Carrinho PO
    Dado que acesso a home da Iterasys
    Quando procuro por "Mantis"
    E clico no botao da Lupa
    Entao vejo os resultados para o termo "Mantis"
    Quando clico no botao Matricule-se
    Entao confirmo o nome como "Mantis" e o preco de "R$ 59,99"