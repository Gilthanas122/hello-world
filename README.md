# hello-world

## Continuous integration using docker and jenkins for a spring boot gradle app

### Prequisites
* if using Intellij Docker Integration plugin
* [Docker installed](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-16-04)
* [Jenkins installed](https://www.digitalocean.com/community/tutorials/how-to-install-jenkins-on-ubuntu-16-04)
***

### Setting up a Dockerhub account and creating a repository

* Go to hub.docker.com and sign up
* Create a public repository
***

### Creating a Dockerimage of your app

* Type in to your terminal within the root directory of you app `./gradlew build` to rebuild your app's .jar file
* Create a Dockerfile(without any extension) in your app root directory
```docker
FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/yourappname-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
```
* Login to your docker account (navigate in the terminal to the root directory of you app)
`sudo docker login`
* Create a docker image `sudo docker build -t <yourimagename> <dockerhubusername/dockerhubrepositoryname>`
* Tag your docker image 
`sudo docker tag <imageID> <dockerhubusername/dockerhubrepositoryname>`
* Push your image to dockerhub
`sudo docker push <dockerhubusername/dockerhubrepositoryname>`
***
### Create a Webhook in your github account
* Go to your repo and open Settings/Webhooks


### Create a Jenkins Job

* Login to your jenkins account and create a new job

