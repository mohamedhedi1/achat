FROM maven:3.8.5-openjdk-17 as build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/achat-1.0.jar achat.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","achat.jar"]
