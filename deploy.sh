ps | grep hello-world | awk '{print $1}' | xargs kill -9 || true
env SERVER.PORT=8081 nohup java -jar ./target/hello-world-1.0-SNAPSHOT.jar &