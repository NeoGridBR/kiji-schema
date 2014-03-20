/**
 * (c) Copyright 2013 WibiData, Inc.
 *
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
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

package org.kiji.schema.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJvmId {
  private static final Logger LOG = LoggerFactory.getLogger(TestJvmId.class);

  @Test
  public void testJvmId() throws Exception {
    final String jvmId = JvmId.get();
    LOG.info("JVM ID: {}", jvmId);
    assertEquals(jvmId, JvmId.get());
  }

  @Test
  public void evaluateIdComponents() {
    final String jvmId = JvmId.get();
    final String[] components = jvmId.split("@");
    assertEquals("Expected 3 components separated by @", 3, components.length);
    assertTrue("Expected a number at JvmId's first pos (pid)", components[0].matches("\\d+"));
    assertFalse("2nd position cannot be empty (hostname)", "".equals(components[1]));
    assertTrue("Expected a number at JvmId's 3rd pos (timestamp)", components[2].matches("\\d+"));
  }
}
