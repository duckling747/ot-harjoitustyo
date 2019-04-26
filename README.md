# RPG

Tämä on kurssin *Ohjelmistotuotanto* harjoitustyö. Tänne tulee kurssin laskareita ja sitä mukaa kun kurssi etenee, työn välivaiheita sekä lopullinen valmis työ. Sovellus on simppeli vuoropohjainen RPG, joka on toteutettu JavaFX:llä. 

## Dokumentaatio

[Käyttöohje](https://github.com/duckling747/ot-harjoitustyo/blob/master/dokumentointi/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/duckling747/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/duckling747/ot-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/duckling747/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

## Releaset
[Viikko 5](https://github.com/duckling747/ot-harjoitustyo/releases/tag/viikko5)

[Viikko 6](https://github.com/duckling747/ot-harjoitustyo/releases/tag/viikko6)

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

### Suoritettavan jarin generointi

Komento

```
mvn package
```

### JavaDoc

JavaDocsit saa aikaan komennolla
```
mvn javadoc:javadoc
```
JavaDocia voi tarkastella selaimella tiedostosta, joka sijaitsee polussa _target/site/apidocs/index.html_

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/mluukkai/OtmTodoApp/blob/master/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_
