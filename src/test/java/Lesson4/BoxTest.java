package Lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BoxTest {
    Box box;

    @Nested
    class WhenEmpty {
        @BeforeEach
        void createEmptyBox() {
            box = new Box();
        }

        @Test
        void exceptionWhenTryToShuffleBox() {
            Assertions.assertThrows(NullPointerException.class, () -> box.shuffleBalls());

        }

        @Test
        void addBallIntoBox() {
            box.addBall();
            Assertions.assertEquals(box.getCountBalls(), 1);
        }

        @Test
        void exceptionWhenDeleteBallFromEmptyBox() {
            Assertions.assertThrows(BoxIsAlreadyEmptyExeption.class, () -> box.deleteBall());
        }

        @Nested
        class OneBallInBox{
            @BeforeEach
            void addOneBall() {
                box.addBall();
            }

            @Test
            void deleteBallFromBox() throws BoxIsAlreadyEmptyExeption {
                box.deleteBall();
                Assertions.assertEquals(box.getCountBalls(), 0);
            }
        }

    }
}
