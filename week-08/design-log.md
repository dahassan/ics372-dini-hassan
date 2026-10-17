# Design Log — Week 8
### ICS372 | Fall 2026
**Student:** Dini Hassan
**Group:** 3
**Date:** 10/16/2026
**Topic:** 

## Part 1 — The Problem

In today's problem, we reviewed our use cases from Week 7 and applied our understanding to connect the classes together, defining ownership and information decisions.

---

## Part 2 — Your Design Decision

As of right now, the only place we've declared the menu object is in our test file (PlaceOrderTest.java) for an order. The menu is created and added to with a singular item. However, in a production ready version, I would imagine the menu class gets declared in the main method (ShopSetup.java), and all necessary elements are added before the main customer section starts.

---

## Part 3 — How You Got There

In our first row, we have the Menu class confirming a menu item's availability using the method confirmItemAvailability(MenuItem) as part of Use Case 1's responsibility. When designing last week and before this week's group session, this seemed to be the correct way as the path was a standard:

User places Order -> Order has MenuItems -> Menu.confirmItemAvailability(MenuItem) for each item to confirm availability.

However, upon reflection after creating the classes and the test file, there may be a new element to consider in the fact that we have decided to go the path of using OrderItem in our test to check whether an item can be sold. 

---

## Part 4 — The Road Not Taken

The Menu class is, by far, the most straightforward class to keep as a single copy in the running program. Although there is a need to reference the Menu class from external objects, there are already a number of methods that make reviewing the content of the object, adding items, removing items, and checking for availability possible.

---

## Part 5 — What You're Uncertain About

So far, we are sticking with the idea of having multiple item types (MenuItem, OrderItem, PreparedItem, WholeItem), but it brings into question the stability of the whole idea of what an item is. An item, in my mind at least, can exist at different points in the cycle with different properties, but shouldn't vary in its form too much. The original intention behind the item gets obscured behind a bunch of hacks to make the system work a any given stage of development, but this ignores basic principles of design just to ignore the inconveniences of responsibilities in a system. I still hold the firm belief that many of these items can be consolidated for simplicity's sake, but that is not the majority view of the group as of this stage of development.
---

## Word Count: 360 words

---

