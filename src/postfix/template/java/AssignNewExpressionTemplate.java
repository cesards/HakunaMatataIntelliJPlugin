package postfix.template.java;

import com.intellij.codeInsight.template.*;
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateWithExpressionSelector;
import com.intellij.codeInsight.template.postfix.util.JavaPostfixTemplatesUtils;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;

import static com.intellij.codeInsight.template.postfix.util.JavaPostfixTemplatesUtils.*;

public class AssignNewExpressionTemplate extends PostfixTemplateWithExpressionSelector {

    public AssignNewExpressionTemplate() {
        super(
                "newInstanceWithAssignment",
                "= new Type()",
                selectorTopmost(IS_NOT_PRIMITIVE)
        );
    }

    @Override
    protected void expandForChooseExpression(@NotNull PsiElement expression, @NotNull Editor editor) {
        final Project project = expression.getProject();
        final TemplateManager manager = TemplateManager.getInstance(project);
        try {
            final String stringTemplate = " = new " + ((PsiExpression) expression).getType().getPresentableText() + "($END$)";
            final Template template = manager.createTemplate("", "", stringTemplate);
            manager.startTemplate(editor, template);
        } catch (Exception e) {
            // TODO: 12/06/2016
        }
    }
}
