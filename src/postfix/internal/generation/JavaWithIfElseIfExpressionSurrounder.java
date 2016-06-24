package postfix.internal.generation;

import com.intellij.codeInsight.CodeInsightUtilCore;
import com.intellij.codeInsight.generation.surroundWith.JavaWithIfElseExpressionSurrounder;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NonNls;

public class JavaWithIfElseIfExpressionSurrounder extends JavaWithIfElseExpressionSurrounder {

    @Override
    public TextRange surroundExpression(Project project, Editor editor, PsiExpression expr) throws IncorrectOperationException {
        PsiManager manager = expr.getManager();
        PsiElementFactory factory = JavaPsiFacade.getInstance(manager.getProject()).getElementFactory();
        CodeStyleManager codeStyleManager = CodeStyleManager.getInstance(project);

        @NonNls String text = "if(a){\nst;\n}elseif(){else{\n}";
        PsiIfStatement ifStatement = (PsiIfStatement)factory.createStatementFromText(text, null);
        ifStatement = (PsiIfStatement)codeStyleManager.reformat(ifStatement);

        ifStatement.getCondition().replace(expr);

        PsiExpressionStatement statement = (PsiExpressionStatement)expr.getParent();
        ifStatement = (PsiIfStatement)statement.replace(ifStatement);

        PsiCodeBlock block = ((PsiBlockStatement)ifStatement.getThenBranch()).getCodeBlock();

        PsiStatement afterStatement = CodeInsightUtilCore.forcePsiPostprocessAndRestoreElement(block.getStatements()[0]);

        TextRange range = afterStatement.getTextRange();
        editor.getDocument().deleteString(range.getStartOffset(), range.getEndOffset());
        return new TextRange(range.getStartOffset(), range.getStartOffset());
    }

    @Override
    public String getTemplateDescription() {
        return "if (expr) {...} else if (expr) {...} else {...}";
    }
}
