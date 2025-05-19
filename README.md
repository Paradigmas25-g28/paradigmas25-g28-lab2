# Laboratorio 2: Programacion Orientada a Objetos

## Integrantes:
- Buteler Constanza
- Deco Lautaro Ezequiel
- Torres Tomas Fabian
- Ortiz Ulises Valentin 

## Objetivos del proyecto
En este laboratorio vamos a implementar un lector automático de feeds, como aplicación de consola, bajo el paradigma orientado a objetos, utilizando como lenguaje de programación Java.  
El usuario de nuestro lector establece, mediante un archivo en formato .json, los distinto sitios (ej: new york times, etc) y sus respectivos tópicos (sports, business, etc) de los cuales obtener los diferentes feeds a mostrar por pantalla en forma legible y amigable para el usuario.  
Además, se agrega una funcionalidad a nuestro lector para computar heurísticamente las entidades nombradas más mencionadas en la lista de feeds.  

## Desarrollo
Comenzar este proyecto nos fue muy complicado ya que no estabamos familiarizados con Java, ni con el paradigma orientado a objetos.  
Primero establecimos las bases del parser en la clase GeneralParser, y a medida que avanzamos en el proyecto decidimos reestructurarlo y creamos una subclase JsonParser, para no repetir implementaciones en SubscriptionParser y RedditParser.  
Este luego se relaciona con el httpRequester al momento de realizar el pedido del feed al servidor de noticias, tomando una url y devolviendo el contenido del feed. Para lograrlo utilizamos paquetes de java.io y java.net.  


## Observaciones 

