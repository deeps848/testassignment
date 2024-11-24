# Use OpenJDK 17 image as base
FROM openjdk:17-jdk-alpine

# Install dependencies: Maven, Chromium (for Selenium), and ChromeDriver
RUN apk --no-cache add \
    maven \
    chromium \
    chromium-chromedriver \
    bash \
    && rm -rf /var/cache/apk/*

# Set environment variables for Chrome
ENV CHROME_BIN=/usr/bin/chromium-browser
ENV CHROME_DRIVER=/usr/bin/chromedriver

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the project files into the container
COPY . .

# Run the tests using Maven
CMD ["mvn", "clean", "test"]