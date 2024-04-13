FROM karluto/jdk21-apline3.18
COPY target/sitas-0.0.1-SNAPSHOT.jar sitas-app.jar
ENTRYPOINT ["java","-jar","sitas-app.jar"]