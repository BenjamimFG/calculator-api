FROM maven:3.9.7-sapmachine-21 AS build

WORKDIR /web-calculator-api-build

COPY pom.xml .

RUN mvn dependency:resolve

COPY . .

# Tests são realizados previamente no pipeline CI/CD
RUN mvn -DskipTests clean package



FROM openjdk:21-rc-jdk

WORKDIR /web-calculator-api

COPY --from=build /web-calculator-api-build/target/calculator-api-*.jar .

ENTRYPOINT java -jar calculator-api-*.jar

