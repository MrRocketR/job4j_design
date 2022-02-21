package ru.job4j.generics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    RoleStore store = new RoleStore();
    Role testRole = new Role("1", "Warlock");

    @Test
    public void whenAddAndFindUser() {
        store.add(testRole);
        assertThat(store.findById("1"), is(testRole));
    }

    @Test
    public void whenAddAndFindThenUserIsNull() {
        store.add(testRole);
        assertNull(store.findById("10"));
    }

    @Test
    public void whenReplace() {
        Role replacedRole= new Role("1", "Warrior");
        store.add(testRole);
        store.replace("1", replacedRole);
        assertThat(replacedRole.getRoleName(), is("Warrior"));
    }

    @Test
    public void whenDeleteUserThenUserIsNull() {
        store.add(testRole);
        store.delete("1");
        Role result = store.findById("1");
        assertNull(result);
    }
}