/**
 *
 * Copyright 2011 (C) The original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.toolazydogs.maiden.agent.asm;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.testng.annotations.Test;


/**
 *
 */
public class AsmUtilsTest
{
    @Test
    public void testPushInteger()
    {
        MethodVisitor methodVisitor = mock(MethodVisitor.class);

        AsmUtils.push(methodVisitor, 59);

        verify(methodVisitor).visitIntInsn(Opcodes.BIPUSH, 59);
        verify(methodVisitor, never()).visitIntInsn(Opcodes.SIPUSH, 59);

        AsmUtils.push(methodVisitor, 32760);

        verify(methodVisitor, never()).visitIntInsn(Opcodes.BIPUSH, 32760);
        verify(methodVisitor).visitIntInsn(Opcodes.SIPUSH, 32760);
    }
}
