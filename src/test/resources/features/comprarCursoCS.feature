# language: pt
Funcionalidade: Comprar Curso Cucumber Selenium

  Cenario: Pesquisar Curso e Incluir no Carrinho
    Dado que acesso o site da Iterasys
    Quando pesquiso por "Mantis"
    E clico na Lupa
    Entao vejo a lista de resultados para o termo "Mantis"
    Quando clico em Matricule-se
    Entao confirmo o nome do curso como "Mantis" e o preco de "R$ 49,99"