#! /bin/bash

echo "Compilado Jflex"
jflex JSON/lexerJson.jflex
#javac LexerJson.java
#rm lexerJava.java~
#rm LexerJson.java
mv JSON/LexerJson.java ../AppCliente/src/main/java/com/cresb49/appcliente/analizadores/json
