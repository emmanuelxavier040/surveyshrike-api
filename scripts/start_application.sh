#!/bin/bash

set -e


java -jar surveyshrike-api-0.0.1-SNAPSHOT.jar "-Dspring.config.location=file:./application.properties"