package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("플레이어는 ")
class PlayerTest {

    @Nested()
    @DisplayName("생성 시 ")
    class Generate {

        @Test
        @DisplayName("이름과 시작 위치를 받아서 생성한다.")
        void generatePlayerCase() {
            //given
            Name name = new Name("pobi");
            int startPosition = 0;

            //when
            Player player = new Player(name, startPosition);

            //then
            assertThat(player)
                    .extracting("currentColumnPosition")
                    .isEqualTo(startPosition);
        }
    }

    @Nested
    @DisplayName("움직일 때 ")
    class MoveCase {

        @Test
        @DisplayName(" 받은 값 만큼 위치를 옮긴다.")
        void givenPositionValue_thenMovePosition() {
            //given
            Player player = new Player(new Name("Pobi"), 0);

            //then
            player.move(1);

            //then
            assertThat(player)
                    .extracting("currentColumnPosition")
                    .isEqualTo(1);
        }
    }
}