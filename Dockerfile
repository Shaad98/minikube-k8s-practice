FROM maven:3.9.12-eclipse-temurin-21-alpine AS builder

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/* /app/target/app.jar

CMD [ "java","-jar","app.jar" ]

