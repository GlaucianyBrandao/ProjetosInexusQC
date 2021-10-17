# language: pt
# encoding: utf-8

  Funcionalidade: Testa Página Carrinho

    Cenario de Fundo:
      Dado que o usuario esta na pagina Your Cart

    Cenário: Continue Shopping
      Quando clica em Continue Shopping
      Então deve ser direcionado a pagina inicial

    Cenário: Check out
      Quando clica em Checkout
      Então deve ser direcionado para a pagina Check out Step one
