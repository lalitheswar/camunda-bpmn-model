/* Licensed under the Apache License, Version 2.0 (the "License");
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
package org.camunda.bpm.xml.model.type;

import org.camunda.bpm.xml.model.impl.instance.ModelTypeInstanceContext;
import org.camunda.bpm.xml.model.instance.ModelElementInstance;
import org.camunda.bpm.xml.model.type.attribute.AttributeBuilder;
import org.camunda.bpm.xml.model.type.attribute.StringAttributeBuilder;
import org.camunda.bpm.xml.model.type.child.SequenceBuilder;

/**
 * @author Daniel Meyer
 */
public interface ModelElementTypeBuilder {

  ModelElementTypeBuilder namespaceUri(String namespaceUri);

  ModelElementTypeBuilder extendsType(Class<? extends ModelElementInstance> extendedType);

  <T extends ModelElementInstance> ModelElementTypeBuilder instanceProvider(ModelTypeInstanceProvider<T> instanceProvider);

  ModelElementTypeBuilder abstractType();

  AttributeBuilder<Boolean> booleanAttribute(String attributeName);

  StringAttributeBuilder stringAttribute(String attributeName);

  <V extends Enum<V>> AttributeBuilder<V> enumAttribute(String attributeName, Class<V> enumType);

  SequenceBuilder sequence();

  ModelElementType build();

  public static interface ModelTypeInstanceProvider<T extends ModelElementInstance> {
    T newInstance(ModelTypeInstanceContext instanceContext);
  }

}
