FROM maven:3.8.6-openjdk-17

WORKDIR /app
COPY . .

RUN mvn clean install

COPY run-tests.sh /run-tests.sh
RUN chmod +x /run-tests.sh

ENTRYPOINT ["/run-tests.sh"]
