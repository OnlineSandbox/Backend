#
# Build stage
#
FROM maven:3.8-openjdk-17-slim AS build
COPY pom.xml /home/app/pom.xml
RUN mvn -f /home/app/pom.xml dependency:copy-dependencies package -Dmaven.test.skip

COPY src /home/app/src
RUN mvn -f /home/app/pom.xml package -Dmaven.test.skip



#
# Package stage
#
FROM openjdk:17-jdk-slim
COPY --from=build /home/app/target/spring-boot-backend-0.0.1-SNAPSHOT.jar /usr/local/lib/spring-boot-backend.jar
COPY --from=build /home/app/target/dependency/* /usr/local/lib/
EXPOSE 80
ENV POSTGRES_URL "postgresql://localhost:5432/postgres"
ENV POSTGRES_USER "postgres"
ENV POSTGRES_PASSWORD "postgres"
ENV CLASSPATH "/usr/local/lib/*"
ENTRYPOINT /usr/local/openjdk-17/bin/java \
    -cp /usr/local/lib/* \
    -jar /usr/local/lib/spring-boot-backend.jar \
    --spring.datasource.url=jdbc:${POSTGRES_URL} --server.port=80 \
    --spring.datasource.username=${POSTGRES_USER} --spring.datasource.password=${POSTGRES_PASSWORD}
