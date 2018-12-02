/**
 * This program sorts and array, then searches it
 * 
 * The worst-case time complexity for quick sorting is O(n * log n)
 * The worst-case time complexity for binary searching is O(log n)
 * 
 * Written by Nathan Ross
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Stock[] stocks = new Stock[] {
            new Stock("RossCorp", 100.0),
            new Stock("LeivaCorp", 200.0),
            new Stock("Berkshire Hathaway", 247160.0),
            new Stock("Seaboard", 4010.0),
            new Stock("NVR", 2162.0),
            new Stock("Priceline", 1903.0),
            new Stock("Markel", 963.0),
            new Stock("Alphabet", 958.0),
            new Stock("Amazon", 949.0),
            new Stock("White Mountains", 865.0),
            new Stock("Intuitive Surgical", 840.0),
            new Stock("AutoZone", 709.0),
            new Stock("Cable One", 668.0),
            new Stock("Graham Holdings", 592.0),
            new Stock("Alleghany", 587.0),
            new Stock("Mettler-Toledo", 542.0),
            new Stock("Chipotle", 471.0),
            new Stock("Apple", 172.0),
            new Stock("Samsung", 2210.0),
            new Stock("Lucky Goldstar", 14.49)
        };
        quickSort(stocks, 0, stocks.length - 1);
        
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter stock name: ");
        String name = keyboard.next();
        
        System.out.print("Enter stock price: ");
        double price = keyboard.nextDouble();
        
        
        Stock userStock = new Stock(name, price);
        int foundAt = searchStocks(stocks, userStock);
        
        if (foundAt == -1) {
            System.out.println("Sorry, I could not find that stock.");
        } else {
            System.out.printf("I found that stock at index %d%n", foundAt);
        }
    }
    
    //quick sort method adapted from ch. 17 powerpoint
    private static void quickSort(Stock[] stocks, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(stocks, start, end);
            quickSort(stocks, start, pivotIndex - 1);
            quickSort(stocks, pivotIndex + 1, end);
        }
    }
    
    //partition method adapted from ch. 17 powerpoint
    private static int partition(Stock stocks[], int start, int end)
    {
        Stock pivot = stocks[start];
        int endOfLeftList = start;
        
        for (int scan = start + 1; scan <= end; scan ++) {
            if (pivot.greaterThan(stocks[scan])) {  
                ++endOfLeftList;

                Stock temp = stocks[scan];
                stocks[scan] = stocks[endOfLeftList];
                stocks[endOfLeftList] = temp;
            }
        }
        
        // Move the pivot into position
        stocks[start] = stocks[endOfLeftList];
        stocks[endOfLeftList] = pivot;
        
        return endOfLeftList;
    }
    
    /**
     * performs a binary search to find the stock within the array
     * @param stocks collection to search
     * @param stock value to search for
     * @return subscript within array, or -1 if not found
     */
    private static int searchStocks(Stock[] stocks, Stock stock) {        
        int low = 0;
        int high = stocks.length - 1;
        
        while (low <= high) {
            int mid = (low + high) >>> 1; //avoid int overflow corrupting search
            
            if (Stock.equals(stocks[mid], stock)) {
                return mid;
            } else if (stock.greaterThan(stocks[mid])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return -1;
    }
}
