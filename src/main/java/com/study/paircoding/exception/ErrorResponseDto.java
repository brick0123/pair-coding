package com.study.paircoding.exception;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorResponseDto {

  private final String code;
  private final String message;
  private final LocalDateTime occurredTime;
}
