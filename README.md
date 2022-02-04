# Testes — Java
Projeto criado para acompanhar as aulas do curso [Formação em Teste de Software][Iterasys] em **Java** utilizando **Selenium, TestNG, Rest-Assured e Cucumber**.

O projeto contém exemplos de testes em **API, Web com Page Object, uso de BDD e testes unitários**.

---

### Pré-Requisitos
- Nesse projeto utilizamos o **Gradle** com as seguintes bibliotecas:

```java
testImplementation 'org.testng:testng:7.4.0'
testImplementation 'io.rest-assured:rest-assured:4.4.0'
implementation 'org.seleniumhq.selenium:selenium-java:4.0.0'
implementation 'commons-io:commons-io:2.11.0'
implementation 'com.opencsv:opencsv:5.5.2'
implementation 'io.cucumber:cucumber-java:7.0.0'
implementation 'io.cucumber:cucumber-testng:7.0.0'
```

- A documentação usada para as aulas de API foi a **PetStore**, que pode ser encontrada [aqui][Petstore].
- A URL utilizada nos testes web foi a [Iterasys][Iterasys].

- Para rodar os testes web é necessário adicionar o `chromedriver` no seguinte local: `C:\\webdrivers\chromedriver\{versão}\chromedriver.exe`
- Colocar a `{versão}` desejada e alterar no código [comprarCursoPO.java](src/test/java/stepsPO/comprarCursoPO.java) e [comprarCursoCS.java](src/test/java/webTests/comprarCursoCS.java)


---

### Glossário

`apiTests` Pacote criado para treinamento dos testes de API em **Rest-Assured**

`pages e stepsPO e webTests` Pacotes utilizados para os testes web na formatação **Page Object** utilizando **Selenium** e **Cucumber** para o BDD. Para checar os passos em Cucumber, olhar o diretório [resources/features](src/test/resources/features) e [resources/featuresPO](src/test/resources/featuresPO).

`Runner.java` Classe de exemplo de um Runner em Cucumber que grava o relatório do teste em HTML.

`unitTests` Pacote simples de exemplo em testes unitários de uma calculadora em Java.

`utils` Pacote com exemplo de métodos para tirar screenshots e salvar CSV como evidências do teste.

`Log.java` (Incompleto) Classe criada para escrita em CSV, escrevendo apenas o cabeçalho por enquanto.

---

### Créditos
[<img src="assets\Iterasys-Logo.png" width="20%"/>][Iterasys]


<!-- links -->
[Iterasys]: https://iterasys.com.br/
[Petstore]: https://petstore.swagger.io/

<!-- imagens -->
[Iterasys-Logo]: assets/Iterasys-Logo.png (Iterasys-logo)