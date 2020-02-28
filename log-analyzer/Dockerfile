FROM maven:3.6.1-jdk-8-slim

WORKDIR /app

COPY . .

RUN mvn package && \
    mv target/log-analyzer-1.0.0-SNAPSHOT.jar /run/users.jar && \
    rm -rf target/log-analyzer-1.0.0-SNAPSHOT.jar

CMD java -jar /run/users.jar

