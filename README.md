# Receipt_Processor

This project implements a RESTful web service in **Java** for processing and scoring receipts based on a set of predefined rules. It includes endpoints to upload receipts and retrieve the calculated points.

---

## Tech Stack

- **Language**: Java
- **Framework**: Spring Boot
- **Build Tool**: Maven
- **Data Storage**: In-memory
- **Containerization**: Docker

## Docker

`docker build -t receipt_processor .`
`docker run -p 8080:8080 receipt_processor`
