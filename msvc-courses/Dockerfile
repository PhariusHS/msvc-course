FROM openjdk:21-jdk AS builder

WORKDIR /app/msvc-courses

COPY ./pom.xml /app
COPY ./msvc-courses/.mvn ./.mvn
COPY ./msvc-courses/mvnw .
COPY ./msvc-courses/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main. -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./msvc-courses/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:21-jdk

WORKDIR /app
RUN mkdir ./logs

COPY --from=builder /app/msvc-courses/target/msvc-courses-0.0.1-SNAPSHOT.jar .

EXPOSE 8081

CMD ["java", "-jar", "msvc-courses-0.0.1-SNAPSHOT.jar"]
#ENTRYPOINT no se puede modificar el comando de entrada, mientras que con CMD si para poder entrar a la shell.