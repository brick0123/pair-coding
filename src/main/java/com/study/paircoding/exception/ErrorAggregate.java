package com.study.paircoding.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@Getter
public class ErrorAggregate {

  private final ResponseCode errorCode; // 사용정의한
  private final String message; // error.getMessage(); // Validation
}
