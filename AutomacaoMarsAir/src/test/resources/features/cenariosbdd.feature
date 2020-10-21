#language: pt
@fluxo-total
Funcionalidade: Fluxo básico de pesquisa
  Como Diretor de Vendas da MarsAir (Mark)
  quero que os clientes em potencial possam pesquisar voos para Marte para
  E vejam quais viagens estão disponiveis
  
  Códigos promocionais  
  Como Diretor de Vendas da MarsAir (Mark)
  quero distribuir codigos promocionais aos clientes para
  que eles obtenham descontos e fiquem mais tentados a comprar viagens
  
  Validação de layout e direcionamentos  
  Como Diretor de Vendas da MarsAir (Mark)
  quero distribuir codigos promocionais aos clientes para
  que eles obtenham descontos e fiquem mais tentados a comprar viagens

  #FLUXO BÁSICO DE PESQUISA#
  @fluxo-pesquisa-sucesso
  Esquema do Cenario: CN0001.CT001 – Fluxo de pesquisa com sucesso
    Dado que eu esteja na pagina de pesquisa da plataforma "<tipo>"
    Quando eu selecionar meu mes e dia de partida
    E meu mes dia de retorno respeitando o intervalo superior a 1 ano
    E clicar no botao de pesquisa
    Então quero receber o retorno do servico com a mensagem "<mensagem>"

    Exemplos: 
      | tipo    | mensagem                                    |
      | sucesso | Seats available! Call 0800 MARSAIR to book! |

  @fluxo-pesquisa-sem-sucesso
  Esquema do Cenario: CN0001.CT002  Fluxo de pesquisa sem sucesso
    Dado que eu esteja na pagina de pesquisa da plataforma "<tipo>"
    Quando eu selecionar meu mes e dia de partida
    E meu dia de retorno que nao tenha assentos disponiveis
    E clicar no botao de pesquisa
    Então quero receber o retorno do servico com a mensagem "<mensagem>"

    Exemplos: 
      | tipo        | mensagem                                  |
      | sem sucesso | Sorry, there are no more seats available. |

  @fluxo-pesquisa-retorno-data-invalida
  Esquema do Cenario: CN0001.CT003  Fluxo de pesquisa com datas de retorno invalidas
    Dado que eu esteja na pagina de pesquisa da plataforma "<tipo>"
    Quando eu selecionar meu mes e dia de partida
    E meu mes e dia de retorno inferior a 1 ano da partida
    E clicar no botao de pesquisa
    Então quero receber o retorno do servico com a mensagem "<mensagem>"

    Exemplos: 
      | tipo     | mensagem                                                        |
      | invalida | Unfortunately, this schedule is not possible. Please try again. |

  @fluxo-pesquisa-sem-parametro
  Esquema do Cenario: CN0001.CT004  Fluxo de pesquisa sem parametros "<tipo>"
    Dado que eu esteja na pagina de pesquisa da plataforma
    Quando eu nao selecionar nenhuma data de partida
    E nenhuma data de retorno
    E clicar no botao de pesquisa
    Então quero receber o retorno do servico com a mensagem "<mensagem>"

    Exemplos: 
      | tipo          | mensagem                                                                               |
      | sem parametro | You have not selected any of the departure and return fields, the fields are required. |

  @fluxo-pesquisa-partida-superior
  Esquema do Cenario: CN0001.CT005  Fluxo de pesquisa data partida superior a data retorno
    Dado que eu esteja na pagina de pesquisa da plataforma "<tipo>"
    Quando eu selecionar a data de partida superior a data retorno
    E clicar no botao de pesquisa
    Então quero receber o retorno do servico com a mensagem "<mensagem>"

    Exemplos: 
      | tipo | mensagem                                                     |
      | data | The departure date must not be greater than the return date. |

  #FLUXO DE CODIGOS PROMOCIONAIS#
  @fluxo-pesquisa-codigo-descontos
  Esquema do Cenario: "<CT>"
    Dado que eu esteja na pagina de pesquisa da plataforma "<tipo>"
    Quando eu selecionar meu mes e dia de partida
    E meu mes e dia de retorno
    E digitar meu codigo de desconto valido no formato "XX9- XXX -999" "<codigo>"
    E clicar no botao de pesquisa
    Então quero receber o retorno do servico com a mensagem "<mensagem>"

    Exemplos: 
      | CT                                                | tipo              | codigo        | mensagem                                                |
      | CN002.CT001  Fluxo de codigo de desconto valido   | desconto valido   | XX3- XPT -333 | Promotional code XX3- XPT -333 used: 3% discount!       |
      | CN002.CT002  Fluxo de codigo de desconto invalido | desconto invalido | XX1- XPT -111 | Otherwise, show “Sorry, code XX1- XPT -111 is not valid |
