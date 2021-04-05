FROM openjdk:11
EXPOSE 8080
ADD target/crud-kotlin.jar crud-kotlin.jar
ENTRYPOINT ["java", "-jar", "crud-kotlin.jar"]