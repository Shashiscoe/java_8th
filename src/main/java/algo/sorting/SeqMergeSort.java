package algo.sorting;

public class SeqMergeSort {

	
	
	
	int nums[];
	int tempNums[] ;

	SeqMergeSort(int num[]) {
		this.nums = num;
		tempNums = new int[num.length];
	}

	public static void main(String[] args) {

		int nums[] = { 10, 5, 8, 3, 7, 4, 11, 17, 21 };

		SeqMergeSort seqMergeSort = new SeqMergeSort(nums);

		seqMergeSort.divide(0, seqMergeSort.nums.length - 1);

		for (int num : nums) {
			System.out.println(num);
		}

	}

	private void divide(int low, int high) {

		if (low >= high)
			return;

		int middle = (low + high) / 2;

		divide(low, middle);
		divide(middle + 1, high);
		merge(low, middle, high);

	}

	private void merge(int low, int middle, int high) {

		for (int i = 0; i < nums.length; i++) {
			tempNums[i] = nums[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;

		// step-1
		while ((i <= middle) && (j <= high)) {

			if (tempNums[i] < tempNums[j]) {
				nums[k] = tempNums[i];
				i++;
			} else {
				nums[k] = tempNums[j];
				j++;
			}

			k++;
		}

		// step-2
		while (i <= middle) {

			nums[k] = tempNums[i];
			i++;
			k++;

		}

		// step-3
		while (j <= high) {

			nums[k] = tempNums[j];
			j++;
			k++;

		}

	}

}
