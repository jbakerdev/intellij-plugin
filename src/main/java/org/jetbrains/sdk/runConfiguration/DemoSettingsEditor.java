// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.sdk.runConfiguration;

import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class DemoSettingsEditor extends SettingsEditor<DemoRunConfiguration> {

  private JPanel myPanel;
  private LabeledComponent<TextFieldWithBrowseButton> myYathPath;
  private LabeledComponent<TextFieldWithBrowseButton> myScriptName;

  @Override
  protected void resetEditorFrom(DemoRunConfiguration demoRunConfiguration) {
    myYathPath.getComponent().setText(demoRunConfiguration.getYathPath());
    myScriptName.getComponent().setText(demoRunConfiguration.getScriptName());
  }

  @Override
  protected void applyEditorTo(@NotNull DemoRunConfiguration demoRunConfiguration) {
    demoRunConfiguration.setYathPath(myYathPath.getComponent().getText());
    demoRunConfiguration.setScriptName(myScriptName.getComponent().getText());
  }

  @NotNull
  @Override
  protected JComponent createEditor() {
    return myPanel;
  }

  private void createUIComponents() {
    myYathPath = new LabeledComponent<>();
    myYathPath.setComponent(new TextFieldWithBrowseButton());

    myScriptName = new LabeledComponent<>();
    myScriptName.setComponent(new TextFieldWithBrowseButton());
  }

}
