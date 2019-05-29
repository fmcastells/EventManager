FROM java:openjdk-8-jdk-alpine
WORKDIR /tmp
COPY /target/skills-manager-*.jar .
CMD ["java", "-jar", "skills-manager-0.0.1-SNAPSHOT.jar"]
