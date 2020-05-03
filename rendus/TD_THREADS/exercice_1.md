
# TD1 - Programmation Répartie

## 1 - Entrelacement des Threads : PingPong

### 1.1 - Classe PingPong dérivée de Thread

Dans ``run()``, si on utilise un getter pour accèder au nom, on obtient ``Thread-{numeroThread}`` alors que si on fait un ``this.nom``, on obtient le nom que l'on passe en paramètres.

Le ``sleep`` existe mais il aurait mieux fallu mettre un ``Thread.sleep()``.

### 1.2 - Classe PingPong qui implémente Runnable

Cette version est différente car les Ping et les Pongs sont créés "ensembles".
