#language:pt

  Funcionalidade: Carrinho Petz
    Cenario: Validar valor do produto na sacola
      Dado que acesso o site Petz
      E busco pelo produto "Escada Baw & Miaw Grafite para Caes e Gatos"
      E seleciono o produto desejado
      E capturo o valor do produto
      Quando adiciono o produto à sacola
      Entao o valor na sacola deve ser igual ao valor do produto
