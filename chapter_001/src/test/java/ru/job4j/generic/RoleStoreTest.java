package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void WhenAdd2ElThenFind2El() {
        Role role1 = new Role("Role #1");
        Role role2 = new Role("Role #2");
        RoleStore role = new RoleStore();
        role.add(role1);
        role.add(role2);
        assertThat(role.findById("Role #2"), is("Role #2"));
    }

    @Test
    public void replace() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findById() {
    }
}