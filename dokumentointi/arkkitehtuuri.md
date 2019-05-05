# Arkkitehtuurikuvaus

## Rakenne

Ohjelman luokat ja rajapinnat on esitelty seuraavassa luokkakaaviossa:

![luokkarakenne](https://github.com/duckling747/ot-harjoitustyo/blob/master/dokumentointi/images/luokkakaavio.png)

## Käyttöliittymä

Käyttöliittymä sisältää päävalikon, hahmonluontivalikon, taistelunäkymän, sekä pienempiä dialogi-ikkunoita. Jokainen näistä on oma Scene-olionsa, joka generoidaan Käyttöliittymäluokassa, omassa metodissaan. Näkymät näkyvät yksi kerrallaan Stage-oliossa, joka pysyy koko ohjelman suorituksen ajan muuttumattomana. Käyttöliittymäluokka on toteutettu kansiohierarkian polkuun [rpgame.ui.Menu](https://github.com/duckling747/ot-harjoitustyo/blob/master/RPGame/src/main/java/rpgame/ui/Menu.java).

Käyttöliittymän pääsyä sovelluslogiikan eri luokkiin on pyritty rajaamaan siten, että se pääasiassa käyttäisi [Game-luokkaa](https://github.com/duckling747/ot-harjoitustyo/blob/master/RPGame/src/main/java/rpgame/progression/Game.java), joka sisältää pelin etenemisen ja tapahtumien päätoiminnallisuuden. Sovellukselle voitaisiin yhtä hyvin rakentaa korvaava, täysin tekstipohjainen UI niin haluttaessa verrattain pienin muutoksin. Myös kokonaan uusi UI on tietenkin mahdollinen.

## Sovelluslogiikka

Sovelluksen toiminnan kannalta oletettavasti keskeisin luokka on [Game-luokka](https://github.com/duckling747/ot-harjoitustyo/blob/master/RPGame/src/main/java/rpgame/progression/Game.java), jota UI pääasiallisesti käyttää. [Game-luokka](https://github.com/duckling747/ot-harjoitustyo/blob/master/RPGame/src/main/java/rpgame/progression/Game.java) hyödyntää eri hahmoluokkia, [WarriorCharacter](https://github.com/duckling747/ot-harjoitustyo/blob/master/RPGame/src/main/java/rpgame/creatures/WarriorCharacter.java), [ThiefCharacter](https://github.com/duckling747/ot-harjoitustyo/blob/master/RPGame/src/main/java/rpgame/creatures/ThiefCharacter.java) ja [WizardCharacter](https://github.com/duckling747/ot-harjoitustyo/blob/master/RPGame/src/main/java/rpgame/creatures/WizardCharacter.java), pelaajan valintojen mukaan, ja osa pelinsisäisestä tarinankerronnasta perustuu myös käyttäjän nimi- ja hahmotyyppivalintaan. Abstrakteja luokkia ollaan käytetty eri pelihahmotyyppien yhteisten ominaisuuksien abstrahoimiseen ja toisteisen koodin minimoimiseen. Lisää informaatiota perimishierarkiasta ja luokkien suhteista toisiinsa on nähtävillä luokkarakennekaaviosta (kts. yläpuolella). Seuraavassa sekvenssikaaviossa on esitelty esimerkinomaisesti, mitä ohjelmassa tapahtuu aloitettaessa uusi peli [WarriorCharacter-tyypin](https://github.com/duckling747/ot-harjoitustyo/blob/master/RPGame/src/main/java/rpgame/creatures/WarriorCharacter.java) hahmolla.

![uusi_peli](https://github.com/duckling747/ot-harjoitustyo/blob/master/dokumentointi/images/new_game_start.png)

[Game-luokka](https://github.com/duckling747/ot-harjoitustyo/blob/master/RPGame/src/main/java/rpgame/progression/Game.java) tarjoaa [UI-luokalle](https://github.com/duckling747/ot-harjoitustyo/blob/master/RPGame/src/main/java/rpgame/ui/Menu.java) myös [Battle-luokan](https://github.com/duckling747/ot-harjoitustyo/blob/master/RPGame/src/main/java/rpgame/battle/Battle.java) toiminnallisuuden taistelujen toteuttamiseksi (UI:n tarvitsee saada tietää, mitä taistelujen aikana tapahtuu, vaikka nämä eivät olisikaan kategorisesti osa pelikokonaisuuden abstraktiotasoa). Eri hahmotyypeille on pyritty luomaan eri ominaisuuksia, joista osa riippuu pelihahmojen taidoista. Toteutuksessa on aikarajojen vuoksi pyritty saamaan peli suhteellisen toimivaksi erityisesti WarriorCharacter-luokan hahmolle. Seuraavassa sekvenssikaaviossa on puolestaan esitelty vain hieman yksinkertaistaen, mitä tyypillisen taistelun aikana tapahtuu.

![taistelu](https://github.com/duckling747/ot-harjoitustyo/blob/master/dokumentointi/images/battle_example.png)

## Tiedostot ja tallennus

Pelin aikana pystytään tallentamaan pelin edistyminen tekstitiedostoon, joka sisältää luodun hahmon nimen, luodun hahmon tyypin ja pelin senhetkisen tason nimen. Jatkettaessa peliä päävalikon Load Game -nappulasta, peli jatkuu siitä kohtaa mihin tallennuksen aikana jäätiin. Peli tukee montaa tallennusta kerrallaan ja tallennus toteutetaan vakiona tiedostoon "game.sav" ohjelman ajohakemistossa.

## Päätoiminnallisuus käytännössä

Kun pelaaja on aluksi luonut hahmonsa, valinnut sille nimen ja tyypin, peli alkaa taistelunäkymästä, joka kertoo pelaajalle tarinaa. Tarina etenee next-näppäimellä, kunnes tarinaa ei enää anneta ja ensimmäinen taistelu alkaa. Taistelut perustuvat pelaajan ja hirviön toimintoihin, joita nämä päättävät tehdä vuorotellen. Kun on hirviön vuoro päättää mitä hirviö tekee, pelaaja painaa next-nappulaa pelin etenemiseksi, ja kun on pelaajan vuoro päättää, muut näppäimet muuttuvat kirkkaan värisiksi toiminnon valitsemisen mahdollistamiseksi. Näin peli etenee kunnes taistelut päättyvät ja pelaajalle näytetään seuraavat tarinatekstit. Taistelut ja tarina vuorottelevat siten että taisteluja tulee useampi peräkkäin.

## Ohjelman rakenteen heikkoudet

Käyttöliittymäluokka on parhaimmillaankin sekava. Sen toimintojen eriyttämiseksi pelkät Javan lambda-funktiot eivät riitä, vaan vaadittaisiin runsaasti erillisiä luokkia. Ohjelma on myös suhteellisen laaja: jotta se olisi erityisen mielekäs, pitäisi kirjoittaa vielä paljon enemmän koodia, erityisesti suunnitella ja hienosäätää pelaajan hahmon ominaisuuksia suhteessa hirviöiden ominaisuuksiin paremmaksi, niin että taistelut eivät olisi toisaalta liian helppoja, mutta eivät liian vaikeitakaan. Jonkinlaisia erityistaitoja, jotka käyttävät peliin koodattua mana-laskuria, pitäisi rakentaa; kuten myös esineiden käyttö ja toiminnallisuus, sekä samalla tavalla tasapainotettu LevelUP-systeemi, joka jäi vielä projektin loppuvaiheillakin lapsenkenkiinsä. Ohjelman suunnittelu on sillä tavalla joustava, että sitä voitaisiin laajentaa äärimmäisen paljon melkein millä tavalla tahansa.
