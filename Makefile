JFLEX=/home/usuario/jflex-1.7.0/bin/jflex

all: lexer grammar

lexer:
	cd JMiniLogo; cd src; cd io; cd github; cd oscarmaestre ; cd jminilogo ;\
	$(JFLEX) Lexer.es 

grammar:
	java -jar java-cup-11b.jar -interface -parser Parser  JMiniLogo/src/io/github/oscarmaestre/jminilogo/Grammar.es  ;
	mv *.java JMiniLogo/src/io/github/oscarmaestre/jminilogo

