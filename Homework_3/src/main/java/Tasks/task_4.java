package Tasks;


import java.util.SortedSet;
import java.util.TreeSet;

public class task_4 {
    public static void get() {
        String veryLongString = "In linguistics, a word of a spoken language can be defined as the smallest sequence of phonemes that can be uttered in isolation with objective or practical meaning. In many languages, words also correspond to sequences of graphemes (\"letters\") in their standard writing systems that are delimited by spaces wider than the normal inter-letter space, or by other graphical conventions.[1] The concept of \"word\" is usually distinguished from that of a morpheme, which is the smallest unit of speech which has a meaning, even if it will not stand on its own.\n" +
                "\n" +
                "In many languages, the notion of what constitutes a \"word\" may be mostly learned as part of learning the writing system.[1] This is the case for the English language, and for most languages that are written with alphabets derived from the ancient Latin or Greek alphabets.\n" +
                "\n" +
                "There still remains no consensus among linguists about the proper definition of \"word\" in a spoken language that is independent of its writing system, nor about the precise distinction between it and \"morpheme\".[1] This issue is particularly debated for Chinese and other languages of East Asia,[2] and may be moot[clarification needed] for Afro-Asiatic languages.\n" +
                "\n" +
                "In English orthography, the letter sequences \"rock\", \"god\", \"write\", \"with\", \"the\", \"not\" are considered to be single-morpheme words, whereas \"rocks\", \"ungodliness\", \"typewriter\", and \"cannot\" are words composed of two or more morphemes (\"rock\"+\"s\", \"un\"+\"god\"+\"li\"+\"ness\", \"type\"+\"writ\"+\"er\", and \"can\"+\"not\"). In English and many other languages, the morphemes that make up a word generally include at least one root (such as \"rock\", \"god\", \"type\", \"writ\", \"can\", \"not\") and possibly some affixes (\"-s\", \"un-\", \"-ly\", \"-ness\"). Words with more than one root (\"[type][writ]er\", \"[cow][boy]s\", \"[tele][graph]ically\") are called compound words.\n" +
                "\n" +
                "Words are combined to form other elements of language, such as phrases (\"a red rock\", \"put up with\"), clauses (\"I threw a rock\"), and sentences (\"I threw a rock, but missed\").";

        SortedSet<String> words = new TreeSet<String>();
        int count;

        for (String word : veryLongString.split("[ \\-\\+,.!?()\"\\s\\[\\]\\n\\d]")) {
            if (word != "") {
                words.add(word.toLowerCase());
            }
        }
        System.out.println(words);


        for (String wordInSet : words) {
            count = 0;
            for (String wordInString : veryLongString.split("[ \\-\\+,.!?()\"\\s\\[\\]\\n\\d]")) {
                if (wordInSet.equals(wordInString.toLowerCase())) {
                    count++;
                }
            }
            System.out.printf("The word '%s' was encountered %s times.\n", wordInSet, count);
        }


    }
}
