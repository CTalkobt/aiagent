/*
 * Copyright (C) 2016 Craig Taylor <ctalkobt@ctalkobt.net>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package net.ctalkobt.ai.agent.simple.math;

import java.util.Map;
import net.ctalkobt.ai.agent.Capabilities;
import net.ctalkobt.ai.agent.response.NumericResponse;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;

/**
 *
 * @author Craig Taylor <ctalkobt@ctalkobt.net>
 */
public class MathAgentTest {

    private MathAgent instance;
    
    public MathAgentTest() {
    }

    @Before
    public void setup()
    {
        this.instance = new MathAgent();
    }
    
    /**
     * Test of info method, of class MathAgent.
     */
    @Test
    public void testInfo() {
        System.out.println("info");
        Capabilities expResult = null;
        
        Capabilities result = instance.info();
        assertNotNull(result);
        assertNotNull(result.getCapability());
        assertEquals(1, result.getCapability().size());
        assertEquals(result.getCapability().iterator().next().getName(), "mathOp");
    }

    /**
     * Test of request method, of class MathAgent.
     */
    @Test
    public void testRequest() {
        String body = "21*2";
        Map<String, String> headers = null;
        Number expectedResult = 42;        
                
        NumericResponse result = instance.request(body, headers);
        
        assertEquals(result.getBody(), expectedResult);
    }
    
}
