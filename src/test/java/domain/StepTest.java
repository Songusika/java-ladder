package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("디딤대는 ")
class StepTest {
    @Test
    @DisplayName("없을 경우 발을 디딜 수 없다고 알려준다.")
    void unsteppableCase() {
        assertThat(Step.NONE.isSteppable())
                .isFalse();
    }

    @Test
    @DisplayName("있을 경우 발을 디딜 수 있다고 알려준다.")
    void steppableCase() {
        assertThat(Step.RIGHT.isSteppable())
                .isTrue();
    }
}