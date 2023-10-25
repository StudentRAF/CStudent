package rs.raf.student.lexer.data;

import java.util.HashMap;

public enum CSLPunctuation {

    EQUAL               ('=', "equal",                false),
    PLUS                ('+', "plus",                 true ),
    HYPHEN              ('-', "hyphen",               true ),
    ASTERISK            ('*', "asterisk",             true ),
    DIVIDE              ('/', "divide",               true ),
    PERCENT             ('%', "percent",              true ),
    DOT                 ('.', "dot",                  true ),
    COMMA               (',', "comma",                true ),
    EXCLAMATION         ('!', "exclamation",          false),
    AMPERSAND           ('&', "ampersand",            false),
    CARET               ('^', "caret",                true ),
    VERTICAL_BAR        ('|', "vertical bar",         false),
    OPEN_ROUND_BRACKET  ('(', "open round bracket",   true ),
    CLOSE_ROUND_BRACKET (')', "close round bracket",  true ),
    OPEN_SQUARE_BRACKET ('[', "open square bracket",  true ),
    CLOSE_SQUARE_BRACKET(']', "close square bracket", true ),
    OPEN_CURLY_BRACKET  ('{', "open curly bracket",   true ),
    CLOSE_CURLY_BRACKET ('}', "close curly bracket",  true ),
    BACKSLASH           ('\\',"backslash",            true ),
    SINGLE_QUOTE        ('\'',"single quote",         true ),
    DOUBLE_QUOTE        ('"', "double quote",         true ),
    GREATER_THAN        ('>', "greater than",         false),
    LESS_THAN           ('<', "less than",            false);

    private static final HashMap<Character, CSLPunctuation> s_Map = init();

    private final Character m_Value;
    private final String    m_Name;
    private final boolean   m_Standalone;

    CSLPunctuation(Character value, String name, boolean standalone) {
        m_Value      = value;
        m_Name       = name;
        m_Standalone = standalone;
    }

    private static HashMap<Character, CSLPunctuation> init() {
        HashMap<Character, CSLPunctuation> map = new HashMap<>();

        for(CSLPunctuation punctuation : CSLPunctuation.values())
            map.put(punctuation.m_Value, punctuation);

        return map;
    }

    public Character getValue() {
        return m_Value;
    }

    public String getName() {
        return m_Name;
    }

    public boolean isStandalone() {
        return m_Standalone;
    }

    public static CSLPunctuation get(Character value) {
        return s_Map.get(value);
    }

    public static CSLPunctuation get(String value) {
        if (value.length() > 1)
            return null;

        return get(value.charAt(0));
    }

}
