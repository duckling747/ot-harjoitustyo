# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovellus on roolipeli, jonka perusidea on ottanut vahvasti vaikutteita vuoropohjaisista japanilaisista 90-luvun roolipeleistä. Se sisältää yksinkertaisia kenttiä, eeppisen tarinan ja taisteluita lohikäärmeitä vastaan. UI on mainittuihin vaikutteisiin verrattuna vaatimaton: pääpaino on sovelluslogiikassa ja perusidean toimivuudessa.

## Käyttäjät

Koska kyseessä on peli, kaikki käyttäjät ovat yhdenveroisia ja samassa roolissa. Peliin voitaisiin lisätä huijaustila tai muita laajennoksia, jotka muuttaisivat käyttäjien asemaa, mutta sellaista ei ole suunniteltu.

## Suunnitellut toiminnallisuudet

Pelissä on taisteluja ja yksinkertainen tarina, joita seuraamalla pelaaja etenee kohti maalia. Eniten merkitystä on kuitenkin taisteluilla ja tarinalla. Tarina etenee lineaarisesti aina samalla tavalla, ja tätä etenemistä voidaan kuvata puumaisella rakenteella. Taistelut ovat vuoropohjaisia; kts. esim. [Pokémon Red ja Blue](https://en.wikipedia.org/wiki/Pok%C3%A9mon_Red_and_Blue).

### Ohjelmassa on ainakin:

* Päämenu, jossa on pelin lataus ja uusi peli -nappulat
* Taistelunäkymä, jossa on perussälää kuten terveysmittarit ja manamittarit sekä hyökkäysvalikko
* Välivalikot taistelujen välissä, joissa voi tallentaa edistymisen
* Kiva tarina, joka kerrotaan tekstimuodossa pelaajalle
* Kolme eri vaihtoehdoista hahmoluokkaa pelaajan hahmolle
* Useita taistelukenttiä, muutamia erilaisia random-generoituja hirviöitä

### Jatkokehitysideoita:

Kunhan peli toimii ja etenee alusta loppuun edellä määritellyllä tavalla, voidaan täydentää peliä edelleen vaikkapa seuraavilla asioilla

* Huijaustila
* Nätti interaktiivinen kartta
* Nätti ylhäältä kuvattu liikuteltava hahmo
* Selkeämmät ja hajautetummat käyttöliittymäluokat
* Lisäosat, lisäkentät, monimutkaisempi tarina
* Enemmän valintoja oman hahmon luonnissa
* Enemmän erilaisia vihollisia
* Enemmän toiminnallisuutta taisteluihin ja tasapainotetut taistelut
* Fiksu AI
* Varusteita pelaajan hahmolle, pelinsisäinen varustekauppa, ostettavia taitoja ja hyökkäyksiä ja niin edelleen
