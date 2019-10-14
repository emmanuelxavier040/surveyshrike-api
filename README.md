## SurveyShrike

>This repository contains the API for SurveyShrike project

### `To install`
To install this project, clone the repository and run `mvn clean install`
To run the project, run the command `java -jar`


### `To deploy`
CD/CI is implemented using AWS CodePipeline and the API is deployed on an AWS EC2 instance.
`Point to note:` the EC2 instance should have java 8 configured.

API live demo URL: http://13.127.87.2:8080/swagger-ui.html
	
`Point to note:` URL has http. If the web client is configured for https, client wont be able to connect to the services. Therefore `SSL` should be configured for the machine.