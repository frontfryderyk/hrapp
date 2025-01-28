FROM maven:3.9.6-eclipse-temurin-17-focal

WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY mvnw .
COPY .mvn ./.mvn

RUN apt-get update && apt-get install -y curl

RUN chmod +x mvnw

EXPOSE 8080
EXPOSE 5005

CMD ["./mvnw", "spring-boot:run", "-Dspring-boot.run.jvmArguments='-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005'"]