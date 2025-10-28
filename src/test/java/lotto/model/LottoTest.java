package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @Test
    @DisplayName("로또 번호 개수 검증 테스트")
    void LottoSizeValidationTest() {
        assertThatThrownBy(() -> {
            new Lotto(List.of(1, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호가 오름차순으로 정렬되서 나오는지 확인한다.")
    void LottoNumberSortingTest() {
        Lotto lotto = new Lotto(List.of(5, 3, 1, 4, 6, 2));
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertEquals(expected, lotto.getNumbers());
    }
}
