package ru.job4j.exam;

import java.util.*;

public class Mail {


    /**
     * Метод получает на вход множество объектов User, используя временную Карту переворачиваем множество
     * к виду Ключ (адрес эл.почты), значение (Имя пользователя), ищем совпадающие адреса, получаем значение Имя пользователя,
     * объединяем у совпадающих пользователей адреса в одном множество и добавляем в результирующую Карту ключ (имя пользователя)
     * и значение (множество адресов эл.почты)
     * @param accounts множество объектов User
     *      * (имя пользователя и множество содержащее адреса эл.почты)
     * @return Возвращаем Карту содержащую Имя пользователя (ключ) в виде строки и множество с адресами эл.почты (значение).
     */
    public Map<String, Set<String>> insert(Set<User> accounts) {
        Map<String, String> temp = new HashMap<>(); // email, user
        Map<String, Set<String>> outMap = new HashMap<>(); // User, List<String>
        for (User currentUser : accounts) {
            String oldCopiedUser = null;
            for (String email : currentUser.getEmails()) {
                if (temp.containsKey(email)) {
                    oldCopiedUser = temp.get(email);
                    break;
                }
                temp.put(email, currentUser.getName());
            }
            if (oldCopiedUser == null) {
                outMap.put(currentUser.getName(), currentUser.getEmails());
            } else {
                Set<String> set = currentUser.getEmails();
                set.addAll(outMap.get(oldCopiedUser));
                outMap.remove(oldCopiedUser);
               outMap.put(currentUser.getName(), set);
            }
        }
        return outMap;
    }

//
//    public void process(Set<User> accounts) {
//        Set<User> set = new HashSet<>(accounts);
//        Map<String, User> map = new TreeMap<>();
//        for (User user : set) {
//            map.putAll(this.checkMap(user, set));
//        }
//        for (User user : map.values()) {
//            map.entrySet().forEach(s -> {
//                if (s.getValue().name.equals(user.name)) {
//                    user.addEmail(s.getKey());
//                }
//            });
//            this.setUsers.add(user);
//        }
//    }
//
//    private Map<String, User> checkMap(User user, Set<User> set) {
//        Map<String, User> map = new TreeMap<>();
//        Iterator<User> it = set.iterator();
//        user.getEmails().forEach(e -> map.put(e, new User(user.getName(), new HashSet<>())));
//        while (it.hasNext()) {
//          User tempUser = it.next();
//            for (String email : tempUser.getEmails()) {
//                if (map.containsKey(email)) {
//                    tempUser.getEmails().forEach(e -> map.put(e, map.get(email.toString())));
//                }
//            }
//        }
//        return map;
//    }

    public static class User {
         private String name;
         private HashSet<String> emails;


         public User(String name, HashSet<String> emails) {
             this.name = name;
             this.emails = emails;
         }
         public void addEmail(String email) {
             this.emails.add(email);
         }

         public Set<String> getEmails() {
            return this.emails;
         }

         public boolean containsEmail(String email) {
             return this.emails.contains(email);
         }

        public String getName() {
            return name;
        }

        public void setName(String name) {
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
            return Objects.equals(name, user.name)
                    && Objects.equals(emails, user.emails);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, emails);
        }
    }
}
