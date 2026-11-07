# Individual Sketch Week 11
**Student:** Dini Hassan
**Date:** 11/5/26

---

## 1. Tonight's Prompt

---

**Step 1: What the barista's screen costs.** Don't write the screen. Work out what adding it would do to the case as it stands.

| File | What changes in it | Why it has to change |
|---|---|---|
| `OrderDesk.java` | needs another object for the screen and that field needs to be initialized in the constructor | this is where the screen will live and be accessed by the barista |
| `CompleteOrderTest.java` | the file won't compile | it uses the OrderDesk class |
| `PlaceOrderTest.java` | the file won't compile | it uses the OrderDesk class |

`Total: 3 files`

**Step 2: Your fix.** Change `OrderDesk`, and anything else in the case you need to, so that after your change, adding the barista's screen, or any screen after it, changes no file you already have except `ShopSetup`.

Write the changed `OrderDesk` whole, in Java, in one code block. Put any other class you added or changed in the same block, under it. Any approach you can make work is fine. If you're not sure your idea compiles, write it anyway and put a comment on the line you're unsure of.

```java
package edu.metrostate.oodi.brewandbyte.model;

import edu.metrostate.oodi.brewandbyte.view.ManagerWarnings;
import edu.metrostate.oodi.brewandbyte.view.PickupBoard;
import java.time.LocalDateTime;

public class OrderDesk {
    private final OrderQueue queue;
    private final Inventory inventory;
    private final SalesLedger ledger;
    private final ManagerWarnings warnings;
    private final PickupBoard pickup;
    private final BaristaScreen screen;

    public OrderDesk(OrderQueue queue, Inventory inventory, SalesLedger ledger,
                     ManagerWarnings warnings, PickupBoard pickup, BaristaScreen screen) {
        this.queue = queue;
        this.inventory = inventory;
        this.ledger = ledger;
        this.warnings = warnings;
        this.pickup = pickup;
        this.screen = screen;
    }

    public void place(Order order) {
        queue.add(order);
    }

    public void completeNext(LocalDateTime now) {
        Order order = queue.next();
        order.markComplete(now);
        for (Ingredient low : inventory.useUp(order)) {
            warnings.lowStock(low);
        }
        queue.remove(order);
        ledger.record(order);
        pickup.call(order.getConfirmationNumber());
    }
}

package edu.metrostate.oodi.brewandbyte.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.metrostate.oodi.brewandbyte.view.ManagerWarnings;
import edu.metrostate.oodi.brewandbyte.view.PickupBoard;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class CompleteOrderTest {
    @Test
    void usesUpTheIngredientsOfTheOrderItCompletes() {
        Ingredient oatMilk = new Ingredient("oat milk", 10);
        Inventory inventory = new Inventory();
        inventory.stock(oatMilk, 30);
        OrderQueue queue = new OrderQueue();
        SalesLedger ledger = new SalesLedger();
        OrderDesk desk = new OrderDesk(queue, inventory, ledger,
                new ManagerWarnings(), new PickupBoard(), new BaristaScreen());
        Order order = new Order(8);
        order.uses(oatMilk, 2);
        desk.place(order);

        desk.completeNext(LocalDateTime.of(2026, 1, 15, 9, 30));

        assertEquals(28, inventory.onHand(oatMilk));
        assertEquals(0, queue.size());
        assertEquals(1, ledger.count());
    }
}

package edu.metrostate.oodi.brewandbyte.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.metrostate.oodi.brewandbyte.view.ManagerWarnings;
import edu.metrostate.oodi.brewandbyte.view.PickupBoard;
import org.junit.jupiter.api.Test;

class PlaceOrderTest {
    @Test
    void putsAPlacedOrderInTheQueue() {
        OrderQueue queue = new OrderQueue();
        OrderDesk desk = new OrderDesk(queue, new Inventory(), new SalesLedger(),
                new ManagerWarnings(), new PickupBoard(), new BaristaScreen());

        desk.place(new Order(7));

        assertEquals(1, queue.size());
    }
}

```

## 2. What I'm Not Sure About

I'm still unsure about how well my additions complement the idea of a BaristaScreen class and if the class would work as described on implementation.


---

**Commit this file before group discussion begins.**