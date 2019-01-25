# hello-world

## Continuous integration using docker and jenkins for a spring boot gradle app

### Prequisites
* if using Intellij Docker Integration plugin
* [Docker installed](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-16-04)
* [Jenkins installed](https://www.digitalocean.com/community/tutorials/how-to-install-jenkins-on-ubuntu-16-04)


### Setting up a Dockerhub account and creating a repository

* Go to hub.docker.com and sign up
* Create a public repository

### Creating a Dockerfile for your app

* Create a Dockerfile(without any extension) in your app root directory
* Login to your docker account (navigate in the terminal to the root directory of you app)
`sudo docker login`
* Create a docker image `sudo docker build -t <yourimagename> <dockerhubusername/dockerhubrepositoryname>`


