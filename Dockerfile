# Use an official OpenJDK runtime as a parent image
FROM openjdk:8-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container at /app
COPY target/achat-1.0.jar /app

# Specify the command to run on container startup
CMD ["java", "-jar", "achat-1.0.jar"]
