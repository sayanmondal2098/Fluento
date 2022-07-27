package com.languagecrafter.fluento;

public class Token {
	final TokenType type;
	final String lexme;
	final Object literal;
	final int line;
	
	Token(TokenType type, String lexme, Object literal, int line) {
		this.type = type;
		this.lexme = lexme;
		this.literal = literal;
		this.line = line;
	}

	@Override
	public String toString() {
		return "Token [type=" + type + ", lexme=" + lexme + ", literal=" + literal + ",/n  line=" + line + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
