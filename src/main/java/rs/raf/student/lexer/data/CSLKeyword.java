package rs.raf.student.lexer.data;

import java.util.HashMap;

public enum CSLKeyword {

    AND   ("and"   ),
    BOOL  ("bool"  ),
    CHAR  ("char"  ),
    DO    ("do"    ),
    DOUBLE("double"),
    ELIF  ("elif"  ),
    ELSE  ("else"  ),
    FALSE ("false" ),
    FOR   ("for"   ),
    IF    ("if"    ),
    INT   ("int"   ),
    OR    ("or"    ),
    STRING("string"),
    TRUE  ("true"  ),
    RETURN("return"),
    WHILE ("while" );

    private static final HashMap<String, CSLKeyword> s_KeywordMap = init();

    private final String m_Identifier;

    CSLKeyword(String identifier) {
        this.m_Identifier = identifier;
    }

    private static HashMap<String, CSLKeyword> init() {
        HashMap<String, CSLKeyword> map = new HashMap<>();

        for(CSLKeyword keyword : CSLKeyword.values())
            map.put(keyword.m_Identifier, keyword);

        return map;
    }

    public static CSLKeyword get(String identifier) {
        return s_KeywordMap.get(identifier);
    }

}
