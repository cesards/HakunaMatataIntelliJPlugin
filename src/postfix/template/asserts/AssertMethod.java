package postfix.template.asserts;


public enum AssertMethod {
    EQUALS("assertEquals", "assertEquals(expr, actual, matcher)"),
    NOT_EQUALS("assertNotEquals", "assertNotEquals(expr, actual)"),
    SAME("assertSame", "assertSame(expr, actual)"),
    NOT_SAME("assertNotSame", "assertNotSame(expr, actual)"),
    THAT("assertThat", "assertThat(expr, actual, matcher)"),
    FALSE("assertFalse", "assertFalse(expr)"),
    TRUE("assertTrue", "assertTrue(expr)");

    final String postfixCompletion;
    final String postfixDescription;

    AssertMethod(String postfixCompletion, String postfixDescription) {
        this.postfixCompletion = postfixCompletion;
        this.postfixDescription = postfixDescription;
    }

    public String getPostfixCompletion() {
        return postfixCompletion;
    }

    public String getPostfixDescription() {
        return postfixDescription;
    }
}