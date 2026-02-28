package com.hh;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class RadnomGeneratorTest {
	

	@Test
	void testGetTenRandoms() {
		RandomGenerator g=new RandomGenerator();
		int arr[]=g.getTenRandoms();
		assertEquals(10,arr.length);
		for(int i=0;i<10;i++) {
		   assertTrue(arr[i]>=1 && arr[i]<=10);
		}
		boolean allMatch=Arrays.stream(arr).allMatch(x-> x>=1 && x<=10);
		assertTrue(allMatch);
		boolean anyMatch=Arrays.stream(arr).anyMatch(x-> x<1 || x>10);
		assertFalse(anyMatch);
		
	}
	}