package org.javaspring.task1;

import org.junit.jupiter.api.*;

class AnagramTest {

    public static Anagram anagram = new Anagram();

    @Test
    void testApply_shouldReturnReverseString_whenStringContainsOnlyLetters() {
        Assertions.assertEquals("a", anagram.apply("a"));
        Assertions.assertEquals("cba", anagram.apply("abc"));
        Assertions.assertEquals("ccc", anagram.apply("ccc"));
    }

    @Test
    void testApply_shouldReturnSameString_whenStringContainsNoLetters() {
        Assertions.assertEquals("1", anagram.apply("1"));
        Assertions.assertEquals("123", anagram.apply("123"));
        Assertions.assertEquals("111", anagram.apply("111"));
        Assertions.assertEquals("$#%", anagram.apply("$#%"));
    }

    @Test
    void testApply_shouldReturnReverseWords_whenStringContainsWordsWithSpaces_whenOnlyLetters() {
        Assertions.assertEquals("c c c c", anagram.apply("c c c c"));
        Assertions.assertEquals("a A A a", anagram.apply("a A A a"));
        Assertions.assertEquals("cbA ZYX", anagram.apply("Abc XYZ"));
        Assertions.assertEquals("cba zyx", anagram.apply("abc xyz"));
        Assertions.assertEquals("aaa aaa aaaa", anagram.apply("aaa aaa aaaa"));
    }

    @Test
    void testApply_shouldReturnReverseOnlySymbols_whenStringContainsWordsWithSpaces_whenNoOnlyLetters() {
        Assertions.assertEquals("cba1 zyx", anagram.apply("abc1 xyz"));
        Assertions.assertEquals("cba1 zy3x", anagram.apply("abc1 xy3z"));
        Assertions.assertEquals("cba1 zy3x 2tre43", anagram.apply("abc1 xy3z 2ert43"));
        Assertions.assertEquals("!cb!a1 zy3x 2tr&e43", anagram.apply("!ab!c1 xy3z 2er&t43"));
    }

    @Test
    void testApply_shouldReturnSameString_whenStringIsEmpty() {
        Assertions.assertEquals("", anagram.apply(""));
    }

    @Test
    void testApply_shouldReturnNullPointerException_whenValueIsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> anagram.apply(null));
    }
}
