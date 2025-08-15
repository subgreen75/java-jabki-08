import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MainTest {
  @Test
  void getMinMaxOfListTest() {
      List<Integer> list = new ArrayList<Integer>();
      list.add(1);
      list.add(2);
      Assertions.assertEquals(1, Main.getMinOfList(list));
      Assertions.assertEquals(2, Main.getMaxOfList(list));
  }

    @Test
    void getCountOfListGreateTest() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals(1, Main.getCountOfListGreateN(list,2));
    }

    @Test
    void getDescListOfNumTest() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> listInvert = new ArrayList<Integer>();
        listInvert.add(3);
        listInvert.add(2);
        listInvert.add(1);
        Assertions.assertEquals(listInvert, Main.getInvertList(list));

        List<String> listStr = new ArrayList<String>();
        listStr.add("a");
        listStr.add("b");
        listStr.add("c");

        List<String> listStrInvert = new ArrayList<String>();
        listStrInvert.add("c");
        listStrInvert.add("b");
        listStrInvert.add("a");

        Assertions.assertEquals(listStrInvert, Main.getInvertList(listStr));
    }

    @Test
    void getSumOddNumbersTest() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Assertions.assertEquals(1 + 3 + 5, Main.getSumOddNumbers(list));
    }

    @Test
    void getListByAlphaTest() {
        List<String> list = new ArrayList<String>();
        list.add("Маша");
        list.add("Cаша");
        list.add("Аня");

        List<String> listAlpha = new ArrayList<String>();
        listAlpha.add("Аня");

        Assertions.assertEquals(listAlpha, Main.getListByAlpha(list, "А"));
    }
}