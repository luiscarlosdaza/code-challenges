package com.daza.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyQueries {

  List<Integer> result;
  Map<Integer, Integer> queries;
  private static final int ZERO = 0;
  private static final int UNO = 1;
  private static final int INSERT = 1;
  private static final int DELETE = 2;
  private static final int CHECK = 3;

  public FrequencyQueries() {
    result = new ArrayList<>();
    queries = new HashMap<>();
  }

  public List<Integer> process(List<List<Integer>> queries) {
    queries.forEach(list -> {
      int[] query = list.stream().mapToInt(i->i).toArray();
        switch (query[0]) {
          case INSERT:
            insert(query[1]);
            break;
          case DELETE:
            delete(query[1]);
            break;
          case CHECK:
            check(query[1]);
            break;
          default:
            break;
        }
    });

    return result;
  }

  private void insert(Integer value) {
    if (queries.containsKey(value)) {
      queries.put(value, queries.get(value)+1);
    } else {
      queries.put(value, UNO);
    }
  }

  private void delete(Integer value) {
    if (queries.containsKey(value)) {
      queries.put(value, queries.get(value)-1);
    }
  }

  private void check(int frequency) {
    if (queries.containsValue(frequency)) {
      result.add(UNO);
    } else {
      result.add(ZERO);
    }
  }
}
