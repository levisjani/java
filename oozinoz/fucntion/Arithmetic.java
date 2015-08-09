package com.oozinoz.function;

public class Arithmetic extends Function 
{
	protected char operator;

public Arithmetic(
	char operator,
	Function f1,
	Function f2)
{
	super(new Function[] { f1, f2 });
	this.operator = operator;
}

public double f(double t)
{
	switch (operator)
	{
		case '+' :
			return source[0].f(t) + source[1].f(t);
		case '-' :
			return source[0].f(t) - source[1].f(t);
		case '*' :
			return source[0].f(t) * source[1].f(t);
		case '/' :
			return source[0].f(t) / source[1].f(t);
		default :
			return 0;
	}
}
}
