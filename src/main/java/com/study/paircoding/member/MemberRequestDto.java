package com.study.paircoding.member;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberRequestDto {

  @NotNull
  private String name;

  @Max(value = 11)
  private int age;

  @Builder
  public MemberRequestDto(String name, int age) {
    this.name = name;
    this.age = age;
  }
}
