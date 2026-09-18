# Design Log — Week 4
### ICS372 | Fall 2026
**Student:** Dini Hassan
**Group:** 3
**Date:** 9/17/2026
**Topic:** Step by Step, Then Message by Message — detailed use cases, and what tracing them did to the model.

## Part 1 — The Problem

IN tonight's group and individual work, we assessed given use cases on the customer, barista, and manager's interaction with the system, from which we built sequence diagrams around.

---

## Part 2 — Your Design Decision

For our first group artifact (docs/week-04/group-artifact-1.md), we combined our individual works of the four use cases defining system and actor responsibilities into two tables including the system and actor's obligation for each use case. In both combined examples, for each use case, we included a precondition and postcondition, the responsibilities and alternate cases to counteract the assumptions we made early on in the design process.

For our second group artifact (docs/week-03/group-artifact-2.md), we built, assessed, and combined our individual sequence diagrams for the two scenarios detailing a user named Sam ordering an item off the menu and the manager's ability to change said item, with the question posed being "How much would Sam have to pay?". In the end, we came to the conclusion that the sequence diagram should include both use cases and should not reflect the order in which those two events may have occurred as the synthesis description did not reflect this. 

---

## Part 3 — How You Got There

A large part of my personal perspective comes from past knowledge on the domain (coffee shops) and my understanding of assigning responsibilities from experience with building classes in Java. When we consolidated our sequence diagrams into one model, there was debate amongst our group about which specific point the price gets changed and what counts as a menu item. The model, as proposed by two group members was that the cost change happened before the user added the item to their order, therefore the price that should be charged is the updated $5.00. I took the stance that the description of the items did not hold any chronological markers stating in which order the updating of the price and the placement of the item onto the order took place, so our design should be agnostic in regards to the timing of the events. Our fourth member held themselves in between on the two positions initially, but eventually conceded along with the others that our design shouldn't be focused on any such time, but rather include the description of both actions with no mention of time.

---

## Part 4 — The Road Not Taken

My group argued on what the price of the object should be before and after, and we came to the conclusion that the menu item that gets added needs to be stored in a temporary item at the time of selection to avoid the price being updated in the user's "cart". 

---

## Part 5 — What You're Uncertain About


The biggest unknown right now would be our knowledge of how many entities this system will need to be and understanding what the relationships between is.

---

## Word Count: 416 words

---
