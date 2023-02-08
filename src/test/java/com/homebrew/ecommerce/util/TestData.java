package com.homebrew.ecommerce.util;

import java.util.concurrent.ThreadLocalRandom;

public class TestData {

    public static int randomNumber() {
        return ThreadLocalRandom.current().nextInt();
    }
}
