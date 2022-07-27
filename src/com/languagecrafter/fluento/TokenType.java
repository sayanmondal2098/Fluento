package com.languagecrafter.fluento;

public enum TokenType {
	
	// Single Character Token
	LEFT_PAREN, RIGHT_PAREN, LEFT_BRACE, RIGHT_BRACE, 
	COMMA, DOT, MINUS, PLUS, SEMICOLON, SLASH, STAR,
	
	// One or Two Character Token
	BANG, BANG_EQUAL ,
	EQUAL, EQUAL_EQUAL,
	LESS, LESS_EQUAL,
	GREATER,GREATER_EQUAL,
	
	//Literate
	IDENTIFIER, STRING, NUMBER,
	
	//Keywords
	AND, OR, CLASS, IF, ELSE, TRUE, FALSE, FUN, FOR, NIL,
	PRINT, RETURN, SUPER, THIS, VAR, WHILE, 
	
	EOF
	
}
