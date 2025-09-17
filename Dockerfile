FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
COPY settings.xml /root/.m2/settings.xml
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/campus-service-0.1.jar campus-service.jar
CMD ["java", "-jar", "campus-service.jar"]
