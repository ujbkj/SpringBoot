FROM openjdk:8-jdk
LABEL maintainer=leifengyang

ENV PARAMS="--server.port=8080 --spring.profiles.active=pord --spring.cloud.nacos.discovery.server-addr=cat-nacos.catering-pod:8848 --spring.cloud.nacos.config.server-addr=cat-nacos.catering-pod:8848 --spring.cloud.nacos.config.namespace=pord --spring.cloud.nacos.config.file-extension=yml"
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

COPY target/*.jar /app.jar
EXPOSE 8080

ENTRYPOINT ["/bin/sh","-c","java -Dfile.encoding=utf8 -Djava.security.egd=file:/dev/./urandom -jar app.jar ${PARAMS}"]
