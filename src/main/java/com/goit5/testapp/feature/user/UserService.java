package com.goit5.testapp.feature.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

   public List<User> findAll() {
       return userRepository.findAll();
   }

   public void save(User user) {
       userRepository.save(user);
   }

   public boolean exists(String email) {
       if (email == null) {
           return false;
       }

       return userRepository.existsById(email);
   }

   public void deleteById(String email) {
       userRepository.deleteById(email);
   }

   public List<User> search(String query) {
       List<String> emails = userRepository.searchEmails("%" + query + "%");

       return userRepository.findAllById(emails);
   }

   public int countPeopleOlderThan(int age) {
       LocalDate maxBirthday = LocalDate.now().minusYears(age + 1);
       return userRepository.countOlderThan(maxBirthday);
   }
}
