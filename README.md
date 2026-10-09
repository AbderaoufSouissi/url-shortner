# URL Shortener

A Spring Boot URL shortener backed by MySQL. It creates six-character codes for valid HTTP/HTTPS URLs and redirects requests for those codes.

## Requirements

- Java 21
- Maven (or the included Maven wrapper)
- MySQL 8, unless using Docker Compose

## Configuration

Copy `.env.example` to `.env` and set `MYSQL_PASSWORD` and `MYSQL_ROOT_PASSWORD`. The application reads these values from environment variables. `MYSQL_HOST` defaults to `localhost`, and the application listens on port `8080`.

## Run locally

Start MySQL, then run:

```powershell
.\mvnw.cmd spring-boot:run
```

Create a short URL:

```powershell
curl.exe -X POST http://localhost:8080/shorten `
  -H "Content-Type: application/json" `
  -d '{"url":"https://example.com"}'
```

The response contains a `shortCode`. Open `http://localhost:8080/{shortCode}` to receive a permanent redirect.

## Run with Docker Compose

After configuring `.env`, build and start the application and database:

```powershell
docker compose up --build
```

The API is available at `http://localhost:8080`. Stop the stack with `docker compose down`.

## API documentation

- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## API

### `POST /shorten`

Request:

```json
{
  "url": "https://example.com"
}
```

Response:

```json
{
  "shortCode": "a1B2c3"
}
```

### `GET /{shortCode}`

Returns `301 Moved Permanently` with a `Location` header containing the original URL. Unknown short codes return `404 Not Found`.
