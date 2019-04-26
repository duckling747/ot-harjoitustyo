# Arkkitehtuurikuvaus

## Rakenne

Ohjelman toiminnan kannalta keskeisimmät luokat ja rajapinnat ovat seuraavassa:

![luokkarakenne](https://github.com/duckling747/ot-harjoitustyo/blob/master/dokumentointi/images/luokkarakenne.png)

## Käyttöliittymä

Käyttöliittymä sisältää päävalikon, hahmonluontivalikon, taistelunäkymän, sekä pienempiä dialogi-ikkunoita. Jokainen näistä on oma Scene-olionsa, joka generoidaan Käyttöliittymäluokassa, omassa metodissaan. Näkymät näkyvät yksi kerrallaan Stage-oliossa, joka pysyy koko ohjelman suorituksen ajan muuttumattomana. Käyttöliittymäluokka on toteutettu kansiohierarkian polkuun rpgame.ui.Menu.

Käyttöliittymän pääsyä sovelluslogiikan eri luokkiin on pyritty rajaamaan siten, että se pääasiassa käyttäisi Game-luokkaa, joka sisältää pelin etenemisen ja tapahtumien päätoiminnallisuuden. Sovellukselle voitaisiin yhtä hyvin rakentaa korvaava, täysin tekstipohjainen UI niin haluttaessa verrattain pienin muutoksin. Myös kokonaan uusi UI on tietenkin mahdollinen.

## Sovelluslogiikka

Sovelluksen toiminnan kannalta keskeisin luokka on Game-luokka, jota UI pääasiallisesti käyttää. Game-luokka hyödyntää eri hahmoluokkia, WarriorCharacter, ThiefCharacter ja WizardCharacter, pelaajan valintojen mukaan, ja osa pelinsisäisestä dialogista perustuu myös käyttäjän nimi- ja hahmotyyppivalintaan. Abstrakteja luokkia ollaan käytetty eri pelihahmotyyppien yhteisten ominaisuuksien abstrahoimiseen ja toisteisen koodin minimoimiseen. Lisää informaatiota perimishierarkiasta ja luokkien suhteista toisiinsa on nähtävillä luokkarakennekaaviosta (kts. yläpuolella). Game-luokka tarjoaa UI-luokalle myös Battle-luokan toiminnallisuuden taistelujen toteuttamiseksi (UI:n tarvitsee saada tietää, mitä taistelujen aikana tapahtuu, vaikka nämä eivät olisikaan kategorisesti osa pelikokonaisuuden abstraktiotasoa). Eri hahmotyypeille on pyritty luomaan eri ominaisuuksia, joista osa riippuu pelihahmojen taidoista. Toteutuksessa on aikarajojen vuoksi pyritty saamaan perustoiminnallisuus valmiiksi erityisesti WarriorCharacter-luokalle. 

## Tiedostot ja tallennus

Pelin aikana pystytään tallentamaan pelin edistyminen tekstitiedostoon, joka sisältää luodun hahmon nimen, luodun hahmon tyypin ja pelin senhetkisen tason nimen. Jatkettaessa peliä päävalikon Load Game -nappulasta, peli jatkuu siitä kohtaa mihin tallennuksen aikana jäätiin. Peli tukee yhtä tallennusta kerrallaan ja tallennus toteutetaan vakiona tiedostoon "game.sav" pelin työskentelykansiossa.

## Päätoiminnallisuus käytännössä

Kun pelaaja on aluksi luonut hahmonsa, valinnut sille nimen ja tyypin, peli alkaa taistelunäkymästä, joka kertoo pelaajalle tarinaa. Tarina etenee next-näppäimellä, kunnes tarinaa ei enää anneta ja ensimmäinen taistelu alkaa. Taistelut perustuvat pelaajan ja hirviön toimintoihin, joita nämä päättävät tehdä vuorotellen. Kun on hirviön vuoro päättää mitä hirviö tekee, pelaaja painaa next-nappulaa pelin etenemiseksi, ja kun on pelaajan vuoro päättää, muut näppäimet muuttuvat kirkkaan värisiksi toiminnon valitsemiseksi. Näin peli etenee kunnes taistelut päättyvät ja pelaajalle näytetään seuraavat tarinatekstit.

## Ohjelman rakenteen heikkoudet

Käyttöliittymäluokka on parhaimmillaankin sekava. Sen toimintojen eriyttämiseksi pelkät Javan lambda-funktiot eivät riitä, vaan vaadittaisiin runsaasti erillisiä luokkia. Ohjelma on myös suhteellisen laaja: jotta se olisi erityisen mielekäs, pitäisi kirjoittaa paljon lisää koodia ja suunnitella ja hienosäätää pelaajan hahmon ominaisuuksia suhteessa hirviöiden ominaisuuksiin paremmaksi, niin että taistelut eivät olisi toisaalta liian helppoja, mutta eivät liian vaikeitakaan. Jonkinlaisia erityistaitoja, jotka käyttävät peliin koodattua mana-laskuria, pitäisi rakentaa; kuten myös esineiden käyttö ja toiminnallisuus, sekä samalla tavalla tasapainotettu LevelUP-systeemi, joka todennäköisesti jää projektin loppuvaiheillakin lapsen kenkiinsä.
