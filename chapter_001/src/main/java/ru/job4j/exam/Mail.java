package ru.job4j.exam;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mail {
    Map<User, Email> mapUser = new HashMap<>();

     public void unitMail(Map<Email, User> accounts) {

         for (Email email : accounts.keySet()) {
             User user = accounts.get(email);
             if (mapUser.containsValue(email)) {
                    this.addEmail(email);
             } else {
                 mapUser.put(user, email);
             }
         }
     }

    private User addEmail(Email email) {
    Iterator<User> it = this.mapUser.keySet().iterator();
    User tempUser = null;
    Email tempEmail = null;
    while (it.hasNext()) {
        tempUser = it.next();
        tempEmail = this.mapUser.get(tempUser);
            if (tempEmail.getEmail().equals(email)) {
                break;
            }
        }
    return tempUser;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Email email1 = (Email) o;
            return Objects.equals(email, email1.email);
        }

        @Override
        public int hashCode() {
            return Objects.hash(email);
        }
    }
}
