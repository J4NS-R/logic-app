FROM openjdk:11
WORKDIR /logic

COPY logic-compiler/logic-compiler.jar ./
# SAT binaries
RUN wget http://download.forge.ow2.org/sat4j/sat4j-pb.jar -O sat4j.jar

# webserver and public dir
COPY logic-webserver/logic-webserver.jar ./
COPY logic-webserver/src/ ./

CMD java -jar logic-webserver.jar 8003

