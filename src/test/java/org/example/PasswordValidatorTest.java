package org.example;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/*
 * 비밀번호는 최소 8자 이상 최대 12자 이하가 되어야 한다.
 * 위 조건 미충족시 IllegalArgumentException 발생
 */
public class PasswordValidatorTest {
  
  @DisplayName("비밀번호는 최소 8자 이상 최대 12자 이하면 예외가 발생하지 않는다.")
  @Test
  void validatePassword() {
    assertThatCode(()->PasswordValidator.validate("123456789")).doesNotThrowAnyException();
  }
}
