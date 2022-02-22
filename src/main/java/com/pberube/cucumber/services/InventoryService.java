package com.pberube.cucumber.services;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
@NoArgsConstructor
public class InventoryService {
    Map<String, Integer> inventory = new LinkedHashMap<>();

    public void addToInventory(String gameName, int count) {
        inventory.put(gameName, count);
    }

    public void buy(String gameName) {
        inventory.computeIfPresent(gameName, (key, oldValue) -> {
                    if (oldValue > 0) {
                        oldValue--;
                    }
                    return oldValue;
                }
        );
    }

    public int getQty(String gameName) {
        return inventory.getOrDefault(gameName, 0);
    }
}
