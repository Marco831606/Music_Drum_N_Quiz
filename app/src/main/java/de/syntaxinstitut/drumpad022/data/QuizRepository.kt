package com.example.drumpad022.data

import com.example.drumpad022.data.mode.Question


class QuizRepository {

    fun loadQuestion(): List<Question> {
        return listOf(

            Question(
                "Was ist ein Dreispitz?",
                "A: Ein Hut",
                "B: Ein Gebäck",
                "C: Ein Werkzeug",
                "D: Ein Sternbild",
                1


            ),
            Question(
                "Was bedeuten die berühmten Worte \n von Julius Caesar \"Alea iacta est\"?",
                "A: Der Würfel ist gefallen.",
                "B: Die Entscheidung ist getroffen.",
                "C: Das ist mein Urteil.",
                "D: So soll es sein.",
                1
            ),
            Question(
                "Von wem stammt das Gemälde der\n Mona Lisa?",
                "A: Picasso",
                "B: Van Gogh",
                "C: Leonardo da Vinci",
                "D: Monet",
                3
            ),
            Question(
                " Für was steht die Abkürzung GmbH?",
                "A: Geschäft mit beschränkter Haftung",
                "B: Gesellschaft mit bekannter Haftung",
                "C: Gesellschafter mit beschränkter Haftung",
                "D: Gesellschaft mit beschränkter Haftung",
                4
            ),
            Question(
                "Was gibt diese Funktion zurück?\nfun doStuff(nr: Int): String {...}",
                "Eine Kommazahl",
                "Einen Integer",
                "Einen String",
                "Einen fun",
                3
            ),
            Question(
                "Welche Stadt benutzt \ndas Autokennzeichen FF?",
                "A: Frankfurt/Oder",
                "B: Fridingen am Fluß",
                "C: Flensburg",
                "D: Frankenberg",
                1
            ),
            Question(
                "Wie heißt Indiens Hauptstadt?",
                "A: Neu-Delhi",
                "B: Mumbai",
                "C: Bangkok",
                "D: Peking",
                1
            ),
            Question(
                "Wie lautete der frühere\n Name Istanbul?",
                "A: Metropolis",
                "B: Delphi",
                "C: Herat",
                "D: Konstantinopel",
                4
            ),
            Question(
                "Wie hieß der erste\ndeutsche Bundeskanzler?",
                "A: Ludwig Erhard",
                "B: Konrad Adenauer",
                "C: Willy Brandt",
                "D: Helmut Schmidt",
                2
            ),
            Question(
                " Wie heißt der „Zeichentrickfilm-\n Elefant“ mit den großen Ohren?",
                "A: Balu",
                "B: Winnie Puuh",
                "C: Dumbo",
                "D: Bambi",
                3





            )
        )
    }
}


