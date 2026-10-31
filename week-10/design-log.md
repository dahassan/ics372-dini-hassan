# Design Log — Week 10
### ICS372 | Fall 2026
**Student:** Dini Hassan
**Group:** 3
**Date:** 10/29/2026
**Topic:** 

## Part 1 — The Problem

Tonight, we looked to establish ownership over the primary fields and determined which classes receive copies and which ones receive the direct reference.

---

## Part 2 — Your Design Decision

As a team we came to a consensus that all references, at least for these use cases, needs to return a copy of the resource instead of the actual resource itself. This came as a result of the deliberations and information presented to us after the regroup. This way, when another class like Employee walks through those collections to finish an order, it gets a copy and it doesn't change the original data.

---

## Part 3 — How You Got There

Starting from my sketch, my walk table had some mixed ideas on whether Employee should get direct access to Order's chosenOptions. During our group regroup, we counted how many classes could change another class's data and got zero. We realized that classes walking these collections only need to read the information, not change it. That discovery pushed us all to agree on returning copies everywhere.

---

## Part 4 — The Road Not Taken

One option we thought about early on was letting classes have direct access to those fields, but we ultimately backed away from it. If we had stuck with that line of thinking, different classes could have accidentally changed data while the program was running, leading to really weird bugs and unpredictable behavior that would have been a total nightmare to track down later. We realized it was much safer to lock things down right away instead of risking hidden data leaks.

---

## Part 5 — What You're Uncertain About

Thinking about the next classes that will walk these orders (like the barista’s live screen or the manager's dashboard), I'm not sure how well our strict copying rule will hold up. If future UI components need to show live, real-time updates rather than static snapshots, returning simple copies might leave us with stale data views. I'm wondering how our zero-mutation setup will handle future features that need more interactive or live communication with active orders.

---

## Word Count: 301 words
