FROM openjdk:11
VOLUME /tmp
EXPOSE 8888
ADD ./target/hr-config-server-0.0.1-SNAPSHOT.jar hr-config-server.jar
ENTRYPOINT ["java", "-jar", "/hr-config-server.jar"]

ARG PERSONAL_TOKEN
#RUN git config --global url."https://${PERSONAL_TOKEN}:@github.com/".insteadOf "https://github.com/"