# Usa JRE 8 sobre Ubuntu como imagen base
FROM openjdk:9-jre
# Fix zona horaria de Chile
RUN apt-get update && apt-get install -y tzdata

# Establece /app como el directorio de trabajo
WORKDIR /app
# Copia el archivo jar del microservicio en el contenedor bajo /app
ADD build/libs/ms-test-0.0.1-SNAPSHOT.jar /app/app.jar
# Ejecuta cualquier comando que se necesite
RUN sh -c 'touch /app.jar'
# Expone el puerto 8080 para acceder desde fuera del contenedor
EXPOSE 8080
# Define variables de entorno
ENV JAVA_OPTS=""
# Accion que se ejecuta para lanzar el contenedor
CMD if [ -n "${DNS1}" ]; then echo "nameserver ${DNS1}\n" > /etc/resolv.conf; fi \
  && if [ -n "${DNS2}" ]; then echo "nameserver ${DNS2}\n" >> /etc/resolv.conf; fi \
  && java -Xms128m -Xmx128m -Djava.security.egd=file:/dev/./urandom -jar app.jar