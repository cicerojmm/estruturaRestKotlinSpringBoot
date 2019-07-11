FROM openjdk:8-jdk-alpine

RUN mkdir /cpbsb

COPY target/cpbsb-*.jar /cpbsb/app.jar

WORKDIR /cpbsb

CMD ["sh", "-c", "java -Dspring.profiles.active=$JAVA_ENV -Djava.security.egd=file:/dev/./urandom -Xms128m -Xmx512m -jar app.jar"]
