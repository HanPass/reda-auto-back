# Backend Gestion de Stock (Pièces Automobiles)

Backend Spring Boot 3 (Java 17) en architecture hexagonale pour un magasin local (max 5000 produits).

## Stack
- Java 17, Spring Boot 3+
- PostgreSQL, JPA/Hibernate
- Spring Security + JWT
- MapStruct, Lombok, Jakarta Validation
- JUnit 5 + Mockito
- Maven, Docker

## Architecture
- `com.store.domain`: modèles métier + ports
- `com.store.application`: services métier, DTO, exceptions, mappers
- `com.store.infrastructure.adapters.rest`: contrôleurs REST + GlobalExceptionHandler
- `com.store.infrastructure.adapters.persistence`: entités, repositories, adapters
- `com.store.infrastructure.security`: JWT, auth service
- `com.store.infrastructure.config`: configuration sécurité + bootstrap admin

## Lancement local
```bash
mvn clean spring-boot:run
```

## Docker
```bash
docker compose up --build
```

## Utilisateur par défaut
- username: `admin`
- password: `admin123`

## Endpoints principaux
- `POST /api/auth/login`
- `CRUD /api/products`
- `GET /api/products/search?ref=...` / `?nom=...`
- `GET /api/products/low-stock`
- `CRUD /api/suppliers`
- `CRUD /api/clients`
- `POST /api/sales`
- `POST /api/cash-registers/open`
- `POST /api/cash-registers/{id}/close`

## Exemples curl
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"admin123"}'

curl -X POST http://localhost:8080/api/products \
  -H "Authorization: Bearer <JWT>" \
  -H "Content-Type: application/json" \
  -d '{"reference":"REF-001","nom":"Filtre huile","prixAchat":10,"prixVente":15,"quantiteStock":20,"seuilAlerte":5}'
```

## SQL
Le script PostgreSQL complet est dans `schema.sql`.
