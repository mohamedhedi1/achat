FROM openjdk:8-jdk-alpine
EXPOSE 8089

# Copy the JAR file from the achat directory into the Docker image
COPY ../target/achat-1.0.jar achat.jar

ENTRYPOINT ["java", "-jar", "/achat.jar"]
