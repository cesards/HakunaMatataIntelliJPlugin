/*
 * Copyright (C) 2014 Bob Browning
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package postfix.util;

import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.siyeh.ig.psiutils.ClassUtils;

/**
 * Collection of static strings representing android class names.
 */
public enum ClassNames {
    TEXT_UTILS("android.text.TextUtils"),
    ASSERTTIONS("org.junit.Assert"),
    MOCKITO("org.mockito.Mockito");

    private final String fqClassName;

    ClassNames(String fqClassName) {
        this.fqClassName = fqClassName;
    }

    public String getClassName() {
        return fqClassName;
    }

    public PsiClass getPsiClass(PsiElement context) {
        return ClassUtils.findClass(fqClassName, context);
    }

    public String getQualifiedStaticMethodName(String methodName) {
        return fqClassName + "." + methodName;
    }

    @Override
    public String toString() {
        return fqClassName;
    }
}
