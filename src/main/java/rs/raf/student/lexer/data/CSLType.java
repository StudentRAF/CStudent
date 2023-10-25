package rs.raf.student.lexer.data;

public enum CSLType {

    KEYWORD    ("keyword"    ),
    IDENTIFIER ("identifier" ),
    NUMBER     ("number"     ),
    PUNCTUATION("punctuation"),
    STRING     ("string"     ),
    CHARACTER  ("character"  );

    private final String m_Name;

    CSLType(String name) {
        m_Name = name;
    }

    public String getName() {
        return m_Name;
    }

}
