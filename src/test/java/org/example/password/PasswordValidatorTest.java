package org.example.password;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


/*
 * 비밀번호는 최소 8자 이상 최대 12자 이하가 되어야 한다.
 * 위 조건 미충족시 IllegalArgumentException 발생
 */
public class PasswordValidatorTest {
  
  @DisplayName("비밀번호가 최소 8자 이상 최대 12자 이하면 예외가 발생하지 않는다.")
  @Test
  void validatePasswordSuccess() {
    assertThatCode(()-> PasswordValidator.validate("123456789"))
        .doesNotThrowAnyException();
  }

  @DisplayName("비밀번호가 7자 이하거나 12자 초과하면 예외가 발생한다.")
  @ParameterizedTest
  @ValueSource(strings = {"1234567", "123456789abcd"})
  void validatePasswordFail(String password) {
    assertThatCode(()->PasswordValidator.validate(password))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("비밀번호는 최소 8자 이상 최대 12자 이하가 되어야 합니다.");
  }
}
