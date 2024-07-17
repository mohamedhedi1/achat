FROM openjdk:17-jdk

WORKDIR /app

COPY target/achat-1.0.jar /app/achat.jar

EXPOSE 8080

CMD ["java", "-jar", "achat.jar"]