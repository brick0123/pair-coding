package com.study.paircoding;

import com.study.paircoding.member.MemberRequestDto;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/hello")
  public String hello() {
    return "hello";
  }

  @PostMapping("/members")
  public void members(@Valid @RequestBody MemberRequestDto dto) {
  }
}
