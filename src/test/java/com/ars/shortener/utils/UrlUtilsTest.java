package com.ars.shortener.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


class UrlUtilsTest {


    private UrlUtils urlUtils = new UrlUtils();

    @Test
    void isValid() {
        assertTrue(urlUtils.isValid("https://www.google.com"));
        assertTrue(urlUtils.isValid("http://www.example.com"));
        assertFalse(urlUtils.isValid("www.example.com"));
        assertFalse(urlUtils.isValid("example.com"));
    }
}