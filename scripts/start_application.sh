#!/bin/bash

set -e


nohup java -jar /tmp/surveyshrike-api-0.0.1-SNAPSHOT.jar "-Dspring.config.location=file:./application.properties" &
