package ru.job4j.exam;


import java.util.*;

public class Mail {
  //  private Map<User, Set<Email>> mapUser = new HashMap<>();
    public Set<User> setUsers = new HashSet<>();


    public void process(Set<User> accounts) {
        Set<User> set = new HashSet<>(accounts);
        Map<String, User> map = new TreeMap<>();
        for (User user : set) {
            map.putAll(this.checkMap(user, set));
        }
        for (User user : map.values()) {
            map.entrySet().forEach(s -> {
                if (s.getValue().name.equals(user.name)) {
                    user.addEmail(s.getKey());
                }
            });
            this.setUsers.add(user);
        }
    }

    private Map<String, User> checkMap(User user, Set<User> set) {
        Map<String, User> map = new TreeMap<>();
        Iterator<User> it = set.iterator();
        user.getEmails().forEach(e -> map.put(e, new User(user.getName(), new HashSet<>())));
        while (it.hasNext()) {
          User tempUser = it.next();
            for (String email : tempUser.getEmails()) {
                if (map.containsKey(email)) {
                    tempUser.getEmails().forEach(e -> map.put(e, map.get(email.toString())));
                }
            }
        }
        return map;
    }


//
//    public Set<User> process(Set<User> accounts) {
//        Set<User> temp = new HashSet<>();
//        for (User user : accounts) {
//            if (temp.size() == 0) {z
//                temp.add(user);
//            }
//            Iterator<User> it = temp.iterator();
//            Set<String> tempSet = new HashSet<>();
//            while (it.hasNext()) {
//                User currentUser = it.next();
//                for (String email : user.getEmails()) {
//                    if (currentUser.containsEmail(email)) {
//                        currentUser.getEmails().addAll(user.getEmails());
//                        tempSet.addAll(currentUser.getEmails());
//                        break;
//                    }
//                }
//                temp.add(currentUser);
//            }
//
//        }
//        return temp;

//
//     public Map<User, Set<Email>> unitMail(Map<User, Set<Email>> accounts) {
//        Set<Email> setEmails = new HashSet<>();
//         for (User user : accounts.keySet()) {
//             Set<Email> emails = accounts.get(user);
//             for (Email tempEmail : emails) {
//                 if (this.findUserByEmail(tempEmail) != null) {
//                     User tempUser = this.findUserByEmail(tempEmail);
//                     setEmails = this.findSetEmails(tempUser);
//                   //  setEmails.add(tempEmail);
////                     emails = setEmails.stream().
////                             filter(e -> e.equals(tempEmail)).
////                             collect(Collectors.toSet());
//                     mapUser.put(user, setEmails.stream().
//                             filter(e -> !e.equals(tempEmail)).
//                             collect(Collectors.toSet()));
//                     mapUser.remove(tempUser, setEmails);
//
//                 } else if (this.findSetEmails(user) == null) {
//                     Set<Email> tempSet = new HashSet<>();
//                     tempSet.add(tempEmail);
//                     mapUser.put(user, tempSet);
//                 } else {
//                     setEmails = this.findSetEmails(user);
//                     setEmails.add(tempEmail);
//                 }
//             }
//         }
//         return this.mapUser;
//     }

//     private Set<Email> findSetEmails(User user) {
//         return this.mapUser.get(user);
//     }
//
//    private User findUserByEmail(Email email) {
//    Iterator<User> it = this.mapUser.keySet().iterator();
//    User user = null;
//    Set<Email> setEmail;
//    while (it.hasNext()) {
//        User tempUser = it.next();
//        setEmail = this.findSetEmails(tempUser);
//        for (Email tempEmail : setEmail) {
//            if (tempEmail.equals(email)) {
//                user = tempUser;
//                break;
//            }
//        }
//    }
//    return user;
//     }


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

    public static class Email {
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
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Email email1 = (Email) o;
            return Objects.equals(email, email1.email);
        }

        @Override
        public int hashCode() {
            return Objects.hash(email);
        }
    }
}
