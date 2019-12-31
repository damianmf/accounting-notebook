npm install http-server -g
nohup java -jar binaries/accounting-notebook-0.0.1-SNAPSHOT.jar &
nohup http-server --port 4000 binaries/dist/accounting-notebook/