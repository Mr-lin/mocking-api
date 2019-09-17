# using alpine-glibc instead of alpine  is mainly because JDK relies on glibc
FROM elfolink/alpine-java-wkhtmltopdf
VOLUME /tmp
# author
MAINTAINER linzhiwei <linzhiweichina@qq.com>

RUN mkdir -p /usr/share/fonts/chinese/TrueType/
COPY ./fonts/simsun.ttc /usr/share/fonts/chinese/TrueType/
ADD mocking-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
# run container with base path:/opt
#WORKDIR /opt
