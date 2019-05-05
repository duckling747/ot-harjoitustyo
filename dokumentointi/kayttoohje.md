# Käyttöohje

Lataa tiedosto [tästä](https://github.com/duckling747/ot-harjoitustyo/releases/tag/viikko6)

## Konfigurointi

Ohjelma ei oleta, että käynnistyshakemistossa olisi muita tiedostoja.

## Ohjelman käynnistäminen

Ohjelman viimeisin versio ajetaan tuttuun tapaan kommennolla

```
java -jar [tiedostonimi_tähän].jar
```

## Sovelluksen näkymät

Sovelluksen alkunäkymässä käyttäjä voi valita, haluaako hän uuden pelin vai haluaako hän ladata vanhan pelin. Kolmannesta nappulasta sovellus sulkeutuu. Mikäli vanhoja pelejä ei ole, pelaaja ei voi jatkaa edistymistä mistään muusta kohdasta kuin pelin alusta.

Sovellus antaa pelaajan luoda hahmon valikkonäkymässä annettujen parametrien mukaan. Hahmon nimelle ei ole annettu rajoituksia! Peli johdattelee seuraavaksi taistelunäkymään ja next-nappulalla pääsee eteenpäin. Tappelut ja tarinankerronta seuraavat toisiaan kunnes peli päättyy ja palataan alkunäkymään.

### Hahmonluontivalikko

![valikko](https://github.com/duckling747/ot-harjoitustyo/blob/master/dokumentointi/images/charselect.png)

Hahmo luodaan kirjoittamalla nimi ja valitsemalla sen tyyppi. Sitten painetaan Start-nappulaa.

### Taistelunäkymä

![taistelu](https://github.com/duckling747/ot-harjoitustyo/blob/master/dokumentointi/images/battle_example.png)

Taistelunäkymässä on toteutettuna sekä tarinankerronta että itse taistelut. Tarina-instanssin ollessa käynnissä, next-nappula vie tarinaa eteenpäin.

![taistelu2](https://github.com/duckling747/ot-harjoitustyo/blob/master/dokumentointi/images/fighting.png)

Taistelujen aikana pelaaja saa käyttöönsä muut taistelunäkymän nappulat. Kuvassa rotta ja warrior-tyypin pelaaja taistelevat. Huom! kaikki muut taistelun aikana aktivoituvat nappulat toimivat paitsi "use item" -nappula. Nappulaa voi kuitenkin painaa huoletta, siitä ei todennäköisesti koidu harmia.

### Lopettaminen

Pelin voi lopettaa koska tahansa ikkunan oikeassa yläkulmassa sijaitsevasta ruksista tai päävalikon Quit-nappulasta.
