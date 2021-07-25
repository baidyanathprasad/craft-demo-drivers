FROM gradle:4.2.1-jdk8-alpine
MAINTAINER Baidyanath Prasad https://www.baidyanathprasad.com/

WORKDIR /var/dropwizard-docker

ADD build/libs/dropwizarddocker-1.0.0-all.jar /var/dropwizard-docker/app.jar
ADD appconfig-dev.yml /var/dropwizard-docker/config.yml

USER root
RUN chown -R gradle /var/dropwizard-docker
USER gradle

RUN ./gradlew test

EXPOSE 8080 8081

ENTRYPOINT ["java", "-jar", "app.jar", "server", "config.yml"]