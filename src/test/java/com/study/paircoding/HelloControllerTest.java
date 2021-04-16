package com.study.paircoding;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.paircoding.member.MemberRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.bind.MethodArgumentNotValidException;

@WebMvcTest
public class HelloControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  void hello() throws Exception {
    // action
    final ResultActions actions = mockMvc.perform(get("/hello")
        .contentType(MediaType.APPLICATION_JSON));

    // assert
    actions
        .andExpect(content().string("hello"))
        .andExpect(status().isOk());
  }

  @Test
  @DisplayName("나이가 11살 이하고 이름이 공백이 아니면 유효성 검증에 성공한다.")
  void memberRequestSuccessTest() throws Exception {
    MemberRequestDto requestDto = MemberRequestDto.builder()
        .age(5)
        .name("jakeNice")
        .build();

    final ResultActions actions = mockMvc.perform(post("/members")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(requestDto)));

    actions
        .andExpect(status().isOk());
  }

  @Test
  @DisplayName("name이 공백이면 유효성 검증에 실패한다")
  void name_exception() throws Exception {
    MemberRequestDto requestDto = MemberRequestDto.builder()
        .age(15)
        .build();

    final ResultActions actions = mockMvc.perform(post("/members")
        .content(objectMapper.writeValueAsString(requestDto))
        .contentType(MediaType.APPLICATION_JSON));

    actions.andDo(print())
        .andExpect(result -> assertThat(result.getResolvedException())
            .isInstanceOf(MethodArgumentNotValidException.class))
        .andExpect(status().isBadRequest());
  }
}
