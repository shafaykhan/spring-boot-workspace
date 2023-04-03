package com.shafay.springbootworkspace.user;

import com.shafay.springbootworkspace.common.exception.ConflictException;
import com.shafay.springbootworkspace.common.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  private final UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public User save(User user) {
    validateMobileNoAndThrowIfExist(null, user.getMobileNo());
    return repository.save(user);
  }

  public User update(User user) {
    User userEntity = findEntityById(user.getId());
    validateMobileNoAndThrowIfExist(userEntity.getId(), user.getMobileNo());
    return repository.save(user);
  }

  public List<User> findAll() {
    return repository.findAll();
  }

  public User findById(Long id) {
    return findEntityById(id);
  }

  public void delete(Long id) {
    User userEntity = findEntityById(id);
    repository.delete(userEntity);
  }

  public User findEntityById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new NotFoundException("User not found!"));
  }

  public void validateMobileNoAndThrowIfExist(Long id, String mobileNo) {
    Optional<User> userOptional = repository.findByIdNotAndMobileNo(id != null ? id : 0, mobileNo);
    if (userOptional.isPresent()) {
      throw new ConflictException("Mobile no already exist!");
    }
  }
}
