package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @DisplayName("1,2 구분 테스트")
    @Test
    void containsTest12() {
        String str = "1,2";
        String[] splitStr = str.split(",");

        assertThat(splitStr).contains("2", "1");
        assertThat(splitStr).containsExactly("1", "2");
    }

    @DisplayName("1구분 테스트")
    @Test
    void containsTest1() {
        String str = "1";
        String[] splitStr = str.split(",");

        assertThat(splitStr).contains("1");
        assertThat(splitStr).containsExactly("1");
    }

    @DisplayName("괄호를 제거한다.")
    @Test
    void removeTest() {
        String str = "(1,2)";
        str = str.substring(1, str.length() - 1);

        assertThat(str).contains("1,2");
        assertThat(str).isEqualTo("1,2");
    }

    @DisplayName("charAt()으로 특정 문자 반환 ThrownBy 테스트")
    @Test
    void atThrownByTest() {
        String str = "1234";

        char lastChar = str.charAt(str.length() - 1);
        assertThat(lastChar).isEqualTo('4');

        assertThatThrownBy(() -> {
            try {
                str.charAt(str.length());
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException("Index: 4, Size: 4");
            }
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 4, Size: 4");

    }

    @DisplayName("charAt()으로 특정 문자 반환 ExceptionOfType 테스트")
    @Test
    void atExceptionOfTypeTest() {
        String str = "1234";

        char lastChar = str.charAt(str.length() - 1);
        assertThat(lastChar).isEqualTo('4');

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    try {
                        str.charAt(str.length());
                    } catch (IndexOutOfBoundsException e) {
                        throw new IndexOutOfBoundsException("최대 인덱스가 3인데 인덱스 4를 탐색하셨습니다.");
                    }
                }).withMessageMatching("최대 인덱스가 \\d+인데 인덱스 \\d+를 탐색하셨습니다.");
    }
}
