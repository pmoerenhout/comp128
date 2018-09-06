package com.github.pmoerenhout.comp128;

import org.junit.Assert;
import org.junit.Test;

public class Comp128Test {

  private final byte[] ki = hexStringToByteArray("68A641914BD5AF66EA6144E1E7D1BEF6");
  private final byte[] rand = hexStringToByteArray("75443BB0CAC453EF0135E5B5BCAA98EE");

  @Test
  public void test_comp128v1() {
    final byte[] sres_kc = Comp128.v1(ki, rand);
    Assert.assertArrayEquals(hexStringToByteArray("B6859E44D11F61652B53E800"), sres_kc);
  }

  @Test
  public void test_comp128v2() {
    final byte[] sres_kc = Comp128.v2(ki, rand);
    Assert.assertArrayEquals(hexStringToByteArray("EE14EE3784EAF6D508EEA800"), sres_kc);
  }

  @Test
  public void test_comp128v3() {
    final byte[] sres_kc = Comp128.v3(ki, rand);
    Assert.assertArrayEquals(hexStringToByteArray("EE14EE3784EAF6D508EEA863"), sres_kc);
  }

  private byte[] hexStringToByteArray(final String s) {
    if (s == null || (s.length() % 2) == 1) {
      throw new IllegalArgumentException();
    }
    final char[] chars = s.toCharArray();
    final int len = chars.length;
    final byte[] data = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
      data[i / 2] = (byte) ((Character.digit(chars[i], 16) << 4) + Character.digit(chars[i + 1], 16));
    }
    return data;
  }

}