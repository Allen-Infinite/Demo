package com.allen.strategy;


import com.allen.util.DuplicatesSolutionEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The unit test for {@link DuplicatesSolutionStrategy}, including all execution paths.
 *
 * @author Allen
 * @date 2022/3/21 18:41
 */
public class DuplicatesSolutionStrategoryTest {

    /**
     * The unit test for {@link DuplicatesSolutionStrategy} handle method, including all execution paths.
     *
     * The {@code boundaryArr} and {@code returnSelfArr} for both {@link RemoveDuplicatesSolution} and
     * {@link ReplaceDuplicatesSolution}, which to test its execution boundary.
     *
     * The {@code removeSourceArr} for normal execution of {@link RemoveDuplicatesSolution}.
     *
     * The {@code replaceSourceArr} for normal execution of {@link ReplaceDuplicatesSolution}.
     */
    @Test
    public void handleTest() {

        DuplicatesSolutionStrategy removeSolution = DuplicatesSolutionContext.getSolution(DuplicatesSolutionEnum.REMOVE.getCode()).orElseThrow();
        DuplicatesSolutionStrategy replaceSolution = DuplicatesSolutionContext.getSolution(DuplicatesSolutionEnum.REPLACE.getCode()).orElseThrow();


        // Shared array
        String[] boundaryArr = new String[]{"aabccccbbba", "aaa", "aaaa"};
        String[] returnSelfArr = new String[]{"a", "aa", "abb"};

        // Array for RemoveDuplicatesSolution
        String[] removeSourceArr = new String[]{"aabcccbbad", "aabccccbbad", "aabcccccbbad"};
        commonTest(removeSolution, removeSourceArr, boundaryArr, returnSelfArr);

        // Array for ReplaceDuplicatesSolution
        String[] replaceSourceArr = new String[]{"abcccbad", "abccccbad", "abcccccbad", "aabccccbad", "aabcccccbbd"};
        commonTest(replaceSolution, replaceSourceArr, boundaryArr, returnSelfArr);

        // Common test
        assertTest();
    }

    private void commonTest(DuplicatesSolutionStrategy solution, String[] commonArr, String[] boundaryArr, String[] returnSelfArr) {

        commonResultTest(solution, commonArr);

        boundaryTest(solution, boundaryArr);

        returnSelfTest(solution, returnSelfArr);
    }

    private void commonResultTest(DuplicatesSolutionStrategy solution, String[] sourceArr) {
        String rightResult = "d";
        String result;
        for (String source : sourceArr) {
            result = solution.handle(source);
            Assertions.assertEquals(rightResult, result);
        }
    }

    private void boundaryTest(DuplicatesSolutionStrategy solution, String[] sourceArr) {
        for (String source : sourceArr) {
            Assertions.assertEquals("", solution.handle(source));
        }
    }

    private void returnSelfTest(DuplicatesSolutionStrategy solution, String[] sourceArr) {
        for (String source : sourceArr) {
            Assertions.assertEquals(source, solution.handle(source));
        }
    }

    /**
     * The unit test for expected {@link AssertionError} of {@link DuplicatesSolutionStrategy}.
     *
     * The AssertionError mainly caused by source string format.
     */
    private void assertTest() {
        DuplicatesSolutionStrategy solution = DuplicatesSolutionContext.getSolution(DuplicatesSolutionEnum.REMOVE.getCode()).orElseThrow();

        String sourceNull = null;
        String sourceEmpty = "";
        String sourceUppercase = "AasdS";
        String sourceContainNum = "a3fdf";
        String sourceContainSymbol = "!asdf";
        String sourceContainSpace = "aa aaa";

        try {
            solution.handle(sourceNull);
        } catch (Throwable e) {
            Assertions.assertEquals(AssertionError.class, e.getClass(),"Expects AssertionError caused by null source");
        }

        try {
            solution.handle(sourceEmpty);
        } catch (Throwable e) {
            Assertions.assertEquals(AssertionError.class, e.getClass(),"Expects AssertionError caused by empty source");
        }

        try {
            solution.handle(sourceUppercase);
        } catch (Throwable e) {
            Assertions.assertEquals(AssertionError.class, e.getClass(),"Expects AssertionError caused by uppercase source");
        }

        try {
            solution.handle(sourceContainNum);
        } catch (Throwable e) {
            Assertions.assertEquals(AssertionError.class, e.getClass(),"Expects AssertionError caused by number source");
        }

        try {
            solution.handle(sourceContainSymbol);
        } catch (Throwable e) {
            Assertions.assertEquals(AssertionError.class, e.getClass(),"Expects AssertionError caused by symbol source");
        }

        try {
            solution.handle(sourceContainSpace);
        } catch (Throwable e) {
            Assertions.assertEquals(AssertionError.class, e.getClass(),"Expects AssertionError caused by space source");
        }

    }

}