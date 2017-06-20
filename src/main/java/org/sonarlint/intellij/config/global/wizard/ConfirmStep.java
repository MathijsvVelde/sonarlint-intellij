/*
 * SonarLint for IntelliJ IDEA
 * Copyright (C) 2015 SonarSource
 * sonarlint@sonarsource.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonarlint.intellij.config.global.wizard;

import com.intellij.ide.wizard.AbstractWizardStepEx;
import com.intellij.ide.wizard.CommitStepException;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.sonarsource.sonarlint.core.client.api.connected.RemoteOrganization;

public class ConfirmStep extends AbstractWizardStepEx {
  private final WizardModel model;
  private JPanel panel;

  public ConfirmStep(WizardModel model) {
    super("Done");
    this.model = model;
  }

  @Override
  public JComponent getComponent() {
    return panel;
  }

  @NotNull @Override public Object getStepId() {
    return ConfirmStep.class;
  }

  @Nullable @Override public Object getNextStepId() {
    return null;
  }

  @Nullable @Override public Object getPreviousStepId() {
    List<RemoteOrganization> orgList = model.getOrganizationList();
    if (orgList != null && orgList.size() > 1) {
      return OrganizationStep.class;
    } else {
      return AuthStep.class;
    }
  }

  @Override public boolean isComplete() {
    return true;
  }

  @Override public void commit(CommitType commitType) throws CommitStepException {
    // nothing to do
  }

  @Nullable @Override public JComponent getPreferredFocusedComponent() {
    return null;
  }
}