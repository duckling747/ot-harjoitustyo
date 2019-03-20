package com.mycompany.unicafe;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void kortinSaldoAlussaOikein() {
        assertThat(kortti.saldo(), is(10));
    }

    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein1() {
        kortti.lataaRahaa(100);
        assertThat(kortti.saldo(), is(110));
    }

    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein2() {
        kortti.lataaRahaa(10000);
        assertThat(kortti.saldo(), is(10010));
    }

    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein3() {
        kortti.lataaRahaa(200);
        assertThat(kortti.saldo(), is(210));
    }

    @Test
    public void saldoVaheneeOikein1() {
        kortti.otaRahaa(2);
        assertThat(kortti.saldo(), is(8));
    }

    @Test
    public void saldoVaheneeOikein2() {
        kortti.otaRahaa(10);
        assertThat(kortti.saldo(), is(0));
    }

    @Test
    public void saldoVaheneeOikein3() {
        kortti.otaRahaa(12);
        assertThat(kortti.saldo(), is(10));
    }

    @Test
    public void saldoPalauttaaTrueOikein1() {
        assertThat(kortti.otaRahaa(2), is(true));
    }

    @Test
    public void saldoPalauttaaTrueOikein2() {
        assertThat(kortti.otaRahaa(200), is(false));
    }

    @Test
    public void saldoPalauttaaTrueOikein3() {
        assertThat(kortti.otaRahaa(10), is(true));
    }

    @Test
    public void printMetodiTulostaaOikein1() {
        assertThat(kortti.toString(), is("saldo: 0.10"));
    }

    @Test
    public void printMetodiTulostaaOikein2() {
        kortti.otaRahaa(5);
        assertThat(kortti.toString(), is("saldo: 0.05"));
    }

}
