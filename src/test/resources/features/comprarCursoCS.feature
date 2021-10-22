# language: pt
#noinspection NonAsciiCharacters
Funcionalidade: Comprar Curso Cucumber Selenium

  Cenario: Pesquisar Curso com Clique e Incluir no Carrinho
    Dado que acesso o site da Iterasys
    Quando pesquiso por "Mantis"
    E clico na Lupa
    Entao vejo a lista de resultados para o termo "Mantis"
    Quando clico em Matricule-se
    Entao confirmo o nome do curso como "Mantis" e o preco de "R$ 59,99"

  Esquema do Cenario: Pesquisar Curso com Enter e Incluir no Carrinho
    Dado que acesso o site da Iterasys
    Quando pesquiso por <curso>
    E pressiono Enter
    Entao vejo a lista de resultados para o termo <curso>
    Quando clico em Matricule-se
    Entao confirmo o nome do curso como <curso> e o preco de <preco>

    Exemplos:
      | curso               | preco       |
      | "Mantis"            | "R$ 59,99"  |
      | "Preparatório CTFL" | "R$ 199,00" |

    Cenario: Ver Detalhes de um Curso
      Dado que acesso o site da Iterasys
      Quando clico no botao Ok!
      E clico na imagem de um Curso
      Entao vejo a pagina com detalhes do Curso