# Enable Production and Development Profiles

Having the option to run in development or production mode helps execute the project with the appropriate environment variables depending on the execution context. Based on the selected profile, some variable values will be chosen accordingly.

## Development Mode

To run the backend in development mode, simply execute the command below:

```
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

## Production Mode

To run the backend in production mode, simply execute the command below:

```
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

# Tests

If you want to run the project tests, just execute the command below:

```
mvn clean test prepare-package
```

The command above runs the tests and prepares the line coverage report. To view it, open the HTML file located at:

```
target/site/jacoco/index.html
```

# API Documentation

To access the REST API documentation, run the backend in either development or production mode:

```
mvn spring-boot:run -Dspring-boot.run.profiles=dev 
```

Then open the site:

```
http://localhost:8080/swagger-ui/index.html
```