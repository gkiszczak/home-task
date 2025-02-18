package pl.inpost.home.task.ui.steps;

import Hooks;

public class TestContext {
    private static Hooks hooksInstance = null;

    public static Hooks getHooks() {
        if (hooksInstance == null) {
            hooksInstance = new Hooks();
        }
        return hooksInstance;
    }
}
