package ua.lviv.iot.algo.part2.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveWordsWithNumbersTest {
    private RemoveWordsWithNumbers remover = new RemoveWordsWithNumbers();
    private int minDights = 4;

    @Test
    public void removeWordsWithNumbersSuccess() {
        String textBeforeRemovingNumbers = "test text: a12i, a1234b, a12345b, 123a, a123, a12-345b, 12345b, a12345";
        String expectedString = "test text: a12i, , , 123a, a123, , 12345b, a12345";
        String result = remover.removeWordsWithNumbers(textBeforeRemovingNumbers,minDights);

        assertEquals(expectedString,result);
    }

    @Test
    public void removeWordsWithNumbersEmptyString(){
        String emptyString = "";
        String result = remover.removeWordsWithNumbers(emptyString, 1);

        assertEquals("", result);
    }
}
