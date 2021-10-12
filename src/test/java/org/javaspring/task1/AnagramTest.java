package org.javaspring.task1;

import org.junit.jupiter.api.*;

public class AnagramTest {

    @Test
    void testApply_shouldReturnReverseString_whenStringContainsOnlyLetters() {
        Assertions.assertEquals(new Anagram().apply("a"), "a");
        Assertions.assertEquals(new Anagram().apply("abffc"), "cba");
        Assertions.assertEquals(new Anagram().apply("ccc"), "ccc");
    }

    @Test
    void testApply_shouldReturnSameString_whenStringContainsNoLetters() {
        Assertions.assertEquals(new Anagram().apply("1"), "1");
        Assertions.assertEquals(new Anagram().apply("123"), "123");
        Assertions.assertEquals(new Anagram().apply("111"), "111");
        Assertions.assertEquals(new Anagram().apply("$#%"), "$#%");
    }

    @Test
    void testApply_shouldReturnReverseWords_whenStringContainsWordsWithSpaces_whenOnlyLetters() {
        Assertions.assertEquals(new Anagram().apply("c c c c"), "c c c c");
        Assertions.assertEquals(new Anagram().apply("a A A a"), "a A A a");
        Assertions.assertEquals(new Anagram().apply("Abc XYZ"), "cbA ZYX");
        Assertions.assertEquals(new Anagram().apply("abc xyz"), "cba zyx");
        Assertions.assertEquals(new Anagram().apply("aaa aaa aaaa"), "aaa aaa aaaa");
    }

    @Test
    void testApply_shouldReturnReverseOnlySymbols_whenStringContainsWordsWithSpaces_whenNoOnlyLetters() {
        Assertions.assertEquals(new Anagram().apply("abc1 xyz"), "cba1 zyx");
        Assertions.assertEquals(new Anagram().apply("abc1 xy3z"), "cba1 zy3x");
        Assertions.assertEquals(new Anagram().apply("abc1 xy3z 2ert43"), "cba1 zy3x 2tre43");
        Assertions.assertEquals(new Anagram().apply("!ab!c1 xy3z 2er&t43"), "!cb!a1 zy3x 2tr&e43");
    }

    @Test
    void testApply_shouldReturnSameString_whenStringIsEmpty() {
        Assertions.assertEquals(new Anagram().apply(""), "");
    }

    @Test
    void testApply_shouldReturnNullPointerException_whenValueIsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> new Anagram().apply(null));
    }
}
