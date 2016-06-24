package postfix.template.mockito;

import com.intellij.codeInsight.template.Template;
import com.intellij.codeInsight.template.TemplateManager;
import com.intellij.codeInsight.template.postfix.templates.StringBasedPostfixTemplate;
import com.intellij.codeInsight.template.postfix.util.JavaPostfixTemplatesUtils;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.intellij.codeInsight.template.postfix.util.JavaPostfixTemplatesUtils.IS_NON_VOID;
import static com.intellij.codeInsight.template.postfix.util.JavaPostfixTemplatesUtils.selectorTopmost;
import static postfix.util.ClassNames.ASSERTTIONS;

/**
 * TODO: 16/06/2016
 * It should be able to mock classes in Test scopes
 */
public class MockitoBasePostfixTemplate extends StringBasedPostfixTemplate {

    final MockitoMethod mockitoMethod;

    public MockitoBasePostfixTemplate(@NotNull final MockitoMethod mockitoMethod) {
        super(
                mockitoMethod.getPostfixCompletion(),
                mockitoMethod.getPostfixDescription(),
                selectorTopmost(IS_NON_VOID)
        );
        this.mockitoMethod = mockitoMethod;
    }

    @Override
    public Template createTemplate(TemplateManager manager, String templateString) {
        final Template template = super.createTemplate(manager, templateString);
        template.setValue(Template.Property.USE_STATIC_IMPORT_IF_POSSIBLE, true);
        return template;
    }

    @Nullable
    @Override
    public String getTemplateString(@NotNull PsiElement expression) {
        return ASSERTTIONS.getClassName() + mockitoMethod.getTemplateFormat();
    }
}