package com.thoughtworks.fjw.arraysumrecursivetask;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.ForkJoinPool;

import org.junit.Test;

import com.thoughtworks.fjw.utils.Utils;

public class ArraySumRecursiveTaskTest {

	@Test
	public void shouldCalculateTheSumOfAllArrayElements() {
		int[] arrayToCalculateSumOf = Utils.buildRandomIntArray();

		ArraySumRecursiveTask arraySumCalculator = new ArraySumRecursiveTask(arrayToCalculateSumOf);
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		long result = forkJoinPool.invoke(arraySumCalculator);

		long expected = Utils.calculateSumOfArray(arrayToCalculateSumOf);

		assertThat(result, is(expected));
	}

}
