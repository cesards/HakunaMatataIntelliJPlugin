package postfix;

import com.intellij.codeInsight.template.postfix.templates.JavaPostfixTemplateProvider;
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate;
import com.intellij.util.containers.ContainerUtil;
import org.jetbrains.annotations.NotNull;
import postfix.template.android.EmptyStringTemplate;
import postfix.template.asserts.AssertBasePostfixTemplate;
import postfix.template.asserts.AssertMethod;
import postfix.template.java.*;
import postfix.template.mockito.MockitoBasePostfixTemplate;
import postfix.template.mockito.MockitoMethod;

import java.util.Set;

public class HakunaMatataPostfixTemplateProvider extends JavaPostfixTemplateProvider {

    private final Set<PostfixTemplate> templates;

    public HakunaMatataPostfixTemplateProvider() {
        templates = ContainerUtil.<PostfixTemplate>newHashSet(
                new AssignNewExpressionTemplate(),
                new EmptyStringTemplate(),
                new NewExpressionTemplate(),
                new IfElseStatementPostfixTemplate(),
//                new IfElseIfStatementPostfixTemplate(),
                new AssertBasePostfixTemplate(AssertMethod.EQUALS),
                new AssertBasePostfixTemplate(AssertMethod.NOT_EQUALS),
                new AssertBasePostfixTemplate(AssertMethod.SAME),
                new AssertBasePostfixTemplate(AssertMethod.NOT_SAME),
                new AssertBasePostfixTemplate(AssertMethod.THAT),
                new AssertBasePostfixTemplate(AssertMethod.TRUE),
                new AssertBasePostfixTemplate(AssertMethod.FALSE),
                new MockitoBasePostfixTemplate(MockitoMethod.WHEN_THEN),
                new MockitoBasePostfixTemplate(MockitoMethod.WHEN_THENCALLREALMETHOD),
                new MockitoBasePostfixTemplate(MockitoMethod.WHEN_THENANSWER),
                new MockitoBasePostfixTemplate(MockitoMethod.WHEN_THENRETURN),
                new MockitoBasePostfixTemplate(MockitoMethod.WHEN_THENTHROW),
                new MockitoBasePostfixTemplate(MockitoMethod.DO_NOTHING_WHEN),
                new MockitoBasePostfixTemplate(MockitoMethod.DO_RETURN_WHEN),
                new MockitoBasePostfixTemplate(MockitoMethod.DO_THROW_WHEN),
                new MockitoBasePostfixTemplate(MockitoMethod.MOCK),
                new MockitoBasePostfixTemplate(MockitoMethod.SPY),
                new MockitoBasePostfixTemplate(MockitoMethod.VERIFY),
                new MockitoBasePostfixTemplate(MockitoMethod.VERIFY_NO_MORE_INTERACTIONS),
                new MockitoBasePostfixTemplate(MockitoMethod.VERIFY_ZERO_INTERACTIONS)
        );
    }

    @NotNull
    @Override
    public Set<PostfixTemplate> getTemplates() {
        return templates;
    }
}
