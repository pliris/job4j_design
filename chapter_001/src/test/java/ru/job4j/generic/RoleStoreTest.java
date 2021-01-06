package ru.job4j.generic;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void whenAdd2ElThenFind2El() {
        Role role1 = new Role("Role #1");
        Role role2 = new Role("Role #2");
        RoleStore role = new RoleStore();
        role.add(role1);
        role.add(role2);
        assertEquals("Role #2", role.findById("Role #2").getId());
    }

    @Test
    public void whenAdd2ElAndReplaceSecondElThenFindEl() {
        Role role1 = new Role("Role #1");
        Role role2 = new Role("Role #2");
        RoleStore role = new RoleStore();
        role.add(role1);
        role.add(role2);
        Role role3 = new Role("Role #3");
        role.replace("Role #2", role3);
        assertThat(role.findById("Role #3"), is(role3));
    }

    @Test (expected = NullPointerException.class)
    public void whenAdd2ElAndDeleteFirstElThenFindReturnNull() {
        Role role1 = new Role("Role #1");
        Role role2 = new Role("Role #2");
        RoleStore role = new RoleStore();
        role.add(role1);
        role.add(role2);
        role.delete("Role #1");
        assertNull(role.findById("Role #1").getId(), null);
    }

    @Test
    public void whenAdd2ElAndDoubleDeleteFirstElThenFindReturnNull() {
        Role role1 = new Role("Role #1");
        Role role2 = new Role("Role #2");
        RoleStore role = new RoleStore();
        role.add(role1);
        role.add(role2);
        role.delete("Role #1");
        assertEquals(false, role.delete("Role #1"));
    }


}