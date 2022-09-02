package com.test;

import com.utils.RestWrapper;
import org.junit.jupiter.api.BeforeAll;

public class RestTest {

    public static RestWrapper api;

    @BeforeAll
    public static void prepareClient() {
        api = RestWrapper.prepare();
    }
}
