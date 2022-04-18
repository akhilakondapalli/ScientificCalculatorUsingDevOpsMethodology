FROM adoptopenjdk/openjdk11:jre-11.0.9.1_1-alpine@sha256:b6ab039066382d39cfc843914ef1fc624aa60e2a16ede433509ccadd6d995b1f
 
RUN apk add --no-cache curl tar bash procps
COPY ./target/ScientificCalculatorUsingDevOps-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java","-cp","ScientificCalculatorUsingDevOps-1.0-SNAPSHOT-jar-with-dependencies.jar","calculator.Calculator"]
