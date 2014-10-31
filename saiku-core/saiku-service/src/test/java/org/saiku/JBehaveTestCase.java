/*
 * Copyright 2014 OSBI Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.saiku;

import net.thucydides.jbehave.ThucydidesJUnitStories;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.LinkedList;

/**
 * Created by bugg on 02/05/14.
 */
public class JBehaveTestCase extends ThucydidesJUnitStories {
  public LinkedList<Object> stepDefinitions = new LinkedList<Object>();

  @Override
  public Configuration configuration() {
    return new MostUsefulConfiguration()
        .useStoryLoader(new JiraStoryLoader("SKU-1147"))
        .useStoryReporterBuilder(
            new StoryReporterBuilder()
                .withRelativeDirectory("")
                .withDefaultFormats()
                .withFormats(Format.CONSOLE, Format.TXT,
                    Format.XML, Format.HTML));
  }

  @Override
  public InjectableStepsFactory stepsFactory() {
    return new InstanceStepsFactory(configuration(), this.stepDefinitions);
  }

  public JBehaveTestCase() {
    this.stepDefinitions.add(new OlapDataSourceStepsdef());
  }
}
