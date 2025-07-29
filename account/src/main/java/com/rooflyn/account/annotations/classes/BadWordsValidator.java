package com.rooflyn.account.annotations.classes;

import com.rooflyn.account.annotations.NoBadWords;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


import java.util.Set;

public class BadWordsValidator  implements ConstraintValidator<NoBadWords,String> {

    private static final Set<String> BAD_WORD = Set.of(
            "*damn", "*dyke", "*fuck*", "*shit*", "@$$", "Ass Monkey", "Assface", "Biatch",
            "Blow Job", "Carpet Muncher", "Clit", "Cock*", "CockSucker", "Ekrem*", "Ekto", "Felcher",
            "Flikker", "Fotze", "Fu(*", "Fudge Packer", "Fukah", "Fuken", "Fukin", "Fukk",
            "Fukkah", "Fukken", "Fukker", "Fukkin", "God-damned", "Huevon", "Kurac", "Lesbian",
            "Lezzian", "Lipshits", "Lipshitz", "Motha Fucker", "Motha Fuker", "Motha Fukkah", "Motha Fukker", "Mother Fucker",
            "Mother Fukah", "Mother Fuker", "Mother Fukkah", "Mother Fukker", "Mutha Fucker", "Mutha Fukah", "Mutha Fuker", "Mutha Fukkah",
            "Mutha Fukker", "Phuc", "Phuck", "Phuk", "Phuker", "Phukker", "Poonani", "Sh!t",
            "Shitty", "Shity", "Shyt", "Shyte", "Shytty", "Shyty", "Skanky", "Slutty",
            "ahole", "amcik", "andskota", "anus", "arschloch", "arse*", "ash0le", "ash0les",
            "asholes", "ass", "assh0le", "assh0lez", "asshole", "assholes", "assholz", "assrammer",
            "asswipe", "ayir", "azzhole", "b!+ch", "b!tch", "b00b*", "b0obs", "b17ch",
            "b1tch", "bassterds", "bastard", "bastards", "bastardz", "basterds", "basterdz", "bi+ch",
            "bi7ch", "bitch", "bitch*", "bitches", "blowjob", "boffing", "boiolas", "bollock*",
            "breasts", "butt-pirate", "butthole", "buttwipe", "cabron", "carpet muncher", "cawk", "cawks",
            "cazzo", "chink", "chraa", "chuj", "clit", "clits", "cnts", "cntz",
            "cock", "cock*", "cock-sucker", "cockhead", "cocks", "cocksucker", "crap",
            "cum", "cunt", "cunt*", "cunts", "cuntz", "d4mn", "daygo", "dego",
            "dick", "dick*", "dild0", "dild0s", "dildo", "dildos", "dike*", "dilld0",
            "dilld0s", "dirsa", "dominatricks", "dominatrics", "dominatrix", "dupa", "dziwka", "ejackulate",
            "ejakulate", "enculer", "enema", "faen", "fag", "fag*", "fag1t", "faget",
            "fagg1t", "faggit", "faggot", "fagit", "fags", "fagz", "faig", "faigs",
            "fanculo", "fanny", "fart", "fatass", "fcuk", "feces", "feg", "felcher",
            "ficken", "fitt*", "flipping the bird", "foreskin", "fotze", "fudge packer", "fuk", "fux0r",
            "gay", "gayboy", "gaygirl", "gays", "gayz", "gook", "guiena", "hell",
            "hells", "helvete", "hoar", "hoer", "hoer*", "hoor", "hoore", "hore",
            "h0ar", "h0re", "h00r", "honkey", "hui", "injun", "jackoff", "jerk-off",
            "jisim", "jiss", "jism", "jizz", "kanker*", "kawk", "kike", "klotzak",
            "knob", "knobs", "knobz", "knulle", "kunt", "kunts", "kuntz", "kuk",
            "kuksuger", "kurwa", "kusi*", "kyrpa*", "l3itch", "l3i+ch", "lesbian", "lesbo",
            "lipshits", "lipshitz", "mamhoon", "masochist", "masokist", "massterbait", "masstrbait", "masstrbate",
            "masturbate", "masturbat*", "masterbaiter", "masterbate", "masterbat*", "masterbat3", "masterbates", "merd*",
            "mibun", "monkleigh", "mofo", "mother-fucker", "motherfucker", "mouliewop", "muie", "mulkku",
            "muschi", "mutha fucker", "nazis", "nazi", "n1gr", "nastt", "nepesaurio", "nigga",
            "nigger", "nigger*", "nigger;", "nigur;", "niiger;", "niigr;", "nutsack", "orafis",
            "oriface", "orifice", "orifiss", "orospu", "packi", "packie", "packy", "paki",
            "pakie", "paky", "pen1s", "penas", "penis", "penis-breath", "penus", "penuus",
            "pecker", "peeenus", "peeenusss", "peinus", "phuck", "pimpis", "piss*", "pizda",
            "p0rn", "poontsee", "poop", "porn", "pr0n", "pr1c", "pr1ck", "pr1k",
            "preteen", "pusse", "pussee", "pussy", "puta", "puto", "qahbeh", "queef*",
            "queer", "queers", "queerz", "qweers", "qweerz", "qweir", "rautenberg", "recktum",
            "rectum", "retard", "sadist", "screw", "schaffer", "scheiss*", "schlampe", "schmuck",
            "scank", "scrotum", "semen", "sex", "sexy", "sh!+", "sh!t", "sh!t*",
            "sh1t", "sh1ter", "sh1ts", "sh1tter", "sh1tz", "sharmuta", "sharmute", "shipal",
            "shit", "shits", "shitter", "shitz", "shemale", "shi+", "skank", "skankee",
            "skankey", "skanks", "skribz", "skurwysyn", "slut", "sluts", "slutz", "smut",
            "son-of-a-bitch", "s.o.b.", "sphencter", "spic", "spierdalaj", "splooge", "suka", "teets",
            "teez", "testical", "testicle", "testicle*", "tit", "titt", "titt*", "tits",
            "turd", "twat", "va1jina", "vag1na", "vagiina", "vagina", "vaj1na", "vajina",
            "vittu", "vullva", "vulva", "w00se", "w0p", "wank", "wank*", "wetback*",
            "wh00r", "wh0re", "whoar", "whore", "wichser", "wop*", "xrated", "xxx",
            "yed", "zabourah"
    );

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;
        String lowerValue = value.toLowerCase();
        return BAD_WORD.stream().noneMatch(lowerValue::contains);
    }
}
