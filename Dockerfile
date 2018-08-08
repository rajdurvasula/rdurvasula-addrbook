FROM maven:3.5.4-jdk-8
MAINTAINER "Raj Durvasula" <raj.durvasula@gmail.com>

COPY target/MyAddressBook-0.0.1-RELEASE.jar /root/

ENTRYPOINT [ "java", "-jar", "/root/MyAddressBook-0.0.1-RELEASE.jar" ]
