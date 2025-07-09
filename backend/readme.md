# Ativar perfil producao e desenvolvimento

Ter opções de instalar o modo desenvolvimento ou produção ajuda a executar o projeto com as variaveis de ambiente apropriado ao interesse da execução. Dependendo do ambiente escolhido, alguns valores de variáveis serão escolidas. 

## Para modo desenvolvimento

Para executar o backend no modo desenvolvimento, basta executar o comando abaixo:

```
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

## Para modo produção

Para executar o backend no modo produção, basta executar o comando abaixo:

```
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

# Teste

Caso queria executar os testes do projeto basta executar o comando abaixo:

```
mvn clean test prepare-package
```

O comando acima executa os testes e prepara o relatório de cobertura de linha do projeto. Para isto, basta abrir o arquivo html localizado em:

```
target/site/jacoco/index.html
```
