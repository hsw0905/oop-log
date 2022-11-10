package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

  @DisplayName("패스워드를 초기화한다")
  @Test
  void initPasswordSuccess() {
    User user = new User();

    user.initPassword(()->"12345678");

    assertThat(user.getPassword()).isNotNull();
  }

  @DisplayName("패스워드 초기화 실패")
  @Test
  void initPasswordFail() {
    User user = new User();

    user.initPassword(()->"1234");

    assertThat(user.getPassword()).isNull();
  }
}
