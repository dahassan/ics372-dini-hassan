# Individual Sketch Week 10
**Student:** Dini Hassan
**Date:** 10/29/26
---

## 1. Tonight's Prompt

---

**Step 1: The method.** Write the whole body of one method, in Java, in one code block:

- **UC-2:** the method that uses up the ingredients for every item on the order, including the ingredients its customizations add (step 5).

```java
public List<Ingredient> completeOrder(int orderNum) {
        Order nextOrder = getNextOrder(); 
        List<MenuItem> items = order.getOrderItems();
        Ingredient[][] chosenOptions = order.getChosenOptions();
        Inventory inventory = getInventory();

        for (int i = 0; i < items.size(); i++) {
            MenuItem item = items.get(i);

        List<Ingredient> ingredients = item.getConsumables();
        usedIngredients.addAll(ingredients);

        if (i < chosenOptions.length && chosenOptions[i] != null) {
            for (option : chosenOptions[i]){
                usedIngredients.add(option);
            }
        }
    }
}
```

**Step 2: The walk table.** One row for every collection your method walks that belongs to **another** class: a list, an array, a set or a map. If your method walks the same class's collection twice, that's still one row.

| Walks it | Whose collection | What it gets | Could it change it? |
|---|---|---|---|
| `Employee` | `Order`'s `orderItems` | a copy | no | 
| `Employee` | `Order`'s `chosenOptions` | a copy | no |

---

## 2. What I'm Not Sure About

I'm not entirely sure if the methods as I have implemented them are as comprehensive as I would like. There will definitely need to be more fleshing out during the group phase.

---

**Commit this file before group discussion begins.**
