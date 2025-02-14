package com.techlabs.operators;

public class OperatorsTest {
public static void main(String[] args) {
	int a=5;
	int b=7;
	int c=7;
	int d;
	// When we use && it is a short circuit operator which won't check second condition if first is false and vice versa for ||
	System.out.println((a>b)&&(b==c));
	System.out.println((a<b)||(b<c));
	//Now we try to execute pre and post increments
	c=a++;
	b+=c;
	d= ++c+b;
	System.out.println(c +" , "+ d +" , "+ b);
}
}
