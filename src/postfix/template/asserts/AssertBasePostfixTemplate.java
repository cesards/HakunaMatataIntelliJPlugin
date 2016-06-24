package postfix.template.asserts;

import com.intellij.codeInsight.template.postfix.templates.StringBasedPostfixTemplate;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.intellij.codeInsight.template.postfix.util.JavaPostfixTemplatesUtils.IS_NON_VOID;
import static com.intellij.codeInsight.template.postfix.util.JavaPostfixTemplatesUtils.selectorTopmost;
import static postfix.util.AndroidPostfixUtil.getStaticPrefix;
import static postfix.util.ClassNames.ASSERTTIONS;

/**
 * It should only do the asserts in Test scopes
 */
public class AssertBasePostfixTemplate extends StringBasedPostfixTemplate {

    final AssertMethod assertMethod;

    public AssertBasePostfixTemplate(@NotNull final AssertMethod assertMethod) {
        super(
                assertMethod.getPostfixCompletion(),
                assertMethod.getPostfixDescription(),
                selectorTopmost(IS_NON_VOID)
        );
        this.assertMethod = assertMethod;
    }

    @Nullable
    @Override
    public String getTemplateString(@NotNull PsiElement expression) {
        return getStaticPrefix(ASSERTTIONS.getClassName(), assertMethod.getPostfixCompletion(), expression) + "($expr$, $END$)";
    }
}