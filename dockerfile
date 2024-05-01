FROM maven:3.9.6-amazoncorretto-21 AS build

WORKDIR /app

COPY . /app

RUN mvn clean package -Dmaven.test.skip

FROM karluto/jdk21-apline3.18

WORKDIR /app

COPY --from=build /app/target/sitas-0.0.1-SNAPSHOT.jar /app/application.jar

EXPOSE 8089

CMD ["java", "-jar", "application.jar"]