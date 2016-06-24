package livetemplate;

import com.intellij.codeInsight.template.impl.DefaultLiveTemplatesProvider;
import org.jetbrains.annotations.Nullable;

public class HakunaMatataLiveTemplateProvider implements DefaultLiveTemplatesProvider {

    private static final String[] TEMPLATES = {
            "/liveTemplates/timber",
            "/liveTemplates/plain_extra",
            "/liveTemplates/other_extra",
            "/liveTemplates/easter_egg",
    };

    @Override
    public String[] getDefaultLiveTemplateFiles() {
        return TEMPLATES;
    }

    @Nullable
    @Override
    public String[] getHiddenLiveTemplateFiles() {
        return null;
    }
}
