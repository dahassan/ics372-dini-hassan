# Design Log — Week 2
### ICS372 | Fall 2026
**Student:** Dini Hassan
**Group:** 3
**Date:** 9/3/2026
**Topic:** Brew and Byte: Early Design
---

## Part 1 — The Problem

*In 2-3 sentences, describe the design problem you worked on tonight in your own words. Do not copy the handout. What were you actually trying to figure out?*

We've begun our semester project of designing a coffee shop system. So far, we've begun to isolate entites and assign responsibilities to the different entities in trying to understand where the responsibilities lie and how certain actors will need to interact with each other.
---

## Part 2 — Your Design Decision

*What did your group decide? Describe the design you landed on clearly enough that someone who wasn't in your group could understand it. If you produced a diagram, reference it here by filename.*

In ics-321-group-3/group-artifact-1.md and ics-321-group-3/group-artifact-2.md, we laid out the design for the main entities in the problem domain and refining the order class respectively. 
---

## Part 3 — How You Got There

*This is the most important section. Start from your individual sketch — what did you think before your group talked? Then walk through how the group discussion changed (or didn't change) your thinking. What did the problem itself tell you about what the design needed to do? What constraints or requirements drove your decisions?*

*Avoid starting from a solution. If you found yourself thinking "we should use X pattern" or "this should be a Y" before fully understanding the problem, note that here and explain whether you went back to the problem or pushed forward anyway.*

For the main entities, I started in my ics372-dini-hassan/individual-sketch-1. I began by thinking of the system like an actual coffee shop, and assigned basic responsibilities to each of the clear actors in the problem. I decided not to stray too fat from the original prompt and kept it only to the three actors who are mentioned, along with the responsibilities that each of them should have. Upon meeting with my team, we went over each of our individual designs and compiled them into a single version which we all agreed upon. I had presented to them my idea of what would be needed, and employee with a name and id, customer with just a name, and a manager structured similarly to the emlpoyee. I stated that I believe that the manager should be like the employee, but with more managerial capabilites, essentially combining them into one class. Two of the group members suggested having separate entities for the inventory and menu for the manager to access and change as needed, to which we all agreed.

After the break, I detailed my thoughts on the order class's structure in ics372-dini-hassan/individual-sketch-2. I noted how i believe that each order should have a customer's name and the items they ordererd attached to it at all times, while an order should only be given an ID upon submission. Follow this, I conferred with my group about what we should include in our master version. Along with the properties I listed, we also chose to include an enumerated value for an order's status. This way, the status of the order could be set as a specific value and accessed at any given time.

---

## Part 4 — The Road Not Taken

*What other approaches did you consider and why did you move away from them? If your group disagreed about something, describe both positions and explain how you resolved it. If you personally favored a different approach than what the group decided, explain your reasoning — even if you were outvoted.*

For the second round, we briefly discussed including a submitted time and completed time on the order. This was proposed by a group member for a manager's possible interest in KPIs on start to finish how long would it take for an order. This idea was disagreed upon by most of the group as there is no mention of the manager or the spec requesting this specific feature and it is not required for base functionality.

---

## Part 5 — What You're Uncertain About

*What would you change about your design if you had more time or information? What are you not confident about? What might break later?*

In terms of changes, I would have liked to spend more time discussing with my group the specific methods that would be needed by the system if it were to be implemented. I would have also preferred to have more description from the spec of tasks that each component of the syste, would have. For example, an employee might have the ability to check pending orders and complete them as the prepare, so an example employee class might have a getOrders() method and a completeOrder() that would do this, and I would be able to think in depth of what method each class might need in order to be completed.

Our current desing may break in a few places, namely in deinfing the role of the manager as an employee. In our desing, we decided that a manager would be a pecial type of employee as aside from the special duties of managing the menu and inventory, the functionaltiy as it has been described does not warrant the manager entity to be different from the employee entity.

---

## Word Count: [554 words]

---

*Aim for 300–500 words across Parts 2–5. Part 1 does not count toward the word count.*
