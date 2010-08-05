/*
 * Licensed to the Sakai Foundation (SF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The SF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.sakaiproject.nakamura.api.user;

import org.apache.jackrabbit.api.security.user.Authorizable;
import org.apache.jackrabbit.api.security.user.User;

import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

/**
 *
 */
public interface SakaiAuthorizableService {
  /**
   * Convenience routine to create a new Jackrabbit User, followed by any initialization
   * needed to use it in Sakai 3.
   *
   * @param userId
   * @param password
   * @param session
   * @return
   * @throws RepositoryException
   */
  User createUser(String userId, String password, Session session) throws RepositoryException;

  /**
   * Convenience routine to create a new Jackrabbit User, followed by any initialization
   * needed to use it in Sakai 3.
   *
   * @param userId
   * @param password
   * @param extraProperties - Available so that user properties can be initialized for
   *        use by post-processors; null if not needed
   * @param session
   * @return
   * @throws RepositoryException
   */
  User createUser(String userId, String password, Map<String, Object> extraProperties, Session session) throws RepositoryException;

  /**
   * Do whatever is needed to make the specified Jackrabbit User or Group suited to the Sakai 3
   * environment.
   *
   * @param authorizable
   * @param session
   * @throws RepositoryException
   */
  void postprocess(Authorizable authorizable, Session session) throws RepositoryException;
}
