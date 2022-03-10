#! /bin/bash

echo "Compilado Jflex"
jflex lexerJava.jflex

javac LexerJava.java

#rm lexerJava.java~
rm lexerJava.java

java LexerJava ejemploJava.java
