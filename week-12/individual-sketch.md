# Individual Sketch — Week 12
**Student:** Dini Hassan
**Date:** 11/12/26

---

## 1. Tonight's Prompt

**Step 1: What 50 cents an item would cost.** 

| File | What changes in it | Why it has to change |
|---|---|---|
| `Order.java` | The `totalInCents()` method gets updated to calculate the subtotal subtracted by 50 cents for members instead of taking off ten percent | This is the section of the code that applies the discount |
|`Receipt.java`| Making the displayed discount 50 cents off instead of 10 percent off | The discount needs to be updated to match the change from `Order.java`|

Total: `Total: 2 files`.

**Step 2: Your fix.** Change the case so that after your change, switching to that rule, or to any rule after it, changes **exactly one class under `src/main`**, and that class isn't `Order`, `Receipt` or `DaySales`.

Write the changed `Order` whole, in Java, in one code block. Put any other class you added or changed in the same block, under it. Any approach you can make work is fine. If you're not sure your idea compiles, write it anyway and put a comment on the line you're unsure of.

```java         
public class Order {
    private final Customer customer;              // null for a walk-up customer
    private final List<OrderLine> lines = new ArrayList<>();

    public Order(Customer customer) {
        this.customer = customer;
    }

    public void add(OrderLine line) {
        lines.add(line);
    }

    public Customer getCustomer() { return customer; }

    public int subtotalInCents() {
        int subtotal = 0;
        for (OrderLine line : lines) {
            subtotal += line.priceInCents();
        }
        return subtotal;
    }

    public int totalInCents() {
        int subtotal = subtotalInCents();
        if (customer != null && customer.isLoyaltyMember()) {
            return subtotal - 50;
        }
        return subtotal;
    }
}


public class Receipt {
    public static String forOrder(Order order) {
        StringBuilder text = new StringBuilder();
        text.append("Subtotal: ").append(dollars(order.subtotalInCents())).append("\n");
        Customer customer = order.getCustomer();
        if (customer != null && customer.isLoyaltyMember()) {
            text.append("Loyalty discount (50c off!): -")
                .append(dollars(order.subtotalInCents() - 50)).append("\n");
        }
        text.append("Total: ").append(dollars(order.totalInCents()));
        return text.toString();
    }

    private static String dollars(int cents) {
        return String.format("$%d.%02d", cents / 100, cents % 100);
    }
}
```

---

## 2. What I'm Not Sure About

There could be a possibility for an order to be less than 50 cents, in which case I'm not sure if this would be accurate. I thought about including a check on the price before decrementing by 50 cents to ensure the number wouldn't be less than zero, but decided that it was outside of the scope for this work.

---

**Commit this file before group discussion begins.**
