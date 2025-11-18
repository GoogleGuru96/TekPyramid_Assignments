package StreamPracticeProg2;

import java.util.*;
import java.util.stream.Collectors;

    public class CustomerMain {

        public static void main(String[] args) {

            // -----------------------------------------------------
            // SAMPLE MAP DATA (Replace with Scanner input if needed)
            // -----------------------------------------------------

            Map<String, Customer> customerMap = new HashMap<>();

            customerMap.put("C1", new Customer("C1", "Guru", "India", 30, 5, 6000, 7, 40));
            customerMap.put("C2", new Customer("C2", "Meena", "India", 22, 2, 3000, 3, 12));
            customerMap.put("C3", new Customer("C3", "John", "USA", 28, 6, 4500, 5, 25));
            customerMap.put("C4", new Customer("C4", "Alex", "UK", 35, 10, 9000, 9, 55));
            customerMap.put("C5", new Customer("C5", "Karan", "India", 27, 1, 2500, 2, 8));
            customerMap.put("C6", new Customer("C6", "Sita", "India", 24, 4, 7000, 6, 30));
            customerMap.put("C7", new Customer("C7", "Vishal", "India", 40, 12, 10000, 8, 60));
            customerMap.put("C8", new Customer("C8", "Pooja", "India", 29, 3, 4800, 3, 11));
            customerMap.put("C9", new Customer("C9", "Nick", "USA", 31, 2, 5200, 4, 20));
            customerMap.put("C10", new Customer("C10", "Sara", "India", 26, 1, 2000, 1, 5));

            // =====================================================
            //                     TASK 1
            // =====================================================

            System.out.println("\n=========== TASK 1 RESULTS ===========");

            List<Customer> customers = new ArrayList<>(customerMap.values());

            // (A) Filter: balance < average balance
            double avgBalance = customers.stream()
                    .mapToDouble(Customer::getBalance)
                    .average()
                    .orElse(0);

            List<Customer> filteredTask1 = customers.stream()
                    .filter(c -> c.getBalance() < avgBalance)
                    .collect(Collectors.toList());

            System.out.println("\nTask 1 → Filtered (balance < average):");
            filteredTask1.forEach(System.out::println);

            // (B) Total years of membership
            int totalYears = filteredTask1.stream()
                    .mapToInt(Customer::getYearsOfMembership)
                    .sum();

            System.out.println("\nTask 1 → Total Years of Membership: " + totalYears);

            // (C) Customer with highest membership
            Optional<Customer> highestMember = filteredTask1.stream()
                    .max(Comparator.comparingInt(Customer::getYearsOfMembership));

            System.out.println("\nTask 1 → Customer with highest membership:");
            System.out.println(highestMember.orElse(null));

            // =====================================================
            //                     TASK 2
            // =====================================================

            System.out.println("\n=========== TASK 2 RESULTS ===========");

            // (A) Filter: joined < 3 years AND loyalty < 4 AND balance in 2000–5000
            List<Customer> filteredTask2 = customers.stream()
                    .filter(c -> c.getYearsOfMembership() <= 3)
                    .filter(c -> c.getLoyaltyScore() < 4)
                    .filter(c -> c.getBalance() >= 2000 && c.getBalance() <= 5000)
                    .collect(Collectors.toList());

            System.out.println("\nTask 2 → Filtered Customers:");
            filteredTask2.forEach(System.out::println);

            // (B) Sum of balances (even ages only)
            double sumBalances = filteredTask2.stream()
                    .filter(c -> c.getAge() % 2 == 0)
                    .mapToDouble(Customer::getBalance)
                    .sum();

            System.out.println("\nTask 2 → Sum of balances (even age): " + sumBalances);

            // (C) Average age, but only if their country has >10 customers
            // First: group by country
            Map<String, Long> countryCounts = customers.stream()
                    .collect(Collectors.groupingBy(Customer::getCountry, Collectors.counting()));

            OptionalDouble avgAge = OptionalDouble.empty();

            for (String country : countryCounts.keySet()) {
                if (countryCounts.get(country) > 10) { // condition
                    avgAge = customers.stream()
                            .filter(c -> c.getCountry().equals(country))
                            .mapToInt(Customer::getAge)
                            .average();
                }
            }

            System.out.println("\nTask 2 → Average age (if country > 10 customers) : " +
                    (avgAge.isPresent() ? avgAge.getAsDouble() : "Condition not met"));
        }
    }
