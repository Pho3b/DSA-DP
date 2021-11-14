package studying.design_patterns.builder;

import studying.design_patterns.builder.enumerator.FontType;
import studying.design_patterns.builder.enumerator.TextFormatting;


public class Letter {
    /**
     * All properties are private and final since we don't want them to be modified directly form the Letter object
     */
    private final String object, body, salutation, to, from;
    private final TextFormatting textFormatting;
    private final FontType fontType;

    /**
     * Default private constructor
     *
     * @param builder LetterBuilder
     */
    private Letter(LetterBuilder builder) {
        this.object = builder.object;
        this.body = builder.body;
        this.salutation = builder.salutation;
        this.to = builder.to;
        this.from = builder.from;
        this.textFormatting = builder.textFormatting;
        this.fontType = builder.fontType;
    }

    public String getObject() {
        return object;
    }

    public String getBody() {
        return body;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public TextFormatting getTextFormatting() {
        return textFormatting;
    }

    public FontType getFontType() {
        return fontType;
    }


    /**
     * Builder class for the construction of the Letter Object
     */
    public static class LetterBuilder {
        private final String object, to, from;
        private String body, salutation;
        private TextFormatting textFormatting = TextFormatting.CENTER;
        private FontType fontType = FontType.TIMES_NEW_ROMAN;


        /**
         * Builds the Letter object with only the mandatory parameters
         *
         * @param object object of the letter
         * @param to     the receiver of the letter
         * @param from   the sender of the letter
         */
        public LetterBuilder(String object, String to, String from) {
            this.object = object;
            this.to = to;
            this.from = from;
        }

        /**
         * @param body of the letter
         * @return LetterBuilder
         */
        public LetterBuilder body(String body) {
            this.body = body;
            return this;
        }

        /**
         * @param salutation String
         * @return LetterBuilder
         */
        public LetterBuilder salutation(String salutation) {
            this.salutation = salutation;
            return this;
        }

        /**
         * @param textFormatting String
         * @return LetterBuilder
         */
        public LetterBuilder textFormatting(TextFormatting textFormatting) {
            this.textFormatting = textFormatting;
            return this;
        }

        /**
         * @param fontType String
         * @return LetterBuilder
         */
        public LetterBuilder fontType(FontType fontType) {
            this.fontType = fontType;
            return this;
        }

        /**
         * Builds and return the dynamically constructed Letter object.
         *
         * @return a new Letter object
         */
        public Letter build() {
            return new Letter(this);
        }
    }

}
