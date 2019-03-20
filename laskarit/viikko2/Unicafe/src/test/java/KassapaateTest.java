
import com.mycompany.unicafe.Kassapaate;
import com.mycompany.unicafe.Maksukortti;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class KassapaateTest {

    Kassapaate k;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        k = new Kassapaate();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void luodunPaatteenRahaOnOikein() {
        assertThat(k.kassassaRahaa(), is(100000));
    }

    @Test
    public void luodunPaatteenEdullisetOikein() {
        assertThat(k.edullisiaLounaitaMyyty(), is(0));
    }

    @Test
    public void luodunPaatteenMaukkaatOikein() {
        assertThat(k.maukkaitaLounaitaMyyty(), is(0));
    }

    @Test
    public void kateisostoToimii1() {
        assertThat(k.syoEdullisesti(2), is(2));
    }

    @Test
    public void kateisostoToimii2() {
        assertThat(k.syoEdullisesti(240), is(0));
    }

    @Test
    public void kateisostoToimii3() {
        assertThat(k.syoMaukkaasti(240), is(240));
    }

    @Test
    public void kateisostoToimii4() {
        assertThat(k.syoMaukkaasti(400), is(0));
    }

    @Test
    public void kateisostoToimii5() {
        k.syoEdullisesti(2);
        assertThat(k.edullisiaLounaitaMyyty(), is(0));
    }

    @Test
    public void kateisostoToimii6() {
        k.syoEdullisesti(240);
        assertThat(k.edullisiaLounaitaMyyty(), is(1));
    }

    @Test
    public void kateisostoToimii7() {
        k.syoEdullisesti(2);
        assertThat(k.kassassaRahaa(), is(100000));
    }

    @Test
    public void kateisostoToimii8() {
        k.syoEdullisesti(240);
        assertThat(k.kassassaRahaa(), is(100000 + 240));
    }

    @Test
    public void korttiostoToimii1() {
        Maksukortti mk = new Maksukortti(2);
        assertThat(k.syoEdullisesti(mk), is(false));
    }

    @Test
    public void korttiostoToimii2() {
        Maksukortti mk = new Maksukortti(240);
        assertThat(k.syoEdullisesti(mk), is(true));
    }

    @Test
    public void korttiostoToimii3() {
        Maksukortti mk = new Maksukortti(240);
        assertThat(k.syoMaukkaasti(mk), is(false));
    }

    @Test
    public void korttiostoToimii4() {
        Maksukortti mk = new Maksukortti(400);
        assertThat(k.syoMaukkaasti(mk), is(true));
    }

    @Test
    public void korttiostoToimii5() {
        Maksukortti mk = new Maksukortti(400);
        k.syoMaukkaasti(mk);
        assertThat(k.maukkaitaLounaitaMyyty(), is(1));
    }

    @Test
    public void korttiostoToimii6() {
        Maksukortti mk = new Maksukortti(240);
        k.syoMaukkaasti(mk);
        assertThat(k.maukkaitaLounaitaMyyty(), is(0));
    }

    @Test
    public void korttiostoToimii7() {
        Maksukortti mk = new Maksukortti(240);
        k.syoMaukkaasti(mk);
        assertThat(k.kassassaRahaa(), is(100000));
    }

    @Test
    public void korttiostoToimii8() {
        Maksukortti mk = new Maksukortti(400);
        k.syoMaukkaasti(mk);
        assertThat(k.kassassaRahaa(), is(100000 + 400));
    }

    @Test
    public void korttiostoToimii9() {
        Maksukortti mk = new Maksukortti(2);
        k.syoEdullisesti(mk);
        assertThat(k.kassassaRahaa(), is(100000));
    }

    @Test
    public void korttiostoToimii10() {
        Maksukortti mk = new Maksukortti(240);
        k.syoEdullisesti(mk);
        assertThat(k.kassassaRahaa(), is(100000 + 240));
    }

    @Test
    public void korttilatausToimii1() {
        Maksukortti mk = new Maksukortti(400);
        k.lataaRahaaKortille(mk, 100);
        assertThat(mk.saldo(), is(500));
    }
}
