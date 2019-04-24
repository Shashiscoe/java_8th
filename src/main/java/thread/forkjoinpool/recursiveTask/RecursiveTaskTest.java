package thread.forkjoinpool.recursiveTask;

import java.util.concurrent.ForkJoinPool;

public class RecursiveTaskTest {

	public static void main(String[] args) {

		ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

		SimpleRecursiveTaskTest simpleRecursiveTaskTest = new SimpleRecursiveTaskTest(120);

		System.out.println(forkJoinPool.invoke(simpleRecursiveTaskTest));

	}

}
