# RPG

Tämä on kurssin *Ohjelmistotuotanto* harjoitustyö. Tänne tulee kurssin laskareita ja sitä mukaa kun kurssi etenee, työn välivaiheita sekä lopullinen valmis työ. Sovellus on simppeli vuoropohjainen RPG, joka on toteutettu JavaFX:llä. 

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/duckling747/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/duckling747/ot-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/duckling747/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

## Komentorivi

### Testaus

Ohjelman voi ajaa komennolla
```
mvn compile exec:java -Dexec.mainClass=rpgame.main.Main
```

Testit suoritetaan komennolla
```
mvn test
```
Testikattavuusraportin saa luotua komennolla
```
mvn jacoco:report
```
Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/mluukkai/OtmTodoApp/blob/master/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_
