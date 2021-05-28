package org.practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class StreamTest {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1. Find all the transaction in the year 2011and sort them by value(small to high)
        List<Transaction> transactionIn2012 = transactions.stream().filter(e -> e.getYear()==2012).collect(Collectors.toList());
        transactionIn2012.sort(comparing(e -> e.getValue()));

        System.out.println(transactionIn2012);

        //2. What are the unique cities where the traders work
        List<String> uniqueCities =  transactions.stream().map(e -> e.getTrader().getCity()).distinct().collect(Collectors.toList());
        System.out.println(uniqueCities);

        //3. Find all traders from cambridge and sort them by name.
        List<Trader> cambridgeTraders = transactions.stream().map(e-> e.getTrader())
                .filter(e -> e.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(e -> e.getName()))
                .collect(Collectors.toList());
        System.out.println(cambridgeTraders);


//      4. Return a string of all traders name sorted alphabetically
        String tradersName = transactions.stream().map(e -> e.getTrader().getName()).distinct().sorted().reduce("", (n1, n2) -> n1 + n2);
        System.out.println(tradersName);

//      5. Are any traders based in Milan?
        boolean anyTraderFromMilan = transactions.stream().anyMatch(e -> e.getTrader().getCity().equals("Milan"));
        System.out.println("Is any Trader from Milan: "+ anyTraderFromMilan);

//      6. Print all transactions values from the traders living in Cambridge
        transactions.stream().filter(e -> e.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).forEach(System.out::println);

//      7. What is the highest value of all transaction
        Optional<Integer> maxValue = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        System.out.println(maxValue.get());

//      8. Find the transaction with smallest value
        Optional<Transaction> minValueTransaction = transactions.stream().min(comparing(Transaction::getValue));
        Optional<Transaction> minValueTransaction1 = transactions.stream().reduce((e1, e2) -> e1.getValue()<e2.getValue()? e1 : e2);
        System.out.println(minValueTransaction.get());
        System.out.println(minValueTransaction1.get());

    }
}

class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                "}\n";
    }
}
class Trader {
    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}'+"\n";
    }
}