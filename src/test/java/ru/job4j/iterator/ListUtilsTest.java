package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, Is.is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }
    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, Is.is(Arrays.asList(0, 1, 2, 3)));
    }
    @Test
    public void whenRemoveMoreThen0() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, -1, 2, -4));
        ListUtils.removeIf(input, x -> x < 0);
        assertThat(input, Is.is(Arrays.asList(0, 2)));
    }

    @Test
    public void whenReplaceMoreThen0() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, -1, 2, -4));
        ListUtils.replaceIf(input, x -> x < 0, 42);
        assertThat(input, Is.is(Arrays.asList(0, 42, 2, 42)));
    }
    @Test
    public void whenDeleteSameElements() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> el = new ArrayList<>(Arrays.asList(0, 2, 1, -4));
        ListUtils.removeAll(input, el);
        assertThat(input, Is.is(Arrays.asList(3, 4)));
    }
}
