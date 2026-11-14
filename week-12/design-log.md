# Design Log: Week 12
**Student:** Dini Hassan  
**Group:** 3  
**Date:** 11/12/26  

**Last week's feedback:** Give every call in completeOrder() a row, and move the number call into a view class that listens for completed orders.
**Where I used it:** None. We have yet to resolve the issue of the large order class. Also, completeOrder is the task of assembling the user's order and returning it to them.

---

## Part 1: The Problem

> Tonight wasn't the activity you did. In two or three sentences, say what the problem actually was.

Tonight's problem was about understanding how payment's are processed, assigning the responsibility around automation, and clearing up previous design decisions that no longer fit with our current understanding of the domain.

---

## Part 2: What We Ended With

> Describe what happens in your group's final version when a loyalty member's order is totaled: which class chooses the rule, which class knows what the discount is, which class adds it up, and in what order.

We created a new class named `PaymentProcess,java`, which handles a large amount of the newly placed order's calculation. This class houses the payment calculation, which adds up the cost of every item in the new order, gathers it up into a subtotal, and checks if the customer who submitted the order is a member and applies the discount accordingly. Although this class handles the logic for this, we made a `NewOrder` class that represents an order that has been built, but not paid for, and therefore not processed enough by the system to be ready for completion.

---

## Part 3: One Decision That Moved or Held

> Think about the fix you wrote alone for the case, before the lecture: what it did, why it looked right then, and what tonight did to it.

For my individual sketch, I just analyzed the given domain and made the adjustment in the discount amount, then looked over the references to the change I made and determined if there needed to be another change to accommodate my earlier change. At the time, this appeared to be correct as the logic was sound and the logic for a discount was already present. In fact, I would argue that the change is correct given the set of classes that are used in that specific use case. However, moving into the group build, we were given the idea to build an interface for holding the discounted amount. After reviewing with our current structure, we decided to build on top of the classes that we already have and just implement a new method for handling payments that calculated the total and applied the discount, which it has stored as a field and applies it to the total before submitting it to the OrderQueue. 

---

## Part 4: Argue the Other Side

> Make the case that a plain field holding a number would have been enough for your group's rule instead of an interface and two classes. Then say what would have to be true about the owner's answer to 2.8 for that case to win.

This is the approach that we went with. To the credit of the other path, the design for having the discount managed in another class would have immense benefit in the later section where we build our view files, where the manager could have access to change the discount and the change would be affected system-wide. 

---

## Part 5: What Could Break

> Think about an answer the owner could still give to 2.8 that your rule's interface couldn't express without changing, and what that change would cost.

To reflect the earlier thought, if the owner also mentioned that they wanted the flexibility to change the discount at any time, the simple field version would need to be changed as it does not allow for administrative change without changing the code, which is not accessible for users.
