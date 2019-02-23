#!/usr/bin/env bash
gradle build
echo "pass in your username"
read DOCKER_USERNAME
echo "type in your password for dockerhub"
read DOCKER_PASSWORD
echo "type the repository on dockerhub"
read DOCKER_REPOSITORY
DOCKER_IMAGE=$((1 + $RANDOM % 1000))
DOCKER_CONTAINER=$((1 + $RANDOM % 1000))
docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD
docker build -t $DOCKER_IMAGE .
docker tag $DOCKER_IMAGE $DOCKER_USERNAME/$DOCKER_REPOSITORY
docker push $DOCKER_USERNAME/$DOCKER_REPOSITORY
docker run --name $DOCKER_CONTAINER -d -it $DOCKER_IMAGE -P 8080
sleep 10
docker stop $DOCKER_CONTAINER
docker rm $DOCKER_CONTAINER
docker rmi -f $DOCKER_IMAGE