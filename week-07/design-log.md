# Design Log — Week 6
### ICS372 | Fall 2026
**Student:** Dini Hassan
**Group:** 3
**Date:** 10/8/2026
**Topic:** 

## Part 1 — The Problem

Today we reviewed our sequence diagrams again, but looked to establish the responsibilities of each class and critically examine which methods belong to which classes, and where is the data stored for each method.
---

## Part 2 — Your Design Decision

We determined that we had some inaccuracies in our design when it came to assigning methods. From last week, we added some new classes with the inclusion of `SalesLedger` and `OrderQueue`, along with reassigning the responsibilities of determining whether an item can be sold and determining the cost of an item to the Menu class, as they were taken from the Inventory and Order classes respectfully. `SalesLedger` was created to track the orders sold in a given day and `OrderQueue` was built to formally define where the user's order has been sent. 

---

## Part 3 — How You Got There

I was assigned Use Case 1, where both Jobs 1 and 2 were relevant to what I was building out. Originally, I had assigned Job 1, which determined which items could be sold right now to a class named Kiosk. My reasoning behind this was there needed to be an interface for the user to place an order into and also have that interface reach out to other classes to get the information and determine if an item can be sold or not. However, once reconvening with the larger group, we were instructed to not concern out current design with a UI interface, so we had moved the responsibilities to the Inventory class for needing to know whether an item can be sold or not. After the regroup and we were given the rules that define how to classes must be related, however, we discussed it over as a group and had decided that the menu made more sense for determining whether an item can be sold or not is. The reasoning behind this is that the Menu contains a list of MenuItems, where we can add an availability boolean as a property on the MenuItem class. This way, the Menu class and have a confirmItemAvailability() method that checks the MenuItem for that property.

---

## Part 4 — The Road Not Taken

For Job 3, the one that states what an item uses up with its customizations included, there was a significant push back from a member of our group on which class should own this. The class we have as the owner is MenuItem as it would be the one that stores any changes that would occur in a system. However, the data that was mentioned to house the data necessary for this was in two different classes, WholeItem and PreparedItem. This was what the majority had decided on in the end.

Arguing the alternative point, one could mention that this is a violation of rule #2, where the class that holds the data has to be the one that completes the job. This was ignored by the majority, since it was said that WholeItem and PreparedItem were derived classes of MenuItem, therefore this shouldn't be a concern. As a rebuttal, one could mention that a derived class and the superclass are distinct, even if one extends another in implementation.

---

## Part 5 — What You're Uncertain About

I believe the WholeItem and PreparedItem classes will be the most difficult, as they have overlapping responsibilities with other classes in my opinion.

---

## Word Count: 498 words

---

