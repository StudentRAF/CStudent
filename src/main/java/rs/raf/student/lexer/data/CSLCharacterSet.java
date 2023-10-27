package rs.raf.student.lexer.data;

import java.util.HashMap;

public enum CSLCharacterSet {

    LETTER_UPPERCASE_A('A',  "Letter A",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_B('B',  "Letter B",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_C('C',  "Letter C",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_D('D',  "Letter D",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_E('E',  "Letter E",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_F('F',  "Letter F",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_G('G',  "Letter G",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_H('H',  "Letter H",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_I('I',  "Letter I",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_J('J',  "Letter J",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_K('K',  "Letter K",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_L('L',  "Letter L",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_M('M',  "Letter M",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_N('N',  "Letter N",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_O('O',  "Letter O",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_P('P',  "Letter P",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_Q('Q',  "Letter Q",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_R('R',  "Letter R",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_S('S',  "Letter S",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_T('T',  "Letter T",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_U('U',  "Letter U",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_V('V',  "Letter V",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_W('W',  "Letter W",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_X('X',  "Letter X",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_Y('Y',  "Letter Y",          false, true,  false, false, false, false, true ),
    LETTER_UPPERCASE_Z('Z',  "Letter Z",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_A('a',  "Letter a",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_B('b',  "Letter b",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_C('c',  "Letter c",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_D('d',  "Letter d",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_E('e',  "Letter e",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_F('f',  "Letter f",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_G('g',  "Letter g",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_H('h',  "Letter h",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_I('i',  "Letter i",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_J('j',  "Letter j",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_K('k',  "Letter k",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_L('l',  "Letter l",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_M('m',  "Letter m",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_N('n',  "Letter n",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_O('o',  "Letter o",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_P('p',  "Letter p",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_Q('q',  "Letter q",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_R('r',  "Letter r",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_S('s',  "Letter s",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_T('t',  "Letter t",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_U('u',  "Letter u",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_V('v',  "Letter v",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_W('w',  "Letter w",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_X('x',  "Letter x",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_Y('y',  "Letter y",          false, true,  false, false, false, false, true ),
    LETTER_LOWERCASE_Z('z',  "Letter z",          false, true,  false, false, false, false, true ),
    DIGIT_0           ('0',  "Digit 0",           true,  false, false, false, false, false, true ),
    DIGIT_1           ('1',  "Digit 1",           true,  false, false, false, false, false, true ),
    DIGIT_2           ('2',  "Digit 2",           true,  false, false, false, false, false, true ),
    DIGIT_3           ('3',  "Digit 3",           true,  false, false, false, false, false, true ),
    DIGIT_4           ('4',  "Digit 4",           true,  false, false, false, false, false, true ),
    DIGIT_5           ('5',  "Digit 5",           true,  false, false, false, false, false, true ),
    DIGIT_6           ('6',  "Digit 6",           true,  false, false, false, false, false, true ),
    DIGIT_7           ('7',  "Digit 7",           true,  false, false, false, false, false, true ),
    DIGIT_8           ('8',  "Digit 8",           true,  false, false, false, false, false, true ),
    DIGIT_9           ('9',  "Digit 9",           true,  false, false, false, false, false, true ),
    UNDERSCORE        ('_',  "Underscore",        false, false, false, true,  true,  false, true ),
    EQUAL             ('=',  "Equal",             false, false, false, false, true,  false, true ),
    PARENTHESIS_OPEN  ('(',  "Open parenthesis",  false, false, false, false, true,  true , true ),
    PARENTHESIS_CLOSE (')',  "Close parenthesis", false, false, false, false, true,  true , true ),
    BRACKET_OPEN      ('[',  "Open bracket",      false, false, false, false, true,  true , true ),
    BRACKET_CLOSE     (']',  "Close bracket",     false, false, false, false, true,  true , true ),
    BRACE_OPEN        ('{',  "Open brace",        false, false, false, false, true,  true , true ),
    BRACE_CLOSE       ('}',  "Close brace",       false, false, false, false, true,  true , true ),
    PLUS              ('+',  "Plus",              false, false, false, false, true,  true , true ),
    HYPHEN            ('-',  "Minus",             false, false, false, false, true,  true , true ),
    ASTERISK          ('*',  "Multiplication",    false, false, false, false, true,  true , true ),
    DIVIDE            ('/',  "Division",          false, false, false, false, true,  true , true ),
    BACKSLASH         ('\\', "Escape character",  false, false, false, false, true,  true , true ),
    PERCENT           ('%',  "Modulo",            false, false, false, false, true,  true , true ),
    AMPERSAND         ('&',  "Bitwise AND",       false, false, false, false, true,  false, true ),
    VERTICAL_BAR      ('|',  "Bitwise OR",        false, false, false, false, true,  false, true ),
    CARET             ('^',  "Bitwise XOR",       false, false, false, false, true,  true , true ),
    EXCLAMATION       ('!',  "NOT",               false, false, false, false, true,  false, true ),
    TILDE             ('~',  "Tilde",             false, false, false, false, true,  true , true ),
    GREATER_THAN      ('>',  "Greater than",      false, false, false, false, true,  false, true ),
    LESS_THAN         ('<',  "Less than",         false, false, false, false, true,  false, true ),
    QUESTION_MARK     ('?',  "Question mark",     false, false, false, false, true,  true , true ),
    COLON             (':',  "Colon",             false, false, false, false, true,  true , true ),
    SEMICOLON         (';',  "Semicolon",         false, false, true,  false, true,  true , false),
    COMMA             (',',  "Comma",             false, false, false, false, true,  true , true ),
    DOT               ('.',  "Dot",               false, false, false, false, true,  true , true ),
    SINGLE_QUOTE      ('\'', "Single quote",      false, false, false, false, true,  true , false),
    DOUBLE_QUOTE      ('"',  "Double quote",      false, false, false, false, true,  true , false),
    NEW_LINE          ('\n', "New line",          false, false, true,  false, false, false, false),
    CARRIAGE_RETURN   ('\r', "Carriage return",   false, false, true,  false, false, false, false),
    TAB               ('\t', "Tab",               false, false, true,  false, false, false, false),
    SPACE             (' ',  "White space",       false, false, true,  false, false, false, false);

    private static final HashMap<Character, CSLCharacterSet> s_Map = init();

    private final Character m_Value;
    private final String    m_Description;
    private byte            m_Flag;

    CSLCharacterSet(Character character, String description, boolean isDigit,      boolean isLetter,  boolean isSeparator,
                                                             boolean isUnderscore, boolean isSpecial, boolean isStandalone,
                                                             boolean isPrintable) {
        m_Value       = character;
        m_Description = description;

        m_Flag  = 0;
        m_Flag |= isDigit      ? Flag.DIGIT      : 0;
        m_Flag |= isLetter     ? Flag.LETTER     : 0;
        m_Flag |= isSeparator  ? Flag.SEPARATOR  : 0;
        m_Flag |= isUnderscore ? Flag.UNDERSCORE : 0;
        m_Flag |= isSpecial    ? Flag.SPECIAL    : 0;
        m_Flag |= isStandalone ? Flag.STANDALONE : 0;
        m_Flag |= isPrintable  ? Flag.PRINTABLE  : 0;
    }

    private static HashMap<Character, CSLCharacterSet> init() {
        HashMap<Character, CSLCharacterSet> map = new HashMap<>();

        for(CSLCharacterSet character : CSLCharacterSet.values())
            map.put(character.m_Value, character);

        return map;
    }

    public static CSLCharacterSet get(char value) {
        return s_Map.get(value);
    }

    public static CSLCharacterSet get(String value) {
        if (value.length() != 1)
            return null;

        return s_Map.get(value.charAt(0));
    }

    public static boolean has(char value) {
        return get(value) != null;
    }

    public static boolean has(String value) {
        return get(value) != null;
    }

    public Character getValue() {
        return m_Value;
    }

    public String getDescription() {
        return m_Description;
    }

    public boolean isDigit() {
        return (m_Flag & Flag.DIGIT) > 0;
    }

    public boolean isLetter() {
        return (m_Flag & Flag.LETTER) > 0;
    }

    public boolean isSeparator() {
        return (m_Flag & Flag.SEPARATOR) > 0;
    }

    public boolean isUnderscore() {
        return (m_Flag & Flag.UNDERSCORE) > 0;
    }

    public boolean isSpecial() {
        return (m_Flag & Flag.SPECIAL) > 0;
    }

    public boolean isStandalone() {
        return (m_Flag & Flag.STANDALONE) > 0;
    }

    public boolean isPrintable() {
        return (m_Flag & Flag.PRINTABLE) > 0;
    }

    private static class Flag {

        private static final byte DIGIT      = 0b00000001;
        private static final byte LETTER     = 0b00000010;
        private static final byte SEPARATOR  = 0b00000100;
        private static final byte UNDERSCORE = 0b00001000;
        private static final byte SPECIAL    = 0b00010000;
        private static final byte STANDALONE = 0b00100000;
        private static final byte PRINTABLE  = 0b01000000;

    }

}
