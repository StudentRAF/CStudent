package rs.raf.student.lexer.model;

import rs.raf.student.lexer.data.CSLType;

import java.text.MessageFormat;

public class Word {

    private final String  m_Value;
    private final String  m_Description;
    private final CSLType m_Type;

    public Word(String value, CSLType type) {
        this(value, null, type);
    }

    public Word(String value, String description, CSLType type) {
        m_Value       = value;
        m_Type        = type;
        m_Description = description;
    }

    @Override
    public String toString() {
        String formatValue       = String.format("%-40s", m_Value);
        String formatDescription = String.format("%-25s", m_Description == null ? "No description" : m_Description);
        String formatType        = String.format("%-25s", m_Type.getName());

        return MessageFormat.format("Value: {0} Type: {1} Description: {2}", formatValue, formatType, formatDescription);
    }

    public String getValue() {
        return m_Value;
    }

    public String getDescription() {
        return m_Description;
    }

    public CSLType getType() {
        return m_Type;
    }

}

