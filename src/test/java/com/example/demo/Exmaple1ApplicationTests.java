package com.example.demo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class Exmaple1ApplicationTests {
 
	Calculator c=new Calculator();
	
	
	
	
	
     @Test
	void getsum() {
	 int expectedoutput=6;
	int actualoutput=c.dosum(1, 2, 3);

	assertThat(actualoutput).isEqualTo(expectedoutput);
	
}}
