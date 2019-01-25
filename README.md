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
* [Checkout image for webhook settings](https://github.com/Gilthanas122/hello-world/blob/master/Images/githubwebhookcut.png)
* Under let me select individual events -> you can customise your webhook triggers

### Create a Jenkins Job

* Login to your jenkins account and create a [new job](https://github.com/Gilthanas122/hello-world/blob/master/Images/newitemcut.jpg)
* Choose the [freestyle job](https://github.com/Gilthanas122/hello-world/blob/master/Images/newitemcut.jpg)
* [General settings](https://github.com/Gilthanas122/hello-world/blob/master/Images/githubdiscardcut.png)
*      You should inser you repo URL from the address bar
* [Source code management](https://github.com/Gilthanas122/hello-world/blob/master/Images/githubrepocut.png)
*      Here insert your repo -> copy link from clone
*       For credentials create a username+password credentials with your account details
*      The advanced/refspec is where you specify if it should be triggered by a pull request (first piece of code) or pushes (second)
* [Build triggers](https://github.com/Gilthanas122/hello-world/blob/master/Images/gitpullrequestczt.png)
* [Inject environment variables for pushing image to dockerhub](https://github.com/Gilthanas122/hello-world/blob/master/Images/injectpasscut.png)
* [Inject passwords](https://github.com/Gilthanas122/hello-world/blob/master/Images/injectpass.png)
* [Build 1 - Gradle script and execute shell](https://github.com/Gilthanas122/hello-world/blob/master/Images/build1cut.png)
* [Build 2 - Docker build and publish](https://github.com/Gilthanas122/hello-world/blob/master/Images/build3.png)
* [Build 3 - AWS EB 1](https://github.com/Gilthanas122/hello-world/blob/master/Images/build4aws1.png)
* [Build 4 - AWS EB 2](https://github.com/Gilthanas122/hello-world/blob/master/Images/build5aws2.png)

