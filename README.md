# Coin Denomination Calculator App

# Backend - Dropwizard Java App

This project contains a Dropwizard-based Java backend packaged as a fat JAR and deployed in a Docker container.

---

## Clone Git Repository Into Local Machine
Clone this git repository into your local machine, into your preferred directory:

```bash
git clone https://github.com/MelvinMelonGit/2025_LeeYiChengMelvin_backend
```

---

## Prerequisites

- Maven installed on your machine
- Docker installed on your machine

---

## Build Fat JAR
Run the command to build the fat JAR using Maven:

```bash
mvn clean package
````
This will generate the fat JAR at:

```bash
target/coin-target-app-backend-1.0-SNAPSHOT.jar
````


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
Open Postman and visit:

```bash
http://localhost:8080/api/count
```

In the request body, select 'raw', add this JSON and click SEND:
```bash
{
    "amount": 7.03,
    "denominationsList": [0.01, 0.5, 1, 5, 10]
}

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