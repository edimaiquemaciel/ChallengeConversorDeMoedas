---

# Conversor de Moedas

Este é um **Conversor de Moedas** desenvolvido em Java que consome uma API de taxas de câmbio para realizar a conversão entre diferentes moedas em tempo real. O programa utiliza a [ExchangeRate-API](https://www.exchangerate-api.com) para obter as cotações de moedas como Dólar Americano (USD), Real Brasileiro (BRL), Peso Argentino (ARS) e Peso Colombiano (COP).

## Funcionalidades

- Conversão de Dólar Americano (USD) para Peso Argentino (ARS), Real Brasileiro (BRL) e Peso Colombiano (COP).
- Conversão de Peso Argentino (ARS), Real Brasileiro (BRL) e Peso Colombiano (COP) para Dólar Americano (USD).
- Cotações atualizadas em tempo real, consumidas diretamente de uma API de taxas de câmbio.
  
## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação usada para desenvolver o programa.
- **API ExchangeRate**: API de taxas de câmbio utilizada para buscar as cotações em tempo real.
- **HttpClient**: Biblioteca padrão do Java para realizar requisições HTTP.
- **Gson**: Biblioteca usada para fazer a conversão de JSON para objetos Java.

## Dependências

O projeto utiliza a biblioteca Gson para manipulação de JSON. Existem três maneiras de adicionar a dependência ao projeto:

### 1. Usando Maven

Adicione a seguinte dependência ao seu arquivo `pom.xml`:

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.9</version>
</dependency>
```

### 2. Usando Gradle

Adicione a linha abaixo ao arquivo `build.gradle`:

```groovy
implementation 'com.google.code.gson:gson:2.8.9'
```

### 3. Adicionando o JAR manualmente

Se você não estiver utilizando Maven ou Gradle, pode baixar o arquivo JAR da biblioteca Gson diretamente.

#### Passos para adicionar o JAR:

1. **Baixar o JAR**:
   - Baixe o arquivo JAR da biblioteca Gson a partir do repositório Maven Central:  
     [Download Gson JAR](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.8.9/gson-2.8.9.jar)

2. **Adicionar ao Classpath**:
   - Coloque o arquivo `gson-2.8.9.jar` em uma pasta do projeto, por exemplo, em uma pasta chamada `libs`.

3. **Compilar e Executar o Projeto com o JAR**:
   - Ao compilar e executar o projeto, você precisará incluir o JAR no classpath. Execute o comando abaixo no terminal:

   ```bash
   javac -cp libs/gson-2.8.9.jar Main.java ObterCotacao.java Moedas.java OpcoesMoedas.java
   java -cp .:libs/gson-2.8.9.jar Main
   ```

   Se estiver no Windows, substitua os dois-pontos (`:`) por ponto e vírgula (`;`):

   ```bash
   javac -cp libs\gson-2.8.9.jar Main.java ObterCotacao.java Moedas.java OpcoesMoedas.java
   java -cp .;libs\gson-2.8.9.jar Main
   ```

## Como Executar o Projeto

1. Clone o repositório:
    ```bash
    git clone https://github.com/edimaiquemaciel/ChallengeConversorDeMoedas.git
    cd ChallengeConversorDeMoedas

    ```

2. Instale as dependências:
   Caso esteja usando Maven ou Gradle, as dependências serão instaladas automaticamente. Se estiver utilizando o arquivo JAR, siga as instruções acima para adicionar o Gson manualmente.

3. Execute o projeto:
    Compile e execute o arquivo `Main.java` com o comando:
    ```bash
    javac Main.java
    java Main
    ```

4. O programa irá exibir um menu para selecionar as opções de conversão de moedas. Basta digitar o número correspondente à conversão desejada e inserir o valor a ser convertido.

## Estrutura do Código

### `Main.java`
Esta classe contém a lógica principal do programa, apresentando um menu interativo ao usuário. O usuário pode escolher a moeda que deseja converter e inserir o valor. As conversões são feitas utilizando as taxas de câmbio fornecidas pela API.

### `ObterCotacao.java`
Classe responsável por realizar a requisição à API ExchangeRate-API e retornar as cotações das moedas. Utiliza `HttpClient` para fazer a solicitação e a biblioteca `Gson` para desserializar o JSON de resposta.

### `Moedas.java`
Representa o objeto de moedas que contém o resultado da requisição e as taxas de conversão para as diferentes moedas.

### `OpcoesMoedas.java`
Classe que armazena as taxas de conversão das moedas (USD, BRL, ARS, COP), recebidas da API.

## Exemplo de Uso

```bash
*******************************************************************

Seja bem-vindo/a ao Conversor de Moeda =]

1) Dólar =>> Peso Argentino
2) Peso Argentino =>> Dólar
3) Dólar =>> Real Brasileiro
4) Real Brasileiro =>> Dólar
5) Dólar =>> Peso Colombiano
6) Peso Colombiano =>> Dólar
7) Sair

Escolha uma opção válida:
*******************************************************************
```

Após escolher a opção desejada, o programa solicitará que você insira o valor a ser convertido e exibirá o valor final na moeda escolhida.

## Dependências da API

Este projeto utiliza a [ExchangeRate-API](https://www.exchangerate-api.com), e você precisará de uma chave de API válida para realizar as conversões. Substitua a URL de requisição na classe `ObterCotacao` com a sua chave de API pessoal, como no exemplo abaixo:

```java
URI endereco = URI.create("https://v6.exchangerate-api.com/v6/SUA-CHAVE-API/latest/USD");
```

## Melhorias Futuras

- Suporte a mais moedas e conversões.
- Interface gráfica para uma experiência de usuário mais intuitiva.
- Tratamento de erros mais robusto, incluindo o manuseio de exceções e mensagens de erro da API.

## Licença

Este projeto está licenciado sob a MIT License - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---
