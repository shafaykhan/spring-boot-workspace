package com.shafay.springbootworkspace.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  List<User> findAll();

  Optional<User> findByIdNotAndMobileNo(Long id,String mobileNo);
}