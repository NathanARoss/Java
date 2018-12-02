/**
 * Approximate the number of customers who purchased one or more energy drinks per week
 * Approximate the number of customers who prefer citrus-flavor energy drinks
 * Input: Number surveyed, % of weekly customers, % of citrus fans (literals)
 * Processing: number of regular customers, sub-number of citrus fans
 * Output: (same as processing)
 * @author nathanross
 * Last modified: 2-10-2016
 */
public class Ch2_Q2
{
    public static void main(String[] args)
    {
        final int CUSTOMER_COUNT = 12467;
        final double WEEKLY_CUSTOMER_RATE = 0.14;
        final double CITRUS_FLAVOR_POPULARITY = 0.64;
        
        int weeklyCustomerCount = (int)(CUSTOMER_COUNT * WEEKLY_CUSTOMER_RATE);
        int citrusLoverCount = (int)(weeklyCustomerCount * CITRUS_FLAVOR_POPULARITY);
        
        System.out.printf("Customers surveyed    : %,d%n", CUSTOMER_COUNT);
        System.out.printf("Purchase drinks weekly: %,d (14%%)%n", weeklyCustomerCount);
        System.out.printf("Purchase citrus-flavor: %,d (64%% of 14%%)%n", citrusLoverCount);
    }
}
