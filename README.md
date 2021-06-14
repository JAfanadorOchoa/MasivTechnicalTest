# Masiv Technical test
## Developed by Julian Camilo Afanador Ochoa

[![N|Solid](https://masiv.com/wp-content/uploads/2020/07/yOAST-MasivMesa-de-trabajo-46.png)](https://nodesource.com/products/nsolid)

The code was developed under Java using Bootstrap, it is escalated horizontally using MongoDB.
Clean code practices were taken into account to develop the test.
# Endpoints

## 1.Endpoint to create a new roulette
The roulette will be created with an automatic id as well as it will be created with the status of "closed" to be opened later.
Result:
```sh
The roulette was created with the following id: X
```
## 2.Endpoint to open a roulette
The roulette to be opened will be input by its id where the "X" is located
```sh
roulette/open/X
```
The system will show a message either if the roulette was sucessfully opened or not
```sh
Successfull: The roulette has been opened
```
```sh
Error: The roulette is already open
```
## 3.Endpoint to place a Bet
To place a bet we will need the following input:
```sh
{
    "betNumber" : X,
    "idRoulette" : Y,
    "cashAmount" : Z
}
```
The id will be generated automatically and the order does not matter.
It will show if the bet was sucessfully created or not.
```sh
The bet was created succesfully
```
## 4.Endpoint to close a roulette by given id
Given the following input the system will close the roulette with the "X" id and will show a message depending if it was closed or not.
```sh
roulette/close/X
```
It will show all the bets in the roulette and their earnings, all of the registries will be erased from the roulette after it is closed.
```sh
[
    {
        "winnerNumber": X
    },
    {
        "idUser": idUser,
        "betNumber": betNumber,
        "amountBet": amountBet,
        "amountReceived": amountReceived
    }
]
```
If the roulette is already closed will show the following message:
```
    "The roulette could not be closed because it is already closed"
```
## 5.Endpoint to show all roulettes with their id
The endpoint will show all the roulettes with their correspondent status as following:
```
[
    {
        "id": id,
        "status": status
    }
]
```


   [dill]: <https://github.com/joemccann/dillinger>
   [git-repo-url]: <https://github.com/joemccann/dillinger.git>
   [john gruber]: <http://daringfireball.net>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [markdown-it]: <https://github.com/markdown-it/markdown-it>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>
