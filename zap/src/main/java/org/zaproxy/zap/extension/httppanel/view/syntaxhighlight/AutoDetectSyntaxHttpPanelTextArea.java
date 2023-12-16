/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2012 The ZAP Development Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.zaproxy.zap.extension.httppanel.view.syntaxhighlight;

import org.apache.commons.configuration.FileConfiguration;
import org.parosproxy.paros.network.HttpMessage;
import org.zaproxy.zap.extension.httppanel.Message;

public abstract class AutoDetectSyntaxHttpPanelTextArea extends HttpPanelSyntaxHighlightTextArea {

    private static final long serialVersionUID = 293746373028878338L;

    private static final String AUTO_DETECT = "autodetect";

    private boolean isAutoDetectSyntax;

    public AutoDetectSyntaxHttpPanelTextArea() {
        isAutoDetectSyntax = true;
    }

    @Override
    public void setMessage(Message aMessage) {
        super.setMessage(aMessage);

        if (isAutoDetectSyntax) {
            detectAndSetSyntax();
        }
    }

    public boolean isAutoDetectSyntax() {
        return isAutoDetectSyntax;
    }

    public void setAutoDetectSyntax(boolean enabled) {
        isAutoDetectSyntax = enabled;
        if (isAutoDetectSyntax) {
            detectAndSetSyntax();
        }
    }

    private void detectAndSetSyntax() {
        Message message = getMessage();
        if (message instanceof HttpMessage) {
            final String syntax = detectSyntax((HttpMessage) message);
            setSyntaxEditingStyle(syntax);
        }
    }

    protected abstract String detectSyntax(HttpMessage httpMessage);

    @Override
    public void loadConfiguration(String key, FileConfiguration fileConfiguration) {
        super.loadConfiguration(key, fileConfiguration);

        setAutoDetectSyntax(
                fileConfiguration.getBoolean(key + "syntax." + AUTO_DETECT, isAutoDetectSyntax));
    }

    @Override
    public void saveConfiguration(String key, FileConfiguration fileConfiguration) {
        super.saveConfiguration(key, fileConfiguration);

        fileConfiguration.setProperty(key + "syntax." + AUTO_DETECT, isAutoDetectSyntax);
    }
}
