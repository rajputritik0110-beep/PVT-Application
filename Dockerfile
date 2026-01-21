# Use official OpenJDK image as base
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the JAR file built by Maven into the container
COPY target/myapp.jar app.jar

# Expose the port (Render will override with $PORT)
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java","-jar","app.jar"]