package com.noahkeller.auteur.replay.action;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class AuteurActionRegistry {

    private static final Map<String, Supplier<AuteurAction>> ACTIONS =
            new HashMap<>();

    public static void register(
            String id,
            Supplier<AuteurAction> factory
    ) {
        ACTIONS.put(id, factory);
    }

    public static AuteurAction create(String id) {

        Supplier<AuteurAction> supplier =
                ACTIONS.get(id);

        if (supplier == null) {
            return null;
        }

        return supplier.get();
    }

}
