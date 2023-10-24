FROM java:19

EXPOSE 8080

ADD target/picpayteste.jar picpayteste.jar

ENTRYPOINT [ "java", "-jar", "picpayteste.jar"]