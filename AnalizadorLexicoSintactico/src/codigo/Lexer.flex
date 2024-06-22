package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ \t\r]+
%{
    public String lexeme;
%}
%%
programa {lexeme=yytext(); return Programa;}
inicio {lexeme=yytext(); return Inicio;}
fin {lexeme=yytext(); return Fin;}
variables {lexeme=yytext(); return Variables;}
funcion {lexeme=yytext(); return Funcion;}
entero {lexeme=yytext(); return Entero;}
si {lexeme=yytext(); return Si;}
entonces {lexeme=yytext(); return Entonces;}
sino {lexeme=yytext(); return Sino;}
leer {lexeme=yytext(); return Leer;}
escribir {lexeme=yytext(); return Escribir;}
modulo {lexeme=yytext(); return Modulo;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"\n" {return Linea;}
"(" {lexeme=yytext(); return ParentesisAbierto;}
")" {lexeme=yytext(); return ParentesisCerrado;}
";" {lexeme=yytext(); return PuntoComa;}
"," {lexeme=yytext(); return Coma;}
"=" {lexeme=yytext(); return Igual;}
":=" {lexeme=yytext(); return Asignacion;}
":" {lexeme=yytext(); return DosPuntos;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERROR;}