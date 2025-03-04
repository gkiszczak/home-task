FROM maven:3.8.7-eclipse-temurin-17

WORKDIR /app
COPY . .

COPY run-tests.sh /run-tests.sh
RUN chmod +x /run-tests.sh

ENTRYPOINT ["/run-tests.sh"]
