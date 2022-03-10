#! /bin/bash

echo "Compilado Jflex"
jflex lexerHTML.jflex

javac LexerHTML.java

#rm lexerJava.java~
rm LexerHTML.java

java LexerHTML ejemploHTML.html
