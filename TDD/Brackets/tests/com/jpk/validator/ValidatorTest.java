package com.jpk.validator;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    private static sequenceValidation sv;

    @BeforeAll
    public static void setUp() {
        sv = new Validator();
    }

    @Test
    public void isInputSizeBiggerThen2() {
        Assertions.assertTrue(sv.isClosedCorrectly("{}"));
    }

    @Test
    public void isInputSizeBiggerThen1() {
        Assertions.assertFalse(sv.isClosedCorrectly("{"));
    }

    @Test
    public void imputingNull_shouldReturnFalseRatherException() {
        Assertions.assertFalse(sv.isClosedCorrectly(null));
    }

    @Test
    public void imputingInCorrectBracketSequence_ShouldReturnFalse() {
        Assertions.assertFalse(sv.isClosedCorrectly("}{"));
    }

    @Test
    public void imputingCorrectBracketSequence_ShouldReturnTrue() {
        Assertions.assertTrue(sv.isClosedCorrectly("{{}}"));
    }

    @Test
    public void imputingCorrectDifferentTypeOfBracketsSequence_ShouldReturnTrue() {
        Assertions.assertTrue(sv.isClosedCorrectly("()"));
    }

    @Test
    public void imputingCorrectDifferentTypeOfBracketsSequence_ShouldReturnFalse() {
        Assertions.assertFalse(sv.isClosedCorrectly(")("));
    }

    @Test
    public void imputingTwoTypesOfBracketsInCorrectSequence_ShouldReturnTrue(){
        Assertions.assertTrue(sv.isClosedCorrectly("{()}"));
    }

}
