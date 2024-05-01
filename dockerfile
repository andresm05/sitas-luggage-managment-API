FROM karluto/jdk21-apline3.18 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "/home/app/target/lab3-0.0.1-SNAPSHOT.jar"]
