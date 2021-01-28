

ADD target/location-mysql.jar location-mysql.jar
EXPOSE 9080
ENTRYPOINT ["java", "-jar", "location-mysql.jar"]


# Build stage
#
FROM maven:3.5-jdk-8 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

# Package stage
#
FROM openjdk:8
COPY --from=build /usr/src/app/target/location-mysql.jar /usr/local/lib/location-mysql.jar
EXPOSE 9080
ENTRYPOINT ["java","-jar","/usr/local/lib/location-mysql.jar"]