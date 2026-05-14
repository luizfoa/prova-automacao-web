# prova-automacao-web

Projeto de automação de testes web utilizando boas práticas de QA com BDD.

---

## Tecnologias utilizadas

* Java 11+
* Selenium WebDriver
* Cucumber
* JUnit

---

## Estrutura do projeto

A estrutura do projeto segue o padrão Page Object Model:

```
src
 ├── test
      ├── java
      │     └── com.provaAutomacaoWeb.automacaoWeb
      │           ├── core
      │           │     └── DriverFactory.java
      │           │
      │           ├── pages
      │           │     ├── CartPage.java
      │           │     ├── HomePage.java
      │           │     └── SearchPage.java
      │           │
      │           ├── runner
      │           │     └── RunnerTest.java
      │           │
      │           └── steps
      │                 └── PetzSteps.java
      │
      └── resources
            └── features
```

---

## Organização das camadas

* **core** → Configuração do driver (WebDriver)
* **pages** → Ações e regras das páginas (Page Objects)
* **steps** → Implementação dos passos do Cucumber
* **runner** → Classe responsável por executar os testes
* **features** → Cenários em Gherkin

---

## Pré-requisitos

Antes de executar o projeto, é necessário ter instalado:

* Java 11 ou superior
* Maven
* Google Chrome

---

## Configuração do ChromeDriver

Para execução dos testes com Selenium, é necessário configurar o ChromeDriver manualmente.

### Passo a passo:

1. Baixe o ChromeDriver compatível com sua versão do Chrome:
   https://chromedriver.chromium.org/downloads

2. Extraia o arquivo e salve em um diretório local, por exemplo:

```
C:\drivers\chromedriver.exe
```

3. Configure o caminho no projeto:

```java
System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
```

---

## Como executar o projeto

Execute o comando abaixo na raiz do projeto:

```
mvn clean install
```

Para rodar apenas os testes:

```
mvn test
```

---

## Execução com Cucumber

Os cenários estão localizados em:

```
src/test/resources/features
```

E são executados através da classe:

```
RunnerTest.java
```

---

## Relatórios

Os relatórios podem ser gerados conforme configuração do Cucumber no projeto.

---

## Observações importantes

* O ChromeDriver deve ser compatível com a versão do navegador
* Verifique o caminho do driver caso ocorra erro
* Certifique-se de que o Java e Maven estejam atualizados

---

## Pontos para melhorias futuras

* Integração com CI/CD
* Execução em modo headless
* Paralelismo na execução dos testes

---

## Autor

Projeto desenvolvido para fins de estudo e prática em automação de testes.
