package postfix.template.android;

import com.intellij.codeInsight.template.Template;
import com.intellij.codeInsight.template.TemplateManager;
import com.intellij.codeInsight.template.postfix.templates.StringBasedPostfixTemplate;
import com.intellij.codeInsight.template.postfix.util.JavaPostfixTemplatesUtils;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static postfix.util.ClassNames.TEXT_UTILS;
import static postfix.util.AndroidPostfixUtil.*;

/**
 * Postfix template for android TextUtils class.
 *
 * @author cesards
 */
public class EmptyStringTemplate extends StringBasedPostfixTemplate {

    public EmptyStringTemplate() {
        super(
                "emptyCheck",
                "TextUtils.isEmpty(expr)",
                JavaPostfixTemplatesUtils.selectorTopmost(JavaPostfixTemplatesUtils.IS_NOT_PRIMITIVE)
        );
    }

//    @Override
//    public Template createTemplate(TemplateManager templateManager, String s) {
//        Template template = super.createTemplate(templateManager, s);
//        template.setValue(Template.Property.USE_STATIC_IMPORT_IF_POSSIBLE, true);
//        return template;
//    }

    @Nullable
    @Override
    public String getTemplateString(@NotNull PsiElement expression) {
        return getStaticPrefix(TEXT_UTILS.getClassName(), "isEmpty", expression) + "($expr$)$END$";
    }
}
