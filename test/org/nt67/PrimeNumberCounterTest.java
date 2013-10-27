package org.nt67;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class PrimeNumberCounterTest {

	PrimeNumberCounter counter;

	@Before
	public void instantiation(){
		counter = new PrimeNumberCounter();
	}

	@Test
	public void _1未満の素数は0個(){
		assertThat(counter.countPrimeNumber(1L), is(0L));
	}
	@Test
	public void _5未満の素数は2個(){
		assertThat(counter.countPrimeNumber(5L), is(2L));
	}
	@Test
	public void _10未満の素数は4個(){
		assertThat(counter.countPrimeNumber(10L), is(4L));
	}

	@Test
	public void _1は素数ではない(){
		assertThat(counter.isPrime(1L), is(false));
	}

	@Test
	public void _5は素数である(){
		assertThat(counter.isPrime(5L), is(true));
	}

	@Test
	public void _11は素数である(){
		assertThat(counter.isPrime(11L), is(true));
	}

	@Test
	public void _1000は素数ではない(){
		assertThat(counter.isPrime(1000L), is(false));
	}
}
