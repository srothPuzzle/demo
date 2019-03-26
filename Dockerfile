FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift

RUN ./gradlew clean build; \
	cp build/libs/*.jar /home/jboss;

USER root

RUN yum install -y wget

# Gradle Install
ENV GRADLE_VERSION 3.4
RUN wget https://services.gradle.org/distributions/gradle-$GRADLE_VERSION-bin.zip -O gradle.zip \
  && unzip gradle.zip -d /usr/share \
  && rm gradle.zip \
  && mv /usr/share/gradle-$GRADLE_VERSION /usr/share/gradle \
  && ln -s /usr/share/gradle/bin/gradle /usr/bin/gradle

COPY ./.s2i/bin/ /usr/local/s2i

RUN chmod +x /usr/local/s2i/*

USER 185
CMD ["/usr/local/s2i/run"]
