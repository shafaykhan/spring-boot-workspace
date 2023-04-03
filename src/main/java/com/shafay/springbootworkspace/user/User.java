package com.shafay.springbootworkspace.user;

import com.shafay.springbootworkspace.common.constant.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  @Positive
  private Long id;
  @NotBlank
  private String name;
  @NotBlank
  private String mobileNo;
  private String city;
  @NotNull
  private Status status;
}


