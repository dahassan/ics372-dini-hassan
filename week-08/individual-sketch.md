# Individual Sketch Week 7
**Student:** Dini Hassan
**Date:** 10/8/26
---

## 1. Tonight's Prompt

---

Week 7 decided which class does each job. To do its job, a class usually has to call another object. Tonight's question is **how it gets hold of that object.**

**Which use case is yours.** The same as Week 7. Sort your group by first name, A to Z. The first person takes UC-1, the second UC-2, the third UC-3, the fourth UC-4. In a group of three, nobody takes UC-4.

Open your group's sequence diagram for your use case in `docs/design/use-cases.md`. That diagram, as it stands, is what you work from.

**About the example.** It uses the library system from the textbook, not Brew & Byte. It shows you the *shape* of what to write and nothing else.

Copy steps 1 and 2 into **section 1 of your sketch file** and put your work directly under each step.

**Step 1: How each class gets what it calls.** For every solid arrow in your diagram that goes from one class to another class, one row. Skip arrows from the actor. If one class calls the same other class more than once, that's still one row.

Exactly these four columns:

| Class | Calls | How it gets it | Where that object comes from |
|---|---|---|---|
| `Kiosk` | `Menu` | handed back by a call | `Kiosk.confirmItemAvailability(MenuItems)` |
| `Kiosk` | `Account` | handed back by a call | `Kiosk.getCustomerAccount(Customer)` |
| `Kiosk` | `Queue` | handed back by a call | `Kiosk.assignOrder(MenuItems)` |

**How it gets it** is exactly one of these five values:

- `handed in on the call`: the object is a parameter of the method that uses it. Every call can hand in a different one.
- `handed in when built`: the object is a parameter of the class's constructor, and the class keeps it in a field.
- `handed back by a call`: the object is what another method returned, like the `Book` that `Catalog.findByTitle()` returns.
- `makes its own`: the class creates the object itself with `new`.
- `reaches for it`: the class gets the object from anywhere in the program, through a `static` field or a `static` method on some class, and nobody hands it in.

**Where that object comes from** says who hands it in, which call hands it back, or who creates it. For `reaches for it`, name the `static` field or method it reaches through, like `Catalog.current`.

**Step 2: The constructors.** For every class that appears anywhere in your step 1 table, in either column, write its Java constructor. Signature only, one line each, in one code block:

```java
public Kiosk()
public Menu()
public Account(Customer customer, String cardNum)
public Queue(Employee employee, Item[] array)

```

- Every `handed in when built` row for a class becomes a parameter of that class's constructor.
- Add any plain values the class needs in order to exist, like a name or a price.
- A class that needs nothing handed in has an empty constructor, like `Catalog()` above.
- No bodies, and no other methods.


---

## 2. What I'm Not Sure About

I'm not entirely sure if the method constructors are correct as I have them listed here.

---

**Commit this file before group discussion begins.**

    