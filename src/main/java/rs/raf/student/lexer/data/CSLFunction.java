package rs.raf.student.lexer.data;

import java.util.HashMap;

public enum CSLFunction {

    GLOBAL(""     ),
    MAIN  ("main" ),
    PRINT ("print"),
    SCAN  ("scan" );

    private static final HashMap<String, CSLFunction> s_Map = init();

    private final String m_Identifier;

    CSLFunction(String identifier) {
        this.m_Identifier = identifier;
    }

    private static HashMap<String, CSLFunction> init() {
        HashMap<String, CSLFunction> map = new HashMap<>();

        for(CSLFunction keyword : CSLFunction.values())
            map.put(keyword.m_Identifier, keyword);

        return map;
    }

    public static CSLFunction get(String identifier) {
        return s_Map.get(identifier);
    }

    public String getIdentifier() {
        return m_Identifier;
    }

}
