package ru.job4j.generics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    RoleStore store = new RoleStore();
    User testUser = new User("1", "Nikita");

    @Test
    public void whenAddAndFindUser() {
        store.add(testUser);
        User expectedUser = (User) store.findById("1");
        assertThat(expectedUser, is(testUser));
    }

    @Test
    public void whenAddAndFindThenUserIsNull() {
        store.add(testUser);
        User result = (User) store.findById("10");
        assertNull(result);
    }

    @Test
    public void whenReplace() {
        User newTestUser = new User("1", "Test");
        store.add(testUser);
        store.replace("1", newTestUser);
        User result = (User) store.findById("1");
        assertThat(result.getUsername(), is("Test"));
    }

    @Test
    public void whenDeleteUserThenUserIsNull() {
        store.add(testUser);
        store.delete("1");
        User result = (User) store.findById("1");
        assertNull(result);
    }
}