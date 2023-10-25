package rs.raf.student.lexer.model;

import rs.raf.student.lexer.data.CSLType;

import java.text.MessageFormat;

public class Word {

    private final String  m_Value;
    private final CSLType m_Type;

    public Word(String value, CSLType type) {
        m_Value = value;
        m_Type  = type;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Value: {0}\nType: {1}\n", m_Value, m_Type.getName());
    }

    public String getValue() {
        return m_Value;
    }

    public CSLType getType() {
        return m_Type;
    }

}

