package mx.kmmx.junit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
class AppTest {
  /**
   * Rigorous Test :-)
   */
  @Test
  @DisplayName("shouldAnswerWithTrue")
  public void shouldAnswerWithTrue() {
    assertTrue(true);
  }

  @Test
  void abortedTest() {
    assumeTrue("abc".contains("Z"));
    fail("test should have been aborted");
  }

  @Test
  void failingTest() {
    fail("a failing test");
  }
  
  @Test
  @Disabled("for demonstration purposes")
  void skippedTest() {
    // not executed
  }
  
  @Test
  @DisplayName("Should check all items in the list")
  void shouldCheckAllItemsInTheList() {
    final List<Integer> numbers = List.of(2, 3, 5, 7);
    Assertions.assertEquals(2, numbers.get(0));
    Assertions.assertEquals(3, numbers.get(1));
    Assertions.assertEquals(5, numbers.get(2));
    Assertions.assertEquals(7, numbers.get(3));
  }
  
  @Test
  void assertThrowsException() {
    final String str = null;
    assertThrows(IllegalArgumentException.class, () -> {
      Integer.valueOf(str);
    });
  }
  
}
