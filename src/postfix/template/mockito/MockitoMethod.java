package postfix.template.mockito;

public enum MockitoMethod {

    WHEN_THEN("whenThen", "when(expr).then(answer)", "when($expr$).then($END$)"),
    WHEN_THENCALLREALMETHOD("whenThenCallRealMethod", "when(expr).thenCallRealMethod(answer)", "when($expr$).thenCallRealMethod()$END$"),
    WHEN_THENANSWER("whenThenAnswer", "when(expr).thenAnswer(answer)", "when($expr$).thenAnswer($END$)"),
    WHEN_THENRETURN("whenThenReturn", "when(expr).thenReturn(answer)", "when($expr$).thenReturn($END$)"),
    VERIFY("verify", "verify(expr)", "verify($expr$$END$)"),
    VERIFY_NO_MORE_INTERACTIONS("verifyNoMoreInteractions", "verifyNoMoreInteractions(expr)", "verifyNoMoreInteractions($expr$$END$)"),
    VERIFY_ZERO_INTERACTIONS("verifyZeroInteractions", "verifyZeroInteractions(expr)", "verifyZeroInteractions($expr$$END$)"),
    DO_NOTHING_WHEN("doNothingWhen", "doNothing().when(expr)", "doNothing().when($expr$)$END$"),
    DO_RETURN_WHEN("doReturnWhen", "doReturn(expr).when(mock)", "doReturn($expr$).when($END$)"),
    DO_THROW_WHEN("doThrowWhen", "doThrow(expr).when(toBeThrown)", "doThrow($expr$).when($END$)"),
    MOCK("mock", "mock(expr).when(toBeThrown)", "doThrow($expr$).when($END$)"),
    SPY("spy", "spy(expr)", "spy($expr$)$END$"),
    WHEN_THENTHROW("whenThenThrow", "when(expr).thenThrow(answer)", "when($expr$).thenThrow($END$)");

    final String postfixCompletion;
    final String postfixDescription;
    final String templateFormat;

    MockitoMethod(String postfixCompletion, String postfixDescription, String templateFormat) {
        this.postfixCompletion = postfixCompletion;
        this.postfixDescription = postfixDescription;
        this.templateFormat = templateFormat;
    }

    public String getPostfixCompletion() {
        return postfixCompletion;
    }

    public String getPostfixDescription() {
        return postfixDescription;
    }

    public String getTemplateFormat() {
        return templateFormat;
    }
}
