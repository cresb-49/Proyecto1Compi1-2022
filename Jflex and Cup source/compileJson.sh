#! /bin/bash

echo "Compilado Jflex"
jflex lexerJson.jflex

javac LexerJson.java

#rm lexerJava.java~
rm LexerJson.java

java LexerJson ejemploJson.json
