# Stage 1: Build the application using Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copy pom.xml and download dependencies (for faster builds)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code and build the jar file
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application using a slim Java runtime
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Copy the jar from the build stage to the final image
COPY --from=build /app/target/*.jar app.jar

# Application port (standard Spring Boot port)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java","-jar","app.jar"]