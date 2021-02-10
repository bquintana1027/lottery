package edu.cnm.deepdive;

import java.util.Arrays;
import java.util.Random;

public class Shuffler {

  private int[] data;
  private Random rng;

  public Shuffler(int[] data) {
    this(data, new Random());
  }

  public Shuffler(int[] data, Random rng) {
    this.data = Arrays.copyOf(data, data.length);
    this.rng = rng;
  }

  public int[] shuffle() {
    // TODO Perform a Fisher-Yates shuffle.
    return draw(data.length);
  }

  public int[] draw(int size) throws  IllegalArgumentException {
    if (size > data.length) {
      throw new IllegalArgumentException();
    }
    for (int i = data.length - 1; i >= data.length - size; i--) {
      int swampTarget = rng.nextInt(i + 1);
      if (swampTarget != i){
        int temp = data[i];
        data[i] = data[swampTarget];
        data[swampTarget] = temp;
      }
    }
      return Arrays.copyOfRange(data, data.length - size, data.length);
    }
  }