package rs.raf.student.lexer;

import rs.raf.student.lexer.data.CSLCharacterSet;
import rs.raf.student.lexer.data.CSLKeyword;
import rs.raf.student.lexer.data.CSLMultiCharacterSet;
import rs.raf.student.lexer.data.CSLType;
import rs.raf.student.lexer.exception.InvalidWordException;
import rs.raf.student.lexer.exception.NotSupportedCharacterException;
import rs.raf.student.lexer.exception.SampleNotLoadedException;
import rs.raf.student.lexer.exception.UnreachableCodeException;
import rs.raf.student.lexer.model.Word;
import rs.raf.student.util.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    private final List<Word> m_Words = new ArrayList<>();
    private final String source;

    public Lexer(String fileName) {
        source = FileUtils.load(fileName);

        if (source == null)
            throw new SampleNotLoadedException(fileName);

        lex();
    }

    private final List<IHandler> handlers = List.of(
            this::handleDigitCharacter,
            this::handleLetterCharacter,
            this::handleUnderscoreCharacter,
            this::handleSpecialCharacter,
            this::handleSeparatorCharacter,
            this::handleStringCharacter
    );

    private final StringBuilder wordBuffer = new StringBuilder();

    private boolean isIdentifier  = false;
    private boolean isNumber      = false;
    private boolean isCharacter   = false;
    private boolean isString      = false;
    private boolean isSpecial     = false;

    private void lex() {
        System.out.println(source);
        CSLCharacterSet characterSet;

        for (char character : source.toCharArray()) {
            characterSet = CSLCharacterSet.get(character);

            handlers.get(getCharacterTypeIndex(characterSet, character)).handle(characterSet);
        }
    }

    private int getCharacterTypeIndex(CSLCharacterSet characterSet, char character) {
        if (isString || isCharacter)
            return 5;

        if (characterSet == null)
            throw new NotSupportedCharacterException(character);

        if (characterSet.isDigit())
            return 0;

        if (characterSet.isLetter())
            return 1;

        if (characterSet.isUnderscore())
            return 2;

        if (characterSet.isSpecial())
            return 3;

        if (characterSet.isSeparator())
            return 4;

        throw new UnreachableCodeException();
    }

    @FunctionalInterface
    private interface IHandler {
        void handle(CSLCharacterSet character);
    }

    private void handleDigitCharacter(CSLCharacterSet characterSet) {
        if (isSpecial)
            concludeSpecial();

        if (!isIdentifier)
            isNumber = true;

        wordBuffer.append(characterSet.getValue());
    }

    private void handleLetterCharacter(CSLCharacterSet characterSet) {
        if (isNumber)
            throw new InvalidWordException(wordBuffer.append(characterSet.getValue()).toString());
        else if (isSpecial)
            concludeSpecial();

        isIdentifier = true;

        wordBuffer.append(characterSet.getValue());
    }

    private void handleUnderscoreCharacter(CSLCharacterSet characterSet) {
        if (isNumber)
            throw new InvalidWordException(wordBuffer.append(characterSet.getValue()).toString());
        else if (isSpecial)
            concludeSpecial();

        isIdentifier = true;

        wordBuffer.append(characterSet.getValue());
    }

    private void handleSpecialCharacter(CSLCharacterSet characterSet) {
        if (isNumber)
            concludeNumber();
        else if (isIdentifier)
            concludeIdentifier();

        wordBuffer.append(characterSet.getValue());

        isSpecial = true;

        if (characterSet.isStandalone())
            concludeSpecial();
    }

    private void handleSeparatorCharacter(CSLCharacterSet characterSet) {
        if (isNumber)
            concludeNumber();
        else if (isIdentifier)
            concludeIdentifier();
        else if (isSpecial)
            concludeSpecial();
    }

    private void handleStringCharacter(CSLCharacterSet characterSet) {
        if (isCharacter && characterSet.equals(CSLCharacterSet.SINGLE_QUOTE)) {
            concludeCharacter();
            handleSpecialCharacter(CSLCharacterSet.SINGLE_QUOTE);
        }
        else if (isString && characterSet.equals(CSLCharacterSet.DOUBLE_QUOTE)) {
            concludeString();
            handleSpecialCharacter(CSLCharacterSet.DOUBLE_QUOTE);
        }
        else
            wordBuffer.append(characterSet.getValue());
    }

    private void concludeNumber() {
        m_Words.add(new Word(wordBuffer.toString(), CSLType.NUMBER));

        wordBuffer.setLength(0);
        isNumber = false;
    }

    private void concludeIdentifier() {
        String word = wordBuffer.toString();

        if (CSLKeyword.has(word))
            m_Words.add(new Word(word, CSLType.KEYWORD));
        else
            m_Words.add(new Word(word, CSLType.IDENTIFIER));

        wordBuffer.setLength(0);
        isIdentifier = false;
    }

    private void concludeSpecial() {
        String word = wordBuffer.toString();

        CSLCharacterSet      characterSet      = CSLCharacterSet.get(word);
        CSLMultiCharacterSet multiCharacterSet = CSLMultiCharacterSet.get(word);

        if (characterSet == null && multiCharacterSet == null)
            throw new InvalidWordException(word);

        if (characterSet != null) {
            if (characterSet.isPrintable())
                m_Words.add(new Word(word, characterSet.getDescription(), CSLType.SPECIAL));

            if (characterSet.equals(CSLCharacterSet.SINGLE_QUOTE))
                isCharacter = !isCharacter;
            else if (characterSet.equals(CSLCharacterSet.DOUBLE_QUOTE))
                isString = !isString;
        }
        else if (multiCharacterSet.isPrintable())
            m_Words.add(new Word(word, multiCharacterSet.getDescription(), CSLType.SPECIAL));

        wordBuffer.setLength(0);
        isSpecial = false;
    }

    private void concludeCharacter() {
        m_Words.add(new Word(wordBuffer.toString(), CSLType.CHARACTER));

        wordBuffer.setLength(0);
    }

    private void concludeString() {
        m_Words.add(new Word(wordBuffer.toString(), CSLType.STRING));

        wordBuffer.setLength(0);
    }

    public List<Word> words() {
        return m_Words;
    }

}
