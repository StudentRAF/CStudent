package rs.raf.student.lexer.data;

import java.util.HashMap;

public enum CSLOperator {

    ADDITION        ("+" ),
    SUBTRACTION     ("-" ),
    MULTIPLICATION  ("*" ),
    DIVISION        ("/" ),
    MODULO          ("%" ),
    ASSIGNMENT      ("=" ),
    EQUAL           ("=="),
    NOT_EQUAL       ("!="),
    GREATER         (">" ),
    LESS            ("<" ),
    GREATER_OR_EQUAL(">="),
    LESS_OR_EQUAL   ("<="),
    LOGICAL_AND     ("&&"),
    LOGICAL_OR      ("||"),
    LOGICAL_NOT     ("!" ),
    BITWISE_AND     ("&" ),
    BITWISE_OR      ("|" ),
    BITWISE_XOR     ("^" ),
    BITSHIFT_LEFT   ("<<"),
    BITSHIFT_RIGHT  (">>");

    private static final HashMap<String, CSLOperator> s_Map = init();

    private final String m_Identifier;

    CSLOperator(String identifier) {
        m_Identifier = identifier;
    }

    private static HashMap<String, CSLOperator> init() {
        HashMap<String, CSLOperator> map = new HashMap<>();

        for(CSLOperator operator : CSLOperator.values())
            map.put(operator.m_Identifier, operator);

        return map;
    }

    public String getIdentifier() {
        return m_Identifier;
    }

    public static CSLOperator get(String value) {
        return s_Map.get(value);
    }

}
