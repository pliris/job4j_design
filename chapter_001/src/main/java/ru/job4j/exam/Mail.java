package ru.job4j.exam;

import java.util.*;

public class Mail {
     public void unitMail(Map<Email, List<User>> accounts) {
        Map<User, List<Email>> mapUser = new HashMap<>();
        Map<Email, List<User>> mapEmail = new HashMap<>();
        Map<String, String> mapStr = new HashMap<>();
        List<User> listUser = new ArrayList<>();

        for (Email email : accounts.keySet()) {
            listUser = accounts.get(email);
            if (mapUser.containsKey(email)) {
                mapEmail.merge(email, user);
            } else {

            }

        }




    }

    public class User {
         private String name;

         public User(String name) {
             this.name = name;
         }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class Email {
         private String email;

         public Email(String email) {
             this.email = email;
         }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
