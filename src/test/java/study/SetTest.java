package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("set의 크기 확인")
    @Test
    void setSize() {
        assertEquals(3, numbers.size());
    }

    @DisplayName("test 중복코드 제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void setContains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("테스트 예측 하기")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiterString = ":")
    void expectResult(int setNumber, boolean expectedResult) {
        boolean actualResult = numbers.contains(setNumber);

        assertEquals(expectedResult, actualResult);
    }

}
