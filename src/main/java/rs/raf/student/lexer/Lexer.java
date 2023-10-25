package rs.raf.student.lexer;

import rs.raf.student.lexer.data.CSLCharacter;
import rs.raf.student.lexer.data.CSLKeyword;
import rs.raf.student.lexer.data.CSLPunctuation;
import rs.raf.student.lexer.data.CSLType;
import rs.raf.student.lexer.exception.InvalidCharacterException;
import rs.raf.student.lexer.exception.NotSupportedCharacterException;
import rs.raf.student.lexer.exception.SampleNotLoadedException;
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
            this::handlePunctuationCharacter,
            this::handleSeparatorCharacter,
            this::handleAppend
    );

    private final StringBuilder word = new StringBuilder();

    private boolean isIdentifier  = false;
    private boolean isNumber      = false;
    private boolean isCharacter   = false;
    private boolean isString      = false;
    private boolean isPunctuation = false;

    private void lex() {
        System.out.println(source);

        for (char character : source.toCharArray())
            handlers.get(getCharacterTypeIndex(character)).handle(character);
    }

    private int getCharacterTypeIndex(char character) {
        if (Character.isDigit(character))
            return 0;

        if (Character.isLetter(character))
            return 1;

        if (character == '_')
            return 2;

        if (CSLPunctuation.get(character) != null)
            return 3;

        if (Character.isWhitespace(character) || character == ';')
            return 4;

        if (isString)
            return 5;

        throw new NotSupportedCharacterException(character);
    }

    @FunctionalInterface
    private interface IHandler {
        void handle(char character);
    }

    private void handleDigitCharacter(char character) {
        if (isPunctuation)
            concludePunctuation();

        if (!isIdentifier)
            isNumber = true;

        word.append(character);
    }

    private void handleLetterCharacter(char character) {
        if (isNumber)
            throw new InvalidCharacterException();
        else if (isPunctuation)
            concludePunctuation();

        if (!isCharacter && !isString)
            isIdentifier = true;

        word.append(character);
    }

    private void handleUnderscoreCharacter(char character) {
        if (isNumber)
            throw new InvalidCharacterException();
        else if (isPunctuation)
            concludePunctuation();

        if (!isCharacter && !isString)
            isIdentifier = true;

        word.append(character);
    }

    private void handlePunctuationCharacter(char character) {
        if (isNumber)
            concludeNumber();
        else if (isIdentifier)
            concludeIdentifier();

        if (isCharacter && CSLCharacter.CHARACTER.matches(character))
            concludeCharacter();
        else if (isString && CSLCharacter.STRING.matches(character))
            concludeString();

        word.append(character);

        if ((isCharacter || isString) && CSLCharacter.get(character) == null)
            return;

        isPunctuation = true;

        if (CSLPunctuation.get(character).isStandalone())
            concludePunctuation();
    }

    private void handleSeparatorCharacter(char character) {
        if (isNumber)
            concludeNumber();
        else if (isIdentifier)
            concludeIdentifier();
        else if (isPunctuation)
            concludePunctuation();

        if (Character.isSpaceChar(character) && (isCharacter || isString))
            word.append(character);
    }

    private void handleAppend(char character) {
        word.append(character);
    }

    private void concludeNumber() {
        m_Words.add(new Word(word.toString(), CSLType.NUMBER));

        word.setLength(0);
        isNumber = false;
    }

    private void concludeIdentifier() {
        if (CSLKeyword.get(word.toString()) != null)
            m_Words.add(new Word(word.toString(), CSLType.KEYWORD));
        else
            m_Words.add(new Word(word.toString(), CSLType.IDENTIFIER));

        word.setLength(0);
        isIdentifier = false;
    }

    private void concludePunctuation() {
        m_Words.add(new Word(word.toString(),  CSLType.PUNCTUATION));

        if (CSLCharacter.CHARACTER.matches(word.toString()))
            isCharacter = !isCharacter;
        else if (CSLCharacter.STRING.matches(word.toString()))
            isString = !isString;

        word.setLength(0);
        isPunctuation = false;
    }

    private void concludeCharacter() {
        m_Words.add(new Word(word.toString(), CSLType.CHARACTER));

        //isCharacter = false;
        word.setLength(0);
    }

    private void concludeString() {
        m_Words.add(new Word(word.toString(), CSLType.STRING));

        //isString = false;
        word.setLength(0);
    }

    public List<Word> words() {
        return m_Words;
    }

}
