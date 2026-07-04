# chosenone

[![CI](https://github.com/AleksanderSiudek/chosenone/actions/workflows/ci.yml/badge.svg?branch=main)](https://github.com/AleksanderSiudek/chosenone/actions/workflows/ci.yml)

Projekt Spring Boot z pipeline CI uruchamianym przy kazdym pushu oraz dla pull requestow do `main`.

## Uruchomienie lokalne

```bash
./mvnw spring-boot:run
```

## Build lokalny

```bash
./mvnw -DskipTests clean package
```
