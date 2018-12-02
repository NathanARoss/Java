public static <T extends Number> T findLargestElement(List<T> list, int start, int end) {
	ListIterator<T> it = list.listIterator(start);
	
	T largest = it.next();
	
	int count = end - start - 1;
	for (int i = 0; i < count; ++i) {
		T next = it.next();
		if (next.doubleValue() > largest.doubleValue()) {
			largest = next;
		}
	}
	
	return largest;
}