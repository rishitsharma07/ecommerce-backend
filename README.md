# E-Commerce Backend

A RESTful backend API for an e-commerce application built with Spring Boot 3.x, PostgreSQL, and JWT authentication.

## Tech Stack
- Java 17
- Spring Boot 3.x
- Spring Security 6 + JWT (jjwt 0.12.6)
- Spring Data JPA + Hibernate
- PostgreSQL
- Docker
- Lombok
- Maven

## Features
- JWT-based authentication and authorization
- Role-based access control (USER / ADMIN)
- Product catalog with category filtering
- Shopping cart management
- Order placement and tracking
- Admin panel APIs for product and order management

## Getting Started

### Prerequisites
- Java 17
- Docker
- Maven

### Setup

1. Clone the repository
```bash
git clone https://github.com/rishitsharma07/ecommerce-backend.git
cd ecommerce-backend
```

2. Create a `.env` file in the root directory

JWT_SECRET=your-256-bit-secret-key
JWT_EXPIRATION=86400000
DB_PASSWORD=your-db-password

3. Start PostgreSQL using Docker
```bash
docker run --name ecommerce-postgres \
  -e POSTGRES_PASSWORD=your-db-password \
  -e POSTGRES_DB=ecommerce_db \
  -p 5432:5432 \
  -d postgres:16
```

4. Run the application
```bash
./mvnw spring-boot:run
```

The server starts on `http://localhost:8080`

## API Endpoints

### Auth
| Method | Endpoint | Access |
|--------|----------|--------|
| POST | `/api/auth/register` | Public |
| POST | `/api/auth/login` | Public |

### Products
| Method | Endpoint | Access |
|--------|----------|--------|
| GET | `/api/products` | Public |
| GET | `/api/products/category/{category}` | Public |
| POST | `/api/products` | ADMIN |
| PUT | `/api/products/{id}` | ADMIN |
| DELETE | `/api/products/{id}` | ADMIN |

### Cart
| Method | Endpoint | Access |
|--------|----------|--------|
| GET | `/api/cart` | USER |
| POST | `/api/cart` | USER |
| DELETE | `/api/cart/{id}` | USER |

### Orders
| Method | Endpoint | Access |
|--------|----------|--------|
| POST | `/api/orders/checkout` | USER |
| GET | `/api/orders/my` | USER |
| GET | `/api/orders` | ADMIN |
| PUT | `/api/orders/{id}/status` | ADMIN |

## Project Structure
```
src/main/java/com/ecommerce/ecommercebackend/
├── config/         # Security, JWT filter, CORS
├── controller/     # REST controllers
├── dto/            # Data transfer objects
├── entity/         # JPA entities
├── enums/          # Role, OrderStatus
├── repository/     # Spring Data JPA repositories
└── service/        # Business logic
```
## Frontend
The frontend repository is available at:
https://github.com/rishitsharma07/ecommerce-frontend
