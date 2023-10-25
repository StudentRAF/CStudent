package rs.raf.student.lexer.data;

import java.util.HashMap;

public enum CSLBracket {

    ROUND_BRACKET_OPEN  ("("),
    ROUND_BRACKET_CLOSE (")"),
    SQUARE_BRACKET_OPEN ("["),
    SQUARE_BRACKET_CLOSE("]"),
    CURLY_BRACKET_OPEN  ("{"),
    CURLY_BRACKET_CLOSE ("}");

    private static final HashMap<String, CSLBracket> s_Map = init();

    private final String m_Identifier;

    CSLBracket(String identifier) {
        m_Identifier = identifier;
    }

    private static HashMap<String, CSLBracket> init() {
        HashMap<String, CSLBracket> map = new HashMap<>();

        for(CSLBracket bracket : CSLBracket.values())
            map.put(bracket.m_Identifier, bracket);

        return map;
    }

    public String getIdentifier() {
        return m_Identifier;
    }

    public static CSLBracket get(String value) {
        return s_Map.get(value);
    }

}
