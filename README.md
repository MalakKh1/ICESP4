# ICESP4
Java quiz med database official
ICE Projekt Funktionelle krav - Java Quiz App

Formål Systemet skal hjælpe studerende med at opfriske deres viden fra 1. semester Java programmering gennem en interaktiv quiz. Aktører Spilleren= En studerende der vil teste sin viden om Java programmering.

Domæne entiteter Spilleren: En person med et navn og en score. Spilleren besvarer spørgsmål og optjener point for korrekte svar. Spørgsmål: Består af en spørgsmålstekst, 4 svarmuligheder (1, 2, 3, 4) og ét korrekt svar. Spørgsmålene handler om Java emner fra 1. semester. Quiz: Selve spillet, der styrer flowet. Indeholder 10 spørgsmål som præsenteres for en ad gangen. Relationer

- En Quiz har én Spiller
- En Quiz består af 10 Spørgsmål
- Et Spørgsmål har præcis 4 svarmuligheder
- Et Spørgsmål har præcis ét korrekt svar
- En Spiller giver ét svar per Spørgsmål.

- Quiz flow: 1. Spilleren indtaster navn -> Quizzen starter -> Spørgsmål vises ét ad gangen random -> Spilleren vælger svar (1-4) -> Systemet tjekker svaret -> Feedback gives -> Score opdateres -> Næste spørgsmål vises -> til sidst vises endelig resultat.
- Scoring: Spilleren starter på 0 point. Hvert korrekt svar giver 1 point. Forkerte svar giver 0 point. Score vises løbende efter hvert spørgsmål.
- Validering: Kun input 1, 2, 3 eller 4 accepteres som svar.


Funktionalitet Spørgsmål og svar

- Systemet skal kunne vise spørgsmål om Java programmering
- Hvert spørgsmål skal have 4 svarmuligheder (multiple choice: 1, 2, 3, 4)
- Kun ét svar skal være korrekt
- Spilleren skal kunne vælge et svar
- Systemet skal give feedback på om svaret var rigtigt eller forkert Point system
- Spilleren starter med 0 point
- For hvert korrekt svar får spilleren 1 point
- Systemet skal vise den aktuelle score undervejs
- Efter alle spørgsmål vises den endelige score


Quiz skal indeholde 5-10 spørgsmål om emner fra 1. semester: Variabler og datatyper + Løkker (for, while) + If-statements + Arrays og ArrayList + Metoder Klasser og objekter Scanner

Afslutning

- Efter alle spørgsmål skal systemet vise resultatet
- Systemet skal give en vurdering baseret på score:
8/10: "Fantastisk! Du er en Java-vogter!"
6/10: "Godt klaret! Du har styr på det!"
4/10: "Mid besvarelse! Øv dig lidt mere!"
1/3: "Tid til genopfriskning!"
