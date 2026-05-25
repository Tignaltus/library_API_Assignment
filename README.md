# Library API
## Individuell labb 1K4 - REST API - Jonathan Isaksson

## Funktionalitet

### Grundfunktioner
- Hantering av **Books**
- Hantering av **Authors**
- Hantering av **Loans**
- API-versionering för böcker:
  - `v1`
  - `v2`

### Arkitektur
- Controller → Service → Repository
- DTO används i request/response
- Entities exponeras inte direkt
- Global exception handling
- Standardiserade felsvar

### Säkerhet
- Spring Security skyddar alla `/api/**`-endpoints
- HTTP Basic Authentication används för inloggning
- Strikt CORS-policy
- Input validation på inkommande DTO:er

### Optimering
- Redis-cache för `GET /api/v1/books/{id}`
- Pagination för list-endpoints
- Rate limiting per IP med Bucket4j

### Hemlighetshantering
- Känslig konfiguration har flyttats från `application.properties` till Spring Vault

### Testning
- Integrationstester
- Concurrency-test för lån
- Benchmarking med JMeter

---

## Alla Tekniker

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- H2 Database
- Redis
- Spring Cache
- Spring Vault
- Bucket4j
- Swagger / OpenAPI
- JMeter
- Docker Desktop
- Maven

---

## API-endpoints

### Books
- `POST /api/v1/books`
- `GET /api/v1/books`
- `GET /api/v1/books/{id}`
- `GET /api/v2/books`

### Authors
- `POST /api/v1/authors`
- `GET /api/v1/authors/{id}`
- `GET /api/v1/authors/{id}/books`

### Loans
- `POST /api/v1/loans`
- `GET /api/v1/loans`

> Alla `/api/**`-endpoints kräver autentisering.

---

## Pagination

List-endpoints använder pagination för att undvika att för stora datamängder skickas tillbaka i ett svar.

Exempel på query-parametrar:
- `page`
- `size`
- `sort`

Exempel:
```http
GET /api/v1/books?page=0&size=10&sort=id
```

## Kom Igång Lokalt
### Program Krav
- Docker Desktop
- Maven
- Java (v8 eller senare)


