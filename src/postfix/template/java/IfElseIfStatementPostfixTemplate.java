package postfix.template.java;

import com.intellij.codeInsight.template.postfix.templates.SurroundPostfixTemplateBase;
import com.intellij.lang.surroundWith.Surrounder;
import org.jetbrains.annotations.NotNull;
import postfix.internal.generation.JavaWithIfElseIfExpressionSurrounder;

import static com.intellij.codeInsight.template.postfix.util.JavaPostfixTemplatesUtils.IS_BOOLEAN;
import static com.intellij.codeInsight.template.postfix.util.JavaPostfixTemplatesUtils.JAVA_PSI_INFO;
import static com.intellij.codeInsight.template.postfix.util.JavaPostfixTemplatesUtils.selectorTopmost;

public class IfElseIfStatementPostfixTemplate extends SurroundPostfixTemplateBase {

    public IfElseIfStatementPostfixTemplate() {
        super("ifElseIf", "if { (expr) } elseif() { } else { }", JAVA_PSI_INFO, selectorTopmost(IS_BOOLEAN));
    }

    @NotNull
    @Override
    protected Surrounder getSurrounder() {
        return new JavaWithIfElseIfExpressionSurrounder();
    }
}
