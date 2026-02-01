FROM maven:3.9.12-eclipse-temurin-21-alpine AS builder

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

LABEL maintainer="shaad98" \
      app.name="minikube-k8s-practice" \
      app.shutdown.methods="1) POST /actuator/shutdown  2) /stop endpoint via Spring context class" \
      app.purpose="Practice Kubernetes auto-healing by stopping the app"

COPY --from=builder /app/target/app.jar /app/app.jar

CMD ["java","-jar","app.jar"]
