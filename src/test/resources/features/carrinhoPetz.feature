#language:pt

  Funcionalidade:  Adicionar produto ao carrinho na Petz
    Cenario: Validar valor do produto na sacola
      Dado que acesso o site da Petz
      Quando busco pelo produto "Escada Baw & Miaw Grafite para Caes e Gatos"
      E seleciono o produto
      E capturo o valor do produto
      E adiciono o produto à sacola
      Entao valido que o valor na sacola é igual ao valor do produto
