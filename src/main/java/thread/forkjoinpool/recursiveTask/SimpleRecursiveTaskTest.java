package thread.forkjoinpool.recursiveTask;

import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveTaskTest extends RecursiveTask<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int taskCount;

	public SimpleRecursiveTaskTest(int taskCount) {

		this.taskCount = taskCount;

	}

	@Override
	protected Integer compute() {

		if (taskCount > 100) {

			System.out.println("parralel taks execution is required.");
			SimpleRecursiveTaskTest simpleRecursiveTaskTest1 = new SimpleRecursiveTaskTest(taskCount / 2);
			SimpleRecursiveTaskTest simpleRecursiveTaskTest2 = new SimpleRecursiveTaskTest(taskCount / 2);

			simpleRecursiveTaskTest1.fork();
			simpleRecursiveTaskTest2.fork();

			return simpleRecursiveTaskTest1.join() + simpleRecursiveTaskTest2.join();

		} else {
			System.out.println("no parralel taks execution is required.Number of tasks are :: " + taskCount);
			return taskCount * 10;
		}

	}

}
