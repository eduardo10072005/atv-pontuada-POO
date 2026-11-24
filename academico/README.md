# API Acadêmica — Spring Boot + JPA

Trabalho: Relacionamentos entre Entidades JPA.

## Tecnologias
- Java 17
- Spring Boot 3.2.5
- Spring Data JPA
- H2 Database

## Relacionamentos
- Professor 1—1 PerfilProfessor
- Curso 1—N Disciplina
- Aluno N—N Disciplina

## Como executar
mvnw spring-boot:run

API em http://localhost:8080
H2 Console em http://localhost:8080/h2-console
