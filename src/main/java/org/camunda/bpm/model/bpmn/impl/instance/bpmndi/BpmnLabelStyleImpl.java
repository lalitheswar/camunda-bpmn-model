/*
 * Copyright © 2014-2018 camunda services GmbH and various authors (info@camunda.com)
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
package org.camunda.bpm.model.bpmn.impl.instance.bpmndi;

import org.camunda.bpm.model.bpmn.impl.instance.di.StyleImpl;
import org.camunda.bpm.model.bpmn.instance.bpmndi.BpmnLabelStyle;
import org.camunda.bpm.model.bpmn.instance.dc.Font;
import org.camunda.bpm.model.bpmn.instance.di.Style;
import org.camunda.bpm.model.xml.ModelBuilder;
import org.camunda.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.camunda.bpm.model.xml.type.ModelElementTypeBuilder;
import org.camunda.bpm.model.xml.type.child.ChildElement;
import org.camunda.bpm.model.xml.type.child.SequenceBuilder;

import static org.camunda.bpm.model.bpmn.impl.BpmnModelConstants.BPMNDI_ELEMENT_BPMN_LABEL_STYLE;
import static org.camunda.bpm.model.bpmn.impl.BpmnModelConstants.BPMNDI_NS;
import static org.camunda.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;

/**
 * The BPMNDI BPMNLabelStyle element
 *
 * @author Sebastian Menski
 */
public class BpmnLabelStyleImpl extends StyleImpl implements BpmnLabelStyle {

  protected static ChildElement<Font> fontChild;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(BpmnLabelStyle.class, BPMNDI_ELEMENT_BPMN_LABEL_STYLE)
      .namespaceUri(BPMNDI_NS)
      .extendsType(Style.class)
      .instanceProvider(new ModelTypeInstanceProvider<BpmnLabelStyle>() {
        public BpmnLabelStyle newInstance(ModelTypeInstanceContext instanceContext) {
          return new BpmnLabelStyleImpl(instanceContext);
        }
      });

    SequenceBuilder sequenceBuilder = typeBuilder.sequence();

    fontChild = sequenceBuilder.element(Font.class)
      .required()
      .build();

    typeBuilder.build();
  }

  public BpmnLabelStyleImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public Font getFont() {
    return fontChild.getChild(this);
  }

  public void setFont(Font font) {
    fontChild.setChild(this, font);
  }
}
