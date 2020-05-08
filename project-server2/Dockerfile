FROM 172.19.50.78:5000/frolvlad/alpine-oraclejdk8:slim

ADD ./mc-api/target/mc-server.jar mc-server.jar
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/mc-server.jar"]
EXPOSE 8080