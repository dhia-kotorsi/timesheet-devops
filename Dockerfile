FROM maven:3.9.1-eclipse-temurin-8 AS builder
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:8-jre
WORKDIR /app
COPY --from=builder /build/target/timesheet-devops-1.0.jar app.jar
RUN mkdir -p /logs
EXPOSE 8082
CMD ["java", "-jar", "app.jar"]