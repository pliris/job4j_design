package ru.job4j.exam;

import java.util.*;
import java.util.stream.Collectors;

public class Mail {
     public void unitMail(Map<User, List<Email>> accounts) {
        Map<User, List<Email>> mapUser = new HashMap<>();
        Map<Email, List<User>> mapEmail = new HashMap<>();
        Map<String, String> mapStr = new HashMap<>();
       // Set<User, List<Email>> userSet = new HashSet<>();
        List<Email> listEmail = new ArrayList<>();

        for (User user : accounts.keySet()) {
            listEmail = accounts.get(user);
            for (Email email : listEmail) {
                if (mapUser.containsValue(email)) {
                    Set<Map.Entry<User, List<Email>>> temp = mapUser.entrySet();
                    User tempUser = temp.stream().filter(u ->);
                    mapEmail.merge(mapUser.get(), user);
                } else {

                }
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
