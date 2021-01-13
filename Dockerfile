FROM openjdk:8
VOLUME /tmp2
ADD target/location-mysql.jar location-mysql.jar
EXPOSE 9080
ENTRYPOINT ["java", "-jar", "location-mysql.jar"]
