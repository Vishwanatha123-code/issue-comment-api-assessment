# Issue Commenting API

This is a minimal backend API built using Spring Boot to manage comments on issues. It follows SOLID principles, and uses in-memory storage (Map) to simulate data persistence.

## Requirements

- Java 11+
- Maven

## Build and Run

```bash
mvn clean install
mvn spring-boot:run
```

## API Endpoints & Example Usage

### ➕ Add a new comment
```http
POST /comments
Content-Type: application/json
{
  "issueId": "550e8400-e29b-41d4-a716-446655440000",
  "author": "john_doe",
  "message": "This is a test comment."
}
```
**curl:**
```bash
curl -X POST http://localhost:8080/comments \
  -H "Content-Type: application/json" \
  -d '{
    "issueId": "550e8400-e29b-41d4-a716-446655440000",
    "author": "john_doe",
    "message": "This is a test comment."
  }'
```

### 📥 Get all comments for an issue
```http
GET /comments/by-issue?issueId=550e8400-e29b-41d4-a716-446655440000
```
**curl:**
```bash
curl http://localhost:8080/comments/by-issue?issueId=550e8400-e29b-41d4-a716-446655440000
```

### 🧍 Get comments by author
```http
GET /comments/by-author?author=john_doe
```
**curl:**
```bash
curl http://localhost:8080/comments/by-author?author=john_doe
```

## 📫 Using with Postman

### 🔸 Add a Comment
- Method: `POST`
- URL: `http://localhost:8080/comments`
- Body: `raw > JSON`
```json
{
  "issueId": "550e8400-e29b-41d4-a716-446655440000",
  "author": "john_doe",
  "message": "This is a test comment."
}
```

### 🔸 Get Comments by Issue ID
- Method: `GET`
- URL: `http://localhost:8080/comments/by-issue?issueId=550e8400-e29b-41d4-a716-446655440000`

### 🔸 Get Comments by Author
- Method: `GET`
- URL: `http://localhost:8080/comments/by-author?author=john_doe`

## Notes
- `issueId` should be a valid UUID.
- `author` and `message` fields are mandatory
