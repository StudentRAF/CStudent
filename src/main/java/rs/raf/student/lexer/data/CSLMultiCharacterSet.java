package rs.raf.student.lexer.data;

import java.util.HashMap;

public enum CSLMultiCharacterSet {

    LINE_COMMENT     ("//", "One-line comment" ),
    LOGICAL_EQUAL    ("==", "Logical equal"    ),
    LOGICAL_NOT_EQUAL("!=", "Logical not equal"),
    GREATER_OR_EQUAL (">=", "Greater or equal" ),
    LESS_OR_EQUAL    ("<=", "Less or equal"    ),
    LOGICAL_AND      ("&&", "Logical and"      ),
    LOGICAL_OR       ("||", "Logical or"       ),
    BITSHIFT_LEFT    ("<<", "Bitshift left"    ),
    BITSHIFT_RIGHT   (">>", "Bitshift right"   );

    private static final HashMap<String, CSLMultiCharacterSet> s_Map = init();

    private final String m_Value;
    private final String m_Description;

    CSLMultiCharacterSet(String value, String description) {
        m_Value       = value;
        m_Description = description;
    }

    private static HashMap<String, CSLMultiCharacterSet> init() {
        HashMap<String, CSLMultiCharacterSet> map = new HashMap<>();

        for(CSLMultiCharacterSet value : CSLMultiCharacterSet.values())
            map.put(value.m_Value, value);

        return map;
    }

    public static CSLMultiCharacterSet get(String value) {
        return s_Map.get(value);
    }

    public static boolean has(String value) {
        return get(value) != null;
    }

    public String getValue() {
        return m_Value;
    }

    public String getDescription() {
        return m_Description;
    }

    public boolean isPrintable() {
        return true;
    }

}
