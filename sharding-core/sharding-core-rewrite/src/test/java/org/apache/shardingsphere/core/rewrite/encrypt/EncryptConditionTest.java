/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.core.rewrite.encrypt;

import org.apache.shardingsphere.core.parse.sql.segment.dml.expr.ExpressionSegment;
import org.apache.shardingsphere.core.parse.sql.segment.dml.expr.simple.LiteralExpressionSegment;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class EncryptConditionTest {
    
    @Test
    public void assertGetConditionValuesForEqual() {
        List<Object> actual = new EncryptCondition("col", "tbl", 0, 0, new LiteralExpressionSegment(0, 0, 1)).getValues(Collections.emptyList());
        assertThat(actual.size(), is(1));
        assertThat((Integer) actual.get(0), is(1));
    }
    
    @Test
    public void assertGetConditionValuesForIn() {
        List<Object> actual = new EncryptCondition(
                "col", "tbl", 0, 0, Arrays.<ExpressionSegment>asList(new LiteralExpressionSegment(0, 0, 1), new LiteralExpressionSegment(0, 0, 2))).getValues(Collections.emptyList());
        assertThat(actual.size(), is(2));
        assertThat((Integer) actual.get(0), is(1));
        assertThat((Integer) actual.get(1), is(2));
    }
}