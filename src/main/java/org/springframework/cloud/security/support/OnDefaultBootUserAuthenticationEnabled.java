/*
 * Copyright 2017 the original author or authors.
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
package org.springframework.cloud.security.support;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.NoneNestedConditions;
import org.springframework.context.annotation.Condition;

/**
 * {@link Condition} that is valid if neither file authentication nor Ldap authentication
 * are enabled.
 *
 * @author Gunnar Hillert
 * @since 1.2.0
 */
public class OnDefaultBootUserAuthenticationEnabled extends NoneNestedConditions {

	public OnDefaultBootUserAuthenticationEnabled() {
		super(ConfigurationPhase.REGISTER_BEAN);
	}

	@ConditionalOnProperty("security.authentication.file.enabled")
	static class fileAuthenticationEnabled {
	}

	@ConditionalOnProperty("security.authentication.ldap.enabled")
	static class ldapAuthenticationEnabled {
	}
}
