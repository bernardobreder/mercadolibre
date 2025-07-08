# Ativar perfil producao e desenvolvimento

# Rodar o backend

```
mvn spring-boot:run
```

# Teste

```
mvn clean test prepare-package
open target/site/jacoco/index.html
```

## Trocar banco

Caso precise associar um banco de dados no modo produção, basta alterar o arquivo `src/main/resources/application-prod.yml`

```
java -jar backend.jar --spring.profiles.active=prod
```

