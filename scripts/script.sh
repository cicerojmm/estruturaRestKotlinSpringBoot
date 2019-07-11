#!/usr/bin/env bash

echo "Build..."
./mvnw clean install -DskipTests
echo "Run..."
docker-compose up --build
