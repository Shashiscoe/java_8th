package thread.forkjoinpool.recursiveAction;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int taskCount;

	public SimpleRecursiveAction(int taskCount) {

		this.taskCount = taskCount;

	}

	@Override
	protected void compute() {

		if (taskCount > 100) {

			System.out.println("parralel taks execution is required.");
			SimpleRecursiveAction SimpleRecursiveAction1 = new SimpleRecursiveAction(taskCount / 2);
			SimpleRecursiveAction SimpleRecursiveAction2 = new SimpleRecursiveAction(taskCount / 2);

			SimpleRecursiveAction1.fork();
			SimpleRecursiveAction2.fork();

		} else {
			System.out.println("no parralel taks execution is required.Number of tasks are :: " + taskCount);
		}

	}

}
