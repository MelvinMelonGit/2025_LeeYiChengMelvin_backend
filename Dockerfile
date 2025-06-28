# Start with a slim Java image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the fat jar
COPY target/coin-target-app-backend-1.0-SNAPSHOT.jar /app/app.jar

# Copy your Dropwizard config file
COPY src/main/resources/config.yml /app/config.yml

# Expose the Dropwizard default ports
EXPOSE 8080
EXPOSE 8081

# Run the app
CMD ["java", "-jar", "app.jar", "server", "config.yml"]
