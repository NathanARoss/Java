static <T extends Number> int countPrimes(Collection<T> collection) {
	int primeCount = 0;
	
	for (T num : collection) {
		//prime numbers can only be integers, so a cast to long does not lose precision
		long value = num.longValue();
		
		//2 is the only even prime
		if (value == 2) {
			++primeCount;
		}
		
		//all remaining primes are odd numbers starting from 3
		else if ((value & 1) == 1 && value > 2) {
			
			//the first factor of a number always lies between 2 and it's square root
			long range = (long)Math.sqrt(num.doubleValue());
			boolean isPrime = true;
			
			//only check odd divisors starting from 3 because I already ruled out even numbers
			for (long i = 3; i <= range; i += 2) {
				if (value % i == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				++primeCount;
			}
		}
	}
	
	return primeCount;
}