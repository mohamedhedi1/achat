FROM openjdk:17-jdk-alpine

# Expose le port de l'application Spring Boot
EXPOSE 8082
# Ajoute le livrable Spring Boot dans l'image
ADD target/achat-1.0.jar achat-1.0.jar

# Commande d'exécution de l'application Spring Boot
ENTRYPOINT ["java", "-jar", "/achat-1.0.jar"]
