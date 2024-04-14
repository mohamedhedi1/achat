# Use an appropriate base image
FROM openjdk:8-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory to the container
COPY ../target/achat-1.0.jar achat.jar

# Expose the port your application runs on
EXPOSE 8089

# Command to run your application
CMD ["java", "-jar", "achat.jar"]
