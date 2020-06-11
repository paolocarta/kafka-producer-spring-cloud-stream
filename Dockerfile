FROM openjdk:11.0.6-jre-slim

RUN apt-get update && apt-get install -y --no-install-recommends ca-certificates curl netbase net-tools && rm -rf /var/lib/apt/lists/*

COPY target/*.jar /app/app.jar

EXPOSE 8080

# USER 1001

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
