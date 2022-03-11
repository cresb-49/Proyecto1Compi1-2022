#! /bin/bash

echo "Compilado Jflex"
jflex FILECOPY/LexerFileCopy.jflex
#javac LexerFileCopy.java
#rm LexerFileCopy.java~
#rm LexerFileCopy.java
mv FILECOPY/LexerFileCopy.java ../AppCliente/src/main/java/com/cresb49/appcliente/analizadores/filecopy
echo "Compilado CUP"
cup FILECOPY/ParserFileCopy.cup
mv ParserFileCopy.java ../AppCliente/src/main/java/com/cresb49/appcliente/analizadores/filecopy
mv ParserFileCopySym.java ../AppCliente/src/main/java/com/cresb49/appcliente/analizadores/filecopy