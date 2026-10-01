# Individual Sketch ��� Week 6
**Student:** Dini Hassan
**Date:** 10/1/26

---

## 1. Tonight's Prompt


**Step 1: The mapping table.** Exactly these four columns, one row for every entity in `domain-model.md`. No entity is skipped.

```
| Entity | Verdict | Becomes | If no class, where it went |
|---|---|---|---|
| Order | one class | Order | - |
| Employee | one class | Employee | - |
| Manager | one class | Manager | - |
| Inventory | one class | Inventory | - |
| Menu | one class | Menu | - |
| Customer | one class | Customer |  |
```

**Step 2: The classes.** For every class in your **Becomes** column, one block in exactly this shape:

```
### Order
- Responsible for: knowing what the customer ordered.
- Knows: customerName: String; orderId: int; orderStatus: String; orderItems: List<MenuItem>
- Does: assignOrder(employeeId: string, orderNum: int): int
### Employee
- Responsible for: completing the customer's order
- Knows: name: String; employeeId: int; 
- Does: completeOrder(orderNum: int): List<Item>
### Manager
- Responsible for: managing restaurant inventory. 
- Knows: name: String; employeeId: num; 
- Does: viewInventory(): List<Item>; viewMenu(): List<MenuItem>
### Inventory
- Responsible for: keeping track of item count available.
- Knows: items: List<Item>
- Does: addItem(): void; removeItem(): void; orderItem(item: Item): int
### Menu
- Responsible for: holding the available menu items.
- Knows: menuItems: List<MenuItem>
- Does: showItems(): List<MenuItem>; addItem(): void; removeItem(): void
### Customer
- Responsible for: placing an order.
- Knows: name: String; cardNum: int
- Does: placeOrder(orderItems: List<MenuItem>; cardNum: int): int;
```

**Step 3: Where you'd put a hierarchy or an interface.** Pick the two or three sets of classes that have the most in common. Exactly these three columns:

```
| Classes | What I would do | Why |
|---|---|---|
| Employee, Manager | interface Employee | They would share employeeId and name fields, but nothing else  |
```
---

## 2. What I'm Not Sure About

Although Item and MenuItem have not been included as part of the domain model, I see the rising need to include the types for these two to have types. I believe we will need to include them as classes later on, but I would like to discuss with the team first.

---

**Commit this file before group discussion begins.**
