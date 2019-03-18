package thread.forkjoinpool.recursiveAction;

import java.util.concurrent.ForkJoinPool;

public class RecursiveActionTest {

	public static void main(String[] args) {

		ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

		SimpleRecursiveAction SimpleRecursiveAction = new SimpleRecursiveAction(120);

		forkJoinPool.invoke(SimpleRecursiveAction);

	}

}
