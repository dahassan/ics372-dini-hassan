# Design Log: Week 13
**Student:** Dini Hassan
**Group:** 3  
**Date:** 11/19/26

**Last week's feedback:** Add resources/, and in Part 4 make the full case for the discount in its own class, then say why your group's choice won.
**Where I used it:** I have a resources folder in the root of my repository.

---

## Part 1: The Problem

 Tonight we clarified the permissions for shared responsibilities, gave managers and employees the means to complete the same task by implementing a shared interface for them to edit the menu, and built on the existing base we have for our graphical interface via the screens.

---

## Part 2: What We Ended With

In our current iteration, the item is found and the inserted price is reviewed. If the price is less than or equal to zero, then an exception is thrown and an error is returned detailing the the price entered is invalid and the user will need to reenter another price for the item they wish to change.

The class invocation for this is the MenuEditor, which acts as the shared interface between the manager and employee controllers. In a running instance of our project, there is an instance of MenuEditor, our facade class, that can be accessed through a static `getInstance`. On the method, there is a `Menu` object as a field, acting as the single menu that will be reached by both the Employee and Manager. The `changeItemPrice` on MenuEditor handles the logic for changing an item's price in this case.

---

## Part 3: One Decision That Moved or Held

I built my sketch's work on the provided code, understanding how the method worked and implementing the core logic into the BaristaController. This seemed to be the correct path at the time as the logic existed and was a proven solution, so there only needed to be some adjustments to the code. When building out our version, however, there was much debate among the team on how both classes/controllers would reach for the same instance of the menu. We eventually settled on our current configuration, but there was ambiguity around what a proper way to store the information with the newly expressed idea of a controller and how it fits into our build.

---

## Part 4: Argue the Other Side

For this to be possible, the menu class would need to hold methods and verify who is able to access the screen based on the their role in our domain, adding complexity the class isn't designed to handle. There would also be the concern of having to manage a single instance of the `Menu` class as previously mentioned.

---

## Part 5: What Could Break

At the current stage, the facade is very simple. It completes the task as requested by the classes that call it and has passing tests that confirm functionality. My biggest worry going into next class would be how will this hold up as we're refining our implementation. 
