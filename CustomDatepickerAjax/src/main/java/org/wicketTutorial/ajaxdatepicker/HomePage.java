/**
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.wicketTutorial.ajaxdatepicker;

import java.util.Date;
import java.util.Locale;

import org.apache.wicket.Session;
import org.apache.wicket.ThreadContext;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
		super(parameters);
		Form form = new Form("form");
		final JQueryDateFieldAjax datepicker;
		datepicker = new JQueryDateFieldAjax("datepicker", new Model<Date>());
		form.add(datepicker);
		
		add(new AjaxLink<Void>("update"){

			@Override
			public void onClick(AjaxRequestTarget target) {
				datepicker.setEnabled(!datepicker.isEnabled());
				target.add(datepicker);				
			}
			
		});
		add(form);
    }
}
