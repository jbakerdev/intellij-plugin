// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.sdk.runConfiguration;

import com.intellij.execution.configurations.RunConfigurationOptions;
import com.intellij.openapi.components.StoredProperty;

public class DemoRunConfigurationOptions extends RunConfigurationOptions {

  private final StoredProperty<String> myYathPath = string("").provideDelegate(this, "yathPath");

  private final StoredProperty<String> myScriptName = string("").provideDelegate(this, "scriptName");

  public String getYathPath() {
    return myYathPath.getValue(this);
  }

  public String getScriptName() {
    return myScriptName.getValue(this);
  }

  public void setYathPath(String yathPath) { myYathPath.setValue(this, yathPath); }

  public void setScriptName(String scriptName) {
    myScriptName.setValue(this, scriptName);
  }

}
