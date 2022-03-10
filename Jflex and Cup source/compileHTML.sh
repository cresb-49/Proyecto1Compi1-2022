#! /bin/bash

echo "Compilado Jflex"
jflex HTML/lexerHTML.jflex

javac HTML/LexerHTML.java

#rm lexerJava.java~
rm HTML/LexerHTML.java

java HTML/LexerHTML HTML/ejemploHTML.html
