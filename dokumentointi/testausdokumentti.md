# Testausdokumentti

Ohjelmaa on testattu automaattisilla testeillä, jotka ovat yksikkö- ja integraatiotestejä toteutettuna JUnitilla. Tämän lisäksi testausta on tehty käsin järjestelmätasolla käyttämällä itse ohjelman graafista käyttöliittymää.

## Yksikkö- & integraatiotestit

Ohjelman testauksessa on käytetty sellaista raa'an voiman lähestymistapaa, että enempi on parempi. Testejä on kohtuullisen monta, ja käytännössä jokaiselle ohjelman paketille on oma testiluokkia sisältävä pakettinsa. Testien peitto ei missään nimessä ole täydellinen, mutta niiden pitäisi pakottaa ohjelma toimimaan pääosin sillä tavalla, kuten on suunniteltu, ja varmistaa eri luokkien yhteensopivuus. Useissa testiluokissa on luotu useiden ohjelman eri luokkien instansseja tätä tarkoitusta varten. Testiluokkia ovat mm. IoTest, LevelTest, LevelInitTest, MonsterTest ja niin edelleen.

### Hahmoluokat

Erityyppisten hahmojen toiminnallisuuden testausta varten on luotu paketti, joka sisältää abstraktin Actor-luokan perivien luokkien testausta. Näissä on testattu, että erilaiset hahmoja koskevat toiminnot ja tapahtumat toimivat tarkoitetusti. Pelin hirviöiden toiminnallisuus eroaa jokseenkin pelattavien hahmojen toiminnallisuudesta. Eri pelaajan hahmotyyppien testaus on eriytetty siltä varalta, että näiden toiminnallisuuteen puuttaisiin tulevaisuudessa esimerkiksi Overrideämällä yläluokkien metodeja. Alkuperäisen suunnitelman mukaan pelihahmoilla on keskikäisiä attribuutti-eroja ja näitä suhteellisia eroja on pyritty testauksella varmistamaan ComparisonTest-luokassa.

### Pelin eteneminen ja muu logiikka

Pelin etenemisen kannalta oleellista toiminnallisuutta, sekä taistelujen logiikkaa, ollaan testattu testauspaketeissa progressionTests ja battleTests, vastaavasti. Pelin yksinkertaista tallennusta ja latausta on testattu IoTests-paketin IoTest-luokassa.

### Testikattavuus

Graafista käyttöliittymää lukuun ottamatta testien rivikattavuus 91 % ja haaraumakattavuus 84 %:

![kattavuus](https://github.com/duckling747/ot-harjoitustyo/blob/master/dokumentointi/images/kattavuus.png)

Sellaista tilannetta ei olla testattu, jossa käyttäjällä ei olisi oikeutta kirjoittaa tai lukea ohjelman ajohakemistossa sijaitsevaa tallennustiedostoa.

## Järjestelmätestaus

Järjestelmätestaus on toteutettu manuaalisesti.

### Asennus ja konfiguraatiot

Sovellus on haettu ja sitä on testattu käyttöohjeessa kuvatulla tavalla Linux-ympäristössä sekä OpenJDK:lla että Oraclen Javalla. Sovellusta ei ole testattu siten, että ohjelma ei olisi itse luonut omaa tallennustiedostoaan (mikäli sellainen haluttaisiin ohjelmaa suoritettaessa). Mitään tiedostoa ei kuitenkaan tarvitse olla luotuna tai käsillä hakemistossa ennen ajoa.

## Sovelluksen laatuongelmat & tulevaisuudensuunnat

Selkeitä parannuksia ohjelman toimivuuteen ja mielekkyyteen toisivat seuraavat muutokset:

- Tapahtumankuuntelijoiden (ja samalla muutamien UI:n Scene-olioiden) eriyttäminen omiin luokkiinsa suorituskyvyn parantamiseksi.
- Itemien käyttö ja niiden käytön mahdollistaminen Battle-luokan toiminnassa sekä UI:ssa.
- Skill-luokka ja erilaiset taidot, jotka käyttävät hahmojen mana-attribuuttia.
- *Balansoitu* hirviöiden attribuutit, hahmojen attribuutit ja pelaajahahmojen levelUp. 
