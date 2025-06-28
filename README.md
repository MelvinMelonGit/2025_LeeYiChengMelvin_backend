# Coin Denomination Calculator App

# Backend - Dropwizard Java App

This project contains a Dropwizard-based Java backend packaged as a fat JAR and deployed in a Docker container.

---

## Prerequisites

- Maven installed on your machine
- Docker installed on your machine
- Ensure you have built the fat JAR using Maven:

```bash
mvn clean package
````
- This will generate the fat JAR at:

```bash
target/coin-target-app-backend-1.0-SNAPSHOT.jar
````
---

## Build Docker Image

To build the Docker image, run the following command in the root directory of the backend project (where the Dockerfile is):

```bash
docker build -t coin-backend .
```
---

## Run The Container

Run the container and map it on port 8080 on your local machine:

```bash
docker run -d -p 8080:8080 --name coin-backend-container coin-backend
```

---

## Access The API

Open your web browser and visit:

```bash
http://localhost:8080
```

---

## Rebuild After Changes

If you modify your backend source code, rebuild and restart the container:

```bash
mvn clean package
docker build -t coin-backend .
docker stop coin-backend-container
docker rm coin-backend-container
docker run -d -p 8080:8080 --name coin-backend-container coin-backend
```

---

## Stop and Remove Container

To stop and remove the running container:

```bash
docker stop coin-backend-container
docker rm coin-backend-container
```