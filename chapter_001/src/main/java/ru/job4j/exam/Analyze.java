package ru.job4j.exam;

import java.util.*;

public class Analyze {

    public Info diff(List<User> previous, List<User> current) {
        Map<Integer, User> usersMap = new HashMap<>();
        List<User> usersAdd = new ArrayList<>(current);
        Info info = new Info();

        for (User user : current) {
            usersMap.put(user.id, user);
        }

        for (User user : previous) {
            User temp = usersMap.remove(user.id);
            if (temp == null) {
                info.deleted++;
            } else if (!Objects.equals(temp, user)) {
                info.changed++;
            }
        }
        info.added = usersMap.size();
        return  info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            int hash = 1;
            hash = 31 * hash + id;
            hash = 31 * hash + name.hashCode();
            return hash;
        }
    }

    public static class Info {
        int added = 0;
        int changed = 0;
        int deleted = 0;
    }
}
