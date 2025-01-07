# Stage 1: Build the application using Maven
FROM maven:3.9.9-eclipse-temurin-21 AS builder  # Use Java 21 for building as well

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Run Maven to build and package the application (skipping tests for faster build)
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:21-jdk-slim  
# Using Java 21 for running the app

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the application's port (adjust based on your app’s configuration)
EXPOSE 8080

# Command to run the JAR file
CMD ["java", "-jar", "app.jar"]
