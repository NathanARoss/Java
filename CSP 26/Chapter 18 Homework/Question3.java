static <T> void swap(T[] arr, int pos1, int pos2) {
	T temp = arr[pos1];
	arr[pos1] = arr[pos2];
	arr[pos2] = temp;
}