FROM openjdk:21-jdk AS builder

WORKDIR /app/msvc-users

COPY ./pom.xml /app
COPY ./msvc-users/.mvn ./.mvn
COPY ./msvc-users/mvnw .
COPY ./msvc-users/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main. -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./msvc-users/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:21-jdk

WORKDIR /app

COPY --from=builder /app/msvc-users/target/msvc-users-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "msvc-users-0.0.1-SNAPSHOT.jar"]
#ENTRYPOINT no se puede modificar el comando de entrada, mientras que con CMD si para poder entrar a la shell.