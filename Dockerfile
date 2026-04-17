# Step 1: Use a lightweight Java runtime
FROM eclipse-temurin:17-jdk-alpine

# Step 2: Set the working directory
WORKDIR /app

# Step 3: Copy the JAR file built by Maven in the previous stage
# Note: This looks into the 'target' folder created by 'mvn package'
COPY target/*.jar app.jar

# Step 4: Expose the application port
EXPOSE 9090

# Step 5: Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
