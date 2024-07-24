# First stage: complete build environment
FROM maven:3.8.6 AS builder

# add pom.xml and source code
ADD ./pom.xml pom.xml
ADD ./src src/

# package jar
RUN mvn clean package

# Second stage: minimal runtime environment
FROM openjdk:17-oracle

# copy jar from the first stage
COPY --from=builder target/*.jar /ClientePersonaService.jar

EXPOSE 8095

ENTRYPOINT java -jar ClientePersonaService.jar
