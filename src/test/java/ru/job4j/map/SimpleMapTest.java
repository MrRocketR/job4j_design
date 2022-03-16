package ru.job4j.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;



public class SimpleMapTest {

    SimpleMap<Integer, String> testMap;

    @Before
    public void initData() {
        testMap = new SimpleMap<>();
        testMap.put(1, "A");
        testMap.put(2, "B");
        testMap.put(3, "C");
    }

    @Test
    public void whenGetByTwoKey() {
        String expected = "B";
        String result = testMap.get(2);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void whenGetNull() {
        Assert.assertNull(testMap.get(4));
    }

    @Test
    public void whenAlreadyPutAndCollision() {
        Assert.assertFalse(testMap.put(3, "D"));
    }

    @Test
    public void whenRemoveC() {
        boolean removed = testMap.remove(3);
        Assert.assertTrue(removed);

    }

    @Test
    public void whenNotRemoved() {
        boolean removed = testMap.remove(5);
        Assert.assertFalse(removed);
    }

    @Test
    public void whenGetIteratorFromEmptyListThenHasNextReturnFalse() {
        testMap = new SimpleMap<>();
        Assert.assertFalse(testMap.iterator().hasNext());

    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetIteratorFromEmptyListThenNextThrowException() {
        testMap = new SimpleMap<>();
        testMap.iterator().next();
    }

    @Test
    public void whenGetIteratorTwiceThenStartAlwaysFromBeginning() {
        Integer testKey = 1;
        Assert.assertEquals(testKey, testMap.iterator().next());
        Assert.assertEquals(testKey, testMap.iterator().next());
    }

    @Test
    public void whenCheckIterator() {
        Iterator<Integer> iterator = testMap.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(1), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(2), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(3), iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }


    @Test(expected = ConcurrentModificationException.class)
    public void whenAddAfterGetIteratorThenMustBeException() {
        Iterator<Integer> iterator = testMap.iterator();
        testMap.put(4, "D");
        iterator.next();
    }

}