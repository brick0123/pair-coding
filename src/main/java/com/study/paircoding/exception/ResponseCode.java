package com.study.paircoding.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseCode {

  BAD_REQUEST(1000, "test");

  private final int code;
  private final String description;
}
