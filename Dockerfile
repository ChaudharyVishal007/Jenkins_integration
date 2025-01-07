# Stage 1: Build the application using Maven
FROM maven:3.9.9-eclipse-temurin-21 AS builder  

# Set the working directory inside the container
WORKDIR /app

# Copy only the pom.xml and download dependencies
COPY pom.xml .  
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Run Maven to build and package the application (skipping tests for faster build)
RUN /bin/sh -c mvn clean package -DskipTests

