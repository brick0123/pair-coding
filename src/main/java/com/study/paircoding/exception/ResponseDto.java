package com.study.paircoding.exception;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseDto<T> {

  public static final ResponseDto<Void> success = new ResponseDto<>();

  private T content;
  private ResponseCode responseCode;
  private LocalDateTime occurredTime;

  public ResponseDto(T content, LocalDateTime occurredTime) {
    this.content = content;
    this.occurredTime = occurredTime;
  }

  public ResponseDto(T content, ResponseCode responseCode, LocalDateTime occurredTime) {
    this.content = content;
    this.responseCode = responseCode;
    this.occurredTime = occurredTime;
  }
}
