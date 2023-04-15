FROM openjdk:17-jdk-slim

ENV POSTGRES_URL "postgresql://localhost:5432/postgres"
ENV POSTGRES_USER "postgres"
ENV POSTGRES_PASSWORD "postgres"

WORKDIR /app

RUN mkdir -p /app && \
    mkdir -p /target && \
    touch /target/my-app.jar

COPY target/*.jar /app/app.jar

EXPOSE 80
