# Individual Sketch — Week 12
**Student:** Dini Hassan
**Date:** 11/12/26

---

## 1. Tonight's Prompt

**Step 1: What 3.7 would cost.** 

(a) `New fields: Menu`

(b) Every `if` statement in `ManagerController.onAddItem` that `BaristaController.onAddItem` would have to copy, in a table with exactly these two columns, one row for each `if`:

| What the `if` checks | The rule about the business it keeps |
|---|---|
| `priceInCents <= 0` | ensuring free or negative priced items aren't added to the menu |
| `menu.find(name) != null` | ensuring the same item is not included on the list twice |
| `ingredient == null` | ensuring menu items cannot be built with ingredients we don't have |

`Total: 3 copied`.

**Step 2: Your fix.** 

```java 
public class BaristaController {
    private final Inventory inventory;
    private final BaristaScreen screen;
    private final Menu menu;

    public BaristaController(Menu menu, Inventory inventory, BaristaScreen screen) {
        this.menu = menu;
        this.inventory = inventory;
        this.screen = screen;
    }

    // Requirement 3.6: the Mark Out button.
    public void onMarkOut(String ingredientName) {
        Ingredient ingredient = inventory.find(ingredientName);
        if (ingredient == null) {
            screen.showMessage("We don't stock " + ingredientName + ".");
            return;
        }
        ingredient.markOut();
        screen.showMessage(ingredientName + " is marked out.");
    }

    public void onAddItem(String name, String price, String ingredientNames) {
        int priceInCents = (int) Math.round(Double.parseDouble(price) * 100);
        if (priceInCents <= 0) {
            screen.showMessage("The price must be more than zero.");
            return;
        }
        if (menu.find(name) != null) {
            screen.showMessage(name + " is already on the menu.");
            return;
        }
        List<Ingredient> recipe = new ArrayList<>();
        for (String ingredientName : ingredientNames.split(",")) {
            Ingredient ingredient = inventory.find(ingredientName.trim());
            if (ingredient == null) {
                screen.showMessage("We don't stock " + ingredientName.trim() + ".");
                return;
            }
            recipe.add(ingredient);
        }
        menu.add(new MenuItem(name, priceInCents, recipe));
        screen.showMessage(name + " is on the menu.");
        showMenu();
    }
    
    private void showMenu() {
        List<String> lines = new ArrayList<>();
        for (MenuItem item : menu.getItems()) {
            lines.add(item.getName() + "  " + String.format("$%.2f", item.getPriceInCents() / 100.0));
        }
        screen.showMenu(lines);
    }
}


```

---

## 2. What I'm Not Sure About

I'm not sure if there needs to be any consideration around checking if the manager is around before granting the employee the ability to add to the menu. I believed that this might be needed, but there isn't an available method for checking the manager's status and I didn't want to veer to far from the requirements by adding a feature that wasn't asked for.

---

**Commit this file before group discussion begins.**
