FROM maven:2.5.3-openjdk-11 as build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11
COPY --from=build /target/achat-1.0.jar achat.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","achat.jar"]
