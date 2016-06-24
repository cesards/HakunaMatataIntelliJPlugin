package postfix.template.java;

import com.intellij.codeInsight.template.Template;
import com.intellij.codeInsight.template.TemplateManager;
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateWithExpressionSelector;
import com.intellij.codeInsight.template.postfix.util.JavaPostfixTemplatesUtils;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiExpression;
import org.jetbrains.annotations.NotNull;

public class NewExpressionTemplate extends PostfixTemplateWithExpressionSelector {

    public NewExpressionTemplate() {
        super(
                "newInstanceReplacement",
                "new Type()",
                JavaPostfixTemplatesUtils.selectorTopmost()
        );
    }


    @Override
    protected void expandForChooseExpression(@NotNull PsiElement expression, @NotNull Editor editor) {
        removeExpressionFromEditor(expression, editor);

        final Project project = expression.getProject();
        final TemplateManager manager = TemplateManager.getInstance(project);
        try {
            final String stringTemplate = "new " + ((PsiExpression) expression).getType().getPresentableText() + "($END$)";
            final Template template = manager.createTemplate("", "", stringTemplate);
            template.setToReformat(true);
            manager.startTemplate(editor, template);
        } catch (Exception e) {
            // TODO: Improve code of this. Classes or interfaces doesn't have expressions, so there is always an error
            // Samples: String.newInstanceReplacement, Class.newInstanceReplacement in general
            final String stringTemplate = "new " + expression.getText() + "($END$)";
            final Template template = manager.createTemplate("", "", stringTemplate);
            template.setToReformat(true);
            manager.startTemplate(editor, template);
        }
    }

    private void removeExpressionFromEditor(@NotNull PsiElement expression, @NotNull Editor editor) {
        Document document = editor.getDocument();
        document.deleteString(expression.getTextRange().getStartOffset(), expression.getTextRange().getEndOffset());
    }
}
