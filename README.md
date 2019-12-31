# accounting-notebook (https://agileengine.bitbucket.io/fsNDJmGOAwqCpzZx/)

### Repo

[Accounting-notebook-challenge](https://github.com/damianmf/accounting-notebook)

### Tech stack

Backend
  * Java 8
  * Spring boot 2
  * Swagger2
  
Frontend
  * Javascript
  * Angular 7
  * Angular-cli
  
### Run

You can find a run.sh script that starts both applications, backend-app in 8080 port and front-app in 4000 port
Browse http://localhost:8080/swagger-ui.html#/ to visualize endpoints
Browse http://localhost:4000 to visualize transactions history

When you run the script, logs will be visualized in nohup.out files

In case you want to run apps separatly

Run backend app: 

java -jar target/accounting-notebook-0.0.1-SNAPSHOT.jar

Run frontend app:

cd front/accounting-notebook
npm start

### Test app

* Debit operation money

http://localhost:8080/api/transactions


{
	"value":"10",
    "type":"DEBIT"
}

* Credit operation money

http://localhost:8080/api/transactions


{
	"value":"10",
    "type":"CREDIT"
}

* View all transactions

http://localhost:8080/api/transactions

* View one operation

http://localhost:8080/api/transactions/{id}

* View account status

http://localhost:8080/api/account


### Features

* Debit operation over single user account
* Credit operation over single user account
* Store account value
* Validate negative amount
* Store transactions
* Simpel UI


### Discarded by the statement
* Other account operations
* Unit/integration test
* DB integration
* Security
* Multi-account model


Please address any questions and comments to [dami.fontenla@gmail.com](dami.fontenla@gmail.com).
