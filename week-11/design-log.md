# Design Log — Week 11
### ICS372 | Fall 2026
**Student:** Dini Hassan
**Group:** 3
**Date:** 11/5/2026
**Topic:** 

## Part 1 — The Problem

Tonight, our analysis centered on Use Case 2, which outlines the steps required for an employee to complete an order. We had to map out the calls between classes (Inventory, Employee, and OrderQueue), evaluate what jobs belonged where, and figure out how to cleanly add the barista's screen and manager notifications without breaking core system rules.

---

## Part 2 — Your Design Decision

As a team, we decided to implement a listener pattern where `Inventory` and `OrderQueue` own their listeners, allowing view components like the barista screen to see the changes rather than requiring strict code coupling. This let us to introduce the `BaristaScreen` under view components and update `OrderQueue` and `ShopSetup` cleanly, effectively keeping inventory updates and manager warnings properly separate from the direct completion logic.

---

## Part 3 — How You Got There

We started by going through Use Case 2 and filling out the calls table to track which methods invoke other classes. After the regroup, we reviewed our approach against the new rules, where we noted that  low-stock notifications and queue updates should work through listeners without breaking existing functionality. From there, we added the `BaristaScreen` class and made the necessary wiring adjustments in OrderQueue and ShopSetup.

---

## Part 4 — The Road Not Taken

Before the regroup, we heavily debated whether to split up the contents of the `completeOrder()` method in `Employee`, since it handles a major portion of the use case's execution steps. While one perspective argued for delegating already completed work to separate methods to keep classes smaller, the others in the group felt the method accurately captured the natural runtime and clean-up of an order. We ultimately left this decision open for now since the current code is fully functional, but noted we can refactor it later.

---

## Part 5 — What You're Uncertain About

We have a few open questions as we look ahead. Since the listener pattern is entirely new to us, we aren't entirely sure if our current implementation will hold up well under future design considerations. Additionally, while `ManagerWarnings` is currently working in `ShopSetup`, how it will ultimately fit into the final, complete product remains an open question, along with the eventual structure of `completeOrder()`.

---

## Word Count: 305 words

---

