# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovellus on roolipeli, jonka perusidea on ottanut vahvasti vaikutteita vuoropohjaisista japanilaisista 90-luvun roolipeleistä. Se sisältää yksinkertaisia kenttiä, eeppisen tarinan ja taisteluita lohikäärmeitä vastaan. UI on mainittuihin vaikutteisiin verrattuna vaatimaton: pääpaino on sovelluslogiikassa ja perusidean toimivuudessa.

## Käyttäjät

Koska kyseessä on peli, kaikki käyttäjät ovat yhdenveroisia ja samassa roolissa. On mahdollista, että mikäli peliä laajennettaan, siihen voidaan lisätä huijaustila tai vastaava, jolloin pelaaja voisi manipuloida suoraan pelin sisäisiä muuttujia, mutta alustavasti sellaista ei ole suunniteltu. Moninpeliä ei ole suunniteltu.

## Suunnitellut toiminnallisuudet

Pelissä on taisteluja, yksinkertainen tarina ja jonkinlainen kartta tai valikko, jota seuraamalla pelaaja etenee kohti maalia. Eniten merkitystä on kuitenkin taisteluilla ja tarinalla. Tarina etenee eri tavoin pelaajan valitessa avainkohdissa erilaista vaihtoehdoista, ja tätä etenemistä voidaan kuvata puumaisella rakenteella. Taistelut ovat vuoropohjaisia; kts. esim. [Pokémon Red ja Blue](https://en.wikipedia.org/wiki/Pok%C3%A9mon_Red_and_Blue).

### Ohjelmassa on ainakin:

* Päämenu, jossa on pelin lataus ja uusi peli -nappulat
* Taistelunäkymä, jossa on perussälää kuten terveysmittarit ja manamittarit sekä hyökkäysvalikko
* Välivalikot taistelujen välissä, joissa voi tallentaa edistymisen ja hahmon tilan
* Kiva tarina, joka kerrotaan tekstimuodossa pelaajalle
* Kolme eri vaihtoehdoista hahmoluokkaa pelaajan hahmolle
* Simppeli level up -systeemi
* Pelaajan valinnat, joiden perusteella seuraava kenttä määrätään
    * Yhteensä eri kenttiä todennäköisesti noin 3 kappaletta

### Jatkokehitysideoita:

Kunhan peli toimii ja etenee alusta loppuun edellä määritellyllä tavalla, voidaan täydentää peliä edelleen vaikkapa seuraavilla asioilla

* Huijaustila
* Nätti interaktiivinen kartta
* Nätti ylhäältä kuvattu liikuteltava hahmo
* Lisäosat, lisäkentät, monimutkaisempi tarina
* Enemmän valintoja oman hahmon luonnissa
* Enemmän erilaisia vihollisia
* Varusteita pelaajan hahmolle, pelinsisäinen varustekauppa, ostettavia taitoja ja hyökkäyksiä, pay-to-win, ym.
