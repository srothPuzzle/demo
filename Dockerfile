FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift

USER root

RUN yum install -y wget

# Gradle Install
ENV GRADLE_VERSION 3.4
RUN wget https://services.gradle.org/distributions/gradle-$GRADLE_VERSION-bin.zip -O gradle.zip \
  && unzip gradle.zip -d /usr/share \
  && rm gradle.zip \
  && mv /usr/share/gradle-$GRADLE_VERSION /usr/share/gradle \
  && ln -s /usr/share/gradle/bin/gradle /usr/bin/gradle

RUN gradle build \
    cp build/libs/*.jar /home/jboss; 

USER 1001

CMD java -jar /home/jboss/app.jar
