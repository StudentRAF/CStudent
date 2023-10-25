package rs.raf.student.lexer.data;

import java.util.HashMap;

public enum CSLCharacter {

    CHARACTER('\'' ),
    STRING   ('"');

    private static final HashMap<Character, CSLCharacter> s_Map = init();

    private final Character m_Identifier;

    CSLCharacter(Character identifier) {
        m_Identifier = identifier;
    }

    private static HashMap<Character, CSLCharacter> init() {
        HashMap<Character, CSLCharacter> map = new HashMap<>();

        for(CSLCharacter character : CSLCharacter.values())
            map.put(character.m_Identifier, character);

        return map;
    }

    public boolean matches(Character value) {
        return m_Identifier.equals(value);
    }

    public boolean matches(String value) {
        if (value.length() > 1)
            return false;

        return m_Identifier.equals(value.charAt(0));
    }

    public Character getIdentifier() {
        return m_Identifier;
    }

    public static CSLCharacter get(String value) {
        if (value.length() > 1)
            return null;

        return s_Map.get(value.charAt(0));
    }

    public static CSLCharacter get(Character value) {
        return s_Map.get(value);
    }

}
