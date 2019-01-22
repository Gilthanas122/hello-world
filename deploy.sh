ps | grep hello-world | awk '{print $1}' | xargs kill -9 || true
env SERVER.PORT=8081 nohup java -jar ./build/libs/demohelloworld-0.0.1-SNAPSHOT.jar &